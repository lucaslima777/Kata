package directionsreduction

object DirReduction {
    var a = arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST")

    fun dirReduc(arr: Array<String>): Array<String> {
        return arr.reductionDir()
    }
}

fun Array<String>.reductionDir(): Array<String> = this.withIndex().forEachIndexed { index, indexedValue -> if (index != this.lastIndex) {
    Pair(indexedValue.value, this[index + 1]).let {
        if (it == Pair("NORTH", "SOUTH") || it == Pair("SOUTH", "NORTH") || it == Pair("EAST", "WEST") || it == Pair("WEST", "EAST")) {
            return this.toMutableList().apply { removeAt(index + 1); removeAt(index) }.toTypedArray().reductionDir() } } }
}.let { return this }


fun main() {
    print(DirReduction.dirReduc(DirReduction.a).count())
}

