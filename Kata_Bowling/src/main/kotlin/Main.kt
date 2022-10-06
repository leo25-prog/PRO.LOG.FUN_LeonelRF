import java.util.logging.Level
import kotlin.time.Duration

fun main(args: Array<String>) {
    var tiradas = listOf(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6)
    println("Los puntos totales de la jugada 1 fueron: ${juegoJugador(tiradas)}")

    var tirada2 = listOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
    println("Los puntos totales de la jugada 2 fueron: ${juegoJugador(tirada2)}")

    var tirada3 = listOf(0, 0, 0, 0, 6, 0, 0, 3, 4, 6, 10, 0, 2, 0, 0, 9, 1, 7, 0)
    println("Los puntos totales de la jugada 3 fueron: ${juegoJugador(tirada3)}")

    var tirada4 = listOf(0, 0, 0, 0, 9, 0, 0, 9, 0, 8, 5, 0, 4, 3, 0, 0, 0, 0)
    println("Los puntos totales de la jugada 4 fueron: ${juegoJugador(tirada4)}")

    var tirada5 = listOf(10, 3, 0, 10, 4, 6, 9, 0, 0, 7, 0, 3, 0, 3)
    println("Los puntos totales de la jugada 5 fueron: ${juegoJugador(tirada5)}")

    var tirada6 = listOf(10, 10, 10, 0, 0, 4, 6, 5, 5, 10, 1, 3, 7, 3, 1, 1)
    println("Los puntos totales de la jugada 6 fueron: ${juegoJugador(tirada6)}")
}

private fun juegoJugador(tiradas: List <Int> ) : Int {
    var pos = 0
    var con = 0
    var puntos = 0
    while (pos < tiradas.size && con < 10) {
        if(tiradas[pos] == 10) {
            puntos += strike(tiradas, pos)
            pos ++
        }
        else {
            var extra = frame(tiradas[pos], tiradas[pos + 1])
            when (extra) {
                "spare" -> puntos += spare(tiradas, pos)
                else -> puntos += extra.toInt()
            }
            pos += 2
        }
        con ++
    }

    return puntos
}

private fun frame(tirada1: Int, tirada2: Int) : String {
    if(tirada1 + tirada2 == 10){
        return "spare"
    }
    else return (tirada1 + tirada2).toString()
    return "frameNormal"
}

private fun spare(tiradas: List <Int>, pos: Int) : Int{
    return tiradas[pos] + tiradas[pos + 1] + tiradas[pos + 2]
}

private fun strike(tiradas: List <Int>, pos: Int) : Int{
    return tiradas[pos] + tiradas[pos + 1] + tiradas[pos + 2]
}