package com.havelisolutions.genericapplication.utils

import android.app.Service
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class ConnectionDetector(private val context: Context) {
//    val context: Context =context

    fun isconnected() :Boolean
    {

        val connectivity: ConnectivityManager =context.getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo?= connectivity.activeNetworkInfo
        if(networkInfo!=null)
        {

            if(networkInfo.state== NetworkInfo.State.CONNECTED)
            {
                return true
            }

        }
        return false



        //return true
    }
}