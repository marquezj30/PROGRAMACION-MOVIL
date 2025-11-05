fun generarNumeroAleatorio(): Int {
    return (1..30).random()
}

fun darPista(numeroSecreto: Int, intento: Int): String {
    return when {
        intento < numeroSecreto -> "El número es mayor que $intento."
        intento > numeroSecreto -> "El número es menor que $intento."
        else -> "Adivinaste el número $numeroSecreto."
    }
}

fun main() {
    val numeroSecreto = generarNumeroAleatorio()
    var intentos = 5

    println("Adivina el número entre 1 y 30. Tienes $intentos intentos.")

    while (intentos > 0) {
        print("Ingresa tu número: ")
        val intento = readLine()!!.toInt()

        if (intento == numeroSecreto) {
            println(darPista(numeroSecreto, intento))
            return
        } else {
            println(darPista(numeroSecreto, intento))
            intentos--
            if (intentos > 0) {
                println("Te quedan $intentos intentos.")
            } else {
                println("Game Over. El número era $numeroSecreto.")
            }
        }
    }
}


