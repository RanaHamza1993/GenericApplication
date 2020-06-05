package com.havelisolutions.genericapplication.extensions

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import es.dmoral.toasty.Toasty

fun Context.showSuccessMessage(message: String?, duration: Int = Toast.LENGTH_SHORT) {
    try {
        Toasty.success(this, message.toString(), duration, true).show()

    } catch (e: WindowManager.BadTokenException) {
    }
}

fun Context.showInfoMessage(message: String?, duration: Int = Toast.LENGTH_SHORT) {
    try {
        Toasty.info(this, message.toString(), duration, true).show()
    } catch (e: Exception) {
    }
}


fun Context.showErrorMessage(message: String?, duration: Int = Toast.LENGTH_SHORT) {
    try {
        Toasty.error(this, message.toString(), duration, true).show()
    } catch (e: WindowManager.BadTokenException) {

    }
}
fun Context.copyToClipboard(text: CharSequence){
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Copy text",text)
    clipboard.setPrimaryClip(clip)
}

/**
 * Param:  cliplabel, textview, context
 */
fun Context.attachClickToCopyText(textView: TextView?, clipLabel: String) {

            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText(clipLabel, textView!!.text)
            clipboard.setPrimaryClip(clip)
            Snackbar.make(textView,
                "Copied $clipLabel", Snackbar.LENGTH_LONG).show()



}
//View Extensions
fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.snackBar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).also { snackbar ->
        snackbar.setAction("Ok") {
            snackbar.dismiss()
        }.show()
    }

}
fun TextView.clear(){
    this.text = ""
}

fun View.makeRound(){
    this.clipToOutline=true
}
//EditTextEextensions


fun EditText.getString():String{
    return this.text.toString().trim()
}
