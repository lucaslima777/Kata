package overtheroad

fun overTheRoad(address: Int, n: Int): Int {
    val leftAddress = mutableListOf<Int>()
    val rightAddress = mutableListOf<Int>()

    for (i in 1..n.plus(n) step 2) leftAddress.add(i)
    for (i in n.plus(n) downTo 1 step 2) rightAddress.add(i)

    return if (address % 2 == 0) leftAddress[rightAddress.indexOf(address)]
    else rightAddress[leftAddress.indexOf(address)]


}

fun main() {
    overTheRoad(1, 3)
}

