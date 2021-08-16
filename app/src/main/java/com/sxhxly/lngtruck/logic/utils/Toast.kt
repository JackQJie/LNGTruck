package com.sxhxly.lngtruck.logic.utils

import android.widget.Toast
import com.sxhxly.lngtruck.App

class Toast {

    fun String.showToast(duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(App.context,this,duration).show()
    }

    fun Int.showToast(duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(App.context,this,duration).show()
    }

}