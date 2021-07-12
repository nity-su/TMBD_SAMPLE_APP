import org.gradle.api.artifacts.dsl.DependencyHandler

object Version{
    val dagger_version = "2.32"
    val glide_version = "4.11.0"
    val rxjava_version = "3.0.0"
    val rxandroid_version = "3.0.0"
    val retrofit2_version = "2.3.0"
    val retrofit2_adapter_version = "2.9.0"

    val appcompat_version = "1.2.0"
    val constraintlayout_version = "2.0.4"
    val legacy_support_version = "1.0.0"
    val livedata_ktx_version = "2.2.0"
    val viewmodel_version = "2.2.0"
    val material_version = "1.3.0"
    val core_ktx_version = "1.3.2"

}

object DaggerDependencies{
    val dagger_android = "com.google.dagger:dagger-android:${Version.dagger_version}"
    val dagger_android_support = "com.google.dagger:dagger-android-support:${Version.dagger_version}"
    val android_processor = "com.google.dagger:dagger-android-processor:${Version.dagger_version}"
    val dagger_compiler = "com.google.dagger:dagger-compiler:${Version.dagger_version}"

    fun DependencyHandler.implementDagger(){
        add("implementation",DaggerDependencies.dagger_android)
        add("implementation",DaggerDependencies.dagger_android_support)
        add("implementation",DaggerDependencies.android_processor)
        add("implementation",DaggerDependencies.dagger_compiler)
    }
}

object GlideDependencies{
    val glide = "com.github.bumptech.glide:glide:${Version.glide_version}"
    val glide_compiler = "com.github.bumptech.glide:compiler:${Version.glide_version}"
}

object RxDependencies{
    val rxjava3 = "io.reactivex.rxjava3:rxjava:${Version.rxjava_version}"
    val rxandroid = "io.reactivex.rxjava3:rxandroid:${Version.rxandroid_version}"

    fun DependencyHandler.implementRx(){
        add("implementation",RxDependencies.rxandroid)
        add("implementation",RxDependencies.rxjava3)
    }
}

object RetrofitDependencies{
    val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit2_version}"
    val retrofit2_adapter_jxjava3 = "com.squareup.retrofit2:adapter-rxjava3:${Version.retrofit2_adapter_version}"
    val retrofit2_conveter_jxjava3 = "com.squareup.retrofit2:converter-gson:${Version.retrofit2_version}"
}

object AndroidxDependencies{
    val appcompat = "androidx.appcompat:appcompat:${Version.appcompat_version}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintlayout_version}"
    val legacy_support_v4 = "androidx.legacy:legacy-support-v4:${Version.legacy_support_version}"
    val livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.livedata_ktx_version}"
    val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.viewmodel_version}"
    val core_ktx = "androidx.core:core-ktx:${Version.core_ktx_version}"
}

object MaterialDependencies{
    val material = "com.google.android.material:material:${Version.material_version}"
}