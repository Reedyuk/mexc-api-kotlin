package uk.co.andrewreed.mexcapi.models

import kotlinx.serialization.Serializable

@Serializable
data class MyTrade(
    val symbol: String,
    val id: String,
    val orderId: String,
    val orderListId: Int,
    val price: String,
    val qty: String,
    val quoteQty: String,
    val commission: String,
    val commissionAsset: String,
    val time: String,
    val isBuyer: Boolean,
    val isMaker: Boolean,
    val isBestMatch: Boolean,
    val isSelfTrade: Boolean,
    val clientOrderId: String?
)
