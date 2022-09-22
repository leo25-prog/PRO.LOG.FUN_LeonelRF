package Extensiones

open class AquariumPlant (val color : String, private val size : Int)
class GreenLeafyPlant(size: Int ) : AquariumPlant ("green", size)


fun AquariumPlant.isRed() = color == "red"
//fun AquariumPlant.isBig() = size > 50

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun main(){
    val aqpl = AquariumPlant("Verde", 20)

    println(aqpl.color)
    println("El color ${aqpl.color} es rojo? " + aqpl.isRed())

    val plant = GreenLeafyPlant(20)
    plant.print()
    println("\n")

    val plantAquarium : AquariumPlant = plant
    plantAquarium.print()
}
