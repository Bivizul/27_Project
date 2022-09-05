//plugins {
//    // this is necessary to avoid the plugins to be loaded multiple times
//    // in each subproject's classloader
//    kotlin("jvm") apply false
//    kotlin("multiplatform") apply false
//    kotlin("android") apply false
//    id("com.android.application") apply false
//    id("com.android.library") apply false
//    id("org.jetbrains.compose") apply false
//}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath("com.android.tools.build:gradle:7.3.0-rc01")
        classpath("gradle.plugin.com.onesignal:onesignal-gradle-plugin:0.14.0")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.7.10")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}