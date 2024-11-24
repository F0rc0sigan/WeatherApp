package com.forcosigan.weatherapp.domain.UseCase

import com.forcosigan.weatherapp.Repository.PreferenceRepository
import com.forcosigan.weatherapp.domain.Model.Location
import javax.inject.Inject

class GetStoredLocation @Inject constructor(private val repository: PreferenceRepository) {
    operator fun invoke(): Location? {
        if (repository.selectedLocationName.isEmpty()) return null

        return Location(repository.selectedLocationId, repository.selectedLocationName, "", "")
    }
}