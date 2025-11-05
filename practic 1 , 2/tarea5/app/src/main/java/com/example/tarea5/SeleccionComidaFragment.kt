package com.example.tarea5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tarea5.databinding.FragmentSeleccionComidaBinding

class SeleccionComidaFragment : Fragment() {
    private var _binding: FragmentSeleccionComidaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSeleccionComidaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSiguiente.setOnClickListener {
            val tipoComida = when {
                binding.radioPizza.isChecked -> "Pizza"
                binding.radioHamburguesa.isChecked -> "Hamburguesa"
                binding.radioEnsalada.isChecked -> "Ensalada"
                else -> ""
            }
            val bundle = Bundle()
            bundle.putString("tipoComida", tipoComida)
            findNavController().navigate(R.id.action_seleccionComidaFragment_to_seleccionExtrasFragment, bundle)
        }

        parentFragmentManager.setFragmentResultListener("pedidoEditado", viewLifecycleOwner) { _, result ->
            val comidaEditada = result.getString("tipoComida")
            when (comidaEditada) {
                "Pizza" -> binding.radioPizza.isChecked = true
                "Hamburguesa" -> binding.radioHamburguesa.isChecked = true
                "Ensalada" -> binding.radioEnsalada.isChecked = true
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
