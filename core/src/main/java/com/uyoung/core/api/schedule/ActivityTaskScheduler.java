package com.uyoung.core.api.schedule;

import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.service.ActivityInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.DelayQueue;

/**
 * User: KennyZhu
 * Date: 16/4/16
 * Desc:
 */
@Service
public class ActivityTaskScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityTaskScheduler.class);
    private DelayQueue<ActivityScheduleTask> queue;
    @Autowired
    private ActivityTaskExecutor executor;

    @Autowired
    private ActivityInfoService activityInfoService;

    @PostConstruct
    public void init() {
        queue = new DelayQueue<>();
        initAllTask();
        new Thread(new Runnable() {
            @Override
            public void run() {
                runTask();
            }
        });


    }

    /**
     * 增加任务
     *
     * @param task
     */
    public void add(ActivityScheduleTask task) {
        if (task == null || task.getActivityInfo() == null || task.getActivityScheduleType() == null) {
            return;
        }

        LOGGER.info("#Add task:" + task + " to schedule.");
        try {
            queue.offer(task);
        } catch (Exception e) {
            LOGGER.error("#Add task to queue error.Task is " + task + "  Cause:", e);
        }
    }

    public void runTask() {
        while (true) {
            try {
                ActivityScheduleTask task = queue.take();
                executor.run(task);
            } catch (Exception e) {
                LOGGER.error("#Run activity task schedule error.Cause:", e);
            }
        }
    }

    public void initAllTask() {
        try {
            List<ActivityStatusEnum> statusList = Arrays.asList(ActivityStatusEnum.SIGNUP, ActivityStatusEnum.ACTIVE);
            List<ActivityScheduleTask> taskList = activityInfoService.wrapActivityScheduleTask(activityInfoService.getAllActivityInfoByStatus(statusList));

            if (CollectionUtils.isEmpty(taskList)) {
                LOGGER.warn("#No activity schedule task need add to queue.");
                return;
            }
            taskList.forEach(task -> add(task));
        } catch (Exception e) {
            LOGGER.error("#Init all activity schedule task error.Cause:", e);
        }

    }
}
