package com.dili.mtms.utils;

import org.apache.commons.lang.StringUtils;

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
        int index = StringUtils.ordinalIndexOf(time,"-",3);
        String start = time.substring(0,index).trim();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sf.parse(start);
        return date;
    }

    /**
     * 结束时间转换
     * @param time
     * @return
     */
    public static Date endTimeConversion(String time) throws ParseException {
        int index = StringUtils.ordinalIndexOf(time,"-",3)+1;
        String end = time.substring(index).trim();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sf.parse(end);
        return date;
    }

}
