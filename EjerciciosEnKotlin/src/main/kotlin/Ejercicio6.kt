import kotlin.math.sqrt

/*
6)
Desarrollar una función que reciba una muestra de números y
devuelva los valores atípicos, es decir, los valores cuya puntuación típica
sea mayor que 3 o menor que -3. Nota: La puntuación típica de un valor se obtiene
restando la media y dividiendo por la desviación típica de la muestra.
 */

fun main(){
    var nums = listOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 299999.0)
    println(valoresAtipicos(nums))
}

fun valoresAtipicos(nums: List<Double>) : List<Double> {
    var numsAtipicos: MutableList<Double> = mutableListOf()
    var media = 0.0
    var desviacionTipica = 0.0

    //CALULAMOS LA MEDIA DE LOS VALORES
    for(numero in nums){
        media += numero
    }
    media /= nums.size

    // CALCULAMOS LA DESVIACION ESTANDAR DE LOS VALORES
    for(numero in nums){
        desviacionTipica += Math.pow((numero - media), 2.0)
    }
    desviacionTipica /= nums.size
    desviacionTipica = sqrt(desviacionTipica)

    // CHECAMOS SI LA PUNTUACION TIPICA DE UN VALOR ESTA FUERA DEL RANGO ESTABLECIDO
    // SI ESTE VALOR SE ENCUENTRA FUERA DE LOS RANGOS ENTONCES ESTE VALOR ES UN VALOR ATIPICO
    for(numero in nums){
        var atipico = (numero - media) / desviacionTipica
        println(atipico)
        if(atipico > 3)  numsAtipicos.add(atipico)
        if(atipico < -3) numsAtipicos.add(atipico)
    }

    return numsAtipicos
}