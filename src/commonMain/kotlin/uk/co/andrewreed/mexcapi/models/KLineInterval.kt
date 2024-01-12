package uk.co.andrewreed.mexcapi.models

enum class KLineInterval(val value: String) {
    OneMinute("1m"),
    FiveMinutes("5m"),
    FifteenMinutes("15m"),
    ThirtyMinutes("30m"),
    SixtyMinutes("60m"),
    FourHours("4h"),
    OneDay("1d"),
    OneMonth("1m"),
}

//1m 1 minute
//5m 5 minute
//15m 15 minute
//30m 30 minute
//60m 60 minute
//4h 4 hour
//1d 1 day
//1M 1 month