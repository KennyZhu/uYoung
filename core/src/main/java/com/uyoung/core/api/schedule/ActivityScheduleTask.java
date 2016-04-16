package com.uyoung.core.api.schedule;

import com.uyoung.core.api.enums.ActivityScheduleTypeEnum;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.service.ActivityInfoService;
import com.uyoung.core.base.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * User: KennyZhu
 * Date: 16/4/6
 * Desc:
 */
public class ActivityScheduleTask implements Delayed, Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityScheduleTask.class);
    private ActivityScheduleTypeEnum activityScheduleType;
    private ActivityInfo activityInfo;

    public ActivityScheduleTask(ActivityInfo activityInfo, ActivityScheduleTypeEnum activityScheduleType) {
        this.activityInfo = activityInfo;
        this.activityScheduleType = activityScheduleType;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        if (ActivityScheduleTypeEnum.BEGIN == activityScheduleType) {
            return unit.convert(activityInfo.getBeginTime().getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        } else if (ActivityScheduleTypeEnum.END == activityScheduleType) {
            return unit.convert(activityInfo.getEndTime().getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        ActivityScheduleTask task = (ActivityScheduleTask) o;
        if (ActivityScheduleTypeEnum.BEGIN == activityScheduleType) {
            if (task.getActivityInfo().getBeginTime().after(activityInfo.getBeginTime())) {
                return 1;
            } else if (task.getActivityInfo().getBeginTime().before(activityInfo.getBeginTime())) {
                return -1;
            }
        } else if (ActivityScheduleTypeEnum.END == activityScheduleType) {
            if (task.getActivityInfo().getEndTime().after(activityInfo.getEndTime())) {
                return 1;
            } else if (task.getActivityInfo().getEndTime().before(activityInfo.getEndTime())) {
                return -1;
            }
        }

        return 0;
    }

    @Override
    public void run() {
        try {
            ActivityInfoService activityInfoService = SpringContextHolder.getBean("activityInfoService");
            if (ActivityScheduleTypeEnum.BEGIN == activityScheduleType) {
                activityInfo.setStatus(ActivityStatusEnum.ACTIVE.getStatus());
                activityInfoService.updateById(activityInfo);
                ActivityTaskScheduler scheduler = SpringContextHolder.getBean("activityTaskScheduler");
                scheduler.add(new ActivityScheduleTask(activityInfo, ActivityScheduleTypeEnum.END));
            } else if (ActivityScheduleTypeEnum.END == activityScheduleType) {
                activityInfo.setStatus(ActivityStatusEnum.COMPLETE.getStatus());
                activityInfoService.updateById(activityInfo);
            }

        } catch (Exception e) {
            LOGGER.error("#Run taks error.Cause:", e);
        }
    }

    public ActivityScheduleTypeEnum getActivityScheduleType() {
        return activityScheduleType;
    }

    public void setActivityScheduleType(ActivityScheduleTypeEnum activityScheduleType) {
        this.activityScheduleType = activityScheduleType;
    }

    public ActivityInfo getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(ActivityInfo activityInfo) {
        this.activityInfo = activityInfo;
    }

    @Override
    public String toString() {
        return "ActivityScheduleTask{" +
                "activityScheduleType=" + activityScheduleType +
                ", activityInfo=" + activityInfo.toString() +
                '}';
    }
}
