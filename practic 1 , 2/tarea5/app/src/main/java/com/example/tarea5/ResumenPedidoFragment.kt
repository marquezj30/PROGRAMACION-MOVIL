package com.example.tarea5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tarea5.databinding.FragmentResumenPedidoBinding

class ResumenPedidoFragment : Fragment() {
    private var _binding: FragmentResumenPedidoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentResumenPedidoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tipoComida = arguments?.getString("tipoComida") ?: ""
        val extras = arguments?.getString("extras") ?: ""

        binding.tvResumen.text = "Comida: $tipoComida\nExtras: $extras"

        binding.btnConfirmar.setOnClickListener {
            Toast.makeText(requireContext(), "Pedido confirmado", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_resumenPedidoFragment_to_inicioFragment)
        }

        binding.btnEditar.setOnClickListener {
            val bundle = Bundle().apply {
                putString("tipoComida", tipoComida)
                putString("extras", extras)
            }
            parentFragmentManager.setFragmentResult("pedidoEditado", bundle)
            findNavController().popBackStack(R.id.seleccionComidaFragment, false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
