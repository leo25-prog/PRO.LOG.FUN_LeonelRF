import kotlin.math.cos

/*
1)
Desarrollar una función que simule una calculadora científica
que permita calcular el seno, coseno, tangente, exponencial y logaritmo neperiano.
La función preguntará al usuario el valor y la función a aplicar, y
mostrará por pantalla una tabla con los enteros de 1 al valor introducido y
el resultado de aplicar la función a esos enteros.
 */

fun main() {
    println(calculadora());
}

fun calculadora(){
    menu();
    var ope = readln().toInt();

    println("Ingrese el valor a calcular: ")
    var valor = readln().toInt()
    var nums = definirLista(valor)

    println(resultado(nums, {a -> (operacion(ope, a))}))
}

fun menu(){
    println("Seleccciona la operación que deseas realizar, tecleando el número correspondiente.")
    println("1: Coseno \n 2: Seno \n 3: Tangente \n 4: Exponencial \n 5: Logaritmo")
}

fun definirLista(limite: Int): MutableList < Pair < Double, Double> > {
    var nums: MutableList< Pair <Double, Double> > = mutableListOf()
    var i = 0.0
    while(i <= limite){
        nums.add((i to 0.0))
        i ++
    }
    return nums
}

fun operacion(ope: Int, a: Double) : Double{
    when (ope) {
        1 -> return Math.cos(a)
        2 -> return Math.sin(a)
        3 -> return Math.tan(a)
        4 -> return Math.exp(a)
        5 -> return Math.log(a)
        else -> return a
    }
}

fun resultado(nums: List < Pair <Double, Double> >, numero: (Double) -> Double) : MutableList <Pair <Int, Double> > {
    var ans: MutableList< Pair <Int, Double> > = mutableListOf()
    for(num in nums){
        ans.add((num.first.toInt() to numero(num.first)))
    }
    return ans
}

