// Descripción: Clase que modela una cuenta bancaria con saldo y límite de retiro.
// Autor: Arnold Daniel Saya Ramos
// Fecha de Creación: 1/09/2024
// Fecha Última Modificación: 1/09/2024

class CuentaBancaria(private var saldo: Double, private var limiteRetiro: Double) {

    // Setter y getter para saldo
    var saldoDisponible: Double
        get() = saldo
        set(value) {
            if (value >= 0) saldo = value
        }

    // Setter y getter para límite de retiro
    var limite: Double
        get() = limiteRetiro
        set(value) {
            if (value >= 0) limiteRetiro = value
        }

    // Método para realizar retiros
    fun retirar(cantidad: Double): Boolean {
        return if (cantidad <= limiteRetiro && cantidad <= saldo) {
            saldo -= cantidad
            println("Retiro exitoso: $cantidad. Saldo restante: $saldo")
            true
        } else {
            println("Retiro fallido. Cantidad excede el límite o saldo disponible.")
            false
        }
    }
}

fun main() {
    val cuenta = CuentaBancaria(1000.0, 500.0)
    cuenta.retirar(300.0)
    cuenta.retirar(600.0)
}
