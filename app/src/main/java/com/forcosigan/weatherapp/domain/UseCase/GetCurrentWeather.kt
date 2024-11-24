package com.forcosigan.weatherapp.domain.UseCase

import android.util.Log
import coil.network.HttpException
import com.forcosigan.weatherapp.Repository.WeatherRepository
import com.forcosigan.weatherapp.domain.Model.CurrentWeather
import com.forcosigan.weatherapp.domain.Model.Resource
import com.forcosigan.weatherapp.domain.Model.Resource.Error
import com.forcosigan.weatherapp.domain.Model.Resource.Loading
import com.forcosigan.weatherapp.domain.Model.Resource.Success
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject


class GetCurrentWeather @Inject constructor(private val repository: WeatherRepository) {
    operator fun invoke(locationId: Int): Flow<Resource<CurrentWeather>> =
        flow {
            try {
                emit(Loading())
                val result = repository.getCurrentWeather(locationId)

                emit(Success(result))
            } catch (e: HttpException) {
                Log.d("GetCurrentWeather", e.toString())
                emit(Error())
            } catch (e: IOException) {
                Log.d("GetCurrentWeather", e.toString())
                emit(Error())
            } catch (e: Exception) {
                Log.d("GetCurrentWeather", e.toString())
                emit(Error())
            }
        }
}