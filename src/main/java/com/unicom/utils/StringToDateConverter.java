package com.unicom.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hanbing
 * @create 2019-09-06 16:15
 */
public class StringToDateConverter implements Converter<String , Date> {
    @Override
    public Date convert(String s) {
        if (s == null){
            throw new RuntimeException("数据为空");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date parse = df.parse(s);
            return parse;
        } catch (ParseException e) {
            throw new RuntimeException("数据格式不正确");
        }
    }
}
