package arrays.medium.group_anagrams

import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main() {
    val time = measureTime {
        val sol = GroupAnagrams()
        val outcome = sol.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
        println(outcome)
    }
    println("Total time: $time")

}

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val previusString = HashMap<String, MutableMap<Char, Int>>()
        val indexValues = HashMap<String, Int>()
        val result = mutableListOf<MutableList<String>>()
        for (str in strs) {
            val currentMap = mutableMapOf<Char, Int>()
            var flag = false;
            str.forEach {
                currentMap[it] = currentMap.getOrDefault(it, 0).plus(1)
            }
            previusString.forEach { id, hMap ->
                if (hMap == currentMap) {
                    flag = true
                    result.get(indexValues[id]!!).add(str)
                }
            }

            if (!flag){
                previusString.put(str, currentMap)
                result.add(mutableListOf(str))
                indexValues[str] = result.indexOf(mutableListOf(str))
            }
        }

        return result
    }
}