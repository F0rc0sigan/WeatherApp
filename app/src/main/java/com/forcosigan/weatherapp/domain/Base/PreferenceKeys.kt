package com.forcosigan.weatherapp.domain.Base

import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferenceKeys {
    val SELECTED_LOCATION_ID = intPreferencesKey("SELECTED_LOCATION")
    val SELECTED_LOCATION_NAME = stringPreferencesKey("SELECTED_LOCATION_NAME")
}