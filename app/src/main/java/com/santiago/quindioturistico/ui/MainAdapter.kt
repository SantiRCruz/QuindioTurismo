package com.santiago.quindioturistico.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santiago.quindioturistico.R
import com.santiago.quindioturistico.models.Informacion
import kotlinx.android.synthetic.main.item_fragment.view.*

class MainAdapter (val Informacion : List<Informacion>):RecyclerView.Adapter<MainAdapter.MainHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MainHolder(layoutInflater.inflate(R.layout.item_fragment,parent,false))
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(Informacion[position])
    }

    override fun getItemCount(): Int  = Informacion.size

    class MainHolder (val view : View):RecyclerView.ViewHolder(view) {
        fun render(informacion: Informacion){
            view.textViewNombre.text = informacion.nombre
            view.textViewDescripcionCorta.text = informacion.descripcionCorta
            view.textViewUbicacion.text = informacion.ubicacion
        }
    }

}