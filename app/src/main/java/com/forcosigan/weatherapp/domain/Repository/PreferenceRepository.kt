package com.forcosigan.weatherapp.Repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.forcosigan.weatherapp.domain.Base.PreferenceKeys.SELECTED_LOCATION_ID
import com.forcosigan.weatherapp.domain.Base.PreferenceKeys.SELECTED_LOCATION_NAME
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@OptIn(DelicateCoroutinesApi::class)
@Singleton
class PreferenceRepository @Inject constructor(private val dataStore: DataStore<Preferences>) {

    private var _selectedLocationId: Int = 0
    val selectedLocationId: Int
        get() {
            return _selectedLocationId
        }

    suspend fun saveSelectedLocationId(value: Int) {
        _selectedLocationId = value
        dataStore.edit { it[SELECTED_LOCATION_ID] = value }
    }

    private var _selectedLocationName = ""
    val selectedLocationName
        get() = _selectedLocationName

    suspend fun saveSelectedLocationName(value: String) {
        _selectedLocationName = value
        dataStore.edit { it[SELECTED_LOCATION_NAME] = value }
    }

    init {
        GlobalScope.launch {
            val data = dataStore.data.first()
            _selectedLocationId = data.getIntPrefOrDefault(SELECTED_LOCATION_ID)
            _selectedLocationName = data.getStringPrefOrDefault(SELECTED_LOCATION_NAME)
        }
    }


}

private fun Preferences.getStringPrefOrDefault(
    key: Preferences.Key<String>
) =
    this[key] ?: ""

private fun Preferences.getIntPrefOrDefault(
    key: Preferences.Key<Int>
) =
    this[key] ?: 0