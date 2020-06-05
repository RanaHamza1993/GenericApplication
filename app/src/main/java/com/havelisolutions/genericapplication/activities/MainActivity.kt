package com.havelisolutions.genericapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamza.covid19assessmentandprevention.interfaces.Communicator
import com.havelisolutions.genericapplication.R

class MainActivity : AppCompatActivity(),Communicator.IConnectionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun isConnected(isConnected: Boolean) {

    }
}
