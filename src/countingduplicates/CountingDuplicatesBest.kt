package countingduplicates

fun duplicateCountBest(text: String) = text.groupBy(Char::toLowerCase).count { it.value.count() > 1 }

fun main() {
    println(duplicateCountBest("indivisibility"))
}