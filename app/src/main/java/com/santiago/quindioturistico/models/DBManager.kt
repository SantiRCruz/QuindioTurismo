package com.santiago.quindioturistico.models

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DBManager(context: Context){


    val dbHelper = DBHelper(context)
    var db : SQLiteDatabase  ?= null






    fun openDbWR(){
        db =  dbHelper.writableDatabase
    }

    fun openDbRd(){
        db =  dbHelper.readableDatabase
    }

    fun closeDb(){
        if(db != null){
            db?.close()
        }
    }
    fun insertar(nombreTabla : String,informacion: Informacion):Long{
        openDbWR()
        var values = ContentValues()
        values.put(Constantes.TABLE_COLUMN_1,informacion.nombre)
        values.put(Constantes.TABLE_COLUMN_2,informacion.descripcionCorta)
        values.put(Constantes.TABLE_COLUMN_3,informacion.ubicacion)
        values.put(Constantes.TABLE_COLUMN_4,informacion.descripcion)
        var result = db?.insert(nombreTabla,null, values)
        closeDb()
        return  result!!
    }

    fun listar(nombreTabla : String):MutableList<Informacion>{
        var lista :MutableList<Informacion> = ArrayList()
        openDbWR()
        var result =  db?.rawQuery(Constantes.CONSULTA+nombreTabla,null)
        if (result!!.moveToFirst())
        do {
            var informacion = Informacion()
            informacion.nombre = result!!.getString(result.getColumnIndex(Constantes.TABLE_COLUMN_1))
            informacion.descripcionCorta = result!!.getString(result.getColumnIndex(Constantes.TABLE_COLUMN_2))
            informacion.ubicacion = result!!.getString(result.getColumnIndex(Constantes.TABLE_COLUMN_3))
            informacion.descripcion = result!!.getString(result.getColumnIndex(Constantes.TABLE_COLUMN_4))
            lista.add(informacion)
        }while (result.moveToNext())
        closeDb()
        return lista

    }
    fun eliminar(nombreTabla: String){
        db?.delete(nombreTabla,null,null)
    }
}