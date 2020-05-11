package baekjoon.codeplus.beginner1.s201

fun main() {
    val count = readLine()!!.toInt()
    val frequency = IntArray(1_000_001)
    val arr = readLine()!!.split(" ").map { it.toInt() }.subList(0, count)
    val answer = IntArray(count)
    val stacks = mutableListOf<Int>()

    for (i in arr.indices) {
        frequency[arr[i]] += 1
    }

    stacks.add(0)

    for (i in 1 until count) {
        while (stacks.isNotEmpty() && frequency[arr[stacks.last()]] < frequency[arr[i]]) {
            answer[stacks.removeAt(stacks.size - 1)] = arr[i]
        }
        stacks.add(i)
    }

    while (stacks.isNotEmpty()) {
        answer[stacks.removeAt(stacks.size - 1)] = -1
    }

    answer.forEach { print("$it ") }
}