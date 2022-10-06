/*
3)
Desarrollar una función que reciba una frase y devuelva
un diccionario con las palabras que contiene y su longitud.
 */

fun main(){
    var frase = "Asi se hara un diccionaroio de palabras"
    println(diccionario(frase))
}

fun diccionario( frase: String) : Map <String, Int> {
    var palabras = frase.split(' ')
    var diccio: MutableMap <String, Int> = mutableMapOf()
    for(palabra in palabras){
        diccio[palabra] = palabra.length
    }
    return diccio
}