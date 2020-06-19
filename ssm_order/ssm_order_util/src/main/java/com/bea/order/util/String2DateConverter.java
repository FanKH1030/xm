package com.bea.order.util;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fandi on 2020/4/5 0005.
 */
public class String2DateConverter implements Converter<String,Date> {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");

    @Override
    public Date convert(String s){
        Date date = null;

        if(s == null){
            throw new RuntimeException("时间转换错误------------");
        }

        try {
            date = sdf.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("时间转换错误------------");
        }
        return date;
    }
}
