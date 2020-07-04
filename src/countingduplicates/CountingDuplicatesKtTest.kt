package countingduplicates

import org.junit.Assert.*
import org.junit.Test
import kotlin.random.Random

class CountingDuplicatesKtTest {

    @Test
    fun `empty returns zero`() {
        assertEquals(0, duplicateCount(""))
    }

    @Test
    fun `abcde returns zero`() {
        assertEquals(0, duplicateCount("abcde"))
    }

    @Test
    fun `abcdeaa returns one`() {
        assertEquals(1, duplicateCount("abcdeaa"))
    }

    @Test
    fun `abcdeaB returns two`() {
        assertEquals(2, duplicateCount("abcdeaB"))
    }

    @Test
    fun `indivisibilities returns two`() {
        assertEquals(2, duplicateCount("Indivisibilities"))
    }

    @Test
    fun `abcdefghijklmnopqrstuvwxyz returns zero`() {
        assertEquals(0, duplicateCount("abcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun `abcdefghijklmnopqrstuvwxyzaaAb returns two`() {
        assertEquals(2, duplicateCount("abcdefghijklmnopqrstuvwxyzaaAb"))
    }

    @Test
    fun `abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz returns twenty six`() {
        assertEquals(26, duplicateCount("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun `abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ returns twenty six`() {
        assertEquals(26, duplicateCount("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"))
    }

    @Test
    fun `random tests`() {
        for (test in 1..100) {
            val dups = Random.nextInt(37)
            val used = mutableSetOf<Char>()
            fun random(): Char {
                var char: Char
                do char = Random.nextInt(36).toString(36).first() while (char in used)
                used += char
                return char
            }

            val text = ((1..dups).flatMap {
                val value = random()
                (0..Random.nextInt(1, 10)).map { if (Random.nextBoolean()) value.toUpperCase() else value }
            } + (1..Random.nextInt(37 - dups)).map { random() }).shuffled().joinToString("")
            assertEquals(dups, duplicateCount(text))
        }
    }
}