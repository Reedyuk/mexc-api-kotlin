package uk.co.andrewreed.mexcapi.models

import kotlinx.serialization.Serializable

@Serializable
data class AveragePrice(
    val mins: Int,
    val price: String
)
