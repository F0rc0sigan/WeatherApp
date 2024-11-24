package com.forcosigan.weatherapp.di

import com.forcosigan.weatherapp.DataSource.WeatherDataSource
import com.forcosigan.weatherapp.Repository.WeatherApiRepositoryImpl
import com.forcosigan.weatherapp.Repository.WeatherRepository
import com.forcosigan.weatherapp.Repository.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class AppModuleBinds {

    @Singleton
    @Binds
    abstract fun provideWeatherApiRepositoryImpl(weatherDataSource: WeatherApiRepositoryImpl): WeatherDataSource

    @Singleton
    @Binds
    abstract fun provideWeatherRepositoryImpl(weatherRepository: WeatherRepositoryImpl): WeatherRepository


}