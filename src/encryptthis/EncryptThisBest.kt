package encryptthis

import java.util.regex.Pattern
import java.util.stream.Collectors

fun encryptThisBest(text: String): String = Pattern.compile(" +")
        .splitAsStream(text)
        .map(mapper)
        .collect(Collectors.joining(" "))

private val mapper = { word: String ->
    val builder = StringBuilder().append(word[0].toInt())
    when (word.length) {
        1    -> {}
        2    -> builder.append(word[1])
        else -> builder.append(word[word.length - 1]).append(word.subSequence(2, word.length - 1)).append(word[1])
    }
    builder.toString()
}

fun main() {
    val test = "test case best"
    encryptThisBest(test)
}