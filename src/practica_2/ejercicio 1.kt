class CuentaBancaria {
    private var saldo: Double = 0.0
    private var limiteRetiro: Double = 1000.0

    // Método para establecer el saldo (set)
    fun setSaldo(nuevoSaldo: Double) {
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo
        } else {
            println("Error: El saldo no puede ser negativo.")
        }
    }

    // Método para obtener el saldo (get)
    fun getSaldo(): Double {
        return saldo
    }

    // Método para realizar un retiro
    fun retirar(cantidad: Double) {
        if (cantidad <= 0) {
            println("Error: La cantidad a retirar debe ser mayor que 0.")
        } else if (cantidad > saldo) {
            println("Error: No hay suficiente saldo para retirar $cantidad.")
        } else if (cantidad > limiteRetiro) {
            println("Error: La cantidad $cantidad excede el límite de retiro ($limiteRetiro).")
        } else {
            saldo -= cantidad
            println("Retiro exitoso de $cantidad. Nuevo saldo: $saldo")
        }
    }
}

fun main() {
    val cuenta = CuentaBancaria()


    cuenta.setSaldo(5000.0) // Establecer saldo inicial
    println("Saldo actual: ${cuenta.getSaldo()}")

    cuenta.retirar(500.0)
    cuenta.retirar(2000.0)
    cuenta.retirar(3000.0)
    cuenta.retirar(1500.0)
    cuenta.retirar(-100.0)
}
