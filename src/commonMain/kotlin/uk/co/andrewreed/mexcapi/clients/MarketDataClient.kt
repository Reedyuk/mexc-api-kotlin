package uk.co.andrewreed.mexcapi.clients

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import uk.co.andrewreed.mexcapi.models.*

class MarketDataClient(private val client: HttpClient, private val buildUrl: (path: String) -> String) {
    suspend fun orderBook(symbol: String): OrderBook =
        client.get(buildUrl("/api/v3/depth?symbol=$symbol")).body()

    suspend fun trades(symbol: String): List<Trade> =
        client.get(buildUrl("/api/v3/trades?symbol=$symbol")).body()

    suspend fun historicalTrades(symbol: String): List<Trade> =
        client.get(buildUrl("/api/v3/historicalTrades?symbol=$symbol")).body()

    suspend fun averagePrice(symbol: String): AveragePrice =
        client.get(buildUrl("/api/v3/avgPrice?symbol=$symbol")).body()

    suspend fun dayTicker(): List<Ticker> =
        client.get(buildUrl("/api/v3/ticker/24hr")).body()

    suspend fun tickerPrice(): List<SymbolPrice> =
        client.get(buildUrl("/api/v3/ticker/price")).body()
}