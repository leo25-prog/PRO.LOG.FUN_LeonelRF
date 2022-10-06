import java.util.Vector
import kotlin.math.sqrt

/*
5)
Desarrollar   una función que calcule el módulo de un vector.
 */

fun main(){
    var vector: Pair <Double, Double> = (4.0 to 3.0)
    println(modVector2D(vector))

    var vector3D = Triple (2.0, 3.0, 6.0)
    println(modVector3D(vector3D))
}

fun modVector2D(vector: Pair <Double, Double> ) : Double {
    return sqrt((Math.pow(vector.first,  2.0)) + (Math.pow(vector.second, 2.0)))
}

fun modVector3D(vector: Triple <Double, Double, Double>) : Double{
    return sqrt((Math.pow(vector.first,  2.0)) + (Math.pow(vector.second, 2.0)) + (Math.pow(vector.third, 2.0)))
}
