package com.example.open.testsastrawi.util;
import android.icu.text.DateFormat;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Rahardyan on 12/16/2017.
 */

public class DateUtils {
    static class Format {
        public static final String INDONESI = "dd MMM yyyy";
    }
    public static String getFormattedDate(long millis, String format) {
        long yourmilliseconds = System.currentTimeMillis();

        Date resultdate = new Date(yourmilliseconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
        return simpleDateFormat.format(resultdate);
    }
}
