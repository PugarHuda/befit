buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Menentukan versi plugin Gradle untuk Android
        classpath("com.android.tools.build:gradle:8.2.0") // Pastikan versinya sesuai dengan Gradle Wrapper yang Anda gunakan
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0") // Versi Kotlin plugin sesuai dengan versi Kotlin yang Anda gunakan
    }
}

plugins {
    // Mendeklarasikan plugin Android dan Kotlin di sini, apply false artinya tidak langsung diterapkan di project ini
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}



