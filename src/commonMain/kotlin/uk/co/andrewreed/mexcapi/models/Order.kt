package uk.co.andrewreed.mexcapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val symbol: String,
    val orderId: String,
    val orderListId: Int,
    val clientOrderId: String?,
    val price: String,
    val origQty: String,
    val executedQty: String,
    val cummulativeQuoteQty: String,
    val status: String,
    val timeInForce: String?,
    val type: String,
    val side: String,
    val stopPrice: String?,
    val icebergQty: String?,
    val time: String,
    val updateTime: String,
    val isWorking: Boolean,
    val origQuoteOrderQty: String
)

//{
//        "symbol": "LUNCUSDT",
//        "orderId": "8cce765bafd34be08c6ef249b15518bb",
//        "orderListId": -1,
//        "clientOrderId": null,
//        "price": "0.07",
//        "origQty": "7125632.57",
//        "executedQty": "0",
//        "cummulativeQuoteQty": "0",
//        "status": "CANCELED",
//        "timeInForce": null,
//        "type": "LIMIT",
//        "side": "SELL",
//        "stopPrice": null,
//        "icebergQty": null,
//        "time": 1662961283000,
//        "updateTime": 1662964621000,
//        "isWorking": true,
//        "origQuoteOrderQty": "498794.2799"
//    }
