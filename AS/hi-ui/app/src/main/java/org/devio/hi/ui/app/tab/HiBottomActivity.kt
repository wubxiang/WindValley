package org.devio.hi.ui.app.tab

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.devio.hi.library.util.HiDisplayUtil
import org.devio.hi.ui.app.R
import org.devio.hi.ui.tab.bottom.HiTabBottomInfo
import org.devio.hi.ui.tab.bottom.HiTabBottomLayout

class HiBottomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_tab_bottom_demo)

        initTabBottom()
    }

    private fun initTabBottom(){
        val hiTabBottomLayout:HiTabBottomLayout = findViewById(R.id.hitablayout)
        hiTabBottomLayout.setTabAlpha(0.85f)
        val bottomInfoList:MutableList<HiTabBottomInfo<*>> = ArrayList()

        val homeInfo = HiTabBottomInfo(
            "首页",
            "fonts/iconfont.ttf",
            getString(R.string.if_home),
            null,
            "#ff656667",
            "#ffd44949"
        )

        val infoFavorite = HiTabBottomInfo(
            "收藏",
            "fonts/iconfont.ttf",
            getString(R.string.if_favorite),
            null,
            "#ff656667",
            "#ffd44949"
        )

//        val infoCategory = HiTabBottomInfo(
//            "分类",
//            "fonts/iconfont.ttf",
//            getString(R.string.if_category),
//            null,
//            "#ff656667",
//            "#ffd44949"
//        )

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.fire, null)
        val infoCategory = HiTabBottomInfo<String>(
            "分类",
            bitmap,
            bitmap
        )

        val infoRecommend = HiTabBottomInfo(
            "推荐",
            "fonts/iconfont.ttf",
            getString(R.string.if_recommend),
            null,
            "#ff656667",
            "#ffd44949"
        )

        val infoProfile = HiTabBottomInfo(
            "我的",
            "fonts/iconfont.ttf",
            getString(R.string.if_profile),
            null,
            "#ff656667",
            "#ffd44949"
        )

        bottomInfoList.add(homeInfo)
        bottomInfoList.add(infoFavorite)
        bottomInfoList.add(infoCategory)
        bottomInfoList.add(infoRecommend)
        bottomInfoList.add(infoProfile)
        hiTabBottomLayout.inflateInfo(bottomInfoList)
        hiTabBottomLayout.addTabSelectedChangeListener { _, _, nextInfo ->
            Toast.makeText(this, nextInfo.name,Toast.LENGTH_SHORT).show()
        }
        hiTabBottomLayout.defaultSelected(homeInfo)

        // 改变某个tab的高度
        val tabBottom = hiTabBottomLayout.findTab(bottomInfoList[2])
        tabBottom?.apply { resetHeight(HiDisplayUtil.dp2px(66f)) }
    }
}