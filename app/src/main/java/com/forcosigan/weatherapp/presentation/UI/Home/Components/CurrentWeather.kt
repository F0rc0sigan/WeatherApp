package com.forcosigan.weatherapp.presentation.UI.Home.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.forcosigan.weatherapp.R
import com.forcosigan.weatherapp.domain.Model.CurrentWeather
import com.forcosigan.weatherapp.presentation.Theme.defaultSubColor
import com.forcosigan.weatherapp.presentation.Theme.inputBackgroundColor
import kotlin.math.roundToInt

@Composable
fun CurrentWeather(currentWeather: CurrentWeather, selectedLocationName: String) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 200.dp)
    ) {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https:${currentWeather.conditionIcon}")

                .size(Size.ORIGINAL) // Set the target size to load the image at.
                .build()
        )

        Image(
            painter = painter,
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            modifier = Modifier
                .size(120.dp),

            )

        Row(modifier = Modifier.padding(vertical = 10.dp)) {
            Text(
                selectedLocationName,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Image(
                painter = painterResource(id = R.drawable.location),
                contentDescription = "Example Image",
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 8.dp),
                contentScale = ContentScale.Fit
            )
        }
        Text(
            "°${currentWeather.temperatureInCelsius.roundToInt().toString()}",
            fontSize = 70.sp,
            textAlign = TextAlign.Center
        )

        Row(
            Modifier
                .width(250.dp)
                .padding(top = 24.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(inputBackgroundColor)
                .padding(18.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ExtraDataColumn("Humidity", "${currentWeather.humidity.toString()}%")
            ExtraDataColumn("UV", currentWeather.uv.toString())
            ExtraDataColumn("Feels Like", "°${currentWeather.feelsLikeInCelsius.toString()}")
        }
    }
}

@Composable
private fun ExtraDataColumn(label: String, value: String) {
    Column(Modifier.wrapContentSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            label,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = defaultSubColor
        )
        Text(
            value,
            textAlign = TextAlign.Center,
            color = defaultSubColor,
            fontWeight = FontWeight.Bold
        )
    }
}