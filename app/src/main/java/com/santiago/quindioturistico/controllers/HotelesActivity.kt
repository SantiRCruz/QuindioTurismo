package com.santiago.quindioturistico.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.github.doyaaaaaken.kotlincsv.client.CsvReader
import com.github.doyaaaaaken.kotlincsv.dsl.context.CsvReaderContext
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.util.CSVParseFormatException
import com.santiago.quindioturistico.R
import com.santiago.quindioturistico.models.DBHelper
import com.santiago.quindioturistico.models.DBManager
import com.santiago.quindioturistico.models.Informacion
import kotlinx.android.synthetic.main.activity_hoteles.*
import kotlinx.android.synthetic.main.fragment_sitios.*
import java.io.*
import java.nio.charset.Charset

class HotelesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoteles)
//
//        var dbHelper = DBHelper(applicationContext)
//        dbHelper.writableDatabase

        var dbManager = DBManager(applicationContext)

        importar2()
        //importar1()
        //importarCSV()
        //importarHoteles()
    }
    fun importar2() {

        var lista: MutableList<String> = ArrayList()
        val openRawResource = resources.openRawResource(R.raw.hoteles)
        val bufferedReader = openRawResource.bufferedReader(charset("iso-8859-1"))
        var line = bufferedReader.readLine()
        while (line != null) {
            var List: List<String> = line.split(";")
            //Log.e("prueba>>>", List.toString())
            lista.add(List.toString())
            line = bufferedReader.readLine()
        }

        var lista0 : String = lista[0]
        var partes : List<String> = lista0.split(",")

        buttonImportarHoteles.setOnClickListener{
            Toast.makeText(applicationContext, partes[2], Toast.LENGTH_SHORT).show()
        }


        var arrayAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_list_item_1,lista)
        lvHoteles.adapter = arrayAdapter
    }

    fun importar1() {
        var lista: MutableList<String> = ArrayList()
        val openRawResource = resources.openRawResource(R.raw.hoteles)
        val bufferedReader = openRawResource.bufferedReader(charset("iso-8859-1"))
        var line = bufferedReader.readLine()
        while (line != null) {
            var List: List<String> = line.toString().split(";")
            Log.e("prueba>>>", List.toString())
            lista.add(List.toString())
            line = bufferedReader.readLine()

        }

        var arrayAdapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_list_item_1,lista)
        lvHoteles.adapter = arrayAdapter
    }

    fun importarCSV() {
        csvReader().open("hoteles.csv") {
            readAllAsSequence().forEach { row ->
                //Do something
//                var arrayAdapter = ArrayAdapter<String>(
//                    applicationContext,
//                    android.R.layout.simple_list_item_1,
//                    row
//                )
//                lv.adapter = arrayAdapter
                Log.e("lista>>>", row.toString())
            }
        }
    }

    fun importarHoteles() {

        buttonImportarHoteles.setOnClickListener {

//                val openRawResource = resources.openRawResource(R.raw.hoteles)
//                val bufferedReader = openRawResource.bufferedReader()
//                var line = bufferedReader.readLine()
//                while (line != null) {
//                    var List: List<String> = line.toString().split(";")
//                    var adapter = ArrayAdapter<String>(
//                        applicationContext,
//                        android.R.layout.simple_list_item_1,
//                        List
//                    )
//
//                    line = bufferedReader.readLine()
//                }
//            }

//            val iStream = InputStreamReader(assets.open("hoteles.csv"))
//            val reader = BufferedReader(iStream)
//
//            var line: String
//            var displayData: String = ""
//
//
//            while (reader.readLine().also { line = it } != null) {
//                val row: List<String> = line?.split(";")
//                displayData = displayData + row[0] + "\n"
//            }
//            textView4.text = displayData
        }
    }
}