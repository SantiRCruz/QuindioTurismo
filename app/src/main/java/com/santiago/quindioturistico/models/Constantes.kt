package com.santiago.quindioturistico.models

class Constantes {
    companion object{
        val DB_NAME="TURISMO"
        val DB_VERSION=12


        val TABLE_H_NAME="hoteles"
        val TABLE_R_NAME="restaurantes"
        val TABLE_S_NAME="sitios"
        val TABLE_COLUMN_1="nombre"
        val TABLE_COLUMN_2="descripcion_corta"
        val TABLE_COLUMN_3="ubicacion"
        val TABLE_COLUMN_4="descripcion"

        val CONSULTA = " SELECT * FROM "


        val TABLE_H_CREATE=" CREATE TABLE IF NOT EXISTS " + TABLE_H_NAME + " ( " + TABLE_COLUMN_1 + " TEXT PRIMARY KEY , " +
                TABLE_COLUMN_2+ " TEXT , " +
                TABLE_COLUMN_3+ " TEXT , " +
                TABLE_COLUMN_4+ " TEXT ) "

        val TABLE_S_CREATE=" CREATE TABLE IF NOT EXISTS " + TABLE_S_NAME + " ( " + TABLE_COLUMN_1 + " TEXT PRIMARY KEY , " +
                TABLE_COLUMN_2+ " TEXT , " +
                TABLE_COLUMN_3+ " TEXT , " +
                TABLE_COLUMN_4+ " TEXT ) "

        val TABLE_R_CREATE=" CREATE TABLE IF NOT EXISTS " + TABLE_R_NAME + " ( " + TABLE_COLUMN_1 + " TEXT PRIMARY KEY , " +
                TABLE_COLUMN_2+ " TEXT , " +
                TABLE_COLUMN_3+ " TEXT , " +
                TABLE_COLUMN_4+ " TEXT ) "


    }
}