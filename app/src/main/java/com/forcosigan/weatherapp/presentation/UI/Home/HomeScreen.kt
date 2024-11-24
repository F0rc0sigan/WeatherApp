package com.forcosigan.weatherapp.UI.Home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.forcosigan.weatherapp.R
import com.forcosigan.weatherapp.domain.Model.Location
import com.forcosigan.weatherapp.presentation.UI.Components.CustomTextInput
import com.forcosigan.weatherapp.presentation.UI.Components.Loading
import com.forcosigan.weatherapp.presentation.UI.Home.Components.CurrentWeather
import com.forcosigan.weatherapp.presentation.UI.Home.Components.NoSelectedLocation
import com.forcosigan.weatherapp.presentation.UI.Home.Components.SearchResults

@Composable
fun HomeScreen(
) {
    val viewModel = hiltViewModel<HomeViewModel>()
    HomeScreen(viewModel)
}

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    HomeScreen(viewModel.uiState, viewModel::updateSearchQuery, viewModel::selectLocation)
}

@Composable
fun HomeScreen(
    state: HomeUiState,
    updateSearchQuery: (String) -> Unit,
    selectLocation: (Location) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxSize()
    ) {
        CustomTextInput(
            if (state.searchQuery != "") state.searchQuery.toString() else "",
            Modifier
                .fillMaxWidth()
                .padding(top = 44.dp)
                .height(46.dp),
            placeholder = stringResource(id = R.string.search_location_placeholder),
            valueChange = { field: String ->
                updateSearchQuery(field)
            },
            rightIcon = Icons.Filled.Search
        )

        if (state.isLoading) {
            Loading()
        } else {
            if (state.showNoSelectedLocation) {
                NoSelectedLocation()
            }
            SearchResults(state.searchResults, selectLocation)

            if (state.currentWeather != null && state.searchResults.isEmpty()) {
                CurrentWeather(state.currentWeather!!, state.selectedLocation ?: "")
            }
        }
    }
}

