package overtheroad

import org.junit.Assert.*
import org.junit.Test

class OverTheRoadKtTest {
    @Test
    fun Examples() {
        println("(1,3) --> 6")
        assertEquals(overTheRoad(1,3), 6)
        println("(3,3) --> 4")
        assertEquals(overTheRoad(3,3), 4)
        println("(2,3) --> 5")
        assertEquals(overTheRoad(2,3), 5)
        println("(3,5) --> 8")
        assertEquals(overTheRoad(3,5), 8)
        println("(7,11) --> 16")
        assertEquals(overTheRoad(7,11), 16)
        println("(20,1000000) -->1999981")
        assertEquals(overTheRoad(20,1000000), 1999981)
    }
}