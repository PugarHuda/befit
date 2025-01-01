// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Specify the version of the Gradle plugin for Android
        classpath("com.android.tools.build:gradle:8.2.0") // Ensure this matches your Gradle Wrapper version
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0") // Make sure the Kotlin plugin version matches the Kotlin version you're using
    }
}

plugins {
    // Declare Android and Kotlin plugins here, apply false means they are not applied directly in this project
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.google.gms.google.services) apply false
}
