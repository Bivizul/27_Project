import aaa.bivizul.a27project.buildSrc.*

plugins {
    kotlin("android")
    id("com.android.application")
    id("com.onesignal.androidsdk.onesignal-gradle-plugin")
    id("kotlin-parcelize")

}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "aaa.bivizul.a27project.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = androidConfigVersion.compose_compile
    }
    compileOptions {
        // Flag to enable support for the new language APIs
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(project(":shared"))

    coreLibraryDesugaring(androidxsupportDependencies.desugar)

    implementation(materialDesignDependencies.materialDesign)
    implementation(androidxsupportDependencies.appcompat)
    implementation(androidxsupportDependencies.contraintLayout)
    implementation(KotlinCoroutines.core)
    implementation(KotlinCoroutines.android)
    implementation(otherDependencies.onesignal)
    implementation(composeDependencies.ui)
    implementation(composeDependencies.uiTooling)
    implementation(composeDependencies.foundation)
    implementation(composeDependencies.material)
    implementation(ComposeUtils.activity)
    implementation(Coil.coil)
    implementation(ComposeUtils.navigation)
    implementation(accompanistDependencies.webview)
    implementation(Koin.core)
    implementation(Koin.android)


//    implementation(ArkIvanov.MVIKotlin.mvikotlin)
//    implementation(ArkIvanov.MVIKotlin.mvikotlinMain)
//    implementation(ArkIvanov.MVIKotlin.mvikotlinLogging)
//    implementation(ArkIvanov.MVIKotlin.mvikotlinTimeTravel)
//    implementation(ArkIvanov.Decompose.decompose)
//    implementation(ArkIvanov.Decompose.extensionsCompose)

//    implementation(composeUtilsDependencies.navigation)

}