import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import com.vanniktech.maven.publish.SonatypeHost
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    `maven-publish`
    id("com.vanniktech.maven.publish") version "0.31.0"
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "platform"
            isStatic = true
        }
    }
    targets.configureEach {
        compilations.configureEach {
            compilerOptions.configure {
                freeCompilerArgs.addAll("-Xexpect-actual-classes")
            }
        }
    }
}

android {
    namespace = "it.github.tunguyen227"
    compileSdk = libs.versions.android.targetSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

mavenPublishing {
    coordinates(
        groupId = "io.github.tunguyen227",
        artifactId = "platformkore",
        version = "0.1.0"
    )
    // Configure POM metadata for the published artifact
    pom {
        name.set("KMM Library for platform information")
        description.set("This library can be used by Android and iOS targets for the shared functionality of getting platform information.")
        inceptionYear.set("2025")
        url.set("https://github.com/TuNguyen227/platform-kore")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        // Specify developer information
        developers {
            developer {
                id.set("2ba887b8-f6ce-4041-82a7-080503128756")
                name.set("nmtu2272000@gmail.com")
                email.set("nmtu2272000@gmail.com")
            }
        }

        // Specify SCM information
        scm {
            url.set("https://github.com/TuNguyen227/platform-kore")
            connection.set("scm:git:git://git@github.com:TuNguyen227/platform-kore.git")
            developerConnection.set("scm:git:ssh://git@github.com:TuNguyen227/platform-kore.git")
        }
    }

    // Configure publishing to Maven Central
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    // Enable GPG signing for all publications
    signAllPublications()
}