package modelo;

import java.awt.Color

data class Decoration (val rocks : String, val color : Color = Color.GREEN) {}

data class Decoration2 (val rock: String, val wood: String, val diver : String){}

enum class color(val rgb: Int){
    red(0xFF0000),
    green(0x00FF00),
    blue(0x0000FF)
}

fun makeDecoration(){
    val decoration = Decoration("Granite")
    println(decoration)
    //println(decoration.color.)

    val decoration2 = Decoration("Slate")
    println(decoration2)

    val decoration3 = Decoration("Slate")
    println(decoration3)

    println(decoration.equals(decoration2))
    println(decoration2.equals(decoration3))


    println(decoration == decoration2)
    println(decoration2 == decoration3)


    println(decoration === decoration2)
    println(decoration2 === decoration3)

    val dec2 = Decoration2("roca", "madera", "buzoeador")
    println(dec2)

    val (rock, wood, diver) = dec2
    //val (rock, _, diver) = dec2
    println(rock + " " + wood + " " + diver)

    println(color.blue.rgb)
    println(color.blue.ordinal)
    println(color.blue.name)
}

fun main (){
    makeDecoration()
}
