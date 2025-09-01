abstract class Shape {
    abstract val area: Double
    abstract val perimetro: Double

    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: ${calcularArea()}")
        println("Perímetro: ${calcularPerimetro()}")
    }
}

class Cuadrado : Shape {
    private var lado: Double

    constructor(lado: Double) {
        this.lado = lado
    }

    override val area: Double
        get() = calcularArea()

    override val perimetro: Double
        get() = calcularPerimetro()

    override fun calcularArea(): Double {
        return lado * lado
    }

    override fun calcularPerimetro(): Double {
        return 4 * lado
    }
}

class Circulo : Shape {
    private var radio: Double
    private val PI = 3.14 // Valor aproximado de π

    constructor(radio: Double) {
        this.radio = radio
    }

    override val area: Double
        get() = calcularArea()

    override val perimetro: Double
        get() = calcularPerimetro()

    override fun calcularArea(): Double {
        return PI * radio * radio
    }

    override fun calcularPerimetro(): Double {
        return 2 * PI * radio
    }
}

class Rectangulo : Shape {
    private var largo: Double
    private var ancho: Double

    constructor(largo: Double, ancho: Double) {
        this.largo = largo
        this.ancho = ancho
    }

    override val area: Double
        get() = calcularArea()

    override val perimetro: Double
        get() = calcularPerimetro()

    override fun calcularArea(): Double {
        return largo * ancho
    }

    override fun calcularPerimetro(): Double {
        return 2 * (largo + ancho)
    }
}

fun main() {
    val cuadrado = Cuadrado(5.0)
    println("Cuadrado:")
    cuadrado.imprimirResultados()

    val circulo = Circulo(3.0)
    println("Círculo:")
    circulo.imprimirResultados()

    val rectangulo = Rectangulo(4.0, 6.0)
    println("Rectángulo:")
    rectangulo.imprimirResultados()
}