package com.hamza.covid19assessmentandprevention.broadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import com.hamza.covid19assessmentandprevention.interfaces.Communicator

class MyCustomBroadCastReceiver : BroadcastReceiver() {
    private var listener: Communicator.IConnectionListener?=null

    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action
        if (action != null) {
            //   if (action.equals(broadAction)) {
            if (action == ConnectivityManager.CONNECTIVITY_ACTION) {

                // Toast.makeText(context,"Receiver Called",Toast.LENGTH_SHORT).show();
                //  val txt = intent.getStringExtra("txt")
                listener = context as Communicator.IConnectionListener

                val isConnected = isNetworkAvailable(context)
                if (isConnected) {
                    listener?.isConnected(true)
                } else {
                    listener?.isConnected(false)
                }
//                val notificationIntent =
//                    Intent(context, MyCustomBroadcastReceiverActivity::class.java)
//                val pendingIntent = PendingIntent.getActivity(
//                    context,
//                    0, notificationIntent, 0
//                )
//
//                //Build a notification
//                val notification = NotificationCompat.Builder(context, CHANNEL_ID)
//                    .setContentTitle("HandFree Plugged")
//                    .setSmallIcon(R.drawable.ic_launcher_background)
//                    .setContentIntent(pendingIntent)
//                    .build()
//                val notificationManager = NotificationManagerCompat.from(context)
//                notificationManager.notify(1, notification)
                // TO-DO: Code to handle BOOT COMPLETED EVENT
                // TO-DO: I can start an service.. display a notification… start an activity
            }

        }

    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }



}