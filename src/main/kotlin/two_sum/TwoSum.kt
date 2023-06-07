package two_sum

import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main() {

    val time = measureTime {
        val sol = TwoSum()
        val outcome = sol.twoSum(intArrayOf(3,3), 6)
        outcome.forEach { println("Result: $it") }
    }

    println("total time: $time")

}

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (num in nums) {
            val need = target - num
            if (nums.indexOf(need) >= 0 && nums.indexOf(num) != nums.indexOf(need)) {
                return intArrayOf(nums.indexOf(num), nums.indexOf(need))

            }
        }
        return intArrayOf(nums.indexOf(target))
    }
}