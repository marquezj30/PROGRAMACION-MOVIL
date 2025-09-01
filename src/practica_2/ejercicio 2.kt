class Producto {
    private var precio: Double = 0.0
    private var descuento: Double = 0.0

    // Método para establecer el precio (set)
    fun setPrecio(nuevoPrecio: Double) {
        if (nuevoPrecio >= 0) {
            precio = nuevoPrecio
        } else {
            println("Error: El precio no puede ser negativo.")
        }
    }

    // Método para obtener el precio
    fun getPrecio(): Double {
        return precio
    }

    // Método para establecer el descuento
    fun setDescuento(nuevoDescuento: Double) {
        if (nuevoDescuento in 0.0..100.0) {
            descuento = nuevoDescuento
        } else {
            println("Error: El descuento debe estar entre 0 y 100 por ciento.")
        }
    }

    // Método para obtener el descuento
    fun getDescuento(): Double {
        return descuento
    }

    // Método para calcular el precio final con descuento
    fun calcularPrecioFinal(): Double {
        val descuentoAplicado = precio * (descuento / 100.0)
        return precio - descuentoAplicado
    }
}

fun main() {
    val producto = Producto()

    // Ejemplo de uso
    producto.setPrecio(1000.0)
    producto.setDescuento(20.0)
    println("Precio original: ${producto.getPrecio()}")
    println("Descuento: ${producto.getDescuento()}%")
    println("Precio final: ${producto.calcularPrecioFinal()}")

    // Pruebas con valores inválidos
    producto.setPrecio(-50.0)
    producto.setDescuento(150.0)
}

