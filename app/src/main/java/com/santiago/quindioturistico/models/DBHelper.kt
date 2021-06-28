package com.santiago.quindioturistico.models

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    context: Context?
) : SQLiteOpenHelper(context, Constantes.DB_NAME, null, Constantes.DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(Constantes.TABLE_H_CREATE)
        db?.execSQL(Constantes.TABLE_R_CREATE)
        db?.execSQL(Constantes.TABLE_S_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL( " DROP TABLE IF EXISTS  " + Constantes.TABLE_S_NAME )
        onCreate(db)
    }
}