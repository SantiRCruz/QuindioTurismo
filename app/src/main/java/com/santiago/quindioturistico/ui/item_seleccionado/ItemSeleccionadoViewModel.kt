package com.santiago.quindioturistico.ui.item_seleccionado

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemSeleccionadoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Sitios Fragment"
    }
    val text: LiveData<String> = _text
}