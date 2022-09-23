package Generics

open class WaterSupply (var needProcessing  : Boolean)

class TapWater : WaterSupply (true){
    fun addChemicalCleaners() {
        needProcessing = false
    }
}

//class Aquarium <T> (val waterSupply: T)
class Aquarium <T: WaterSupply> (val waterSupply: T){
    fun addWater(){
        check(!waterSupply.needProcessing){ "El agua necesita procesarse" }
        println("Agregando agua de ${waterSupply::class.simpleName}")
    }
}

fun main (){
    val aq1 = Aquarium <TapWater> (TapWater())
    //val aq1 = Aquarium (TapWater())
    println("El agua necesita procesarse: ${aq1.waterSupply.needProcessing}")
    aq1.waterSupply.addChemicalCleaners()
    println("El agua necesita procesarse: ${aq1.waterSupply.needProcessing}")
/*
    val aq2 = Aquarium ("Cadena")
    println("El agua necesita procesarse: ${aq2.waterSupply}" )
    aq1.waterSupply.addChemicalCleaners()
    println("El agua necesita procesarse: ${aq2.waterSupply}")
*/
    val aq3 = Aquarium (LateWater())
    println("El agua necesita procesarse: ${aq1.waterSupply}" )
    aq1.waterSupply.addChemicalCleaners()
    println("El agua necesita procesarse: ${aq1.waterSupply}")

    val aq4 = Aquarium (TapWater())
    aq4.waterSupply.addChemicalCleaners()
    aq4.addWater()
    println("El agua necesita procesarse: ${aq4.waterSupply.needProcessing}" )
    aq1.waterSupply.addChemicalCleaners()
    println("El agua necesita procesarse: ${aq4.waterSupply.needProcessing}")
}