package valid_anagram

import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main() {
    val time = measureTime {
        val ex = ValidAnagram()
        val outcume = ex.isAnagram("anagram", "nagaram")
        println("Resultado: $outcume")
    }
    println("Total time: $time")
}


class ValidAnagram {
// TODO Primera solucion propuesta
//    fun isAnagram(s: String, t: String): Boolean {
//        if (s.length != t.length) return false
//
//        val sChars: MutableMap<Char, Int> = mutableMapOf()
//        val tChars: MutableMap<Char, Int> = mutableMapOf()
//
//        for (ch in s) {
//            if (sChars.get(ch) == null) {
//                sChars.put(ch, 1)
//            } else {
//                sChars.replace(ch, sChars.get(ch)!! + 1)
//            }
//        }
//
//        for (ch in t) {
//            if (tChars.get(ch) == null) {
//                tChars.put(ch, 1)
//            } else {
//                tChars.replace(ch, tChars.get(ch)!! + 1)
//            }
//        }
//
//        for (cn in sChars) {
//            if (tChars.get(cn.key) != sChars.get(cn.key)) {
//                return false
//            }
//        }
//        println("s $sChars, t $tChars")
//        return true
//    }

//    TODO Solución mas eficiente
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val arr = Array(26) { 0 }
        for (i in s.indices) {
//            TODO Suma y Resta uno a la letra del abcedario que se esta en cada ciclo
//            Si al final todas son 0 es porque estan la misma cantidad de veces.
            arr[s[i] - 'a']++
            arr[t[i] - 'a']--
        }
        return arr.all { it == 0 }
    }
}