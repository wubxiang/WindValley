package com.wbx.windvalley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.devio.`as`.proj.common.ui.component.HiBaseActivity
import org.devio.hi.library.log.*

class MainActivity : HiBaseActivity() {
    var viewPrinter:HiViewPrinter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPrinter= HiViewPrinter(this)

        findViewById<View>(R.id.btn_log).setOnClickListener {
            printLog()
        }

        viewPrinter!!.viewProvider.showFloatingView()

        HiLogManager.getInstance().addPrinter(viewPrinter)
    }

    private fun printLog() {
        // 自定义log配置
        HiLog.log(object : HiLogConfig() {
            override fun includeThread(): Boolean {
                return true
            }

            override fun statckTraceDepth(): Int {
                return 0
            }
        }, HiLogType.E, "------", "5566")
        HiLog.a("9900")
    }
}