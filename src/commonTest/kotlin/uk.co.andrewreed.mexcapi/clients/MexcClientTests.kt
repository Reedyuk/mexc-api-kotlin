package uk.co.andrewreed.mexcapi.clients

import uk.co.andrewreed.mexcapi.runTest
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class MexcClientTests {

    @Test
    fun orderbookTest() = runTest {
        val orderBook = MexcClient().marketDataClient.orderBook("BTCUSDT")
        assertTrue(orderBook.asks.isNotEmpty())
        assertTrue(orderBook.bids.isNotEmpty())
    }

    @Test
    fun tradesTest() = runTest {
        val trades = MexcClient().marketDataClient.trades("BTCUSDT")
        assertTrue(trades.isNotEmpty())
    }

    @Test
    fun historicTradesTest() = runTest {
        val trades = MexcClient().marketDataClient.historicalTrades("BTCUSDT")
        assertTrue(trades.isNotEmpty())
    }

    @Test
    fun averagePriceTest() = runTest {
        val averagePrice = MexcClient().marketDataClient.averagePrice("BTCUSDT")
        assertNotNull(averagePrice.price)
    }

    @Test
    fun dayTickerTest() = runTest {
        val tickers = MexcClient().marketDataClient.dayTicker()
        assertTrue(tickers.isNotEmpty())
    }

//    @Test
//    fun tickerPriceTest() = runTest {
//        val tickers = MexcClient().tickerPrice()
//        assertTrue(tickers.isNotEmpty())
//    }

}
