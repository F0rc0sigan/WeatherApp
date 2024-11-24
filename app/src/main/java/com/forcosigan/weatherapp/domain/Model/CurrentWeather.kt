package com.forcosigan.weatherapp.domain.Model


data class CurrentWeather(
    val humidity: Int,
    val uv: Float,
    val feelsLikeInCelsius: Float,
    val temperatureInCelsius: Float,
    val conditionIcon: String,
    val conditionDescription: String
)