package com.forcosigan.weatherapp.data.DataSource.API.Entity

import kotlinx.serialization.Serializable

@Serializable
data class WeatherConditionApiEntity(val icon: String, val text: String, val code: Int)