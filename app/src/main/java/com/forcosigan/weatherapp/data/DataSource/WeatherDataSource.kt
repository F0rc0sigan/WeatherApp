package com.forcosigan.weatherapp.DataSource

import com.forcosigan.weatherapp.domain.Model.CurrentWeather
import com.forcosigan.weatherapp.domain.Model.Location


interface WeatherDataSource {
    suspend fun getCurrentWeather(locationId: Int): CurrentWeather
    suspend fun getLocations(query: String): List<Location>
}
