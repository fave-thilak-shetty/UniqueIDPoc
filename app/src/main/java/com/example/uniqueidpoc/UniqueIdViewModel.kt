package com.example.uniqueidpoc

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UniqueIdViewModel : ViewModel() {
    val currentID: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}