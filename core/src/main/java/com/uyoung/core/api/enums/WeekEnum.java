package com.uyoung.core.api.enums;

import java.util.stream.Stream;

/**
 * Desc:
 * <p/>Date: 2015-10-13
 * <br/>Time: 15:20
 * <br/>User: ylzhu
 */
public enum WeekEnum {

    SUNDAY(0, "周日"), MONDAY(1, "周一"), TUESDAY(2, "周二"), WEDNESDAY(3, "周三"),
    THURSDAY(4, "周四"), FRIDAY(5, "周五"), SATURDAY(6, "周六");
    private int week;
    private String weekCnDesc;

    WeekEnum(int week, String weekCnDesc) {
        this.week = week;
        this.weekCnDesc = weekCnDesc;
    }

    public int getWeek() {
        return week;
    }

    public String getWeekCnDesc() {
        return weekCnDesc;
    }

    public static WeekEnum getByWeek(int week) {
        return Stream.of(WeekEnum.values()).filter(weekEnum -> weekEnum.getWeek() == week).findFirst().orElse(null);
    }
}
