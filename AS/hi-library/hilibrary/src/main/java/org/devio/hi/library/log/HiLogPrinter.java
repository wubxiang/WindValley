package org.devio.hi.library.log;

import androidx.annotation.NonNull;

/**
 * Author: admin
 * Date: 2022/6/8/008 13:18
 * Description:
 * 日志打印
 */
public interface HiLogPrinter {
    void print(@NonNull HiLogConfig config, int level, String tag, @NonNull String printString);
}
