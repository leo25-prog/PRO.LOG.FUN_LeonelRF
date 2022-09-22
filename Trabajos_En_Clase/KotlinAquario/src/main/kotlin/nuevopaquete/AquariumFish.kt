package nuevopaquete

abstract class AquariumFish {
    abstract val color : String
}

sealed class Seal
class Sealion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal) : String{
    return when (seal) {
        is Walrus -> "Walrus"
        is Sealion -> "Sea lion"
    }
}

fun makeFish(){
    val shark = Shark()
    println("Shark color: ${shark.color}")
    shark.eat()

    val plecus = Plecostumes(
        object : FishColor {
            override val color: String
                get() = "verde"
        }
    )
    println("Plecus 1 color: ${plecus.color}")
    plecus.eat()

    val otroColor = object : FishColor{
        override val color: String
            get() = "Verde"
    }

    val plecus2 = Plecostumes(otroColor)
    println("Plecus 2 color: ${plecus2.color}")
    plecus2.eat()

    println(matchSeal(Sealion()))
}

fun main(){
    makeFish()
}