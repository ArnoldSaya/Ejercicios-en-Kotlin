// Descripción: Clase que modela un producto con precio y descuento aplicable.
// Autor: Arnold Daniel Saya Ramos
// Fecha de Creación: 1/09/2024
// Fecha Última Modificación: 1/09/2024

class Producto(private var precio: Double, private var descuento: Double) {

    // Setter y getter para precio
    var precioProducto: Double
        get() = precio
        set(value) {
            if (value >= 0) precio = value
        }

    // Setter y getter para descuento
    var descuentoProducto: Double
        get() = descuento
        set(value) {
            if (value in 0.0..100.0) descuento = value
        }

    // Método para calcular el precio final después de aplicar el descuento
    fun calcularPrecioFinal(): Double {
        val precioFinal = precio * (1 - descuento / 100)
        println("Precio final después del descuento: $precioFinal")
        return precioFinal
    }
}

fun main() {
    val producto = Producto(100.0, 20.0)
    producto.calcularPrecioFinal()
}
