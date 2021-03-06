package com.santiago.quindioturistico.controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import com.santiago.quindioturistico.R
import com.santiago.quindioturistico.models.Constantes
import com.santiago.quindioturistico.models.DBHelper
import com.santiago.quindioturistico.models.DBManager
import com.santiago.quindioturistico.models.Informacion

class SplashActivity : AppCompatActivity() {
    var dbManager: DBManager? = null
    var ejecucion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var dbHelper = DBHelper(applicationContext)
        dbHelper.writableDatabase

        dbManager = DBManager(applicationContext)

        if (ejecucion == 0){
            importarCSV(Constantes.TABLE_S_NAME,R.raw.sitios)
            importarCSV(Constantes.TABLE_H_NAME,R.raw.hoteles)
            importarCSV(Constantes.TABLE_R_NAME,R.raw.restaurantes)
            ejecucion++
        }

        startTimer()
    }

    fun startTimer() {
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                val intent = Intent(applicationContext, MenuActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }

    fun importarCSV(nombreTabla: String, nombreCSV: Int) {


        var lista: MutableList<String> = ArrayList()
        val openRawResource = resources.openRawResource(nombreCSV)
        val bufferedReader = openRawResource.bufferedReader(charset("iso-8859-1"))
        var line = bufferedReader.readLine()
        while (line != null) {
            var List: List<String> = line.split(";")
            //Log.e("prueba>>>", List.toString())
            var nombre: String= List[0]
            var descripcionCorta: String= List[1]
            var ubicacion: String= List[2]
            var descripcion: String= List[3]
            var informacion = Informacion(nombre, descripcionCorta, ubicacion, descripcion)
            dbManager?.insertar(nombreTabla, informacion)
            lista.add(List.toString())
            line = bufferedReader.readLine()
        }
    }
}