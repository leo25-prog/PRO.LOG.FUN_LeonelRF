/*
2)
Desarrollar una función que reciba otra función y una lista,
y devuelva otra lista con el resultado de aplicar la función
dada a cada uno de los elementos de la lista.
 */
import kotlin.math.pow
fun main(){
    var nums = listOf(2, 4, 6, 8, 10, 25, 26, 11, 12, 13)
    println(cuadrados(nums,  {a -> (numCuadrado(a)) }))
}

fun numCuadrado(num: Int) : Int{
    return num.toDouble().pow(2).toInt()
}

fun cuadrados( nums: List<Int>, numC: (Int) -> Int): List<Int> {
    var numsCua = mutableListOf <Int> ()
    for(numero in nums){
        numsCua.add(numC(numero))
    }
    return numsCua
}

