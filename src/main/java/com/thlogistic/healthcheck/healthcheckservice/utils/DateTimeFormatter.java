package com.thlogistic.healthcheck.healthcheckservice.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
}
