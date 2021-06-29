package com.santiago.quindioturistico.ui.item_seleccionado

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.santiago.quindioturistico.R
import com.santiago.quindioturistico.controllers.MainAdapter
import com.santiago.quindioturistico.controllers.MenuActivity
import com.santiago.quindioturistico.databinding.FragmentSitiosBinding
import com.santiago.quindioturistico.models.Constantes
import com.santiago.quindioturistico.models.DBManager
import com.santiago.quindioturistico.ui.sitios.SitiosViewModel
import kotlinx.android.synthetic.main.fragment_item_seleccionado.*
import kotlinx.android.synthetic.main.fragment_sitios.*


class ItemSeleccionadoFragment : Fragment() {

    var dbManager : DBManager ?= null


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
        textViewItemSeleccionado.text = "Su item seleccionado es : "



        dbManager= DBManager(view.context)
        var listaSitios = dbManager!!.consultarDetalle(Constantes.TABLE_S_NAME,Constantes.NOMBRE_ITEM)
        var nombre : String = listaSitios[0].toString()
        var descripcionCorta : String = listaSitios[1].toString()
        var ubicacion : String = listaSitios[2].toString()
        var descripcion : String = listaSitios[3].toString()

        textViewItemSeleccionado.text = "Su item seleccionado es : " + nombre
        textViewItemSitiosNombre.text = nombre
        textViewItemSitiosDescripcion.text = descripcion

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}