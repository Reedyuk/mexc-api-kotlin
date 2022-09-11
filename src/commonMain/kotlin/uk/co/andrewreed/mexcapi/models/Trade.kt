package uk.co.andrewreed.mexcapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Trade(
    val id: String?,
    val price: String,
    val qty: String,
    val quoteQty: String,
    val time: String,
    val isBuyerMaker: Boolean,
    val isBestMatch: Boolean
)
