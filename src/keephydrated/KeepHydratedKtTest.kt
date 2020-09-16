package keephydrated

import org.junit.Assert.*
import org.junit.Test

class KeepHydratedKtTest {

    private fun rand(from: Int, to: Int): Double {
        return Math.floor((to - from + 1) * Math.random() + from * 10) / 10
    }

    @Test
    fun testFixed() {
        assertEquals(1, litres(2.0))
        assertEquals(0, litres(1.4))
        assertEquals(6, litres(12.3))
        assertEquals(0, litres(0.82))
        assertEquals(5, litres(11.8))
        assertEquals(893, litres(1787.0))
        assertEquals(0, litres(0.0))
    }

    @Test
    fun testRandom() {
        for (i in 1..100) {
            val time = rand(0, 10000)
            assertEquals(litres(time), litres(time))
        }
    }
}