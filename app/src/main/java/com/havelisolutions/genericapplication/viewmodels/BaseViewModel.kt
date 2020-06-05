package com.havelisolutions.genericapplication.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.havelisolutions.genericapplication.repo.RepositoryClass
import javax.inject.Inject

open class BaseViewModel @Inject constructor(private val repo: RepositoryClass):ViewModel() {
    private val fragmentName= MutableLiveData<String>()

    fun getFragmentNameLiveData():LiveData<String>{
        return fragmentName
    }
    fun setFragmentName(name:String){
        fragmentName.value=name
    }

}