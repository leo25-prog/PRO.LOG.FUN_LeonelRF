/*
4)
Escribir una función reciba un diccionario con las asignaturas y
las notas de un alumno y devuelva otro diccionario con las asignaturas en mayúsculas y
las calificaciones correspondientes a las notas aprobadas.
95-100(excelente), 85-94(Notable), 75-84(Bueno), 70-74(Suficiente)  <70(Desempeño insuficiente).
 */

fun main(){
    var diccio:Map<String, Int> = mutableMapOf(("Matematicas" to 100),
        ("Español" to 94), ("Ingles" to 100), ("Fisica" to 65), ("Programacion" to 50))
    println(calFinales(diccio))
}

fun calFinales (diccio: Map <String, Int> ) : MutableMap <String, Pair <Int, String> > {
    var notas: MutableMap <String, Pair <Int, String >> = mutableMapOf()

    for(nota in diccio){
        if(nota.value >= 95 && nota.value <= 100) notas[nota.key.toUpperCase()] = (nota.value to "Excelente")
        else if(nota.value >= 85 && nota.value <= 94) notas[nota.key.toUpperCase()] = (nota.value to "Notable")
        else if(nota.value >= 75 && nota.value <= 84) notas[nota.key.toUpperCase()] = (nota.value to "Bueno")
        else if(nota.value >= 70 && nota.value <= 74) notas[nota.key.toUpperCase()] = (nota.value to "Suficiente")
    }
    return notas
}
