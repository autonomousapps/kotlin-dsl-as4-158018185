import com.hiya.release
import com.hiya.sdk

plugins {
    id("com.android.library")
}

// This makes it available to projects where this plugin is applied
// VERSION_NAME is from gradle.properties
val sdkVersion by extra(project.property("VERSION_NAME").toString())

android {
    compileSdkVersion(29)

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = sdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
        sdk {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile ("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    lintOptions {
        isAbortOnError = false
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

//dependencies {
//    // To support Java 8 APIs natively
//    // https://developer.android.com/studio/write/java8-support#library-desugaring
//    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.0.5")
//
//    implementation(platform(project(":hiya-platform")))
//    testImplementation(platform(project(":test-platform")))
//    androidTestUtil(platform(project(":test-platform")))
//    androidTestImplementation(platform(project(":test-platform")))
//}

//pluginManager.withPlugin("kotlin-kapt") {
//    dependencies {
//        "kapt"(platform(project(":hiya-platform")))
//        "kaptAndroidTest"(platform(project(":hiya-platform")))
//    }
//}
