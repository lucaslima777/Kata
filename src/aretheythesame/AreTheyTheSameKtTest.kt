package aretheythesame

import org.junit.Assert.*
import org.junit.Test

class AreTheyTheSameKtTest {

    private fun rand(from: Int, to: Int) : Int {
        return Math.floor((to - from + 1) * Math.random()+from).toInt()
    }
    private fun _comp(a: IntArray?, b: IntArray?): Boolean {
        if (a == null || b == null){
            return false;
        }
        val arr = a.map{it*it}.toIntArray()
        arr.sort()
        b.sort()
        return arr contentEquals b
    }
    @Test
    fun testFixed() {
        var a1: IntArray? = intArrayOf(121, 144, 19, 161, 19, 144, 19, 11)
        var a2: IntArray? = intArrayOf(11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19)
        assertEquals(true, comp(a1, a2))
        a1 = intArrayOf(121, 144, 19, 161, 19, 144, 19, 11)
        a2 = intArrayOf(11*21, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19)
        assertEquals(false, comp(a1, a2))
        a1 = intArrayOf(121, 144, 19, 161, 19, 144, 19, 11)
        a2 = intArrayOf(11*11, 121*121, 144*144, 190*190, 161*161, 19*19, 144*144, 19*19)
        assertEquals(false, comp(a1, a2))
        a1 = intArrayOf()
        a2 = intArrayOf()
        assertEquals(true, comp(a1, a2))
        a1 = intArrayOf()
        a2 = null
        assertEquals(false, comp(a1, a2))
        a1 = intArrayOf(121, 144, 19, 161, 19, 144, 19, 11, 1008)
        a2 = intArrayOf(11*11, 121*121, 144*144, 190*190, 161*161, 19*19, 144*144, 19*19)
        assertEquals(false, comp(a1, a2))
        a1 = intArrayOf(10000, 10000)
        a2 = intArrayOf(10000 * 10000, 10000 * 10000)
        assertEquals(true, comp(a1, a2))
        a1 = intArrayOf(10001, 10000)
        a2 = intArrayOf(10000 * 10000, 10000 * 10000)
        assertEquals(false, comp(a1, a2))
        a1 = intArrayOf(2, 2, 3)
        a2 = intArrayOf(4, 9, 9)
        assertEquals(false, comp(a1, a2))
        a1 = intArrayOf(4, 4)
        a2 = intArrayOf(1, 31)
        assertEquals(false, comp(a1, a2))
        a1 = intArrayOf(3, 4)
        a2 = intArrayOf(0, 25)
        assertEquals(false, comp(a1, a2))
        a1 = null
        a2 = null
        assertEquals(false, comp(a1, a2))
        a1 = intArrayOf(10000, 10000)
        a2 = intArrayOf(10000 * 10000 - 1, 10000 * 10000 + 1)
        assertEquals(false, comp(a1, a2))
    }
    @Test
    fun testRandom() {
        for (i in 1..100) {
            val a = IntArray(rand(1, 10)){rand(0, 100)}
            val b = a.map{it*it}.toIntArray()
            b[rand(0,b.size-1)] += rand(0, 1)
            assertEquals(_comp(a, b), comp(a, b))
        }
    }
}