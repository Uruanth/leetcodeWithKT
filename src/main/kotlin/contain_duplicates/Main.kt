fun main(args: Array<String>) {
    println("Hello World!")
    val sol = Solution()
    val intArray = intArrayOf(1,2,3,4,1)
    val asd = setOf<Int>()
    println("El array a probar es: $intArray")
    println("El resutado fue ${sol.containsDuplicate(intArray)}")
}


class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val yaRecorridos: MutableSet<Int> = HashSet();
        for (num in nums){
            if (yaRecorridos.contains(num)){
                return true
            }else{
                yaRecorridos.add(num)
            }
        }
        return false
    }
}
