package uk.co.andrewreed.mexcapi.Client

import uk.co.andrewreed.mexcapi.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class MexcClientTests {

    @Test
    fun orderbookTest() = runTest {
        val orderBook = MexcClient().orderBook("BTCUSDT")
        assertTrue(orderBook.asks.isNotEmpty())
        assertTrue(orderBook.bids.isNotEmpty())
    }

    @Test
    fun tradesTest() = runTest {
        val trades = MexcClient().trades("BTCUSDT")
        println(trades)
        assertTrue(trades.isNotEmpty())
    }
}
