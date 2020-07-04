package countingduplicates

fun duplicateCount(text: String): Int = text.toLowerCase()
        .groupingBy { it }
        .eachCount()
        .filterValues { it > 1 }.keys.size

fun main() {
    println(duplicateCount("indivisibility"))
}