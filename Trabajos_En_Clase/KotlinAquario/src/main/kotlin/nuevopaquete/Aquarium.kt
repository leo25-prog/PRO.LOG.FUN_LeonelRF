package nuevopaquete

open class Aquarium (width: Int = 20, heigth: Int = 40, length: Int = 100){

    open var width: Int = width
    open var heigth: Int = heigth
    open var length: Int = length


    //val volume: Int
    //    get() = (width * height * length) / 1000

    open var volume: Int
        get() { return (width * heigth * length) / 1000 }
        // private set(value){
        set(value){
            heigth = (value * 1000) / (width * length)
        }

    open var shape = "rectangle"
    open var water: Double = 0.0
        get() = volume * 0.90

    init {
        println("Bloque de inicializacion")
        //volume = width * height * length
        printSize()
    }

    constructor (numberOfFish: Int) : this() {
        val tank = numberOfFish * 2000 * 1.1
        println((tank/(length*width)))
        heigth = (tank / (length * width)).toInt()
    }

    fun printSize(){
        println("Widht: $width cm " +
                "Height: $heigth cm" +
                "Length: $length cm ")

        println("Volume: $volume lts")

        println("volume: $volume lts, water: lts (${water/volume * 100.0}% full).")
    }
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()
    println("..............................")

    myAquarium.heigth = 70;
    myAquarium.printSize()
    println("..............................")

    //myAquarium.volume = 90000
    myAquarium.printSize()
    println("..............................")

    val aq2 = Aquarium(90, 110, 1000)
    aq2.printSize()
    println("..............................")

    val aq3 = Aquarium( heigth = 1000)
    aq3.printSize()
    println("..............................")

    val aq4 = Aquarium()
    aq4.printSize()
    println("..............................")

    val aq5 = Aquarium(numberOfFish = 3)
    aq5.printSize()
    println(aq5.heigth)
    println("..............................")

    val aq6 = Aquarium(29)
    aq6.printSize()
    //aq6.volume = 70
    aq6.printSize()
    println("..............................")

    val aq7 = Aquarium(25, 25, 40)
    aq7.printSize()
    println(aq7.shape)
}

fun main(){
    buildAquarium()
}


