package com.backend.WebNewsBackend.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public static String getStrDate(Date date)
    {
        SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Date today = new Date();
        return dmyFormat.format(date);
    }

    public static Date resetTime(Date date) throws ParseException {
        SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Date today = new Date();
        return dmyFormat.parse(getStrDate(date));
    }

    public static Date now()
    {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }
    public static String convertDateToStringJP(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return (cal.get(Calendar.MONTH)+1) + "月" + cal.get(Calendar.DATE) + "日" ;
    }
}
