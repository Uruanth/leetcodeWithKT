package two_sum

import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main() {

    val time = measureTime {
        val sol = TwoSum()
        val outcome = sol.twoSum(intArrayOf(3,3), 6 )
        outcome.forEach { println("Result: $it") }
    }

    println("total time: $time")

}

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val mapa = mutableMapOf<Int, Int>()
        for (num in nums) {
            if (mapa[num] == null) mapa[num] = 1
            else mapa.replace(num, mapa[num]!! + 1)
        }
        mapa.forEach {
            val need = target - it.key
            if (need == it.key && it.value > 1) {
                return intArrayOf(nums.indexOf(it.key), nums.lastIndexOf(need))
            }
            if (need != it.key && mapa[need] != null) return intArrayOf(nums.indexOf(it.key), nums.indexOf(need))
        }
        return intArrayOf(-1, -1)
    }
}