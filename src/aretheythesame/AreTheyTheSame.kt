package aretheythesame

fun comp(a: IntArray?, b: IntArray?): Boolean {
    if (!isNullOrEmpty(a, b)) {
        a!!.forEachIndexed { _, itemA ->
            when {
                b!!.contains(itemA * itemA) -> Unit
                else -> return false
            }
        }
    } else {
        return false
    }
    println(a.toList())
    println(b!!.toList())
    return true
}

fun isNullOrEmpty(a1: IntArray?, a2: IntArray?): Boolean = a1 == null || a2 == null

fun main() {
    val a1 = intArrayOf(121, 144, 19, 161, 19, 144, 19, 11)
    val a2 = intArrayOf(11 * 11, 121 * 121, 144 * 144, 19 * 19, 161 * 161, 19 * 19, 144 * 144, 19 * 19)

    println(comp(a1, a2))
}