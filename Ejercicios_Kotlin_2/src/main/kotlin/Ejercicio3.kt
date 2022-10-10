/*
3)
Escribir una función reciba una lista de calificaciones y devuelva
la lista de calificaciones correspondientes a esas notas.

95-100(excelente), 85-94(Notable), 75-84(Bueno), 70-74(Suficiente)  <70(Desempeño insuficiente).
 */

fun main(){
    var calificaciones = listOf(99, 100, 65, 70, 87, 79, 73)
    println(calFinales(calificaciones))
}

fun calFinales(calificaciones: List <Int>) : MutableList < Pair <Int, String> >{
    var calif : MutableList < Pair <Int, String>> = mutableListOf()
    for(nota in calificaciones) {
        if (nota >= 95 && nota <= 100) calif.add((nota to "Excelente"))
        else if (nota >= 85 && nota <= 94) calif.add((nota to "Notable"))
        else if (nota >= 75 && nota <= 84) calif.add((nota to "Bueno"))
        else if (nota >= 70 && nota <= 74) calif.add((nota to "Suficiente"))
        else if (nota < 70) calif.add((nota to "Desempeño insuficiente"))
    }
    return calif
}