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
import uk.co.andrewreed.mexcapi.requestParamString
import uk.co.andrewreed.mexcapi.sign

class SpotTradeClient(
    private val privateKey: String,
    private val secretKey: String,
    private val client: HttpClient,
    private val buildUrl: (path: String) -> String
) {
    private fun createAuthenticatedUrl(path: String, params: Map<String, String>): String =
        Clock.System.now().toEpochMilliseconds().let { time ->
            val signature = sign(
                secretKey,
                time.toString(),
                params
            )
            buildUrl("$path?${params.requestParamString()}&timestamp=$time&signature=$signature")
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

}
