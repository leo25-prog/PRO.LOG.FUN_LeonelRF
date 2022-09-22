package nuevopaquete

class Shark : /*AquariumFish(),*/ FishAction, FishColor {
    override val color: String
    get() = "gray"

    override fun eat(){
        println("hunt and eat fish")
    }
}
