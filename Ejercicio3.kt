/* Realizar una calculadora  básica suma, resta, multiplicación, división. Debe imprimir un menú con las opciones 
   incluyendo una opción salir. Validar que la opción esté disponible. Imprimir resultados.
   
Autor: Arnold Daniel Saya Ramos
Fecha inicio 25/08/2024
Fecha ulitma modificaciones 25/08/2024
*/

fun main() {
    var opcion: Int  // Variable para almacenar la opción seleccionada por el usuario

    do {
        // Imprimir el menú de opciones
        println("Seleccione una opción:")
        println("1. Sumar")
        println("2. Restar")
        println("3. Multiplicar")
        println("4. Dividir")
        println("5. Salir")
        print("Opción: ")

        // Leer la opción seleccionada por el usuario y convertirla a un entero
        opcion = readLine()!!.toInt()

        if (opcion in 1..4) {  // Verifica si la opción seleccionada está en el rango de 1 a 4
            print("¿Cuántos números desea operar? ")  // Pregunta cuántos números se van a utilizar en la operación
            val cantidadNumeros = readLine()!!.toInt()  // Lee la cantidad de números y la convierte a entero
            val numeros = DoubleArray(cantidadNumeros)  // Crea un array de números con la cantidad especificada

            // Solicitar los números al usuario
            for (i in 0 until cantidadNumeros) {
                print("Ingrese el número ${i + 1}: ")  // Pide al usuario que ingrese cada número uno por uno
                numeros[i] = readLine()!!.toDouble()  // Almacena el número ingresado en el array
            }

            // Realizar la operación seleccionada
            val resultado = when (opcion) {
                1 -> numeros.sum()  // Suma todos los números en el array
                2 -> numeros.reduce { acc, num -> acc - num }  // Resta secuencialmente todos los números
                3 -> numeros.reduce { acc, num -> acc * num }  // Multiplica secuencialmente todos los números
                4 -> numeros.reduce { acc, num ->  // Divide secuencialmente todos los números
                    if (num != 0.0) acc / num else {  // Verifica si el número es diferente de 0 para evitar la división por cero
                        println("Error: No se puede dividir por cero.")
                        return@reduce acc  // Si hay un intento de división por cero, devuelve el acumulador sin cambios
                    }
                }
                else -> 0.0  // Caso por defecto, aunque no debería alcanzarse nunca
            }

            // Imprimir el resultado de la operación
            println("El resultado es: $resultado")

        } else if (opcion != 5) {  // Si la opción no es 5, entonces es inválida
            println("Opción inválida. Por favor, elija una opción entre 1 y 5.")
        }

    } while (opcion != 5)  // El bucle continúa hasta que el usuario elija la opción 5 (Salir)

    println("Gracias por usar la calculadora. ¡Hasta luego!")  // Mensaje de despedida al salir del programa
}
