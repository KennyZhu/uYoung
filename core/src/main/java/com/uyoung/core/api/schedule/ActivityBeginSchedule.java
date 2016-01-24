package com.uyoung.core.api.schedule;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Desc:
 * <p/>Date: 2015-12-08
 * <br/>Time: 15:40
 * <br/>User: ylzhu
 */
public class ActivityBeginSchedule {


    class ActivityBean implements Delayed {
        private Integer activityId;
        private Integer activityTitle;
        private Date time;

        @Override
        public long getDelay(TimeUnit unit) {
            return time.getTime() - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            ActivityBean sch = (ActivityBean) o;
            return time.after(sch.time) ? 1 : 0;
        }
    }


}
