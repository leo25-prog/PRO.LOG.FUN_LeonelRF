package nuevopaquete

class Shark : FishAction, FishColor {
    override val color: String
        get() = "gray"

    override fun eat(){
        println("hunt and eat fish")
    }
}
