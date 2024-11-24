
<h1 align="center">Weather app</h1></br>
<p align="center">  
A demo Weather app using compose and Hilt based on modern Android tech-stacks and MVVM architecture. Fetching data from the network and integrating persisted data in the preference storage via repository pattern.<br> Declarative UI version using compose.
</p>
</br>

## Screenshots
<p align="center">
<img src="/preview/no_location_selected.jpg" width="200"/>
<img src="/preview/current_weather.jpg" width="200"/>
<img src="/preview/search.jpg" width="200"/>
<img src="/preview/search_list.jpg" width="200"/>
</p>

## Tech stack & Open-source libraries
- Minimum SDK level 21
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- Hilt for dependency injection.
- JetPack
  - Compose - A modern toolkit for building native Android UI.
  - ViewModel - UI related data holder, lifecycle aware.
- Architecture
  - MVVM Architecture (Declarative View - ViewModel - Model)
  - Repository pattern
- Material Design & Animations
- [KTOR] - Ktor is a framework for building asynchronous server-side and client-side applications with ease..
