/* Escribe un programa que lea la puntuación y el salario mensual de un empleado, determine su nivel de rendimiento 
   basado en la puntuación (de 0 a 10), y calcule la cantidad de dinero que recibirá según ese nivel. Luego, imprime 
   el nivel de rendimiento y el dinero correspondiente.
   
Autor: Arnold Daniel Saya Ramos
Fecha inicio 25/08/2024
Fecha ulitma modificaciones 25/08/2024
*/
fun main() {
    // Solicita al usuario que ingrese su salario mensual
    print("Ingrese su salario mensual: ")
    var salario = readLine()!!.toDouble()  // Lee la entrada y la convierte a Double

    // Solicita al usuario que ingrese su puntuación (entre 0 y 10)
    print("Ingrese su puntuación (entre 0 y 10): ")
    var puntuacion = readLine()!!.toDouble()  // Lee la entrada y la convierte a Double

    // Determina el nivel de rendimiento en función de la puntuación ingresada
    var nivelRendimiento = when {
        puntuacion < 0.0 || puntuacion > 10.0 -> "Puntuación inválida"  // Valida que la puntuación esté en el rango de 0 a 10
        puntuacion >= 9.0 -> "Nivel de Rendimiento Excelente"  // Nivel excelente si la puntuación es 9 o más
        puntuacion >= 7.0 -> "Nivel de Rendimiento Bueno"  // Nivel bueno si la puntuación es entre 7 y 8.99
        puntuacion >= 5.0 -> "Nivel de Rendimiento Aceptable"  // Nivel aceptable si la puntuación es entre 5 y 6.99
        puntuacion >= 3.0 -> "Nivel de Rendimiento Regular"  // Nivel regular si la puntuación es entre 3 y 4.99
        else -> "Nivel de Rendimiento Insuficiente"  // Nivel insuficiente si la puntuación es menor a 3
    }

    // Verifica si la puntuación ingresada es válida
    if (nivelRendimiento == "Puntuación inválida") {
        println("Puntuación inválida. Debe estar entre 0 y 10.")
    } else {
        // Calcula la cantidad de dinero recibida en función de la puntuación
        var dineroRecibido = salario * (puntuacion / 10)
        // Imprime el nivel de rendimiento del usuario
        println("Nivel de Rendimiento: $nivelRendimiento")
        // Imprime la cantidad de dinero que el usuario recibirá
        println("Cantidad de Dinero Recibido: $${dineroRecibido}")
    }
}
