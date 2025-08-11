# MusicGen (Android)

A minimal Jetpack Compose Android app implementing the mobile UI shown in the screenshot: gradient background, search header, assistant prompt card, recommended albums row, and a bottom navigation bar.

## Open and run in Android Studio
1. File > Open... and pick the `/workspace` folder (root with `settings.gradle`).
2. Let Gradle sync. If prompted, upgrade Gradle plugin/AGP as desired.
3. Select a device or emulator and press Run.

## Build via CLI
```
chmod +x ./gradlew
./gradlew :app:assembleDebug
```

The APK will be at `app/build/outputs/apk/debug/app-debug.apk`.

## Notes
- Built with Compose Material 3 and Kotlin 1.9.
- Replace placeholder album art and icons as needed.
- Minimum SDK 24; target SDK 34.