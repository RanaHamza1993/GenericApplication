package com.havelisolutions.genericapplication.utils

object isInternetAvaliable {
    private var isConnected:Boolean=true
    operator fun invoke():Boolean{
        return isConnected
    }
    public fun setIsConnected(isAvailable:Boolean){
        isConnected=isAvailable
    }
}