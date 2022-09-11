package uk.co.andrewreed.mexcapi.models

import kotlinx.serialization.Serializable

@Serializable
data class OrderBook(
    val lastUpdateId: String,
    val bids: List<List<String>>,
    val asks: List<List<String>>
)
