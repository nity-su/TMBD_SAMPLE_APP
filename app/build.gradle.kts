
import org.apache.commons.logging.LogFactory.release
import org.gradle.internal.impldep.jcifs.UniAddress.getByName
import RxDependencies.implementRx

plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-kapt")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.2"

    defaultConfig {
        applicationId = "com.anlyn.user_rating"
        minSdkVersion(27)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            minifyEnabled(false)
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


    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.32")
    implementation(AndroidxDependencies.core_ktx)
    implementation(AndroidxDependencies.appcompat)
    implementation(MaterialDependencies.material)
    implementation(AndroidxDependencies.constraintLayout)
    implementation (AndroidxDependencies.legacy_support_v4)
    implementation (AndroidxDependencies.livedata_ktx)
    implementation (AndroidxDependencies.viewmodel)
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")



    implementation (DaggerDependencies.dagger_android)
    implementation(DaggerDependencies.dagger_android_support)
    kapt(DaggerDependencies.android_processor)
    kapt(DaggerDependencies.dagger_compiler)
    implementation(GlideDependencies.glide)
    kapt(GlideDependencies.glide_compiler)


    implementRx()
//    implementation RxDependencies.rxjava3
//    implementation RxDependencies.rxandroid
    implementation (RetrofitDependencies.retrofit)
    implementation (RetrofitDependencies.retrofit2_adapter_jxjava3)
    implementation (RetrofitDependencies.retrofit2_conveter_jxjava3)



    implementation (project(":data"))
    implementation (project(":domain"))

}