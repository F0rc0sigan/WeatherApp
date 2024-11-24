package com.forcosigan.weatherapp.presentation.UI.Home.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.forcosigan.weatherapp.domain.Model.Location
import com.forcosigan.weatherapp.presentation.Theme.inputBackgroundColor

@Composable
fun SearchResults(locations: List<Location>, selectLocation: (Location) -> Unit) {
    if (locations.isNotEmpty()) {
        val listState = rememberLazyGridState()

        LazyVerticalGrid(
            modifier = Modifier
                .padding(top = 100.dp)
                .background(MaterialTheme.colors.background),
            state = listState,
            columns = GridCells.Fixed(1),
            content = {
                items(locations.count()) { index ->
                    LocationView(location = locations[index], selectLocation = selectLocation)
                }
            }
        )
    }
}

@Composable
fun LocationView(location: Location, selectLocation: (Location) -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { selectLocation(location) }
            .background(inputBackgroundColor)
            .padding(vertical = 18.dp)

    ) {
        Text(
            location.name,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(horizontal = 24.dp)

        )
        Text(
            location.country,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(horizontal = 24.dp)

        )
    }
}