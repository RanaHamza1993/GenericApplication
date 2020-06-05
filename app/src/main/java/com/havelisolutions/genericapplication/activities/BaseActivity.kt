package com.havelisolutions.genericapplication.activities

import android.Manifest
import android.content.Context
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.Rect
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.hamza.covid19assessmentandprevention.broadcasts.MyCustomBroadCastReceiver
import com.hamza.covid19assessmentandprevention.interfaces.Communicator
import com.havelisolutions.genericapplication.R
import com.havelisolutions.genericapplication.extensions.showInfoMessage
import com.havelisolutions.genericapplication.utils.CustomSharedPreference
import com.havelisolutions.genericapplication.utils.isInternetAvaliable
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import dagger.android.support.DaggerAppCompatActivity
import retrofit2.Retrofit
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity(), Communicator.IConnectionListener {
 //   private val REQUEST_LOCATION: Int=12
    var isKeyboardShowing=false
    internal var myReceiver: MyCustomBroadCastReceiver? = null

    @Inject
    lateinit var sharesPreference: CustomSharedPreference
    @Inject
    protected lateinit var retrofit:Retrofit
    @Inject
    lateinit var injectedContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

    }

    open fun navigateToFragment(fragment: Fragment, addToBackStack:Boolean=true, frame:Int= R.id.content_frame){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.run{
            replace(frame, fragment)
            if(addToBackStack)
                addToBackStack(null)

            commit()
        }
    }


    open fun navigateToFragment(fragment: Fragment, addToBackStack:Boolean=true, tag:String="", frame:Int= R.id.content_frame){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val findFragment=supportFragmentManager.findFragmentByTag(tag)
       // val framefrag=supportFragmentManager.findFragmentById(R.id.content_frame)
        if(findFragment==null){
            fragmentTransaction.run{
                if(!tag.equals(""))
                    replace(frame, fragment,tag)
                else
                    replace(frame, fragment)
                if(addToBackStack)
                    addToBackStack(null)
//                setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                commit()
            }
        }

//
//
//
//
//
//        fragmentTransaction.run{
//            if(!tag.equals(""))
//                replace(frame, fragment,tag)
//            else
//                replace(frame, fragment)
//            if(addToBackStack)
//                addToBackStack(null)
//
//            commit()
//        }
    }

    open fun navigateToFragment(fragment: Fragment, addToBackStack:Boolean=true, tag:String="", bundle:Bundle, frame:Int=R.id.content_frame){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragment.arguments=bundle
        fragmentTransaction.run{
            if(!tag.equals(""))
                replace(frame, fragment,tag)
            else
                replace(frame, fragment)
            if(addToBackStack)
                addToBackStack(null)

            commit()
        }
    }
    fun navigateToFragment(fragment: Fragment, tag:String){
        val findFragment=supportFragmentManager.findFragmentByTag(tag)
        val framefrag=supportFragmentManager.findFragmentById(R.id.content_frame)
        val strfindFragment=findFragment?.toString()?.substring(0,10)
        val strframefrag=framefrag?.toString()?.substring(0,10)
        if(findFragment==null)
            navigateToFragment(fragment,true,tag)
        else if(framefrag!=null&&strframefrag!!.contains(strfindFragment!!)){
        }else if(findFragment!=null){
            navigateToFragment(fragment,true)
        }
    }
    fun setBaseActivityListeners(){

    }
    fun keyBoardListener(rootView: View?){
        rootView?.viewTreeObserver?.addOnGlobalLayoutListener {
            val r = Rect()
            rootView.getWindowVisibleDisplayFrame(r)
            val screenHeight = rootView.getRootView()!!.getHeight()


            // r.bottom is the position above soft keypad or device button.
            // if keypad is shown, the r.bottom is smaller than that before.
            val keypadHeight = screenHeight - r.bottom;

            //            Log.d("KeyBoard", "keypadHeight = " + keypadHeight)

            isKeyboardShowing = keypadHeight > screenHeight * 0.15
        }
    }
    protected fun askPermissions(dowork:()->Unit){
        if(!checkPermissions()){
            Dexter.withActivity(this)
                .withPermissions(Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(object : MultiplePermissionsListener {
//                    override fun onPermissionGranted(response: PermissionGrantedResponse?) {
//                        //openGallery()
//
//                    }
//
//                    override fun onPermissionRationaleShouldBeShown(
//                        permission: PermissionRequest?,
//                        token: PermissionToken?
//                    ) {
//                    }
//
//                    override fun onPermissionDenied(response: PermissionDeniedResponse?) {
//
//                        injectedContext.showInfoMessage("Please give location permission")
//                    }

                    override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                        if(report!=null)
                        if(report.areAllPermissionsGranted())
                        dowork.invoke()
                    }

                    override fun onPermissionRationaleShouldBeShown(
                        permissions: MutableList<PermissionRequest>?,
                        token: PermissionToken?
                    ) {
                        token?.continuePermissionRequest();
                    }

                })
                .check()
        }
    }
    protected fun checkAllPermissions(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }
    protected fun checkPermissions(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

    private fun setReceiver() {
        myReceiver = MyCustomBroadCastReceiver()
        val intentFilter = IntentFilter()
        // intentFilter.addAction(broadAction);
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(myReceiver, intentFilter)
    }

    override fun onResume() {
        super.onResume()
        setReceiver()
    }
    override fun onPause() {
        super.onPause()
        unregisterReceiver(myReceiver)
    }
    override fun isConnected(isConnected: Boolean) {
        if(!isConnected)
            injectedContext.showInfoMessage("Please check your internet connection")
        isInternetAvaliable.setIsConnected(isConnected)

    }
//    private fun getCountryCode():Boolean{
//        CountryCodes()
//        return true
//    }
}
