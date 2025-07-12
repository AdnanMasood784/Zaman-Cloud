import io.grpc.internal.SharedResourceHolder.release

plugins {
    alias(libs.plugins.android.application)

}

android {
    namespace = "com.ncp.ncpgeoattendance"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ncp.ncpgeoattendance"
        minSdk = 21
        targetSdk = 34
        versionCode = 22
        versionName = "22"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"



    }


    buildTypes{
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}






dependencies {

    implementation (libs.core.ktx) // or latest


    implementation (libs.core)
    implementation (libs.drawerlayout)
    implementation (libs.material.v1110)

    //implementation(libs.firebase.analytics)

    //implementation(libs.google.webrtc)
   // implementation (libs.play.services.location.v1501)
    implementation (libs.play.services.location)
    implementation(libs.webkit)
    implementation(libs.appcompat)
    implementation (libs.material) // or latest
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}