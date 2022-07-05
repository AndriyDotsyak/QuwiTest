package com.quwi.apptest.utils;

import android.icu.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

import timber.log.Timber;

public class DataTimeUtil {

    private static final String PATTERN_DATA_TIME = "yyyy-MM-dd HH:mm";
    private static final String PATTERN_TIME = "HH:mm";

    public static String formatDateForChat(String dataString) {
        if (dataString.isEmpty()) {
            return dataString;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_TIME, Locale.ENGLISH);
        Date date = parseDate(dataString);
        return dateFormat.format(date);
    }

    private static Date parseDate(String dataString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATA_TIME, Locale.ENGLISH);
        Date date = new Date();
        try {
            date = dateFormat.parse(dataString);
        } catch (Exception error) {
            Timber.e(error);
        }
        return date;
    }

}
