

fun determinarNivelRendimiento(puntuacion: Int): String {
    return when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Puntuación inválida"
    }
}

fun calcularDineroRecibido(salario: Double, puntuacion: Int): Double {
    return if (puntuacion in 0..10) {
        salario * (puntuacion / 10.0)
    } else {
        0.0
    }
}

fun main() {
    print("Puntuación del empleado (0-10): ")
    val puntuacion = readLine()!!.toInt()
    print("Salario mensual: ")
    val salario = readLine()!!.toDouble()

    val nivel = determinarNivelRendimiento(puntuacion)
    val dinero = calcularDineroRecibido(salario, puntuacion)

    println("Nivel de Rendimiento: $nivel")
    println("Dinero Recibido: $$dinero")
}
