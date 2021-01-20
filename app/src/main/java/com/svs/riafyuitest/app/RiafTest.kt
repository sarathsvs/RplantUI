package com.svs.riafyuitest.app

import android.app.Application
import com.google.gson.Gson
import com.svs.riafyuitest.utils.AppUtils

class RiafTest : Application(){

    companion object{
        var gson = Gson()
        lateinit var appUtils :AppUtils
    }

    override fun onCreate() {
        super.onCreate()

        appUtils = AppUtils(applicationContext)
    }

}