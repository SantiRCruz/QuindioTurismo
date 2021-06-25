package com.santiago.quindioturistico.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.santiago.quindioturistico.R
import kotlinx.android.synthetic.main.activity_hoteles.*

class HotelesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoteles)
        importarHoteles()
    }

    fun importarHoteles()  {

        buttonImportarHoteles.setOnClickListener {
            val openRawResource = resources.openRawResource(R.raw.hoteles)
            val bufferedReader = openRawResource.bufferedReader()
            var line = bufferedReader.readLine()
            while (line!= null){
                textView4.text =  line
                line =  bufferedReader.readLine()
            }
        }




//        val iStream =  InputStreamReader(assets.open("hoteles.csv"))
//        val reader =  BufferedReader(iStream)
//
//        var line : String
//        var displayData : String = " "
//
//        while (reader.readLine().also { line =  it } !=null){
//            val row : List<String> = line?.split(";")
//            displayData = displayData + row[0] + "\n"
//        }
//        textView4.text = displayData
    }
}