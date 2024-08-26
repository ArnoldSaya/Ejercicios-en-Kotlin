/*  Crea un programa que genere un número aleatorio entre 1 y 30 y pida al usuario adivinarlo, dando pistas si el número es mayor o menor, hasta que lo adivine.

Autor: Arnold Daniel Saya Ramos
Fecha inicio 25/08/2024
Fecha ulitma modificaciones 25/08/2024
*/

import kotlin.random.Random

fun main() {
    // Genera un número aleatorio entre 1 y 30 que el usuario debe adivinar
    val numeroAdivinar = Random.nextInt(1, 31)
    var intentosRestantes = 5  // Se inicializan 5 intentos disponibles para el usuario
    var adivinado = false  // Bandera para saber si el número ha sido adivinado

    // Mensaje inicial que informa al usuario sobre el rango del número y los intentos disponibles
    println("He generado un número aleatorio entre 1 y 30. Tienes 5 intentos para adivinarlo.")

    // Bucle que se ejecuta mientras haya intentos disponibles y el número no haya sido adivinado
    while (intentosRestantes > 0 && !adivinado) {
        print("Ingrese su intento: ")
        val intento = readLine()?.toIntOrNull()  // Lee el intento del usuario y lo convierte a entero, si es posible

        if (intento != null) {
            // Compara el intento del usuario con el número a adivinar
            when {
                intento < numeroAdivinar -> {
                    println("El número a adivinar es mayor que $intento.")  // Indica si el número es mayor
                }
                intento > numeroAdivinar -> {
                    println("El número a adivinar es menor que $intento.")  // Indica si el número es menor
                }
                else -> {
                    println("¡Felicidades! Has adivinado el número correctamente.")  // El usuario ha adivinado el número
                    adivinado = true  // Cambia la bandera para indicar que el número ha sido adivinado
                }
            }
        } else {
            // Si la entrada no es un número entero, muestra un mensaje de error
            println("Entrada inválida. Por favor, ingrese un número entero.")
        }

        // Reduce el número de intentos restantes en uno después de cada intento
        intentosRestantes--

        // Si no ha adivinado y aún hay intentos disponibles, informa cuántos intentos quedan
        if (!adivinado && intentosRestantes > 0) {
            println("Te quedan $intentosRestantes intentos.")
        }
    }

    // Si se han agotado los intentos y el número no ha sido adivinado, muestra un mensaje de "Game Over"
    if (!adivinado) {
        println("Game Over. El número era $numeroAdivinar.")
    }
}
