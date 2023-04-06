plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val ktorVersion = "2.0.1"
        val koin = "3.4.0"
        val koinAnnotations = "1.2.0"
        val commonMain by getting {
            dependencies {
                //implementation("io.insert-koin:koin-ksp-compiler:1.2.0")
               // implementation("io.insert-koin:koin-annotations:${koinAnnotations}")
                implementation( "io.insert-koin:koin-core:3.4.0")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation( "io.insert-koin:koin-android:3.2.0")
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation("io.ktor:ktor-client-ios:$ktorVersion")
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.azharkova.otus_kmm"
    compileSdk = 32
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}

dependencies {
   /* add("kspIosArm64","io.insert-koin:koin-ksp-compiler:1.2.0")
    add("kspCommonMainMetadata","io.insert-koin:koin-ksp-compiler:1.2.0")
    add("kspAndroid","io.insert-koin:koin-ksp-compiler:1.2.0")
    add("kspIosX64","io.insert-koin:koin-ksp-compiler:1.2.0")
    add("kspIosSimulatorArm64","io.insert-koin:koin-ksp-compiler:1.2.0")*/
}