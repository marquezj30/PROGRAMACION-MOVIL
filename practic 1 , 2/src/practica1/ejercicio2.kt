
fun obtenerOpcionComputadora(): String {
    val opciones = listOf("piedra", "papel", "tijera")
    return opciones.random()
}

fun obtenerResultado(opcionUsuario: String, opcionComputadora: String): String {
    if (opcionUsuario == opcionComputadora) return "Empate"

    return when {
        (opcionUsuario == "piedra" && opcionComputadora == "tijera") ||
                (opcionUsuario == "papel" && opcionComputadora == "piedra") ||
                (opcionUsuario == "tijera" && opcionComputadora == "papel") -> "Ganaste"
        else -> "Perdiste"
    }
}

fun main() {
    val opcionComputadora = obtenerOpcionComputadora()

    println("Elige una opción (piedra, papel, tijera): ")
    val opcionUsuario = readLine()!!.lowercase()

    println("Computadora eligió: $opcionComputadora")
    println("Tú elegiste: $opcionUsuario")

    if (opcionUsuario in listOf("piedra", "papel", "tijera")) {
        val resultado = obtenerResultado(opcionUsuario, opcionComputadora)
        println("Resultado: $resultado")
    } else {
        println("Opción inválida, elige piedra, papel o tijera.")
    }
}

