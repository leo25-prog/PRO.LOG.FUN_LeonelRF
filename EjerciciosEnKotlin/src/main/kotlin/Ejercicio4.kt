/*
4)
Desarrollar una función reciba un diccionario con las asignaturas y las notas
de un alumno y devuelva otro diccionario con las asignaturas en mayúsculas y
las calificaciones correspondientes a las notas:
95-100(excelente), 85-94(Notable), 75-84(Bueno), 70-74(Suficiente)  <70(Desempeño insuficiente).
 */

fun main(){
    var clases: Map <String, Int> = mapOf(
        ("Matematicas" to 90), ("Programacion" to 70), ("Fisica" to 95), ("IoT" to 83), ("Deportes" to 79),
        ("Movil" to 65 ), ("Web" to 100), ("Investifacion" to 92), ("Ingles" to 69)
    )
    println(notas(clases))
}


fun notas(clases: Map <String, Int>) : Map < Pair <String, Int>, String >{
    var notasFinales: MutableMap <Pair <String, Int>, String> = mutableMapOf()
    for(clase in clases){
        if(clase.value >= 95 && clase.value <= 100) notasFinales[(clase.key.toUpperCase() to clase.value)] = "Excelente"
        else if(clase.value >= 85 && clase.value <= 94) notasFinales[clase.key.toUpperCase() to clase.value] = "Notable"
        else if(clase.value >= 75 && clase.value <= 84) notasFinales[(clase.key.toUpperCase() to clase.value)] = "Bueno"
        else if(clase.value >= 70 && clase.value <= 74) notasFinales[(clase.key.toUpperCase() to clase.value)] = "Suficiente"
        else if(clase.value < 70) notasFinales[(clase.key.toUpperCase() to clase.value)] = "Desempeño Insuficiente"
    }
    return notasFinales
}
