package com.forcosigan.weatherapp.Repository

import com.forcosigan.weatherapp.domain.Model.CurrentWeather
import com.forcosigan.weatherapp.domain.Model.Location

interface WeatherRepository {
    suspend fun getCurrentWeather(locationId: Int): CurrentWeather
    suspend fun getLocations(query: String): List<Location>
}