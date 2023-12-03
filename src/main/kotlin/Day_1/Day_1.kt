import java.io.File

fun main(args: Array<String>) {
    val file = "src/main/kotlin/Day_1/input.txt"
    val list: List<String> = File(file).readLines()
    println("Part 1: " + getA(list))
    println("Part 2: " + getB(list))
}

fun getA(list: List<String>): Int {
    val digits = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
    return list.sumOf {
        val first = it.findAnyOf(digits)?.second
        val last = it.findLastAnyOf(digits)?.second
        "$first$last".toInt()
    }
}

fun getB(list: List<String>): Int {
    val digits = listOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine"
    )
    return list.sumOf {
        val first = it.findAnyOf(digits)?.second?.parseDigit()
        val last = it.findLastAnyOf(digits)?.second?.parseDigit()
        "$first$last".toInt()
    }
}

private fun String.parseDigit() = when (this) {
    "one" -> "1"
    "two" -> "2"
    "three" -> "3"
    "four" -> "4"
    "five" -> "5"
    "six" -> "6"
    "seven" -> "7"
    "eight" -> "8"
    "nine" -> "9"
    else -> this
}
