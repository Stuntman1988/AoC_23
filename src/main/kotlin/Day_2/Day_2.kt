package Day_2

import java.io.File

fun main() {
    val file = "src/main/kotlin/Day_2/input.txt"
    val list: List<String> = File(file).readLines()
    println(getA(list))
}

fun getA(list: List<String>): Int {
    val limits = mapOf("red" to 12, "green" to 13, "blue" to 14)

    return list.filter { e ->
        e.substringAfter(": ").split("; ").forEach { result ->
            result.split(", ").forEach { cube ->
                val count = cube.substringBefore(" ").toInt()
                val color = cube.substringAfter(" ")
                if (checkNotNull(limits[color]) < count) return@filter false
            }
        }
        true
    }.sumOf { it.substringAfter("Game ").substringBefore(":").toInt() }
}
