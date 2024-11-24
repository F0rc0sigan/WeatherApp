package com.forcosigan.weatherapp.UI.Main

sealed class NavScreen(val route: String) {

    object Home : NavScreen("Home")
}