package stringrepeat

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class StringRepeatKtTest {

    private val characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQERSTUVWXYZ0123456789!@#$%^&*()-=_+[]{}|;:,.<>/?`~".toCharArray()

    @Test
    fun test4a() {
        assertEquals("aaaa", repeatStr(4, "a"))
    }

    @Test
    fun test3Hello() {
        assertEquals("HelloHelloHello", repeatStr(3, "Hello"))
    }

    @Test
    fun test5empty() {
        assertEquals("", repeatStr(5, ""))
    }

    @Test
    fun test0kata() {
        assertEquals("", repeatStr(0, "kata"))
    }

    @Test
    fun testRandom() {
        val rand = Random()
        for (testIteration in 1..10) {
            val text = StringBuilder(rand.nextInt(32))
            for (i in 1..text.capacity()) {
                val chi = rand.nextInt(characters.size)
                text.append(characters[chi])
            }
            val string = text.toString()

            val timesToRepeat = rand.nextInt(32)
            val sb = StringBuilder(timesToRepeat * string.length)
            for (i in 1..timesToRepeat) {
                sb.append(text)
            }
            val expected = sb.toString()
            assertEquals(expected, repeatStr(timesToRepeat, string))
        }
    }
}