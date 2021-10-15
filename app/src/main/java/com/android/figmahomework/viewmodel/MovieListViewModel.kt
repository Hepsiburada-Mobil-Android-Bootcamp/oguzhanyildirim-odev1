package com.android.figmahomework.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData




class MovieListViewModel : ViewModel() {

    var data: MutableLiveData<ArrayList<String>> = MutableLiveData()

    fun addMovie(input: String){
        if (data.value == null){
            data.value = arrayListOf<String>(input)
        }
        else{
            data.value!!.add(input)
            data.value = data.value

        }

    }

}