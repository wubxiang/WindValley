package org.devio.hi.ui.tab.top;

import android.graphics.Bitmap;

import androidx.fragment.app.Fragment;

/**
 * Author: admin
 * Date: 2022/7/4/004 19:24
 * Description:
 */
public class HiTabTopInfo<Color> {
    public enum TabType {
        BITMAP, TEXT
    }

    public Class<? extends Fragment> fragment;
    public String name;
    public Bitmap defaultBitmap;
    public Bitmap selectedBitmap;
    public Color defaultColor;
    public Color tintColor;
    public TabType tabType;

    public HiTabTopInfo(String name, Bitmap defaultBitmap, Bitmap selectedBitmap){
        this.name = name;
        this.defaultBitmap = defaultBitmap;
        this.selectedBitmap = selectedBitmap;
        this.tabType = TabType.BITMAP;
    }

    public HiTabTopInfo(String name, Color defaultColor, Color tintColor){
        this.name = name;
        this.defaultColor = defaultColor;
        this.tintColor = tintColor;
        this.tabType = TabType.TEXT;
    }
}
