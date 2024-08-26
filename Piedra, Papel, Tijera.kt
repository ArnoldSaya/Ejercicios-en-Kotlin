/* Escriba un programa que realice el juego de piedra, papel o tijera. La computadora debe elegir 
   de manera aleatoria la opción a elegir. Después debe preguntar al usuario que opción quiere. 
   Imprimir si ganó, perdió o empató.
   
Autor: Arnold Daniel Saya Ramos
Fecha inicio 25/08/2024
Fecha ulitma modificaciones 25/08/2024
*/
import kotlin.random.Random

fun main() {
    val opciones = arrayOf("Piedra", "Papel", "Tijera")  // Definimos las opciones del juego como un array
    var resultado: String  // Variable para almacenar el resultado del juego

    do {
        // Generar la elección de la computadora de manera aleatoria
        val eleccionComputadora = opciones[Random.nextInt(3)]  // Selecciona una opción aleatoria para la computadora

        // Solicitar la elección del usuario
        print("Elija una opción (1 = Piedra, 2 = Papel, 3 = Tijera): ")
        val eleccionUsuarioInput = readLine()?.toIntOrNull()  // Lee la entrada del usuario y la convierte a Int

        if (eleccionUsuarioInput in 1..3) {  // Verifica que la entrada del usuario sea válida (1, 2 o 3)
            val eleccionUsuario = opciones[eleccionUsuarioInput!! - 1]  // Asigna la opción seleccionada por el usuario

            // Mostrar las elecciones de la computadora y del usuario
            println("La computadora eligió: $eleccionComputadora")
            println("Usted eligió: $eleccionUsuario")

            // Determinar el resultado del juego
            resultado = when {
                eleccionUsuario == eleccionComputadora -> "Empate"  // Si ambos eligen lo mismo, es un empate
                (eleccionUsuario == "Piedra" && eleccionComputadora == "Tijera") ||  // Piedra gana a Tijera
                        (eleccionUsuario == "Papel" && eleccionComputadora == "Piedra") ||  // Papel gana a Piedra
                        (eleccionUsuario == "Tijera" && eleccionComputadora == "Papel") -> "Ganaste"  // Tijera gana a Papel
                else -> "Perdiste"  // Si no, el usuario pierde
            }

            // Si es empate, pide al usuario que lo intente de nuevo
            if (resultado == "Empate") {
                println("Empate, vuelve a intentarlo.")
            } else {
                println("Resultado: $resultado")  // Muestra el resultado si no es empate
            }
        } else {
            // Si la entrada del usuario es inválida (no es 1, 2 o 3)
            println("Opción inválida. Por favor, elija 1, 2 o 3.")
            resultado = "Empate" // Fuerza otro intento si la opción es inválida
        }
    } while (resultado == "Empate")  // Repite el proceso hasta que el usuario gane o pierda
}
