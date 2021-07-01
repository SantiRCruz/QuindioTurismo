package com.santiago.quindioturistico.ui.sitios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.santiago.quindioturistico.controllers.MenuActivity
import com.santiago.quindioturistico.R
import com.santiago.quindioturistico.databinding.FragmentSitiosBinding
import com.santiago.quindioturistico.controllers.MainAdapter
import com.santiago.quindioturistico.models.Constantes
import kotlinx.android.synthetic.main.fragment_item_seleccionado.view.*

import kotlinx.android.synthetic.main.fragment_sitios.*

class SitiosFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private  var SitiosViewModel: SitiosViewModel = SitiosViewModel()
    private var _binding: FragmentSitiosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        SitiosViewModel =
            ViewModelProvider(this).get(SitiosViewModel::class.java)

        _binding = FragmentSitiosBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Constantes.BANDERA_POSICION_NAV = 1
        text_sitios.text = "Sitos de nuestro hermoso Quindio"
        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        recyclerViewSitios.layoutManager =  LinearLayoutManager(requireContext())
        val adapter = MainAdapter(MenuActivity.listaSitios)
        recyclerViewSitios.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}