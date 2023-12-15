package uk.co.andrewreed.mexcapi.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class KLine(
    val openTime: Instant,
    val open: Float,
    val high: Float,
    val low: Float,
    val close: Float,
    val volume: Float,
    val closeTime: Instant,
    val assetVolume: Float,
) {
    companion object {
        fun fromArray(array: List<String>) = KLine(
            Instant.fromEpochMilliseconds(array[0].toLong()),
            array[1].toFloat(),
            array[2].toFloat(),
            array[3].toFloat(),
            array[4].toFloat(),
            array[5].toFloat(),
            Instant.fromEpochMilliseconds(array[6].toLong()),
            array[7].toFloat(),
        )
    }
}
