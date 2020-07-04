package encryptthis

fun encryptThis(text: String): String {
    var listText = emptyList<String>()
    var newListText = ArrayList<String>()
    listText = text.split(" ")

    listText.forEachIndexed { index, t ->
        if (t.length == 3) {
            newListText.add(t.letterReverse())
            newListText[index] = newListText[index].convertFirstLetter()
        } else if (t.length > 3) {
            newListText.add(t.letterReverse())
            newListText[index] = newListText[index].convertFirstLetter()
        } else {
            newListText.add(t.convertFirstLetter())
        }
    }
    return newListText.removeSpecialCharacters()
}


fun String.convertFirstLetter() = this.mapIndexed { index, c ->
    if (index == 0) {
        c.toString().toAscii()
    } else c
}.fold("") { acc, c -> acc + c.toString() }

fun String.toAscii() = this.map { it.toInt() }.joinToString()

fun ArrayList<String>.removeSpecialCharacters() = this.joinToString().replace(",", "")

fun String.letterReverse(): String {
    var text = StringBuilder(this)
    text.setCharAt(1, this[lastIndex])
    text.setCharAt(lastIndex, this[1])
    return text.toString()
}


fun main() {
    encryptThis("HbGnfhT w TjsIoqWrORx AXVeBOVNXwfmc kNoVkbHA LAmMDHxq GOeQonvUgcI AmddpEUPHfi NkMVk NxyoUvSlDExMVw DbuN ObXVmBoNpLkccCtNPYXd WVcS SxuL wxIJXRNPfOktgqcZU TYvZdNGUxw ATsmkZjhYthpuXnKDz SrlynGikQhKqPRodz gnGyzJJfbSuftPiwlQ")
}