package com.santiago.quindioturistico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.santiago.quindioturistico.models.Informacion
import kotlinx.android.synthetic.main.activity_hoteles.*
import java.io.File

class HotelesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoteles)

        importarHoteles()
    }

     fun importarHoteles() {
        var listaHoteles = ArrayList<Informacion>()
         recyclerViewHoteles.layoutManager =  GridLayoutManager(applicationContext,1)

         buttonImportarHoteles.setOnClickListener {
             importarCSV()
         }
    }
    fun importarCSV(){


    }
}