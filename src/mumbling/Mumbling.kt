package mumbling

fun accum(s: String): String = s.mapIndexed { index, c -> c.toString()
        .repeat(index + 1)
        .toLowerCase()
        .capitalize() }
        .joinToString(separator = "-")

fun main() {
    accum("test")
}