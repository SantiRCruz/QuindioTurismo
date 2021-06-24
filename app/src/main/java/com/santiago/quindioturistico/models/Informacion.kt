package com.santiago.quindioturistico.models

class Informacion {
    var nombre = ""
    var descripcionCorta = ""
    var ubicacion = ""
    var Descripcion = ""

    constructor()

    constructor(nombre: String, descripcionCorta: String, ubicacion: String, Descripcion: String) {
        this.nombre = nombre
        this.descripcionCorta = descripcionCorta
        this.ubicacion = ubicacion
        this.Descripcion = Descripcion
    }

    override fun toString(): String {
        return "Hoteles(nombre='$nombre', descripcionCorta='$descripcionCorta', ubicacion='$ubicacion', Descripcion='$Descripcion')"
    }
}