package com.santiago.quindioturistico.ui.item_seleccionado

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.santiago.quindioturistico.R
import com.santiago.quindioturistico.controllers.MainAdapter
import com.santiago.quindioturistico.controllers.MenuActivity
import com.santiago.quindioturistico.databinding.FragmentItemSeleccionadoBinding
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

    private  var ItemSeleccionadoViewModel: ItemSeleccionadoViewModel = ItemSeleccionadoViewModel()
    private var _binding: FragmentItemSeleccionadoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        ItemSeleccionadoViewModel =
            ViewModelProvider(this).get(ItemSeleccionadoViewModel::class.java)

        _binding = FragmentItemSeleccionadoBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbManager= DBManager(view.context)
        consultar()

    }

    fun consultar(){
        if (Constantes.BANDERA_POSICION_NAV == 1){
            var listaSitios = dbManager!!.consultarDetalle(Constantes.TABLE_S_NAME,Constantes.NOMBRE_ITEM)
            var partesLista = listaSitios.toString().split("*")
            Log.e("prueba>>>",listaSitios.toString())
            var nombre : String = partesLista[0].replace("[","")
            var descripcionCorta : String = partesLista[1]
            var ubicacion : String = partesLista[2]
            var descripcion : String = partesLista[3].replace("]","")

            textViewItemSeleccionado.text = "Su item seleccionado es : " + nombre
            textViewItemSitiosNombre.text = nombre
            textViewItemSitiosDescripcion.text = descripcion
        }else if (Constantes.BANDERA_POSICION_NAV == 2){
            var listaSitios = dbManager!!.consultarDetalle(Constantes.TABLE_H_NAME,Constantes.NOMBRE_ITEM)
            var partesLista = listaSitios.toString().split("*")
            Log.e("prueba>>>",listaSitios.toString())
            var nombre : String = partesLista[0].replace("[","")
            var descripcionCorta : String = partesLista[1]
            var ubicacion : String = partesLista[2]
            var descripcion : String = partesLista[3].replace("]","")

            textViewItemSeleccionado.text = "Su item seleccionado es : " + nombre
            textViewItemSitiosNombre.text = nombre
            textViewItemSitiosDescripcion.text = descripcion
        }else if(Constantes.BANDERA_POSICION_NAV == 3){
            var listaSitios = dbManager!!.consultarDetalle(Constantes.TABLE_R_NAME,Constantes.NOMBRE_ITEM)
            var partesLista = listaSitios.toString().split("*")
            Log.e("prueba>>>",partesLista.toString())
            var nombre : String = partesLista[0].replace("[","")
            var descripcionCorta : String = partesLista[1]
            var ubicacion : String = partesLista[2]
            var descripcion : String = partesLista[3].replace("]","")

            textViewItemSeleccionado.text = "Su item seleccionado es : " + nombre
            textViewItemSitiosNombre.text = nombre
            textViewItemSitiosDescripcion.text = descripcion
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}