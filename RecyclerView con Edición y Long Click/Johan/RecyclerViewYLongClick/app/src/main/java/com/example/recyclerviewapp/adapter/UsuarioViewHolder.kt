package com.example.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.Usuario

class UsuarioViewHolder(vista: View): RecyclerView.ViewHolder(vista){

    private val lblNombre = vista.findViewById<TextView>(R.id.txtNombre)
    private val lblAnios = vista.findViewById<TextView>(R.id.txtEdad)
    private val lblCorreo = vista.findViewById<TextView>(R.id.txtCorreo)
    private val btnEliminar = vista.findViewById<ImageButton>(R.id.btnEliminar)

    fun bind(
        persona: Usuario,
        alEliminar: (Int) -> Unit,
        alEditar: (Int, Usuario) -> Unit
    ){
        lblNombre.text = persona.nombreCompleto
        lblAnios.text = persona.anios.toString()
        lblCorreo.text = persona.correo

        // Botón eliminar
        btnEliminar.setOnClickListener {
            val indice = bindingAdapterPosition
            if (indice != RecyclerView.NO_POSITION) {
                alEliminar(indice)
            }
        }

        // Long click
        itemView.setOnLongClickListener {
            val indice = bindingAdapterPosition
            if (indice != RecyclerView.NO_POSITION) {
                AlertDialog.Builder(itemView.context)
                    .setTitle("Acción")
                    .setItems(arrayOf("Editar", "Eliminar")) { _, opcion ->
                        when (opcion) {
                            0 -> { // Editar
                                mostrarDialogoEditar(persona, indice, alEditar)
                            }
                            1 -> { // Eliminar
                                alEliminar(indice)
                            }
                        }
                    }
                    .show()
            }
            true
        }
    }

    private fun mostrarDialogoEditar(usuario: Usuario, indice: Int, alEditar: (Int, Usuario) -> Unit) {
        val contexto = itemView.context
        val vistaDialogo = LayoutInflater.from(contexto).inflate(R.layout.dialog_edit_usuario, null)

        val inputNombre = vistaDialogo.findViewById<EditText>(R.id.editNombre)
        val inputAnios = vistaDialogo.findViewById<EditText>(R.id.editEdad)
        val inputCorreo = vistaDialogo.findViewById<EditText>(R.id.editCorreo)

        // valores actuales
        inputNombre.setText(usuario.nombreCompleto)
        inputAnios.setText(usuario.anios.toString())
        inputCorreo.setText(usuario.correo)

        AlertDialog.Builder(contexto)
            .setTitle("Editar usuario")
            .setView(vistaDialogo)
            .setPositiveButton("Guardar") { _, _ ->
                usuario.nombreCompleto = inputNombre.text.toString()
                usuario.anios = inputAnios.text.toString().toIntOrNull() ?: usuario.anios
                usuario.correo = inputCorreo.text.toString()
                alEditar(indice, usuario)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}
