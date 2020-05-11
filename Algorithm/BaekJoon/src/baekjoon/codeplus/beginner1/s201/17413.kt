package baekjoon.codeplus1

fun main() {
    val stacks = mutableListOf<String>()
    var isTag = false

    readLine()!!.chunked(1).forEach {
        when {
            it == "<" -> {
                printStacks(stacks)
                isTag = true
                print(it)
            }
            it == ">" -> {
                isTag = false
                print(it)
            }
            isTag -> print(it)
            else -> {
                reverse(it, stacks)
            }
        }
    }
    printStacks(stacks)
}

private fun reverse(it: String, stacks: MutableList<String>) {
    when (it) {
        " " -> {
            printStacks(stacks)
            print(it)
        }
        else -> stacks.add(it)
    }
}

fun printStacks(stacks: MutableList<String>) {
    while (stacks.size != 0) {
        print(stacks.removeAt(stacks.size - 1))
    }
}