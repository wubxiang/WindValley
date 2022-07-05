package org.devio.hi.library.util;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author: admin
 * Date: 2022/7/5/005 14:08
 * Description:
 */
public class HiViewUtil {
    /**
     * 获取指定类型的子view
     */
    public static <T> T findTypeView(@Nullable ViewGroup group, Class<T> cls){
        if(group == null){
            return null;
        }

        Deque<View> deque = new ArrayDeque<>();
        deque.add(group);
        while(!deque.isEmpty()){
            View node = deque.removeFirst();
            if(cls.isInstance(node)){
                return cls.cast(node);
            }else if(node instanceof ViewGroup){
                ViewGroup container =(ViewGroup) node;
                for(int i=0, count = container.getChildCount();i<count;i++){
                    deque.add(container.getChildAt(i));
                }
            }
        }
        return null;
    }
}
