buildscript {
    dependencies {
        if (gradle.includedBuilds.find { it.name == "plugins" } != null) {
            classpath("com.hivemq:plugins")
        }
    }
}

plugins {
    `java-library`
    `maven-publish`
    signing
    id("io.github.gradle-nexus.publish-plugin")
    id("com.github.hierynomus.license")
    id("com.github.sgtsilvio.gradle.utf8")
    id("com.github.sgtsilvio.gradle.metadata")
    id("com.github.sgtsilvio.gradle.javadoc-links")
}

if (gradle.includedBuilds.find { it.name == "plugins" } != null) {
    apply(plugin = "com.hivemq.version-updater")
    project.ext.set("versionUpdaterFiles", arrayOf("README.adoc"))
}

/* ******************** metadata ******************** */

group = "com.hivemq"
description = "SDK for developing HiveMQ Swarm extensions."

metadata {
    readableName.set("HiveMQ Swarm Extension SDK")
    organization {
        name.set("HiveMQ GmbH")
        url.set("https://www.hivemq.com/")
    }
    license {
        apache2()
    }
    developers {
        register("yweber") {
            fullName.set("Yannick Weber")
            email.set("yannick.weber@hivemq.com")
        }
        register("flimpoeck") {
            fullName.set("Florian Limpoeck")
            email.set("florian.limpoeck@hivemq.com")
        }
        register("lbrandl") {
            fullName.set("Lukas Brandl")
            email.set("lukas.brandl@hivemq.com")
        }
        register("SgtSilvio") {
            fullName.set("Silvio Giebl")
            email.set("silvio.giebl@hivemq.com")
        }
        register("dkrueger") {
            fullName.set("Daniel Krüger")
            email.set("daniel.krueger@hivemq.com")
        }
        register("tseeberger") {
            fullName.set("Till Seeberger")
            email.set("till.seeberger@hivemq.com")
        }
    }
    github {
        org.set("hivemq")
        repo.set("hivemq-swarm-extension-sdk")
        issues()
    }
}

/* ******************** dependencies ******************** */

repositories {
    mavenCentral()
}

dependencies {
    api("io.dropwizard.metrics:metrics-core:${property("metrics.version")}")
    api("org.slf4j:slf4j-api:${property("slf4j.version")}")
    implementation("org.jetbrains:annotations:${property("jetbrains-annotations.version")}")
}

/* ******************** java ******************** */

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }

    withJavadocJar()
    withSourcesJar()
}

tasks.withType<Jar>().configureEach {
    manifest.attributes(
        "Implementation-Title" to project.name,
        "Implementation-Vendor" to metadata.organization.get().name.get(),
        "Implementation-Version" to project.version
    )
}

tasks.javadoc {
    title = "${metadata.readableName.get()} ${project.version} API"

    doLast {
        javaexec {
            classpath(projectDir.resolve("gradle/tools/javadoc-cleaner-1.0.jar"))
        }
    }

    doLast { // javadoc search fix for jdk 11 https://bugs.openjdk.java.net/browse/JDK-8215291
        copy {
            from(destinationDir!!.resolve("search.js"))
            into(temporaryDir)
            filter { line -> line.replace("if (ui.item.p == item.l) {", "if (item.m && ui.item.p == item.l) {") }
        }
        delete(destinationDir!!.resolve("search.js"))
        copy {
            from(temporaryDir.resolve("search.js"))
            into(destinationDir!!)
        }
    }
}

/* ******************** publishing ******************** */

publishing {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

signing {
    val signKey: String? by project
    val signKeyPass: String? by project
    useInMemoryPgpKeys(signKey, signKeyPass)
    sign(publishing.publications["maven"])
}

nexusPublishing {
    repositories {
        sonatype()
    }
}

/* ******************** checks ******************** */

license {
    header = projectDir.resolve("HEADER")
    mapping("java", "SLASHSTAR_STYLE")
}

val javadoc by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = false
    attributes {
        attribute(Category.CATEGORY_ATTRIBUTE, objects.named("javadocs"))
    }
}

artifacts {
    add(javadoc.name, tasks.named("javadocJar"))
}