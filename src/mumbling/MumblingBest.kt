package mumbling

fun accumBest(s: String): String = s.mapIndexed { index, char -> char.toUpperCase() + char.toString().toLowerCase().repeat(index) }.joinToString("-")

fun main() {
    accumBest("test")
}