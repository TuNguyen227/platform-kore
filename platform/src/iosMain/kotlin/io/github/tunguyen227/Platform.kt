package io.github.tunguyen227

import platform.UIKit.UIDevice

actual abstract class PlatformContext private constructor() {
    companion object {
        val INSTANCE = object : PlatformContext() {}
    }
}

actual object Platform {
    actual val name = UIDevice.currentDevice.systemName
    actual object Build {
        actual val sdk = UIDevice.currentDevice.systemVersion.convertSystemVersionToFloat()
    }

    private fun String.convertSystemVersionToFloat() : Float {
        val components = this.split(".")
        val major = components.getOrNull(0)?.toIntOrNull() ?: 0
        val minor = components.getOrNull(1)?.toIntOrNull() ?: 0
        val patch = components.getOrNull(2)?.toIntOrNull() ?: 0
        return (major + minor / 100f + patch / 10000f)
    }
}