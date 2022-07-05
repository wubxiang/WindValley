package org.devio.hi.library.log;

/**
 * Author: admin
 * Date: 2022/6/8/008 13:24
 * Description:
 */
public class HiStackTraceFormatter implements HiLogFormatter<StackTraceElement[]> {
    @Override
    public String format(StackTraceElement[] stackTrace) {
        StringBuilder sb = new StringBuilder(128);
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        } else if (stackTrace.length == 1) {
            return "\t— " + stackTrace[0].toString();
        } else {
            for (int i = 0, len = stackTrace.length; i < len; i++) {
                if(i==0){
                    sb.append("stackTrace: \n");
                }
                if(i!=len-1){
                    sb.append("\t|- ");
                    sb.append(stackTrace[i].toString());
                    sb.append("\n");
                }else{
                    sb.append("\tL ");
                    sb.append(stackTrace[i].toString());
                }
            }
            return sb.toString();
        }
    }
}
