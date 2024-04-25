plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.nhom10_projectcuoiky"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nhom10_projectcuoiky"
        minSdk = 26
        targetSdk = 34
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //glider
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    //RxJava
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.0")
    implementation ("io.reactivex.rxjava3:rxjava:3.0.0")
    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")
    // bradgde
    implementation ("com.nex3z:notification-badge:1.0.4")
    // eventbus
    implementation("org.greenrobot:eventbus:3.2.0")
    // paper
    implementation ("io.github.pilgr:paperdb:2.7.2")
    // gson
    implementation ("com.google.code.gson:gson:2.10.1")
    // lottie
    implementation ("com.airbnb.android:lottie:6.4.0")

}