package com.forcosigan.weatherapp.UI.Home

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.forcosigan.weatherapp.domain.Model.CurrentWeather
import com.forcosigan.weatherapp.domain.Model.Location


@Stable
interface HomeUiState {
    val searchQuery: String?
    val currentWeather: CurrentWeather?
    val searchResults: List<Location>
    var showNoSelectedLocation: Boolean
    var isLoading: Boolean
    var selectedLocation: String?
}

internal class MutableHomeUiState(
    _showNoSelectedLocation: Boolean

) : HomeUiState {
    override var searchResults: List<Location> by mutableStateOf(listOf())
    override var currentWeather: CurrentWeather? by mutableStateOf(null)
    override var searchQuery: String? by mutableStateOf("")
    override var selectedLocation: String? by mutableStateOf("")

    override var showNoSelectedLocation: Boolean by mutableStateOf(_showNoSelectedLocation)
    override var isLoading: Boolean by mutableStateOf(false)
}