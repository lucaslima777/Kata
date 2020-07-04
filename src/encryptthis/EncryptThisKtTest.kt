package encryptthis

import org.junit.Assert.*
import org.junit.Test

class EncryptThisKtTest {
    @Test
    fun testSample() {
        // Example Test Cases
        assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka", encryptThis("A wise old owl lived in an oak"))
        assertEquals("84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp", encryptThis("The more he saw the less he spoke"))
        assertEquals("84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare", encryptThis("The less he spoke the more he heard"))
        assertEquals("87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri", encryptThis("Why can we not all be like that wise old bird"))
        assertEquals("84kanh 121uo 80roti 102ro 97ll 121ruo 104ple", encryptThis("Thank you Piotr for all your help"))
    }

    @Test
    fun testRandom() {
        val howManyTests = 100
        for(i in 1..howManyTests){
            // need up to 50 words with up to 20 letters (will be randomized)
            var testString = ""
            val numberOfWords = (1..50).shuffled().first()

            for(j in 1..numberOfWords){
                val numberOfChars = (1..20).shuffled().first()
                testString += randomString(numberOfChars) + " "
            }

            testString = testString.trimEnd()

            assertEquals("Input string: $testString", encryptThisSol(testString), encryptThis(testString))
        }
    }

    // Solution
    fun encryptThisSol(text:String): String{
        var words = text.split(" ")
        var outputString = ""

        for (word in words) {
            if (word.length == 1){
                outputString += "${word[0].toInt()} "
            }

            if (word.length == 2){
                outputString += "${word[0].toInt()}${word[1]} "
            }

            if (word.length > 2){
                val chars = word.toMutableList()
                val char1 = chars[1]
                val char2 = chars.last()
                chars[1] = char2
                chars[chars.lastIndex] = char1
                chars.remove(chars.first())
                outputString += "${word[0].toInt()}"
                outputString += chars.joinToString(separator = "")
                outputString += " "
            }

        }

        return outputString.trimEnd()
    }

    // Helper Functions
    fun randomString(length:Int):String{
        val letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        var randomString = ""

        for(i in 1..length){
            val pickRandomLetter = (1..letters.length-1).shuffled().first()
            val nextChar = letters.get(pickRandomLetter)
            randomString += nextChar
        }

        return randomString
    }
}