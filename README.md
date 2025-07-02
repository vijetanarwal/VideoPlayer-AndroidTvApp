# 📺 TV App – Jetpack Compose Video Player

A sleek **Android TV-style video streaming app** built with **Jetpack Compose**, **Kotlin**, and **Media3 ExoPlayer**, powered by the **Pexels Video API**.

Users can browse trending videos in  layout, view uploader names, video details like resolution and duration, and **watch HD videos full-screen**.

---
  ![sshot3 - Edited](https://github.com/user-attachments/assets/14485413-e90c-4c66-97d2-3efaac613de5)



---

## 🎥 Demo Video + APK 
Drive link->   https://drive.google.com/drive/folders/179AakGiv_-ogJOHb_Jcuqiok9hEOMKoF

---

## 🚀 Features

- 🔥 **Trending videos** fetched from [Pexels API](https://www.pexels.com/api/)
- 🎬 Full-screen **HD video playback** using ExoPlayer
- 📺 **Optimized for Android TVs** (focusable, scalable UI)
- 🔙 Seamless navigation with an in-player Back Button to return to the Home screen
- 🔁 Retry mechanism & graceful error fallback
- 🎨 **Material 3** UI in **Jetpack Compose**
- 🖼 Shows:
  - Uploader name 
  - Resolution (e.g., `1920x1080`)
  - Duration (in seconds)
- 🧠 Efficient **MVVM architecture** using ViewModel + StateFlow

---

## 🧱 Architecture

- **Jetpack Compose** – Declarative UI
- **Media3 ExoPlayer** – Modern media playback engine
- **Retrofit2 + Gson** – Networking
- **MVVM** – Clean separation of logic
- **Kotlin Coroutines + StateFlow** – Reactive UI updates

---

✅ Manual Testing

This application has been manually tested on both Android Emulator and physical Android TV device to ensure stable and smooth user experience.

Tested features include:

🔄 Focus navigation using D-pad / TV remote.

🎬 Video playback and seeking using ExoPlayer.

🔙 Back button functionality from player screen to home.

📶 API error handling, including no internet and fallback UI.

📱 APK tested on Android Phone (basic functionality verified).

## 🗂️ Project Structure
```
com.example.movieplayer
├── model/
│   └── VideoItem.kt
├── network/
│   ├── RetrofitClient.kt
│   └── RetrofitService.kt
├── repository/
│   └── VideoRepository.kt
├── viewmodel/
│   └── VideoViewModel.kt
├── screens/
│   ├── HomeScreen.kt
│   ├── PlayerScreen.kt
│   ├── VideoCard.kt
│   └── AppNavigation.kt
├── res/
│   └── drawable/
│       └── ic_back.xml
└── MainActivity.kt
```
## 🔑 How to Get and Use Pexels API Key

1. Visit: [https://www.pexels.com/api/new/](https://www.pexels.com/api/new/)
2. **Sign up** or log in
3. Fill the basic form → **App name**, **app type**, and link (use any GitHub repo or dummy link like `https://myapp.com`)
4. Copy the API Key from your Pexels dashboard

And paste your key like this:
```kotlin
@Headers(
    "Authorization: YOUR_PEXELS_API_KEY"
)


