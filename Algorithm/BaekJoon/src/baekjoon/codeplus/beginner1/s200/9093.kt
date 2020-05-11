package baekjoon.codeplus.beginner1.s200

fun main() {
    repeat(readLine()!!.toInt()) {
        readLine()!!.split(" ").map { it.reversed() }.forEach { print("$it ") }
    }
}