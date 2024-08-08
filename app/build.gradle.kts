plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.freelancing_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.freelancing_app"
        minSdk = 29
        targetSdk = 33
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
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    testImplementation("junit:junit:4.13.2")
    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    // Converter for JSON (using Gson)
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp for HTTP client features (optional, but recommended)
    implementation ("com.squareup.okhttp3:okhttp:4.9.0")

    // OkHttp logging interceptor (optional, useful for debugging)
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}