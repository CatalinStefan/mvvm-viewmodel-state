package com.catalin.viewmodel_state

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SaveStateViewModel(private val state: SavedStateHandle): ViewModel() {

    val counterLiveData = state.getLiveData<Int>("Counter")

    fun increment() {
        counterLiveData.value = (counterLiveData.value?:0) + 1
    }
}