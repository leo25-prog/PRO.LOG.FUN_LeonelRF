/*
5)	Una inmobiliaria de una ciudad maneja una lista de inmuebles como la siguiente:

[{'año': 2000, 'metros': 100, 'habitaciones': 3, 'garaje': True, 'zona': 'A'},
{'año': 2012, 'metros': 60, 'habitaciones': 2, 'garaje': True, 'zona': 'B'},
{'año': 1980, 'metros': 120, 'habitaciones': 4, 'garaje': False, 'zona': 'A'},
{'año': 2005, 'metros': 75, 'habitaciones': 3, 'garaje': True, 'zona': 'B'},
{'año': 2015, 'metros': 90, 'habitaciones': 2, 'garaje': False, 'zona': 'A'}]

Construir una función que permita hacer búsqueda de inmuebles en función de un presupuesto dado.
La función recibirá como entrada la lista de inmuebles y un precio, y
devolverá otra lista con los inmuebles cuyo precio sea menor o igual que el dado.

Los inmuebles de la lista que se devuelva deben incorporar un nuevo par a cada diccionario
con el precio del inmueble, donde el precio de un inmueble se calcula con las siguiente fórmula
en función de la zona:

•	Zona A: precio = (metros * 1000 + habitaciones * 5000 + garaje * 15000) * (1-antiguedad/100)
•	Zona B: precio = (metros * 1000 + habitaciones * 5000 + garaje * 15000) * (1-antiguedad/100) * 1.5
 */

import Muebles
class Muebles (var anio: Int, var metros: Int, var habitaciones: Int, var garaje : Boolean, var zona: Char){
    fun nombre() : String{
        var nom = ""
        nom += "año: " + anio.toString() + ", metros: " + metros.toString() + ", habitaciones: " +
                habitaciones.toString() + ", garaje: " + garaje.toString() + ", zona: " + zona.toString()
        return nom
    }
}

fun main(){
    var mue: MutableList <Muebles> = mutableListOf(
        Muebles(2000, 100, 3, true, 'A'),
        Muebles(2012, 60,  2, true, 'B'),
        Muebles(1980, 120, 4,  false, 'A'),
        Muebles(2005, 75,  3,  true, 'B'),
        Muebles(2015, 90,  2,  false, 'A'))

    println(buenosPrecios(mue, 2450000.0))
}

fun zonaA(lugar : Muebles) : Double{
    var precio = 0.0
    if(lugar.garaje)  precio = (lugar.metros * 1000 + lugar.habitaciones * 5000 + 15000) * (1-lugar.anio/100.0) * -1
    else precio = (lugar.metros * 1000 + lugar.habitaciones * 5000) * (1-lugar.anio/100.0) * -1

    return precio
}

fun zonaB(lugar: Muebles) : Double{
    var precio = 0.0
    precio = if(lugar.garaje) (lugar.metros * 1000 + lugar.habitaciones * 5000 + 15000) * (1-lugar.anio/100) * 1.5 * -1
    else (lugar.metros * 1000 + lugar.habitaciones * 5000) * (1-lugar.anio/100.0) * 1.5 * -1

    return precio
}

fun buenosPrecios(inmuebles: List<Muebles>, presupuesto: Double) : MutableList< Pair <String, Double > >{
    var opciones : MutableList <Pair <String, Double> > = mutableListOf()
    for(casa in inmuebles){
        if(casa.zona == 'A'){
            var precioA = zonaA(casa)
            if(precioA <= presupuesto) opciones.add((casa.nombre() + ", precio: " to precioA))
        }
        else {
            var precioB = zonaB(casa)
            if(precioB <= presupuesto) opciones.add((casa.nombre() + ", precio: " to precioB))
        }
    }
    println(opciones.size)
    return opciones
}