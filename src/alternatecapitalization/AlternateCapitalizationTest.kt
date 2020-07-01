package alternatecapitalization

import org.junit.Assert.*
import org.junit.Test
import kotlin.random.Random

class AlternateCapitalizationTest {

    @Test
    fun basicTests() {
        assertEquals(listOf("AbCdEf", "aBcDeF"), capitalize("abcdef"))
        assertEquals(listOf("CoDeWaRs", "cOdEwArS"), capitalize("codewars"))
        assertEquals(listOf("AbRaCaDaBrA", "aBrAcAdAbRa"), capitalize("abracadabra"))
        assertEquals(listOf("CoDeWaRrIoRs", "cOdEwArRiOrS"), capitalize("codewarriors"))
        assertEquals(listOf("InDeXiNgLeSsOnS", "iNdExInGlEsSoNs"), capitalize("indexinglessons"))
        assertEquals(listOf("CoDiNgIsAfUnAcTiViTy", "cOdInGiSaFuNaCtIvItY"), capitalize("codingisafunactivity"))
    }

    private val letters = "abcdefghijklmnopqrstuvwxyz"

    @Test
    fun randomTests() {
        repeat(100) {
            val count = Random.nextInt(10, 20)

            val randomString = letters.split("").shuffled().take(count).joinToString("")

            assertEquals(internalCapitalize(randomString), capitalize(randomString))
        }
    }

    private fun internalCapitalize(text: String): List<String> =
            listOf(
                    { ind: Int -> ind % 2 == 0 },
                    { ind: Int -> ind % 2 != 0 }
            ).map { func ->
                text
                        .mapIndexed { index, c -> if (func(index)) c.toUpperCase() else c }
                        .joinToString("")
            }
}