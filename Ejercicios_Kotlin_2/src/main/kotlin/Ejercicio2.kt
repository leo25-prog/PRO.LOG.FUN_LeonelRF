/*
2)
Desarrollar una función que reciba otra función booleana y una lista,
y devuelva otra lista con los elementos de la lista que devuelvan True
al aplicarles la función booleana.
 */

fun main(){
    var lista = listOf(10, 20, 30, 5, 7, 2000, 51)
    println(esPar(lista, {a -> cambioCriterio(a)}))
}

fun cambioCriterio(valor: Int) : Boolean{
    if(valor.mod(2) == 0) return true
    else return false
}

fun esPar(elementos : List< Int >, valor: (Int) -> Boolean ) : MutableList <Pair <Int, Boolean> > {
    var lista: MutableList< Pair <Int, Boolean> > = mutableListOf()
    for (elem in elementos) {
        lista.add((elem to valor(elem)))
    }

    return lista
}

