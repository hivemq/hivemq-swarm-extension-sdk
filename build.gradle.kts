plugins {
    id("java-library")
    id("maven-publish")
}

group="com.hivemq"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

description = "API for developing HiveMQ Swarm extensions."


repositories {
    mavenCentral()
}

dependencies {

    implementation("org.jetbrains:annotations:${property("jetbrains-annotations.version")}")
    implementation("io.dropwizard.metrics:metrics-core:${property("metrics-core.version")}")

    api("org.slf4j:slf4j-api:${property("slf4j-api.version")}")

    testImplementation("junit:junit:${property("junit.version")}")

}

fun getSnapshotVersion(): String {

//    val stdout = org.apache.commons.io.output.ByteArrayOutputStream()
//
//    exec {
//        commandLine("git", "log", "--pretty=format:%h", "-n", "1")
//        standardOutput = stdout
//    }

//    val gitHash = stdout.toString().trim()

    //FIXME: FIXME
    return property("baseVersion").toString() + "-SNAPSHOT-" //+ gitHash
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/hivemq/hivemq-swarm-extension-sdk")
            credentials {
                username = (System.getenv("PUBLISH_GITHUB_USERNAME") ?: "").toString()
                password = (System.getenv("PUBLISH_GITHUB_TOKEN") ?: "").toString()
            }
        }
    }
    publications.register<MavenPublication>("release") {
        groupId = "com.hivemq"
        artifactId = "hivemq-swarm-extension-sdk"
        version = project.version.toString()

        from(components["java"])
        pom {
            name.set(property("readableName").toString())
            description.set(project.description)
            url.set("https://github.com/hivemq/hivemq-swarm-extension-sdk")
        }
    }
    publications.register<MavenPublication>("snapshot") {
        groupId = "com.hivemq"
        artifactId = "hivemq-swarm-extension-sdk"
        version = getSnapshotVersion()

        from(components["java"])
        pom {
            name.set(property("readableName").toString())
            description.set(project.description)
            url.set("https://github.com/hivemq/hivemq-swarm-extension-sdk")
        }
    }
}



