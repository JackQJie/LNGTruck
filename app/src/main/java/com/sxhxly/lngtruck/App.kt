package com.sxhxly.lngtruck

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import cn.bmob.v3.Bmob

class App :Application() {

    companion object{
        const val TOKEN = "Z01Ze0CAs5EMILuo"
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        //初始化Bmob
        Bmob.initialize(this, "8404c0b09ce3851ad39f5b24a5bb57bc");

    }


}