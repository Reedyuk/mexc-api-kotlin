package uk.co.andrewreed.mexcapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Ticker(
    val symbol: String,
    val priceChange: String,
    val priceChangePercent: String,
    val prevClosePrice: String,
    val lastPrice: String,
    val bidPrice: String,
    val bidQty: String,
    val askPrice: String,
    val askQty: String,
    val openPrice: String,
    val highPrice: String,
    val lowPrice: String,
    val volume: String,
    val quoteVolume: String,
    val openTime: String,
    val closeTime: String,
    val count: String?
)

//{
//        "symbol": "TOMO3LUSDT",
//        "priceChange": "-0.009",
//        "priceChangePercent": "-0.0117647",
//        "prevClosePrice": "0.765",
//        "lastPrice": "0.756",
//        "bidPrice": "0.754",
//        "bidQty": "18.62",
//        "askPrice": "0.76",
//        "askQty": "268.72",
//        "openPrice": "0.765",
//        "highPrice": "0.793",
//        "lowPrice": "0.714",
//        "volume": "264942.64",
//        "quoteVolume": "201698.647",
//        "openTime": 1662924600000,
//        "closeTime": 1662924663111,
//        "count": null
//    },
