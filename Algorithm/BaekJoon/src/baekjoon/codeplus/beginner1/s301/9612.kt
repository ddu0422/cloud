package baekjoon.codeplus.beginner1.s301

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a
    else gcd(b, a % b)
}

fun main() {
    repeat(readLine()!!.toInt()) {
        val array = readLine()!!.split(" ").map { it.toInt() }
        var sum = 0L

        for (i in 1 until array.size - 1) {
            for (j in i + 1 until array.size) {
                sum += gcd(array[i], array[j])
            }
        }

        println(sum)
    }
}