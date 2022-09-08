fun main(args: Array<String>) {
    /*
    ●	De grados Celsius a Fahrenheit: °F = 9/5 (°C) + 32
    ●	Kelvin a Celsius: °C = K - 273.15
    ●	De Fahrenheit a Kelvin: K = 5/9 (°F - 32) + 273.15
    */

    val celsius = 27.0
    val kelvin = 350.0
    val fahrenheit = 10.0

    val uCelsius = "Celsius"
    val uKelvin = "Kelvin"
    val uFahrenheit = "Fahrenheit"

    printFinalTemperature(celsius, uCelsius, uFahrenheit,  {(9 * celsius)/5 + 32})
    printFinalTemperature(kelvin, uKelvin, uCelsius,  {kelvin - 273.15})
    printFinalTemperature(fahrenheit, uFahrenheit, uKelvin, {(5 * (fahrenheit - 32))/9 + 273.15})
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
){
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement))
    println("$initialMeasurement degree $initialUnit is $finalMeasurement degree $finalUnit")
}