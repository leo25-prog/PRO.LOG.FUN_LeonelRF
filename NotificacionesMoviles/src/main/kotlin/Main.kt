fun main(args: Array<String>) {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

fun printNotificationSummary(numberOfMessages: Int){
    if(numberOfMessages >= 100) println("Your ph    one is blowing up! You have 99+ notifications.")
    else println("You have $numberOfMessages notifications.")
}