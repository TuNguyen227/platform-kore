# platform-kore
Platform Info for Compose Multiplatform (Android, IOS)

In your module's build.gradle.kts, add dependency in commonMain
```kotlin
implementation("io.github.tunguyen227:platformkore:0.1.0")
```

## Overview

Here are some key concepts of the library.

* PlatfromContext - if your app need platform context.
* Platform - if your app need platform info like platform name, sdk build, platform versions.
