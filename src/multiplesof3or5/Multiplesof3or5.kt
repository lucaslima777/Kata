package multiplesof3or5

fun solution(number: Int): Int = if (number < 0) 0 else (0 until number).filterIndexed { _, i -> i % 3 == 0 || i % 5 == 0 }.sum()

fun main() {
    println(solution(10))
}