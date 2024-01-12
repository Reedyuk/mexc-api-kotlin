package uk.co.andrewreed.mexcapi.clients

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.datetime.Clock
import kotlinx.serialization.json.JsonObject
import uk.co.andrewreed.mexcapi.models.MyTrade
import uk.co.andrewreed.mexcapi.models.Order
import uk.co.andrewreed.mexcapi.models.OrderSide
import uk.co.andrewreed.mexcapi.models.OrderType
import uk.co.andrewreed.mexcapi.requestParamString
import uk.co.andrewreed.mexcapi.sign

class SpotTradeClient(
    private val privateKey: String,
    private val secretKey: String,
    private val client: HttpClient,
    private val buildUrl: (path: String) -> String
) {
    /*
    if (api_secret) {
    let queryString = Object.keys(paramsObject).map((key) => {
        return `${key}=${paramsObject[key]}`;
    }).join('&');
    console.log('queryString',queryString);
    // queryString = "timestamp=1645522175785"
    // const api_secret = "99d5cd6c195c4e97b3094578eaa9335c"
    const signature = CryptoJS.HmacSHA256(queryString, api_secret).toString();
    console.log('signature',signature)
    pm.environment.set("signature", signature);
}
     */
    private fun createAuthenticatedUrl(path: String, params: Map<String, String>): String =
        Clock.System.now().toEpochMilliseconds().let { time ->
            val queryString = "${params.requestParamString()}&timestamp=$time"
            val signature = sign(
                secretKey,
                queryString
            )
            buildUrl("$path?${queryString}&signature=$signature")
        }

    private suspend fun createAuthenticatedRequest(
        path: String,
        requestMethod: HttpMethod = HttpMethod.Get,
        params: Map<String, String> = emptyMap()
    ): HttpResponse =
        client.request(createAuthenticatedUrl(path, params)) {
            method = requestMethod
            headers { append("x-mexc-apikey", privateKey) }
        }

    suspend fun allOrders(symbol: String): List<Order> =
        createAuthenticatedRequest(
            path = "/api/v3/allOrders",
            params = mapOf("symbol" to symbol.uppercase())
        ).body()

    suspend fun order(symbol: String, orderId: String): Order =
        createAuthenticatedRequest(
            path = "/api/v3/order",
            params = mapOf(
                "symbol" to symbol.uppercase(),
                "orderId" to orderId
            )
        ).body()

    suspend fun openOrders(symbol: String): List<Order> =
        createAuthenticatedRequest(
            path = "/api/v3/openOrders",
            params = mapOf("symbol" to symbol.uppercase())
        ).body()

    suspend fun account(): JsonObject =
        createAuthenticatedRequest(path = "/api/v3/account").body()

    suspend fun myTrades(symbol: String): List<MyTrade> =
        createAuthenticatedRequest(
            path = "/api/v3/myTrades",
            params = mapOf("symbol" to symbol.uppercase())
        ).body()

    suspend fun createOrder(symbol: String, side: OrderSide, type: OrderType, quantity: String? = null, quoteOrderQty: String? = null, price: String? = null): Order =
        createAuthenticatedRequest(
            path = "/api/v3/order",
            requestMethod = HttpMethod.Post,
            params = mapOf(
                "symbol" to symbol.uppercase(),
                "side" to side.name,
                "type" to type.name
            )
            + (quantity?.let { mapOf("quantity" to it) } ?: mapOf())
            + (quoteOrderQty?.let { mapOf("quoteOrderQty" to it) } ?: mapOf())
            + (price?.let { mapOf("price" to it) } ?: mapOf())
        ).body()

    suspend fun createTestOrder(symbol: String, side: OrderSide, type: OrderType, quantity: String? = null, quoteOrderQty: String? = null, price: String? = null): Order =
        createAuthenticatedRequest(
            path = "/api/v3/order/test",
            requestMethod = HttpMethod.Post,
            params = mapOf(
                "symbol" to symbol.uppercase(),
                "side" to side.name,
                "type" to type.name
            )
            + (quantity?.let { mapOf("quantity" to it) } ?: mapOf())
            + (quoteOrderQty?.let { mapOf("quoteOrderQty" to it) } ?: mapOf())
            + (price?.let { mapOf("price" to it) } ?: mapOf())
        ).body()

    suspend fun deleteOrder(symbol: String, orderId: String): JsonObject =
        createAuthenticatedRequest(
            path = "/api/v3/order",
            requestMethod = HttpMethod.Delete,
            params = mapOf(
                "symbol" to symbol.uppercase(),
                "orderId" to orderId
            )
        ).body()

    suspend fun deleteOpenOrders(symbol: String): JsonObject =
        createAuthenticatedRequest(
            path = "/api/v3/openOrders",
            requestMethod = HttpMethod.Delete,
            params = mapOf("symbol" to symbol.uppercase())
        ).body()
}
