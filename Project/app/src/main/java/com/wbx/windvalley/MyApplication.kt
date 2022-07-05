package com.wbx.windvalley

import android.app.Application
import com.google.gson.Gson
import org.devio.hi.library.log.HiConslePrinter
import org.devio.hi.library.log.HiLogConfig
import org.devio.hi.library.log.HiLogManager

/**
 * Author: admin
 * Date: 2022/6/8/008 10:34
 * Description:
 */
class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()

        HiLogManager.init(object :HiLogConfig(){
            override fun injectJsonParser(): JsonParser {
                return JsonParser { src -> Gson().toJson(src) }
            }
        }, HiConslePrinter())
    }
}