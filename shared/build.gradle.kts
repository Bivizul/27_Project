import aaa.bivizul.a27project.buildSrc.*


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
                implementation(Ktor.core)
                implementation(Ktor.logging)
                implementation(Ktor.negotiation)
                implementation(Ktor.json)
                implementation(Ktor.cio)
                //Coroutines
                implementation(KotlinCoroutines.core)
                //Logger
                implementation(Util.napier)
                //JSON
                implementation(kotlinDependencies.serialization)
                //Key-Value storage
                implementation(Util.settings)
                // DI
                implementation(Koin.core)
                implementation(Koin.android)
                // Compose
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                // Needed only for preview.
//                api(compose.preview)
//                implementation(compose.preview)
                //Navigation
                implementation(ComposeUtils.navigation)
                // Log
//                implementation("io.github.aakira:napier:[latest version]")
                // Coil
                implementation(Coil.coil)
                implementation(ComposeUtils.coil)
                // levbrow
                implementation (Util.levbrow)
                // Signal
                implementation(otherDependencies.onesignal)
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
dependencies {
    implementation("androidx.navigation:navigation-common-ktx:2.5.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.2.1")
}
//dependencies {
//    implementation(project(mapOf("path" to ":androidApp")))
//}
