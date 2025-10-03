package com.example.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.Usuario
import com.example.recyclerviewapp.R

class UsuarioAdapter(var listaPersonas: ArrayList<Usuario>) : RecyclerView.Adapter<UsuarioViewHolder>() {

    override fun onCreateViewHolder(contenedor: ViewGroup, tipoVista: Int): UsuarioViewHolder {
        val vista = LayoutInflater.from(contenedor.context).inflate(R.layout.item_usuario, contenedor, false)
        return UsuarioViewHolder(vista)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, indice: Int) {
        val persona = listaPersonas[indice]
        holder.bind(
            persona,
            alEliminar = { pos -> eliminarPersona(pos) },
            alEditar = { pos, personaEditada -> actualizarPersona(pos, personaEditada) }
        )
    }

    override fun getItemCount(): Int = listaPersonas.size

    fun agregarPersona(nuevaPersona: Usuario) {
        listaPersonas.add(nuevaPersona)
        notifyItemInserted(itemCount - 1)
    }

    fun eliminarPersona(indice: Int) {
        if (indice in listaPersonas.indices) {
            listaPersonas.removeAt(indice)
            notifyItemRemoved(indice)
            notifyItemRangeChanged(indice, itemCount - 1)
        }
    }

    fun actualizarPersona(indice: Int, personaEditada: Usuario) {
        if (indice in listaPersonas.indices) {
            listaPersonas[indice] = personaEditada
            notifyItemChanged(indice)
        }
    }
}
