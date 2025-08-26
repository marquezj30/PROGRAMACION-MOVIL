
fun suma(a: Int, b: Int): Int {
    return a + b
}

fun resta(a: Int, b: Int): Int {
    return a - b
}

fun multiplicacion(a: Int, b: Int): Int {
    return a * b
}

fun division(a: Int, b: Int): Int {
    return if (b != 0) a / b else 0
}

fun mostrarMenu() {
    println("==== Menú ====")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicación")
    println("4. División")
    println("5. Salir")
}

fun main() {
    var opcion: Int
    do {
        mostrarMenu()
        print("Elige una opción (1-5): ")
        opcion = readLine()!!.toInt()

        if (opcion in 1..4) {
            print("Ingresa el primer número : ")
            val num1 = readLine()!!.toInt()
            print("Ingresa el segundo número : ")
            val num2 = readLine()!!.toInt()

            val resultado = when (opcion) {
                1 -> suma(num1, num2)
                2 -> resta(num1, num2)
                3 -> multiplicacion(num1, num2)
                4 -> if (num2 != 0) division(num1, num2) else {
                    println("Error: No se puede dividir por cero.")
                    0
                }
                else -> 0
            }
            if (opcion in 1..4 && !(opcion == 4 && num2 == 0)) {
                println("Resultado: $resultado")
            }
        } else if (opcion != 5) {
            println("Opción inválida, elige entre 1 y 5.")
        }
    } while (opcion != 5)
    println("¡Gracias por usar la calculadora!")
}
