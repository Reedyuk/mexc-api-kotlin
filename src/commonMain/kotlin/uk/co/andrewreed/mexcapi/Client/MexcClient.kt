package uk.co.andrewreed.mexcapi.Client

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import uk.co.andrewreed.mexcapi.Models.OrderBook

class MexcClient() {

    private val url: String = "https://api.mexc.com"

    private val ktorClient: HttpClient = HttpClient {
        install(ContentNegotiation) { json() }
        expectSuccess = true
        developmentMode = true
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    suspend fun orderBook(symbol: String): OrderBook =
        ktorClient.get("$url/api/v3/depth?symbol=$symbol").body()

}
