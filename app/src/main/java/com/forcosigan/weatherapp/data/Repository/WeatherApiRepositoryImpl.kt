package com.forcosigan.weatherapp.Repository

import com.forcosigan.weatherapp.DataSource.API.Entity.toCurrentWeather
import com.forcosigan.weatherapp.DataSource.WeatherDataSource
import com.forcosigan.weatherapp.data.DataSource.API.Entity.CurrentWeatherResponseApiEntity
import com.forcosigan.weatherapp.data.DataSource.API.Entity.LocationApiEntity
import com.forcosigan.weatherapp.data.DataSource.API.Entity.toLocation
import com.forcosigan.weatherapp.domain.Model.CurrentWeather
import com.forcosigan.weatherapp.domain.Model.Location
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Inject

class WeatherApiRepositoryImpl @Inject constructor() : WeatherDataSource {

    companion object {
        const val BASE_URL = "http://api.weatherapi.com/v1/"
        const val API_KEY = "89568939867f4fb9957132934242211"
    }

    private val client = HttpClient(CIO) {
        expectSuccess = true
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true

            })
        }
        install(HttpRequestRetry) {
            retryOnServerErrors(maxRetries = 3)
            exponentialDelay()

        }
        engine {
            requestTimeout = 10000
            endpoint {
                connectTimeout = 10000
                socketTimeout = 10000
            }
        }
    }

    override suspend fun getCurrentWeather(locationId: Int): CurrentWeather {
        val path = getQuery("current.json", "q=id:$locationId")

        val url = "${BASE_URL}$path"
        val response = client.get(url) {
            contentType(ContentType.Application.Json)
        }

        val result: CurrentWeatherResponseApiEntity = response.body()

        return result.current.toCurrentWeather()
    }

    override suspend fun getLocations(query: String): List<Location> {
        val path = getQuery("search.json", "q=$query")

        val url = "${BASE_URL}$path"
        val response = client.get(url) {
            contentType(ContentType.Application.Json)
        }

        val result: List<LocationApiEntity> = response.body()

        return result.map { it.toLocation() }
    }


    private fun getQuery(path: String, parameters: String): String {
        return "$path?key=$API_KEY&$parameters"
    }
}