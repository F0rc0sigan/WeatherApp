package com.forcosigan.weatherapp.domain.UseCase

import com.forcosigan.weatherapp.Repository.PreferenceRepository
import com.forcosigan.weatherapp.domain.Model.Location
import javax.inject.Inject

class SaveLocation @Inject constructor(private val repository: PreferenceRepository) {
    suspend operator fun invoke(location: Location) {
        repository.saveSelectedLocationId(location.id)
        repository.saveSelectedLocationName(location.name)
    }
}