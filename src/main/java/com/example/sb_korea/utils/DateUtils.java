package com.example.sb_korea.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author hao.wong
 * @date 2021/12/24
 */
public class DateUtils {

    public static final DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime parse(String time){
        return LocalDateTime.parse(time,formatter);
    }
}
