package org.devio.hi.ui.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.devio.hi.ui.app.refresh.HiRefreshActivity
import org.devio.hi.ui.app.tab.HiBottomActivity
import org.devio.hi.ui.app.tab.HiTopActivity
import org.devio.hi.ui.tab.bottom.HiTabBottom
import org.devio.hi.ui.tab.bottom.HiTabBottomInfo

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tv_tab_bottom->{
                startActivity(Intent(this, HiBottomActivity::class.java))
            }
            R.id.tv_tab_top->{
                startActivity(Intent(this, HiTopActivity::class.java))
            }
            R.id.tv_refresh->{
                startActivity(Intent(this, HiRefreshActivity::class.java))
            }
        }
    }

}