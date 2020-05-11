package baekjoon.codeplus.beginner1.s201

fun main() {
    val count = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.subList(0, count)
    val stacks = mutableListOf<Int>()
    val answer = IntArray(count)

    stacks.add(0)

    for (i in 1 until arr.size) {
        while (stacks.isNotEmpty() && arr[stacks.last()] < arr[i]) {
            answer[stacks.removeAt(stacks.size - 1)] = arr[i]
        }
        stacks.add(i)
    }

    while (stacks.isNotEmpty()) {
        answer[stacks.removeAt(stacks.size - 1)] = -1
    }

    answer.forEach { print("$it ") }
}