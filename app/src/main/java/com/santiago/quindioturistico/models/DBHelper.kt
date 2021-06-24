package com.santiago.quindioturistico.models

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    context: Context?
) : SQLiteOpenHelper(context, Constantes.DB_NAME, null, Constantes.DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}