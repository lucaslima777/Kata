package directionsreduction

import org.junit.Assert.*
import org.junit.Test

class DirectionsReductionKtTest {

    private fun testing(arr: Array<String>, expect: Array<String>) {
        val actual: Array<String> = DirReduction.dirReduc(arr)
        assertEquals(expect.contentDeepToString(), actual.contentDeepToString())
    }
    @Test
    fun basicTests() {
        var a = arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST")
        testing(a, arrayOf("WEST"))
        a = arrayOf("NORTH", "WEST", "SOUTH", "EAST")
        testing(a, arrayOf("NORTH", "WEST", "SOUTH", "EAST"))
        a = arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "NORTH")
        testing(a, arrayOf("NORTH"))
        a = arrayOf("EAST", "EAST", "WEST", "NORTH", "WEST", "EAST", "EAST", "SOUTH", "NORTH", "WEST")
        testing(a, arrayOf("EAST", "NORTH"))
        a = arrayOf("NORTH", "EAST", "NORTH", "EAST", "WEST", "WEST", "EAST", "EAST", "WEST", "SOUTH")
        testing(a, arrayOf("NORTH", "EAST"))
        a = arrayOf("")
        testing(a, arrayOf(""))

        testing( arrayOf("WEST","WEST","EAST","EAST","WEST","SOUTH","NORTH","SOUTH") , arrayOf("WEST","SOUTH") )
        testing( arrayOf("NORTH","WEST","EAST","EAST","SOUTH") ,  arrayOf("NORTH","EAST","SOUTH") )
        testing( arrayOf("SOUTH","SOUTH","SOUTH","NORTH","SOUTH","NORTH","WEST","EAST") ,  arrayOf("SOUTH","SOUTH") )
        testing( arrayOf("WEST","EAST","EAST","SOUTH","NORTH") ,  arrayOf("EAST") )
        testing( arrayOf("WEST","EAST","SOUTH","WEST","EAST") ,  arrayOf("SOUTH") )

        testing( arrayOf("NORTH","EAST","SOUTH","NORTH","SOUTH","NORTH") , arrayOf("NORTH","EAST") )
        testing( arrayOf("NORTH","SOUTH","WEST","NORTH","NORTH") ,  arrayOf("WEST","NORTH","NORTH") )
        testing( arrayOf("NORTH","NORTH","NORTH","NORTH","SOUTH","SOUTH","WEST") ,  arrayOf("NORTH","NORTH","WEST") )
        testing( arrayOf("NORTH","WEST","EAST","WEST","EAST","WEST") ,  arrayOf("NORTH","WEST") )
        testing( arrayOf("EAST","WEST","NORTH","EAST","NORTH") ,  arrayOf("NORTH","EAST","NORTH") )
        testing( arrayOf("WEST","NORTH","EAST","NORTH","WEST") ,  arrayOf("WEST","NORTH","EAST","NORTH","WEST") )
        testing( arrayOf("EAST","SOUTH","SOUTH","SOUTH","EAST","NORTH","NORTH") ,  arrayOf("EAST","SOUTH","SOUTH","SOUTH","EAST","NORTH","NORTH") )
        testing( arrayOf("NORTH","EAST","SOUTH","EAST","WEST","NORTH") ,  arrayOf("NORTH","EAST") )
        testing( arrayOf("WEST","EAST","SOUTH","EAST","WEST","WEST") ,  arrayOf("SOUTH","WEST") )
        testing( arrayOf("SOUTH","NORTH","SOUTH","EAST","SOUTH","EAST","EAST") ,  arrayOf("SOUTH","EAST","SOUTH","EAST","EAST") )
    }
    private fun randDir(n: Int): Array<String> {
        val dirs = arrayOf("NORTH", "SOUTH", "EAST", "WEST")
        val result = Array(n) { "" } // arrayOfNulls<String>(n)
        for (i in 0 until n) {
            result[i] = dirs[(Math.random() * 4).toInt()]
        }
        return result
    }
    //..
    private fun dirReducSa(arr: Array<String>): Array<String> {
        val directions = arr.toMutableList()
        var i = 0
        while (i + 1 < directions.size) {
            if ("NORTHSOUTH,SOUTHNORTH,EASTWEST,WESTEAST".contains(directions[i] + directions[i + 1])) {
                directions.removeAt(i + 1)
                directions.removeAt(i)
                i = -1
            }
            i++
        }
        return directions.toTypedArray()
    }
    //..
    @Test
    fun randomTests() {
        for (i in 0..4) {
            var u = randDir(10)
            var sol = dirReducSa(u)
            testing(u, sol)
            u = randDir(15)
            sol = dirReducSa(u)
            testing(u, sol)
            u = randDir(30)
            sol = dirReducSa(u)
            testing(u, sol)
        }
    }
}