package com.santiago.quindioturistico.controllers

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.santiago.quindioturistico.R
import com.santiago.quindioturistico.models.Constantes
import com.santiago.quindioturistico.models.Informacion
import com.santiago.quindioturistico.ui.item_seleccionado.ItemSeleccionadoFragment
import com.santiago.quindioturistico.ui.item_seleccionado.ItemSeleccionadoViewModel
import com.santiago.quindioturistico.ui.sitios.SitiosFragment
import com.santiago.quindioturistico.ui.sitios.SitiosViewModel
import kotlinx.android.synthetic.main.item_fragment.view.*

class MainAdapter(val Informacion: List<Informacion>) :
    RecyclerView.Adapter<MainAdapter.MainHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MainHolder(layoutInflater.inflate(R.layout.item_fragment, parent, false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.render(Informacion[position])
    }

    override fun getItemCount(): Int = Informacion.size

    class MainHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun render(informacion: Informacion) {
            view.textViewNombre.text = informacion.nombre
            view.textViewDescripcionCorta.text = informacion.descripcionCorta
            view.textViewUbicacion.text = informacion.ubicacion
            view.setOnClickListener {
                val actividad = view!!.context as AppCompatActivity
                val itemSeleccionadoFragment = ItemSeleccionadoFragment()
                val sitiosFragment = SitiosFragment()
                Constantes.NOMBRE_ITEM = view.textViewNombre.text.toString()
                Navigation.findNavController(it).navigate(R.id.nav_itemSeleccionado)
                //actividad.supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_menu,itemSeleccionadoFragment).commit()
//                val intent = Intent(view.context, ItemSeleccionadoFragment::class.java)
//                intent.putExtra("nombreItem",view.textViewNombre.text.toString())
//                .startActivity(intent)
            }
        }
    }

}