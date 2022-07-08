package com.wbx.windvalley.logic;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentManager;

import com.wbx.windvalley.R;
import com.wbx.windvalley.fragment.CategoryFragment;
import com.wbx.windvalley.fragment.FavoriteFragment;
import com.wbx.windvalley.fragment.HomePageFragment;
import com.wbx.windvalley.fragment.ProfileFragment;
import com.wbx.windvalley.fragment.RecommendFragment;

import org.devio.as.proj.common.tab.HiFragmentTabView;
import org.devio.as.proj.common.tab.HiTabViewAdapter;
import org.devio.hi.ui.tab.bottom.HiTabBottomInfo;
import org.devio.hi.ui.tab.bottom.HiTabBottomLayout;
import org.devio.hi.ui.tab.common.IHiTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: admin
 * Date: 2022/7/6/006 13:28
 * Description:
 */
public class MainActivityLogic {
    private HiFragmentTabView fragmentTabView;
    private HiTabBottomLayout hiTabBottomLayout;
    private List<HiTabBottomInfo<?>> infoList;
    private ActivityProvider activityProvider;
    private int currentItemIndex;
    private final static String SAVED_CURRENT_ID = "SAVED_CURRENT_ID";

    public MainActivityLogic(ActivityProvider activityProvider, Bundle savedInstanceState) {
        this.activityProvider = activityProvider;
        // fix 开发者模式中不保留活动开启导致的Fragment重叠问题（不保留活动开启后每次切换到后台都会小伙activity，
        // 当后台唤醒时又重新创建activity，但fragment并没有重新拆功能键还是之前的，但是所有的fragment都显示了，所以会重叠）
        if (savedInstanceState != null) {
            currentItemIndex = savedInstanceState.getInt(SAVED_CURRENT_ID);
        }
        initTabBottom();
    }

    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(SAVED_CURRENT_ID, currentItemIndex);
    }

    public HiFragmentTabView getFragmentTabView() {
        return fragmentTabView;
    }

    public HiTabBottomLayout getHiTabBottomLayout() {
        return hiTabBottomLayout;
    }

    public List<HiTabBottomInfo<?>> getInfoList() {
        return infoList;
    }

    private void initTabBottom() {
        hiTabBottomLayout = activityProvider.findViewById(R.id.tab_bottom_layout);
        hiTabBottomLayout.setTabAlpha(0.85f);
        int defautColor = activityProvider.getResources().getColor(R.color.tabBottomDefaultColor);
        int tintColor = activityProvider.getResources().getColor(R.color.tabBottomTintColor);

        HiTabBottomLayout hiTabBottomLayout = activityProvider.findViewById(R.id.tab_bottom_layout);
        hiTabBottomLayout.setTabAlpha(0.85f);

        HiTabBottomInfo homeInfo = new HiTabBottomInfo(
                "首页",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_home),
                null,
                defautColor,
                tintColor
        );
        homeInfo.fragment = HomePageFragment.class;

        HiTabBottomInfo infoFavorite = new HiTabBottomInfo(
                "收藏",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_favorite),
                null,
                defautColor,
                tintColor
        );
        infoFavorite.fragment = FavoriteFragment.class;

        HiTabBottomInfo infoCategory = new HiTabBottomInfo(
                "分类",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_category),
                null,
                defautColor,
                tintColor
        );
        infoCategory.fragment = CategoryFragment.class;

//        Bitmap bitmap = BitmapFactory.decodeResource(activityProvider.getResources(), R.drawable.fire, null);
//        HiTabBottomInfo<String> infoCategory = new HiTabBottomInfo<String>(
//                "分类",
//                bitmap,
//                bitmap
//        );

        HiTabBottomInfo infoRecommend = new HiTabBottomInfo(
                "推荐",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_recommend),
                null,
                defautColor,
                tintColor
        );
        infoRecommend.fragment = RecommendFragment.class;

        HiTabBottomInfo infoProfile = new HiTabBottomInfo(
                "我的",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_profile),
                null,
                defautColor,
                tintColor
        );
        infoProfile.fragment = ProfileFragment.class;

        infoList = new ArrayList();
        infoList.add(homeInfo);
        infoList.add(infoFavorite);
        infoList.add(infoCategory);
        infoList.add(infoRecommend);
        infoList.add(infoProfile);
        hiTabBottomLayout.inflateInfo(infoList);

        initFragmentTabView();

        hiTabBottomLayout.addTabSelectedChangeListener(new IHiTabLayout.OnTabSelectedListener<HiTabBottomInfo<?>>() {
            @Override
            public void OnTabSelectedChange(int index, @Nullable HiTabBottomInfo<?> preInfo, @NonNull HiTabBottomInfo<?> nextInfo) {
                fragmentTabView.setCurrentItem(index);
                MainActivityLogic.this.currentItemIndex = index;
            }
        });
        hiTabBottomLayout.defaultSelected(infoList.get(currentItemIndex));
    }

    private void initFragmentTabView() {
        HiTabViewAdapter tabViewAdapter = new HiTabViewAdapter(activityProvider.getSupportFragmentManager(), infoList);
        fragmentTabView = activityProvider.findViewById(R.id.fragment_tab_view);
        fragmentTabView.setAdapter(tabViewAdapter);
    }

    public interface ActivityProvider {
        <T extends View> T findViewById(@IdRes int id);

        Resources getResources();

        FragmentManager getSupportFragmentManager();

        String getString(@StringRes int resId);
    }
}
