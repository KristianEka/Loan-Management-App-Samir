plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.navigation.safe.args.kotlin)
}

android {
    namespace = "com.ekachandra.loanmanagementapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ekachandra.loanmanagementapp"
        minSdk = 24
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
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":core"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.androidxTest)
    implementation(libs.bundles.presentation)
    implementation(libs.bundles.koin)
}