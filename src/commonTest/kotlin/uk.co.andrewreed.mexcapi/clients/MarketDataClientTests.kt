package uk.co.andrewreed.mexcapi.clients

import uk.co.andrewreed.mexcapi.runTest
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class MarketDataClientTests {

    private val privateKey: String = ""
    private val secretKey: String = ""

    private val client = MexcClient(privateKey, secretKey)

    @Test
    fun orderbookTest() = runTest {
        val orderBook = client.marketDataClient.orderBook("BTCUSDT")
        assertTrue(orderBook.asks.isNotEmpty())
        assertTrue(orderBook.bids.isNotEmpty())
    }

    @Test
    fun tradesTest() = runTest {
        val trades = client.marketDataClient.trades("BTCUSDT")
        assertTrue(trades.isNotEmpty())
    }

    @Test
    fun historicTradesTest() = runTest {
        val trades = client.marketDataClient.historicalTrades("BTCUSDT")
        assertTrue(trades.isNotEmpty())
    }

    @Test
    fun averagePriceTest() = runTest {
        val averagePrice = client.marketDataClient.averagePrice("BTCUSDT")
        assertNotNull(averagePrice.price)
    }

    @Test
    fun dayTickerTest() = runTest {
        val tickers = client.marketDataClient.dayTicker()
        assertTrue(tickers.isNotEmpty())
    }

//    @Test
//    fun tickerPriceTest() = runTest {
//        val tickers = MexcClient().tickerPrice()
//        assertTrue(tickers.isNotEmpty())
//    }

}
