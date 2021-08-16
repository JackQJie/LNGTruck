package com.sxhxly.lngtruck

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class App :Application() {

    companion object{
        const val TOKEN = "Z01Ze0CAs5EMILuo"
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}