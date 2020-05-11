package baekjoon.codeplus.beginner1.s200

fun main() {
    val n = readLine()!!.toInt()
    val numbers = mutableListOf<Int>()
    val stacks = mutableListOf<Int>()
    val answer = mutableListOf<String>()

    repeat(n) {
        numbers.add(readLine()!!.toInt())
    }

    for (i in 1..n) {
        stacks.add(i)
        answer.add("+")

        while (stacks.isNotEmpty() && numbers.isNotEmpty() && stacks.last() == numbers[0]) {
            stacks.removeAt(stacks.size - 1)
            numbers.removeAt(0) // 이 부분 조심 remove()는 element를 제거하고 removeAt()이 index로 제거
            answer.add("-")
        }
    }

    if (stacks.isNotEmpty()) println("NO")
    else answer.forEach { println(it) }
}