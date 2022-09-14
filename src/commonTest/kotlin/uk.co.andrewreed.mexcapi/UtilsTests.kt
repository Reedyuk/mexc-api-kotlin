package uk.co.andrewreed.mexcapi

import kotlin.test.Test
import kotlin.test.assertEquals

class UtilsTests {
    @Test
    fun signTest() = runTest {
        val signature = sign(
            "903ea2b397e2c472cfbbb37fed0900c2bbb156a255d81e4232e2d08a24c283e8",
            "1663094390599",
            mapOf("symbol" to "LUNCUSDT")
        )
        assertEquals("e538353cf2d1df6c36580735f3e408d5b7dc224ba8d534117b614e63b99fb93b", signature)
    }
}