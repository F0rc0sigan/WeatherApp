package com.forcosigan.weatherapp.UI.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.forcosigan.weatherapp.domain.Model.Location
import com.forcosigan.weatherapp.domain.Model.Resource
import com.forcosigan.weatherapp.domain.UseCase.GetCurrentWeather
import com.forcosigan.weatherapp.domain.UseCase.GetLocationForSearchQuery
import com.forcosigan.weatherapp.domain.UseCase.GetStoredLocation
import com.forcosigan.weatherapp.domain.UseCase.SaveLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCurrentWeather: GetCurrentWeather,
    private val getLocationForSearchQuery: GetLocationForSearchQuery,
    private val saveLocation: SaveLocation,
    private val getStoredLocation: GetStoredLocation
) : ViewModel() {
    private val _uiState: MutableHomeUiState = MutableHomeUiState(
        true
    )
    val uiState: HomeUiState = _uiState

    init {

        viewModelScope.launch {
            kotlinx.coroutines.delay(100)
            val storedLocation = getStoredLocation()
            if (storedLocation?.name != null) {
                _uiState.showNoSelectedLocation = false
            }
            selectLocation(storedLocation)
        }
    }

    fun updateSearchQuery(query: String) {
        if (!query.isEmpty()) {
            _uiState.showNoSelectedLocation = false
        }

        _uiState.searchQuery = query

        if (!uiState.searchQuery.isNullOrBlank() && uiState.searchQuery!!.length > 2) {
            viewModelScope.launch {
                getLocationForSearchQuery(uiState.searchQuery!!).distinctUntilChanged()
                    .collectLatest { result ->
                        when (result) {
                            is Resource.Success -> {
                                if (result.data != null) {
                                    _uiState.isLoading = false
                                    _uiState.searchResults = result.data
                                }
                            }

                            is Resource.Error -> {
                                _uiState.isLoading = false
                            }

                            is Resource.Loading -> {
                                _uiState.isLoading = true
                            }

                            else -> Unit
                        }
                    }

            }
        }
    }

    fun selectLocation(location: Location?) {
        if (location == null) return

        viewModelScope.launch {
            getCurrentWeather(location.id).distinctUntilChanged()
                .collectLatest { result ->
                    when (result) {
                        is Resource.Success -> {
                            if (result.data != null) {
                                _uiState.isLoading = false
                                _uiState.currentWeather = result.data
                                _uiState.selectedLocation = location.name
                                _uiState.searchResults = listOf()

                                saveLocation(location)
                            }
                        }

                        is Resource.Error -> {
                            _uiState.isLoading = false
                        }

                        is Resource.Loading -> {
                            _uiState.isLoading = true
                        }

                        else -> Unit
                    }
                }


        }
    }
}