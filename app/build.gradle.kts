plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    // For Setting application
    namespace = "com.example.setting"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.setting"  // Use "com.example.setting" as applicationId
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    // Enabling data binding if required for the project
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    // AndroidX Libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.database)
    implementation(libs.firebase.auth)

    // Additional dependencies for the project
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Example of additional dependencies (RecyclerView, ViewPager2)
    implementation("androidx.recyclerview:recyclerview:1.2.1") // Check for the latest version
    implementation("androidx.viewpager2:viewpager2:1.0.0") // Check for the latest version

    // Make sure you are using the latest stable version of Material Design
    implementation("com.google.android.material:material:1.9.0") // Check for the latest version
}

