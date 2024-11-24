package com.forcosigan.weatherapp.data.DataSource.API.Entity

import com.forcosigan.weatherapp.DataSource.API.Entity.CurrentWeatherApiEntity
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponseApiEntity(
    val current: CurrentWeatherApiEntity
) {
}