package uk.co.andrewreed.mexcapi.models

enum class OrderType {
    LIMIT,
    MARKET,
    LIMIT_MAKER,
    IMMEDIATE_OR_CANCEL,
    FILL_OR_KILL
}

/*
LIMIT (Limit order)
MARKET (Market order)
LIMIT_MAKER (Limit maker order)
IMMEDIATE_OR_CANCEL (Immediate or cancel order)
FILL_OR_KILL (Fill or kill order)
 */