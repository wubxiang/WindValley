package org.devio.hi.ui.tab.common;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public interface IHiTabLayout<Tab extends ViewGroup, D> {
    Tab findTab(@NonNull D data);

    void addTabSelectedChangeListener(OnTabSelectedListener<D> listener);

    void defaultSelected(@NonNull D defalutInfo);

    void inflateInfo(@NonNull List<D> infoList);

    interface OnTabSelectedListener<D> {
        void OnTabSelectedChange(int index, @Nullable D preInfo, @NonNull D nextInfo);
    }
}
