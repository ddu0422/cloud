package baekjoon.codeplus.beginner1.s200

fun main() {
    repeat(readLine()!!.toInt()) {
        val stack = mutableListOf<String>()
        var answer = "YES"

        readLine()!!.chunked(1).forEach {
            when(it) {
                "(" -> stack.add(it)
                else -> if (stack.size > 0) stack.removeAt(stack.size - 1) else answer = "NO"
            }
        }

        if (stack.size > 0) {
            answer = "NO"
        }

        println(answer)
    }
}