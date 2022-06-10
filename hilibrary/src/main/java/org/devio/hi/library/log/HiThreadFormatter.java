package org.devio.hi.library.log;

/**
 * Author: admin
 * Date: 2022/6/8/008 13:23
 * Description:
 */
public class HiThreadFormatter implements HiLogFormatter<Thread>{
    @Override
    public String format(Thread data) {
        return "Thread:"+data.getName();
    }
}
