package com.santiago.quindioturistico.ui.restaurantes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RestauranteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is inicio Fragment"
    }
    val text: LiveData<String> = _text
}