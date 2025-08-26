
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
    println("Ingrese la puntuación del empleado (0-10):")
    val puntuacion = readLine()?.toIntOrNull() ?: 0
    println("Ingrese el salario mensual del empleado:")
    val salario = readLine()?.toDouble()?: 0.0

    val nivel = determinarNivelRendimiento(puntuacion)
    val dinero = calcularDineroRecibido(salario, puntuacion)

    println("Nivel de Rendimiento: $nivel")
    println("Cantidad de Dinero Recibido: $$dinero")
}