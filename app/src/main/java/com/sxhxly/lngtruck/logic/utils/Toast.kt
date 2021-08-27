package com.sxhxly.lngtruck.logic.utils

import android.widget.Toast
import com.sxhxly.lngtruck.App

public class Toast {

    public fun String.showToast(duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(App.context, this, duration).show()
    }

    fun Int.showToast(duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(App.context, this, duration).show()
    }

}