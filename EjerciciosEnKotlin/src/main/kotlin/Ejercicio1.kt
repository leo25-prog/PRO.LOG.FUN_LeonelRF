/*Sx
1)
Desarrollar una función que aplique un descuento a un precio y otra que aplique el IVA a un precio.
Escribir una tercera función que reciba un diccionario con los precios y porcentajes
de una cesta de la compra, y una de las funciones anteriores, y utilice la función pasada para
aplicar los descuentos o el IVA a los productos de la cesta y devolver el precio final de la cesta.
 */

fun main(args: Array<String>) {

    // LA LOGICA DE LA PARTE BOOLEANA ES PARA SABER SI VA A APLICAR DESCUENTO O NO, EN CASO DE QUE NO
    // APLICAR DESCUENTO APLICARÁ EL IVA AL PRECIO CORRESPONDIENTE.
    var compra = mutableListOf (
        (16.50 to 0.03 to false), (20.0 to 0.05 to true), (500.0 to 0.20 to false), (6999.99 to 0.10 to true), (25000.0 to 0.15 to false),
        (45550.5 to 0.30 to true), (2200.0 to 0.25 to true), (300.0 to 0.12 to false), (250.5 to 0.05 to false), (17899.99 to 0.08 to false)
    )

    println("El precio total de las compras es: ${String.format("%.2f", listaCompras(compra))}.")
}

private fun descuento(precio: Double, porcentaje: Double) : Double{
    return precio - (precio * porcentaje)
}

private fun IVA(precio: Double): Double {
    return precio + (precio * 0.16)
}

private fun listaCompras(compra: MutableList < Pair < Pair < Double, Double>, Boolean>>) : Double{
    var total = 0.0
    for(producto in compra){
        if(producto.second) total += descuento(producto.first.first, producto.first.second)
        else total += IVA(producto.first.first)
    }

    return total
}