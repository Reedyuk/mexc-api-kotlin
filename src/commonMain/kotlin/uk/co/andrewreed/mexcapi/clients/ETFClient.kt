package uk.co.andrewreed.mexcapi.clients

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.json.JsonObject

class ETFClient(private val client: HttpClient, private val buildUrl: (path: String) -> String) {

    suspend fun info(): JsonObject =
        client.get(buildUrl("/api/v3/etf/info")).body()

}