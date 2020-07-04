package aretheythesame

fun compBest(a: IntArray?, b: IntArray?) = a != null && b != null && a.map { it * it }.sorted() == b.sorted()

fun main() {
    val a1 = intArrayOf(121, 144, 19, 161, 19, 144, 19, 11)
    val a2 = intArrayOf(11 * 11, 121 * 121, 144 * 144, 19 * 19, 161 * 161, 19 * 19, 144 * 144, 19 * 19)

    println(compBest(a1, a2))
}
