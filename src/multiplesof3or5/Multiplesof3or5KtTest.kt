package multiplesof3or5

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class Multiplesof3or5KtTest {
    private fun _solution(number: Int): Int {
        var sum = 0
        for (i in 1 until number) {
            sum += if (i % 3 == 0 || i % 5 == 0) i else 0
        }
        return sum
    }

    private val random = Random()

    @Test
    fun testFixed() {
        assertEquals(23, solution(10))
        assertEquals(78, solution(20))
        assertEquals(9168, solution(200))
        assertEquals(0, solution(-1))
        assertEquals(0, solution(0))
        assertEquals(0, solution(1))
        assertEquals(0, solution(3))
        assertEquals(3, solution(4))
    }

    @Test
    fun testRandom() {
        for (i in 1..92) {
            val rand = random.nextInt(1000)
            assertEquals(_solution(rand), solution(rand))
        }
    }
}