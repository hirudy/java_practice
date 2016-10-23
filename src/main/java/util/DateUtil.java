package util;

import java.text.SimpleDateFormat;

/**
 * @author: rudy
 * @date: 2016/10/22
 * 日期字符集
 */
public class DateUtil {

    public static int getSecondTimestamp(){
        return (int)(System.currentTimeMillis()/1000);
    }

    public static String timestampToDateString(int timestamp){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format((long)timestamp*1000);
    }

    public static String getNowDateString(){
        return timestampToDateString(getSecondTimestamp());
    }


    public static void main(String[] args){
        int timestamp = getSecondTimestamp();
        System.out.println("timestamp: " + timestamp);
        System.out.println("date format: " + timestampToDateString(timestamp));
        System.out.println("now time string: " + getNowDateString());
    }
}
