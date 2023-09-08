package com.zoho.desk.asap.api.samplaes

import android.app.Application
import com.zoho.desk.asap.api.ZohoDeskPortalSDK

class MyApplication: Application() {

    companion object {
        lateinit  var deskSDK: ZohoDeskPortalSDK
    }

    override fun onCreate() {
        super.onCreate()
        deskSDK = ZohoDeskPortalSDK.getInstance(this)
    }
}