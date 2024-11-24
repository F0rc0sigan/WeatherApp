package com.forcosigan.weatherapp.presentation.UI.Main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.forcosigan.weatherapp.R
import com.forcosigan.weatherapp.UI.Main.MainScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //private val applicationState by viewModels<ApplicationStateViewModel>()
    //private val dimensions: AppDimensions = AppDimensions()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //applicationState.appContext.currentActivity.value = this

        setTheme(R.style.Theme_WeatherApp)
        setContent { StartScreen() }

    }


    @Composable
    fun StartScreen() {
        CompositionLocalProvider(
            //ApplicationState provides applicationState,
            //LocalDimensions provides dimensions
        ) {
            MaterialTheme {
                MainScreen()
            }
        }
    }
}
