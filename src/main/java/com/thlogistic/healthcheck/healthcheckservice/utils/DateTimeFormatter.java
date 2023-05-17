package com.thlogistic.healthcheck.healthcheckservice.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class DateTimeFormatter {
    public static boolean checkDateTimeFormat(String datetime) {
        SimpleDateFormat formatter = new SimpleDateFormat(Const.dateTimeFormat);
        formatter.setLenient(false);
        try {
            formatter.parse(datetime);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static String getCurrentTimeFormatted() {
        LocalDateTime now = LocalDateTime.now();
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern(Const.dateTimeFormat);
        return now.format(formatter);
    }
}
