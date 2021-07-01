package com.santiago.quindioturistico.ui.hoteles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.santiago.quindioturistico.controllers.MainAdapter
import com.santiago.quindioturistico.controllers.MenuActivity
import com.santiago.quindioturistico.databinding.FragmentHotelesBinding
import com.santiago.quindioturistico.models.Constantes
import kotlinx.android.synthetic.main.fragment_hoteles.*
import kotlinx.android.synthetic.main.fragment_sitios.*

class HotelesFragment : Fragment() {

    private  var HotelesViewModel: HotelesViewModel = HotelesViewModel()
    private var _binding: FragmentHotelesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        HotelesViewModel =
            ViewModelProvider(this).get(HotelesViewModel::class.java)

        _binding = FragmentHotelesBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHoteles
//        HotelesViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Constantes.BANDERA_POSICION_NAV = 2
        text_hoteles.text = "Hoteles de nuestro hermoso Quindio"
        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        recyclerViewHoteles.layoutManager =  LinearLayoutManager(requireContext())
        val adapter = MainAdapter(MenuActivity.listaHoteles)
        recyclerViewHoteles.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}