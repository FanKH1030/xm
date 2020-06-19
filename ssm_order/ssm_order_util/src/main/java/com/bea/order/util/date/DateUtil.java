package com.bea.order.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fandi on 2020/5/16 0016.
 */
public class DateUtil {

    /**
     * 日期转字符串
     * @param date
     * @param patt
     * @return
     */
    public static String date2String(Date date, String patt){
        DateFormat df = new SimpleDateFormat(patt);
        return df.format(date);
    }

    /**
     * 字符串转日期
     * @param dateStr
     * @param patt
     * @return
     * @throws ParseException
     */
    public static Date string2Date(String dateStr, String patt) throws ParseException {
        DateFormat df = new SimpleDateFormat(patt);
        Date parse = df.parse(dateStr);
        return parse;
    }
}
