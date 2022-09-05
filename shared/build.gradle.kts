import aaa.bivizul.a27project.buildSrc.koinDependencies
import aaa.bivizul.a27project.buildSrc.ktorDependencies

//import aaa.bivizul.a27project.buildSrc

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlinx-serialization")
    id("org.jetbrains.compose") version "1.2.0-alpha01-dev774"
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
        val commonMain by getting{
            dependencies {
                //Network
                implementation(ktorDependencies.core)
                implementation(ktorDependencies.logging)
                implementation(ktorDependencies.negotiation)
                implementation(ktorDependencies.json)
                implementation(ktorDependencies.cio)
                //Coroutines
                implementation(aaa.bivizul.a27project.buildSrc.kotlinCoroutinesDependencies.core)
                //Logger
                implementation(aaa.bivizul.a27project.buildSrc.utilDependencies.napier)
                //JSON
                implementation(aaa.bivizul.a27project.buildSrc.kotlinDependencies.serialization)
                //Key-Value storage
                implementation(aaa.bivizul.a27project.buildSrc.utilDependencies.settings)
                // DI
                implementation(koinDependencies.core)
                implementation(koinDependencies.android)
                // Compose
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                // Needed only for preview.
                implementation(compose.preview)


            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
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
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
    dependencies {
        coreLibraryDesugaring(aaa.bivizul.a27project.buildSrc.androidxsupportDependencies.desugar)
    }

}
//dependencies {
//    implementation(project(mapOf("path" to ":androidApp")))
//}
