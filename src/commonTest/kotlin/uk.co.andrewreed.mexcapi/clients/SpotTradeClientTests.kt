package uk.co.andrewreed.mexcapi.clients

import uk.co.andrewreed.mexcapi.runTest
import kotlin.test.Test

class SpotTradeClientTests {

    private val privateKey: String = ""
    private val secretKey: String = ""

    private val client = MexcClient(privateKey, secretKey)

    @Test
    fun allOrdersTest() = runTest {
        val orders = client.spotTradeClient.allOrders("LUNCUSDT")
        println(orders)
    }

    @Test
    fun openOrdersTest() = runTest {
        val orders = client.spotTradeClient.openOrders("LUNCUSDT")
        println(orders)
    }

//    @Test
//    fun existingOrderTest() = runTest {
//        val order = MexcClient().spotTradeClient.order("LUNCUSDT", "1")
//        println(order)
//    }

    @Test
    fun tradesTest() = runTest {
        val trades = client.spotTradeClient.myTrades("LUNCUSDT")
        println(trades)
    }

    @Test
    fun accountTest() = runTest {
        val account = client.spotTradeClient.account()
        println(account)
    }

}