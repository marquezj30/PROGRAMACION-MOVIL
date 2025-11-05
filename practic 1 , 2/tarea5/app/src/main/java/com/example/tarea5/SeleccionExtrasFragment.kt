package com.example.tarea5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tarea5.databinding.FragmentSeleccionExtrasBinding

class SeleccionExtrasFragment : Fragment() {
    private var _binding: FragmentSeleccionExtrasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSeleccionExtrasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSiguiente.setOnClickListener {
            val bebida = if (binding.chkBebida.isChecked) "Bebida" else ""
            val papas = if (binding.chkPapas.isChecked) "Papas" else ""
            val postre = if (binding.chkPostre.isChecked) "Postre" else ""
            val extras = listOf(bebida, papas, postre).filter { it.isNotEmpty() }.joinToString(", ")

            val bundle = arguments ?: Bundle()
            bundle.putString("extras", extras)
            findNavController().navigate(R.id.action_seleccionExtrasFragment_to_resumenPedidoFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
