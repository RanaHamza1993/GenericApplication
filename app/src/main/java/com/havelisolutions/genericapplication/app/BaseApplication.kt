package com.havelisolutions.genericapplication

import android.util.Log
import cat.ereza.customactivityoncrash.CustomActivityOnCrash
import com.havelisolutions.genericapplication.di.components.AppComponent
import com.havelisolutions.genericapplication.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication: DaggerApplication() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
//        if(LeakCanary.isInAnalyzerProcess(this)){
//            return
//        }

//        MobileAds.initialize(
//            this,
//            getString(R.string.app_admob_app_id)
//        )
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent= DaggerAppComponent.builder().application(this).build()
        return appComponent
    }
    companion object: CustomActivityOnCrash.EventListener{
        private val TAG: String="MyApp"
        override fun onLaunchErrorActivity() {
            Log.i(TAG, "onLaunchErrorActivity()")
            //ActivityNavigator<LoginActivity>(appContext!!,LoginActivity::class.java)
        }

        override fun onRestartAppFromErrorActivity() {
            Log.i(TAG, "onRestartAppFromErrorActivity()")
        }

        override fun onCloseAppFromErrorActivity() {
            Log.i(TAG, "onCloseAppFromErrorActivity()")
        }
    }

}