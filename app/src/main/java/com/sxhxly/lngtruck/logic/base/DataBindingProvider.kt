package com.sxhxly.lngtruck.logic.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable

interface DataBindingProvider {

    @LayoutRes
    fun getLayoutRes(): Int

    fun initView(@Nullable savedInstanceState: Bundle?)

}