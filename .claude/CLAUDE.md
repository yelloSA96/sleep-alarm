# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Android application built with Jetpack Compose that helps users set alarms based on sleep cycles. Users can add time increments (1.5, 3, 4.5, 6, 7.5, 9 hours) to the current time and then set an alarm using the system alarm clock.

**Tech Stack:**
- Kotlin 2.0.21
- Jetpack Compose with Material3
- Android Gradle Plugin 8.12.2
- Min SDK: 24, Target SDK: 36

## Build Commands

### Build the app
```bash
./gradlew build
```

### Run tests
```bash
# Unit tests
./gradlew test

# Instrumented tests (requires emulator/device)
./gradlew connectedAndroidTest
```

### Clean build
```bash
./gradlew clean
```

### Install on device/emulator
```bash
./gradlew installDebug
```

### Lint
```bash
./gradlew lint
```

## Architecture

### Entry Point
- **MainActivity.kt** - ComponentActivity that sets up the Compose UI theme and displays SleepAlarmActivity composable

### Core Components
- **SleepAlarmActivity.kt** (app/src/main/java/me/thomassuebwicha/ui/main/SleepAlarmActivity.kt:30) - Main UI composable that:
  - Displays current time in HH:MM format
  - Provides buttons to add time increments (1.5, 3, 4.5, 6, 7.5, 9 hours)
  - Has Reset Time button to return to current time
  - Has Set Alarm button that calls `setAlarm()` function
  - Uses mutable state for hour/minute tracking

- **Logic.kt** (app/src/main/java/me/thomassuebwicha/Logic.kt:10) - Contains `setAlarm()` function that:
  - Creates an Intent using AlarmClock.ACTION_SET_ALARM
  - Opens the system Clock app with pre-filled alarm time
  - Includes error handling with Toast messages and logging

### UI Structure
- **ui/theme/** - Contains Color.kt, Theme.kt, Type.kt for Material3 theming
- Uses Compose declarative UI - no XML layouts
- Single-activity architecture with composables

### Permissions
Required permissions in AndroidManifest.xml:
- `com.android.alarm.permission.SET_ALARM` - To set alarms via system Clock app
- `android.permission.SCHEDULE_ALARMS` - To schedule alarms

## Key Implementation Notes

### Time Calculation Logic
The time increment buttons in SleepAlarmActivity.kt have specific calculation patterns:
- For half-hour increments (+1.5, +4.5, +7.5 hours): Adds to minute, checks if minute rolls over (< 30), then adds extra hour
- For whole-hour increments (+3, +6, +9 hours): Simply adds to hour value
- Missing modulo operator on some buttons (e.g., line 115, 131, 143) may cause hour values > 23

### Compose Preview
The @Preview annotation in MainActivity.kt:74 shows SleepAlarmActivity for quick UI preview in Android Studio

### Dependencies
Dependencies are managed via version catalog (gradle/libs.versions.toml) using the `libs` prefix in build.gradle files

## Development Notes

- Package name: `me.thomassuebwicha`
- Application ID: `me.thomassuebwicha`
- Java compatibility: Version 11
- Uses Compose BOM for dependency version alignment
- Edge-to-edge display enabled in MainActivity
