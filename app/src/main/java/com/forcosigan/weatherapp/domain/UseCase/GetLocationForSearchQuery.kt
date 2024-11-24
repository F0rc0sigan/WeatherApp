package com.forcosigan.weatherapp.domain.UseCase

import android.util.Log
import coil.network.HttpException
import com.forcosigan.weatherapp.Repository.WeatherRepository
import com.forcosigan.weatherapp.domain.Model.Location
import com.forcosigan.weatherapp.domain.Model.Resource
import com.forcosigan.weatherapp.domain.Model.Resource.Error
import com.forcosigan.weatherapp.domain.Model.Resource.Loading
import com.forcosigan.weatherapp.domain.Model.Resource.Success
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetLocationForSearchQuery @Inject constructor(private val repository: WeatherRepository) {
    operator fun invoke(query: String): Flow<Resource<List<Location>>> =
        flow {
            try {
                emit(Loading())
                val locations = repository.getLocations(query)

                emit(Success(locations))
            } catch (e: HttpException) {
                Log.d("GetLocationForSearchQuery", e.toString())
                emit(Error())
            } catch (e: IOException) {
                Log.d("GetLocationForSearchQuery", e.toString())
                emit(Error())
            } catch (e: Exception) {
                Log.d("GetLocationForSearchQuery", e.toString())
                emit(Error())
            }
        }
}