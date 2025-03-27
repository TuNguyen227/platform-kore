package io.github.tunguyen227

actual typealias PlatformContext = android.content.Context
private typealias AndroidBuild = android.os.Build.VERSION
actual object Platform {
    actual val name = "Android"
    actual object Build {
        actual val sdk = AndroidBuild.SDK_INT.toFloat()
    }
}