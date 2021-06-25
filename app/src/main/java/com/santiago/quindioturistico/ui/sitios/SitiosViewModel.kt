package com.santiago.quindioturistico.ui.sitios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SitiosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Sitios Fragment"
    }
    val text: LiveData<String> = _text
}