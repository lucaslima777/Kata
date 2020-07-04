package alternatecapitalization

fun capitalizeBest(text: String): List<String> {
    println(listOf(
        text.mapIndexed {index, c -> if (index % 2 == 0) c.toUpperCase() else c }.fold("") {acc, c -> acc + c.toString() },
        text.mapIndexed {index, c -> if (index % 2 != 0) c.toUpperCase() else c }.fold("") {acc, c -> acc + c.toString() }))
    return listOf(
        text.mapIndexed {index, c -> if (index % 2 == 0) c.toUpperCase() else c }.fold("") {acc, c -> acc + c.toString() },
        text.mapIndexed {index, c -> if (index % 2 != 0) c.toUpperCase() else c }.fold("") {acc, c -> acc + c.toString() })
}

fun main() {
    capitalizeBest("testcase")
}