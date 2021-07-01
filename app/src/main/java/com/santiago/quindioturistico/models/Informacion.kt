package com.santiago.quindioturistico.models

class Informacion {
    var nombre = ""
    var descripcionCorta = ""
    var ubicacion = ""
    var descripcion = ""

    constructor()


    constructor(nombre: String, descripcionCorta: String, ubicacion: String, Descripcion: String) {
        this.nombre = nombre
        this.descripcionCorta = descripcionCorta
        this.ubicacion = ubicacion
        this.descripcion = Descripcion
    }
    constructor(nombre: String, descripcionCorta: String, ubicacion: String) {
        this.nombre = nombre
        this.descripcionCorta = descripcionCorta
        this.ubicacion = ubicacion
    }

    constructor(nombre: String) {
        this.nombre = nombre
    }

    override fun toString(): String {
        return "$nombre * $descripcionCorta * $ubicacion * $descripcion"
    }
}