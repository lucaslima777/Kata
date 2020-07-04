package alternatecapitalization

fun capitalize(text: String): List<String> {
    return listOf(listPar(text), listImpar(text))
}

fun listPar(text: String) : String {
    var textConvertido: StringBuilder = java.lang.StringBuilder()
    text.forEachIndexed { index, c ->
        if (index % 2 == 0) {
            textConvertido.insert(index, c.toString().capitalize())
        } else {
            textConvertido.insert(index, c.toString())
        }
    }
    return textConvertido.toString()
}

fun listImpar(text: String) : String {
    var textConvertido: StringBuilder = java.lang.StringBuilder()
    text.forEachIndexed { index, c ->
        if (index % 2 != 0) {
            textConvertido.insert(index, c.toString().capitalize())
        } else {
            textConvertido.insert(index, c.toString())
        }
    }
    return textConvertido.toString()
}

fun main() {
    capitalize("testcase")
}