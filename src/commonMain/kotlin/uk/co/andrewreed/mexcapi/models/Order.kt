package uk.co.andrewreed.mexcapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val symbol: String,
    val orderId: String,
    val orderListId: Int,
    val clientOrderId: String? = null,
    val price: String,
    val origQty: String,
    val executedQty: String? = null,
    val cummulativeQuoteQty: String? = null,
    val status: String? = null,
    val timeInForce: String? = null,
    val type: String,
    val side: String,
    val stopPrice: String? = null,
    val icebergQty: String? = null,
    val time: String? = null,
    val updateTime: String? = null,
    val isWorking: Boolean? = null,
    val origQuoteOrderQty: String? = null,
    val transactTime: String? = null
)

//symbol	Symbol
//orderId	order id
//orderListId	order list id
//price	Price
//origQty	Original order quantity
//type	Order type
//side	order side
//transactTime	transactTime

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
