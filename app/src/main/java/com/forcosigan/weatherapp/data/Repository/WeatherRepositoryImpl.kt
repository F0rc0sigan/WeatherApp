package com.forcosigan.weatherapp.Repository

import com.forcosigan.weatherapp.DataSource.WeatherDataSource
import com.forcosigan.weatherapp.domain.Model.CurrentWeather
import com.forcosigan.weatherapp.domain.Model.Location
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val datasource: WeatherDataSource) :
    WeatherRepository {
    override suspend fun getCurrentWeather(locationId: Int): CurrentWeather {
        return datasource.getCurrentWeather(locationId)
    }

    override suspend fun getLocations(query: String): List<Location> {
        return datasource.getLocations(query)
    }
}