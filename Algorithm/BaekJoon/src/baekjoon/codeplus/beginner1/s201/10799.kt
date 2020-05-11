package baekjoon.codeplus1.s200

fun main() {
    val stacks = mutableListOf<String>()
    var tag = false
    var total = 0

    readLine()!!.chunked(1).forEach {
        when (it) {
            "(" -> {
                stacks.add(it)
                tag = false
            }
            ")" -> {
                total += countOfBar(tag, stacks)
                tag = true
            }
        }
    }

    print(total)
}

fun countOfBar(tag: Boolean, stacks: MutableList<String>): Int {
    stacks.removeAt(stacks.size - 1)
    return if (tag) 1
    else stacks.size
}