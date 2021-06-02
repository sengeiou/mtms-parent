package com.dili.mtms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间日期工具类
 */
public class DateTimeUtil {

    /**
     * 开始时间转换
     * @param time
     * @return
     */
    public static Date startTimeConversion(String time) throws ParseException {
        String startTime = time+" 00:00:00";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sf.parse(startTime);
        return date;
    }

    /**
     * 结束时间转换
     * @param time
     * @return
     */
    public static Date endTimeConversion(String time) throws ParseException {
        String endTime = time+"23:59:59";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sf.parse(endTime);
        return date;
    }

}
