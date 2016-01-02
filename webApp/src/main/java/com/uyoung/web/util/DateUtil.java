package com.uyoung.web.util;

import com.uyoung.core.api.constant.CommonConstant;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * User: KennyZhu
 * Date: 15/10/12
 * Desc:
 */
public final class DateUtil {
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private DateUtil() {
    }

    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        if (month > 12) {
            month = 0;
        }
        return month;
    }

    /**
     * 获取指定时间后的日期
     *
     * @param time
     * @return
     */
    public static Date getDate(long time) {
        long current = System.currentTimeMillis();
        return new Date(current + time);
    }

    public static int getWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (week < 0) {
            week = 0;
        }
        return week;
    }

    static class DateBean {
        private String year;
        private String month;
        private String day;
        private String week;

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }
    }

    public static void main(String[] args) {
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
//        formatter.format(date);
//        System.out.println(formatter.format(date));


        System.out.println(getDate(CommonConstant.MAX_ACTIVITY_TIME_INTERVAL));
    }
}
