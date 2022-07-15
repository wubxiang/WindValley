package org.devio.hi.ui.refresh;

public interface HiRefresh {
    /**
     * 刷新时是否禁止滚动
     * @param disableRefreshScroll 是否禁止滚动
     */
    void setDisableRefreshScroll(boolean disableRefreshScroll);

    /**
     * 刷新完成
     */
    void refreshFinished();

    /**
     * 设置下拉刷新的监听器
     * @param hiRefreshListener 刷新的监听器
     */
    void setRefreshListener(HiRefreshListener hiRefreshListener);

    void setRefreshOverView(HiOverView hiOverView);

    interface HiRefreshListener{
        void onRefresh();
        boolean enableRefresh();
    }
}
