package Funciones

data class Fish(var name: String){

}

fun test(){
    val lsPeces = listOf(Fish("Flipper"), Fish("Moby dick"), Fish("Dory"))
    println(lsPeces)

   val filtroCadena = lsPeces.filter { it.name.contains("o") }.joinToString(", ") {it.name}
    println(filtroCadena)

    val fish2 = Fish("splashy").apply {
        name = "Sharky"
    }
    
    val fish2same = fish2.apply{name = "Flippi"}
    println(fish2 == fish2same)

    val fish3 = Fish("nemo")

    val fish4 = fish3.let{ it.name = it.name.capitalize()
        it
    }

    println(fish3 === fish4)
}

fun main(){
    test()
}