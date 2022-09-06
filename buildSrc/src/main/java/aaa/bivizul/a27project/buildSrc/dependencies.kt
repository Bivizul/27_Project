package aaa.bivizul.a27project.buildSrc

object Versions {

    val constraint_layout_version = "1.1.3"
    val coroutines_version = "1.6.4"
    val kotlin_version = "1.3.41"
    val desugar_version = "1.1.5"
    val compose_multiplatform = "1.1.0"
    val compose_version = "1.2.1"
    val compose_compile_version = "1.3.0"
    val compose_navigation = "2.5.1"
    val coil_version = "2.2.0"
    val activity_compose_version = "1.5.1"
    val accompanist_version = "0.26.2-beta"
    val levbrow_version = "1.4.0"
    val appcompat = "1.3.1"
    val material_design_version = "1.2.0"
    val onesignal_version = "[4.0.0, 4.99.99]"
    val ktor_version = "2.1.0"
    val napier_version = "2.6.1"
    val settings_version = "0.9"
    val koin_version= "3.2.0"
    val serialization_version = "1.4.0"
}

object androidConfigVersion {
    val compose_compile = Versions.compose_compile_version
}

object androidxsupportDependencies {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val contraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout_version}"
    val desugar = "com.android.tools:desugar_jdk_libs:${Versions.desugar_version}"
}

object composeDependencies {
    val ui = "androidx.compose.ui:ui:${Versions.compose_version}"
    val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose_version}"
    val foundation = "androidx.compose.foundation:foundation:${Versions.compose_version}"
    val material = "androidx.compose.material:material:${Versions.compose_version}"
}

object ComposeUtils {
    val coil = "io.coil-kt:coil-compose:${Versions.coil_version}"
    val activity = "androidx.activity:activity-compose:${Versions.activity_compose_version}"
    val navigation = "androidx.navigation:navigation-compose:${Versions.compose_navigation}"
}

object accompanistDependencies {
    val webview = "com.google.accompanist:accompanist-webview:${Versions.accompanist_version}"
}

object materialDesignDependencies {
    val materialDesign = "com.google.android.material:material:${Versions.material_design_version}"
}

object otherDependencies {
    val onesignal = "com.onesignal:OneSignal:${Versions.onesignal_version}"
}

object Ktor {
    val core = "io.ktor:ktor-client-core:${Versions.ktor_version}"
    val logging = "io.ktor:ktor-client-logging:${Versions.ktor_version}"
    val cio = "io.ktor:ktor-client-cio:${Versions.ktor_version}"
    val negotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor_version}"
    val json = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor_version}"
}

object kotlinDependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
    val serialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization_version}"
}

object KotlinCoroutines {
    val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_version}"
    val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines_version}"
}

object Util {
    val napier = "io.github.aakira:napier:${Versions.napier_version}"
    val settings = "com.russhwolf:multiplatform-settings:${Versions.settings_version}"
}

object Koin{
    val core = "io.insert-koin:koin-core:${Versions.koin_version}"
    val android = "io.insert-koin:koin-android:${Versions.koin_version}"
    val compat = "io.insert-koin:koin-android-compat:${Versions.koin_version}"
    val navigation = "io.insert-koin:koin-androidx-navigation:${Versions.koin_version}"
    val compose = "io.insert-koin:koin-androidx-compose:${Versions.koin_version}"
    val ktor = "io.insert-koin:koin-ktor:${Versions.koin_version}"
}

object Coil {
    val coil = "io.coil-kt:coil:${Versions.coil_version}"
}


