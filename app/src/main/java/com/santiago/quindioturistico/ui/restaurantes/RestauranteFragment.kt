package com.santiago.quindioturistico.ui.restaurantes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.santiago.quindioturistico.R
import com.santiago.quindioturistico.controllers.MainAdapter
import com.santiago.quindioturistico.controllers.MenuActivity
import com.santiago.quindioturistico.databinding.FragmentSitiosBinding
import com.santiago.quindioturistico.ui.sitios.SitiosViewModel
import com.santiago.quindioturistico.databinding.FragmentRestauranteBinding
import com.santiago.quindioturistico.models.Constantes
import kotlinx.android.synthetic.main.fragment_hoteles.*
import kotlinx.android.synthetic.main.fragment_restaurante.*


class RestauranteFragment : Fragment() {

    private  var RestauranteViewModel: RestauranteViewModel = RestauranteViewModel()
    private var _binding: FragmentRestauranteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        RestauranteViewModel =
            ViewModelProvider(this).get(RestauranteViewModel::class.java)

        _binding = FragmentRestauranteBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textRestaurante
//        RestauranteViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Constantes.BANDERA_POSICION_NAV = 3
        text_restaurante.text = "Restaurantes de nuestro hermoso Quindio"
        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        recyclerViewRestaurante.layoutManager =  LinearLayoutManager(requireContext())
        val adapter = MainAdapter(MenuActivity.listaRestaurante)
        recyclerViewRestaurante.adapter = adapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_restaurante, container, false)
//    }
}