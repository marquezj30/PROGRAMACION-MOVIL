abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    abstract fun mostrarDetalles()
}

class Libro(titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numeroPaginas: Int)
    : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numeroPaginas")
    }
}

class Revista(titulo: String, autor: String, anioPublicacion: Int, val issn: String, val volumen: Int, val numero: Int, val editorial: String)
    : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Revista: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial")
    }
}

data class Usuario(val nombre: String, val apellido: String, val edad: Int)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestamo(usuario: Usuario, material: Material)
    fun devolucion(usuario: Usuario, material: Material)
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
        if (usuario !in prestamos) {
            prestamos[usuario] = mutableListOf()
            println("Usuario registrado: ${usuario.nombre} ${usuario.apellido}")
        }
    }

    override fun prestamo(usuario: Usuario, material: Material) {
        if (material in materialesDisponibles && usuario in prestamos) {
            materialesDisponibles.remove(material)
            prestamos[usuario]?.add(material)
            println("Préstamo exitoso: ${material.titulo} a ${usuario.nombre} ${usuario.apellido}")
        } else {
            println("Error: Material no disponible o usuario no registrado.")
        }
    }

    override fun devolucion(usuario: Usuario, material: Material) {
        if (usuario in prestamos && material in prestamos[usuario]!!) {
            prestamos[usuario]!!.remove(material)
            materialesDisponibles.add(material)
            println("Devolución exitosa: ${material.titulo} por ${usuario.nombre} ${usuario.apellido}")
        } else {
            println("Error: El material no está prestado por este usuario.")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        if (materialesDisponibles.isEmpty()) {
            println("No hay materiales disponibles.")
        } else {
            println("Materiales disponibles:")
            for (material in materialesDisponibles) {
                material.mostrarDetalles()
            }
        }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        if (usuario in prestamos && prestamos[usuario]!!.isNotEmpty()) {
            println("Materiales prestados a ${usuario.nombre} ${usuario.apellido}:")
            for (material in prestamos[usuario]!!) {
                material.mostrarDetalles()
            }
        } else {
            println("${usuario.nombre} ${usuario.apellido} no tiene materiales prestados.")
        }
    }
}

fun main() {
    val biblioteca = Biblioteca()

    // Crear materiales
    val libro1 = Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967, "Realismo Mágico", 417)
    val revista1 = Revista("National Geographic", "Varios", 2023, "1234-5678", 135, 10, "National Geographic Society")

    // Crear usuarios
    val usuario1 = Usuario("Juan", "Pérez", 20)
    val usuario2 = Usuario("María", "Gómez", 25)

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)
    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)

    biblioteca.mostrarMaterialesDisponibles()

    biblioteca.prestamo(usuario1, libro1)
    biblioteca.prestamo(usuario2, revista1)

    biblioteca.mostrarMaterialesDisponibles()

    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario2)


    biblioteca.devolucion(usuario1, libro1)

    biblioteca.mostrarMaterialesDisponibles()

    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)

}