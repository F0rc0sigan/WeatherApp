package com.forcosigan.weatherapp.data.DataSource.API.Entity

import com.forcosigan.weatherapp.domain.Model.Location
import kotlinx.serialization.Serializable

@Serializable
data class LocationApiEntity(
    val id: Int,
    val name: String,
    val region: String,
    val country: String
)

fun LocationApiEntity.toLocation(): Location {
    return Location(
        id = id,
        name = name,
        region = region,
        country = country
    )
}