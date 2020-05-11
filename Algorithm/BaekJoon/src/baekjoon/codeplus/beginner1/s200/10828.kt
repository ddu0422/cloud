package baekjoon.codeplus.beginner1.s200

fun main() {
    val stack = mutableListOf<Int>()

    repeat(readLine()!!.toInt()) {
        val texts = readLine()!!.split(" ")
        val size = stack.size

        when(texts[0]) {
            "push" -> stack.add(texts[1].toInt())
            "pop" -> println(if (size == 0) -1 else stack.removeAt(size - 1))
            "size" -> println(size)
            "empty" -> println(if (size == 0) 1 else 0)
            "top" -> println(if (size == 0) -1 else stack.last())
        }
    }
}