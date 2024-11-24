package com.forcosigan.weatherapp.DataSource.API.Entity

import com.forcosigan.weatherapp.data.DataSource.API.Entity.WeatherConditionApiEntity
import com.forcosigan.weatherapp.domain.Model.CurrentWeather
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherApiEntity(
    val humidity: Int,
    val uv: Float,
    val feelslike_c: Float,
    val temp_c: Float,
    val condition: WeatherConditionApiEntity
)

fun CurrentWeatherApiEntity.toCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        humidity = humidity,
        uv = uv,
        feelsLikeInCelsius = feelslike_c,
        temperatureInCelsius = temp_c,
        conditionIcon = condition.icon,
        conditionDescription = condition.text
    )
}