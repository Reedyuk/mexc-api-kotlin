package uk.co.andrewreed.mexcapi.clients

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*

class MexcClient(privateKey: String, secretKey: String) {

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

    val marketDataClient = MarketDataClient(ktorClient) { path ->
        "$url$path"
    }

    val etfClient = ETFClient(ktorClient) { path ->
        "$url$path"
    }

    val spotTradeClient = SpotTradeClient(privateKey, secretKey, ktorClient) { path ->
        "$url$path"
    }

}
