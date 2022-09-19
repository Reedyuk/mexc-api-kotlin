package uk.co.andrewreed.mexcapi.clients

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.json.JsonObject
import uk.co.andrewreed.mexcapi.models.*

class MarketDataClient(private val client: HttpClient, private val buildUrl: (path: String) -> String) {

    suspend fun testConnectivity(): JsonObject =
        client.get(buildUrl("/api/v3/ping")).body()

    suspend fun checkServerTime(): JsonObject =
        client.get(buildUrl("/api/v3/time")).body()

    suspend fun exchangeInfo(): JsonObject =
        client.get(buildUrl("/api/v3/exchangeInfo")).body()

    suspend fun orderBook(symbol: String): OrderBook =
        client.get(buildUrl("/api/v3/depth?symbol=$symbol")).body()

    suspend fun trades(symbol: String): List<Trade> =
        client.get(buildUrl("/api/v3/trades?symbol=$symbol")).body()

    suspend fun historicalTrades(symbol: String): List<Trade> =
        client.get(buildUrl("/api/v3/historicalTrades?symbol=$symbol")).body()

    suspend fun aggTrades(symbol: String): List<Trade> =
        client.get(buildUrl("/api/v3/aggTrades?symbol=$symbol")).body()

    suspend fun klines(symbol: String, interval: String): List<Trade> =
        client.get(buildUrl("/api/v3/klines?symbol=$symbol&interval=$interval")).body()

    suspend fun averagePrice(symbol: String): AveragePrice =
        client.get(buildUrl("/api/v3/avgPrice?symbol=$symbol")).body()

    suspend fun dayTicker(): List<Ticker> =
        client.get(buildUrl("/api/v3/ticker/24hr")).body()

    suspend fun tickerPrice(): List<SymbolPrice> =
        client.get(buildUrl("/api/v3/ticker/price")).body()

    suspend fun bookTicker(): JsonObject =
        client.get(buildUrl("/api/v3/ticker/bookTicker")).body()
}