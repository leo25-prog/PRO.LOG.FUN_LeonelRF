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

    println(updateDirty(15, :: incrementDirty).toString())

    val lista = listOf ("Lunes", "Martes", "Miercoles", "Jueves", "Viernes")
    lista.forEach(::print)
    //lista.forEach(println(it))

    println((updateDirty(30) {dirty: Int -> dirty + 23}).toString())


    val decoration = listOf("rock", "pagoda", "plastic plant", "allogator", "flowerpot")
    println(decoration.filter {it[0] == 'p'})

    //val diasConM = lista.filter{it[0] == 'a'}
    val diasConM = lista.filter( {el -> el[0] == 'm'})
    println(diasConM)


    //eager create a nwe list
    val eager = decoration.filter{it[0] == 'p'}
    println("eagee: $eager")

    //lazy, will wait until asked to evaluate
    val filtered = decoration.asSequence().filter {it[0] == 'p'}
    println("filtered: $filtered")

    val filtroPlaneado = decoration.asSequence().filter{it[0] == 'p'}
    println(filtroPlaneado)

    //force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")


    val lazyMap = decoration.asSequence().map {
        println("acces: $it")
        it
    }

    println("lazy: $lazyMap")
    println("---------------")
    println("first: ${lazyMap.first()}")
    println("---------------")
    println("first: ${lazyMap.last()}")
    println("---------------")
    println("all: ${lazyMap.toList()}")
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

fun isTooHot (temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun incrementDirty(start : Int) = start + 1

fun updateDirty(dirty: Int, operation : (Int) -> Int) : Int{
    return operation(dirty)
}



