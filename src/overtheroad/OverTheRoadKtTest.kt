package overtheroad

import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.TestMethodOrder
import kotlin.test.assertEquals

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class OverTheRoadKtTest {
    @Test
    @Order(1)
    @DisplayName("Examples")
    fun Examples() {
        println("(1,3) --> 6")
        assertEquals(6, overTheRoad(1, 3))
        println("(3,3) --> 4")
        assertEquals(4, overTheRoad(3, 3))
        println("(2,3) --> 5")
        assertEquals(5, overTheRoad(2, 3))
        println("(3,5) --> 8")
        assertEquals(8, overTheRoad(3, 5))
        println("(7,11) --> 16")
        assertEquals(16, overTheRoad(7, 11))
        println("(20,1000000) -->1999981")
        assertEquals(1999981, overTheRoad(20, 1000000))
    }

    @Test
    @Order(2)
    @DisplayName("Advanced Tests")
    fun AdvancedTests() {

        fun r13(a: Int, b: Int): Int {
            return 2 * b - a + 1
        }

        for (i in 1..194) {
            println("Test ${i}")
            val street = Math.ceil(Math.random() * 500000000000).toInt()
            val address = Math.ceil(Math.random() * (2 * street - 1)).toInt()
            val expected = r13(address, street)
            assertEquals(expected, overTheRoadBest(address, street), "address=${address}, street=${street}")
        }
    }
}