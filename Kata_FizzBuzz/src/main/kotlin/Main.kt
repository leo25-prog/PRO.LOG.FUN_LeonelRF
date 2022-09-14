//FUNCION PRINCIPAL EN LA CUAL VAMOS A RECIBIR EL VALOR A EVALUAR
//Y AQUI ES DONDE VAMOS A IMPRIMIR SI CUMPLE CON FIZZ, BUZZ, AMBAS O NINGUNA
fun main(args: Array<String>) {
    val nume = 178
    println( nume.toString() + "\n" + numero(nume))
}

// ESTA FUNCION RECIBE UN VALOR ENTERO COMO PARAMETRO Y RETORNA UNA CADENA
// AQUI SE EVALUA SI EL VALOR DADO ES MULTIPLO DE 3 Y 5, DE 3 SOLAMENTE, ó, DE 5 SOLAMENTE
// SI NO ES MULTIPLI DE NINGUNO DE LOS DOS NUMEROS ANTERIORES MANDA LLAMAR A LA FUNCION DONDE DEFINIMOS
// EL NOMBRE DEL NUMERO CON LETRAS
fun numero (valor : Int) : String{
    when {
        valor % 5 == 0 && valor % 3 == 0 -> return "FizzBuzz!"
        valor % 5 == 0 -> return "Fizz!"
        valor % 3 == 0 -> return "Buzz!"
        else -> return numeroLetra(valor) + "!"
    }
}

// ESTA ES LA FUNCION DONDE DEFINIMOS EL NOMBRE DEL VALOR CON LETRAS, IGUAL RECIBIMOS EL VALOR
// A REPRESENTAR EN LETRAS QUE ES UN ENTERO Y RETORNAREMOS UNA CADENA
// AQUI SE EVALUA SI EL VALOR TIENE UN ONCE, DOCE, TRECE, CATORCE O QUINCE AL FINAL DEL NUMERO
// SI NO LO TIENE NOS VAMOS A EVALUAR DIGITO POR DIGITO A VER DE QUE DIGITO SE TRATA MEDIANTE UN CICLO
// DEBEMOS TOMAR EN CUENTA TANTO EL VALOR DEL DIGITO COMO LA POSICION EN LA QUE SE ENCUENTRA, POR ESO DEFINIMOS
// UNA VARIABLE CONTADOR PARA CONTROLAR LAS POSICIONES EN LAS QUE SE ENCUENTRA EL DIGITO INDICADO, UNA VARIABLE
// DIGITOS QUE ME INDICA EL NUMERO DE DIGITOS QUE TIENE EL NUMERO INGRESADO, UNA VARIABLE NUM PARA CAMBIAR EL VALOR
// DEL NUMERO INICIAL Y UNA VARIABLE STRING DONDE SE GUARDARAN LAS LETRAS O PALABRAS QUE VAN FORMANDO LA REPRESENTACION
// DEL NUMERO.
fun numeroLetra(valor : Int) : String {
    var num = valor
    var con = 0
    var digitos = num.toString().length
    var numLetra = ""
    var aux = ""

    if (valor.toString()[digitos-1] == '1' && valor.toString()[digitos-2] == '1'){
        aux = "once"
        num /= 100
        con = 2
        digitos -= 2
    }
    else if (valor.toString()[digitos-1] == '2' && valor.toString()[digitos-2] == '1'){
        aux = "doce"
        num /= 100
        con = 2
        digitos -= 2
    }
    else if (valor.toString()[digitos-1] == '3' && valor.toString()[digitos-2] == '1'){
        aux = "trece"
        num /= 100
        con = 2
        digitos -= 2
    }
    else if (valor.toString()[digitos-1] == '4' && valor.toString()[digitos-2] == '1'){
        aux = "catorce"
        num /= 100
        con = 2
        digitos -= 2
    }
    else if (valor.toString()[digitos-1] == '5' && valor.toString()[digitos-2] == '1'){
        aux = "quince"
        num /= 100
        con = 2
        digitos -= 2
    }

    var ultimoDigito = false
    var ultimoDigitoMiles = false


    while( digitos > 0){
        numLetra = nombreDigito((num%10), con, ultimoDigitoMiles, ultimoDigito)

        if(con == 0 && numLetra.length > 0) ultimoDigito = true
        if(con == 3 && numLetra.length > 0) ultimoDigitoMiles = true

        numLetra += aux
        aux = numLetra

        num /= 10
        con ++
        digitos --
    }

    return numLetra
}

// EN ESTA FUNCION DEFINIMOS DE QUE DIGITO DEL 1 AL 9 SE TRATA, PARA SABER SI REGRESAMOS
// UNA UNIDAD, DECENA, CENTENA, UNIDAD DE MILLAR, DECENA DE MILLAR, CENTENA DE MILLAR, O EN DADO CASO
// MILLONES
fun nombreDigito (digito : Int, con : Int, ultimoDigitoMiles : Boolean, ultimoDigito : Boolean) : String{
    when {
        digito == 9 && (con == 2 || con == 5) -> return "novecientos "
        digito == 9 && con == 1 && ultimoDigito -> return "noventa y "
        digito == 9 && con == 4 && ultimoDigitoMiles -> return "noventa y "
        digito == 9 && (con == 1 || con == 4) -> return "noventa "
        digito == 9 && con == 3 -> return "nueve mil "
        digito == 9 && con == 0 -> return "nueve "

        digito == 8 && (con == 2 || con == 5) -> return "ochocientos "
        digito == 8 && con == 1 && ultimoDigito -> return "ochenta y "
        digito == 8 && con == 4 && ultimoDigitoMiles -> return "ochenta y "
        digito == 8 && (con == 1 || con == 4) -> return "ochenta "
        digito == 8 && con == 3 -> return "ocho mil "
        digito == 8 && con == 0 -> return "ocho "

        digito == 7 && (con == 2 || con == 5) -> return "setecientos "
        digito == 7 && con == 1 && ultimoDigito -> return "setenta y "
        digito == 7 && con == 4 && ultimoDigitoMiles -> return "setenta y "
        digito == 7 && (con == 1 || con == 4) -> return "sententa "
        digito == 7 && con == 3 -> return "siete mil "
        digito == 7 && con == 0 -> return "siete "

        digito == 6 && (con == 2 || con == 5) -> return "seicientos "
        digito == 6 && con == 1 && ultimoDigito -> return "sesenta y "
        digito == 6 && con == 4 && ultimoDigitoMiles -> return "sesenta y "
        digito == 6 && (con == 1 || con == 4) -> return "sesenta "
        digito == 6 && con == 3 -> return "seis mil "
        digito == 6 && con == 0 -> return "seis "

        digito == 5 && (con == 2 || con == 5) -> return "quinientos "
        digito == 5 && con == 1 && ultimoDigito -> return "cincuenta y "
        digito == 5 && con == 4 && ultimoDigitoMiles -> return "cincuenta y "
        digito == 5 && (con == 1 || con == 4) -> return "cincuenta "
        digito == 5 && con == 3 -> return "cinco mil "
        digito == 5 && con == 0 -> return "cinco "

        digito == 4 && (con == 2 || con == 5) -> return "cuatrocientos "
        digito == 4 && con == 1 && ultimoDigito -> return "cuarenta y "
        digito == 4 && con == 4 && ultimoDigitoMiles -> return "cuarenta y "
        digito == 4 && (con == 1 || con == 4) -> return "cuarenta "
        digito == 4 && con == 3 -> return "cuatro mil "
        digito == 4 && con == 0 -> return "cuatro "

        digito == 3 && (con == 2 || con == 5) -> return "trecientos "
        digito == 3 && con == 1 && ultimoDigito -> return "treinta y "
        digito == 3 && con == 4 && ultimoDigitoMiles -> return "treinta y "
        digito == 3 && (con == 1 || con == 4) -> return "treinta "
        digito == 3 && con == 3 -> return "tres mil "
        digito == 3 && con == 0 -> return "tres "

        digito == 2 && (con == 2 || con == 5) -> return "docientos "
        digito == 2 && con == 1 && ultimoDigito -> return "veinti "
        digito == 2 && con == 4 && ultimoDigitoMiles -> return "veinti "
        digito == 2 && (con == 1 || con == 4) -> return "veinte "
        digito == 2 && con == 3 -> return "dos mil "
        digito == 2 && con == 0 -> return "dos "

        digito == 1 && con == 6 -> return "Un millon "
        digito == 1 && (con == 2 || con == 5) -> return "ciento "
        digito == 1 && con == 1 && ultimoDigito -> return "dieci "
        digito == 1 && con == 4 && ultimoDigitoMiles -> return "dieci "
        digito == 1 && (con == 1 || con == 4) -> return "diez "
        digito == 1 && con == 3 -> return "un mil "
        digito == 1 && con == 0 -> return "uno "

        else -> return ""
    }
}