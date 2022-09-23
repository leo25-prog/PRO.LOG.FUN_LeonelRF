import java.sql.DriverManager.println
import java.util.*

data class Aquarium (var temperature: Int = 0)

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    feedTheFish()
    swim()
    swim("slow")
    swim(speed = "turtle-like")

    var dirtyLevel = 20
    val waterFilter = {dirty : Int -> dirty / 2}
    println(waterFilter(dirtyLevel).toString())

    println(updateDirty( 30, waterFilter).toString())
    println(updateDirty( 30, { dirty: Int -> dirty * 3 }).toString())
    println(updateDirty(16, :: incrementDirty).toString())

    println(updateDirty(30) {dirty: Int -> dirty + 23})

    val lista = listOf ("Lunes", "Martes", "Miercoles", "Jueves", "Viernes")
    lista.forEach(::println)
    lista.forEach{println(it)}

    //val diasConM = lista.filter{it[0] == 'm'}
    val diasConM = lista.filter( {el -> el[0] == 'm'})
    println(diasConM)

    val filtroPlaneado = lista.asSequence().filter {it[0] == 'm'}
    println(filtroPlaneado)

    val listaNueva = filtroPlaneado.toList()
    println(listaNueva)

    val lazyMap = lista.asSequence().map{
        println("  access " + it)
        "¡" + it + "!"
    }

    println("lazy: $lazyMap")
    println("---------------")
    println("first: ${lazyMap.first()}")
    println("---------------")
    println("last: ${lazyMap.last()}")
    println("---------------")
    println("all: ${lazyMap.toList()}")

    val decoration = listOf("rock", "pagoda", "plastic plant", "allogator", "flowerpot")
    println(decoration.filter {it[0] == 'p'})

    //eager create a nwe list
    val eager = decoration.filter{it[0] == 'p'}
    println("eagee: $eager")

    //lazy, will wait until asked to evaluate
    val filtered = decoration.asSequence().filter {it[0] == 'p'}
    println("filtered: $filtered")

    val filtroPlaneado2 = decoration.asSequence().filter{it[0] == 'p'}
    println(filtroPlaneado2)

    //force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")
}


fun randomDay() : String{
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood(day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun swim (speed: String = "Fast") {
    println("swimming $speed")
}

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20 ): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

//fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = getDirtySensorReading()): Boolean {}

fun getSensorDirtyReading() = 20

fun isTooHot (temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun incrementDirty(start : Int) = start + 1

fun updateDirty(dirty: Int, operation : (Int) -> Int) : Int{
    return operation(dirty)
}



