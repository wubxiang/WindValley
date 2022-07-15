package org.devio.hi.ui.app.refresh

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.devio.hi.ui.app.R
import org.devio.hi.ui.refresh.HiRefresh
import org.devio.hi.ui.refresh.HiRefreshLayout
import org.devio.hi.ui.refresh.HiTextOverView
import android.os.Handler
import android.os.Looper

class HiRefreshActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_refresh)

        val refreshLayout = findViewById<HiRefreshLayout>(R.id.refresh_layout)
        val xOverView = HiTextOverView(this)
        refreshLayout.setRefreshOverView(xOverView)
        refreshLayout.setRefreshListener(object :HiRefresh.HiRefreshListener{
            override fun onRefresh() {
                Handler(Looper.getMainLooper()).postDelayed({refreshLayout.refreshFinished()}, 1000)
            }

            override fun enableRefresh(): Boolean {
                return true
            }
        })
    }
}