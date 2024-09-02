// Descripción: Sistema de gestión de biblioteca con libros y revistas, usuarios y operaciones de préstamo.
// Autor: Arnold Daniel Saya Ramos
// Fecha de Creación: 1/09/2024
// Fecha Última Modificación: 1/09/2024

abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    abstract fun mostrarDetalles()
}

class Libro(titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numPaginas: Int) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numPaginas")
    }
}

class Revista(titulo: String, autor: String, anioPublicacion: Int, val issn: String, val volumen: Int, val numero: Int, val editorial: String) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Revista: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial")
    }
}

data class Usuario(val nombre: String, val apellido: String, val edad: Int)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material): Boolean
    fun devolverMaterial(usuario: Usuario, material: Material): Boolean
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("Material registrado: ${material.titulo}")
    }

    override fun registrarUsuario(usuario: Usuario) {
        prestamos[usuario] = mutableListOf()
        println("Usuario registrado: ${usuario.nombre} ${usuario.apellido}")
    }

    override fun prestarMaterial(usuario: Usuario, material: Material): Boolean {
        return if (material in materialesDisponibles) {
            materialesDisponibles.remove(material)
            prestamos[usuario]?.add(material)
            println("Material prestado: ${material.titulo} a ${usuario.nombre}")
            true
        } else {
            println("Material no disponible.")
            false
        }
    }

    override fun devolverMaterial(usuario: Usuario, material: Material): Boolean {
        return if (material in prestamos[usuario] ?: mutableListOf()) {
            prestamos[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("Material devuelto: ${material.titulo} por ${usuario.nombre}")
            true
        } else {
            println("El material no pertenece a los préstamos del usuario.")
            false
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("Materiales reservados por ${usuario.nombre}:")
        prestamos[usuario]?.forEach { it.mostrarDetalles() }
    }
}

fun main() {
    val biblioteca = Biblioteca()
    val libro = Libro("1984", "George Orwell", 1949, "Distopía", 328)
    val revista = Revista("National Geographic", "Varios", 2022, "1234-5678", 10, 1, "NatGeo")

    val usuario = Usuario("Juan", "Pérez", 30)

    biblioteca.registrarMaterial(libro)
    biblioteca.registrarMaterial(revista)
    biblioteca.registrarUsuario(usuario)

    biblioteca.prestarMaterial(usuario, libro)
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario)

    biblioteca.devolverMaterial(usuario, libro)
    biblioteca.mostrarMaterialesDisponibles()
}
