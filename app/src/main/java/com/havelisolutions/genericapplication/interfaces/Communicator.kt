package com.hamza.covid19assessmentandprevention.interfaces

interface Communicator {
    interface IConnectionListener{
        fun isConnected(isConnected:Boolean)
    }
}