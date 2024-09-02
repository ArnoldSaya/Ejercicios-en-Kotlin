// Descripción: Clases para calcular el área y perímetro de diferentes figuras.
// Autor: Arnold Daniel Saya Ramos
// Fecha de Creación: 1/09/2024
// Fecha Última Modificación: 1/09/2024

abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double
}

class Cuadrado(private val lado: Double) : Shape() {
    override fun calcularArea() = lado * lado
    override fun calcularPerimetro() = 4 * lado
}

class Circulo(private val radio: Double) : Shape() {
    override fun calcularArea() = Math.PI * radio * radio
    override fun calcularPerimetro() = 2 * Math.PI * radio
}

class Rectangulo(private val largo: Double, private val ancho: Double) : Shape() {
    override fun calcularArea() = largo * ancho
    override fun calcularPerimetro() = 2 * (largo + ancho)
}

fun main() {
    val cuadrado = Cuadrado(4.0)
    val circulo = Circulo(3.0)
    val rectangulo = Rectangulo(5.0, 2.0)

    println("Área del cuadrado: ${cuadrado.calcularArea()}, Perímetro: ${cuadrado.calcularPerimetro()}")
    println("Área del círculo: ${circulo.calcularArea()}, Perímetro: ${circulo.calcularPerimetro()}")
    println("Área del rectángulo: ${rectangulo.calcularArea()}, Perímetro: ${rectangulo.calcularPerimetro()}")
}
