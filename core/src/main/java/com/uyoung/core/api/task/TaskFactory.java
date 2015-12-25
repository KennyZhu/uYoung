package com.uyoung.core.api.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Desc:
 * <p/>Date: 2015-12-24
 * <br/>Time: 12:13
 * <br/>User: ylzhu
 */
@Service
public class TaskFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskFactory.class);

    private BlockingQueue<Task> blockingQueue = new ArrayBlockingQueue<Task>(100);
    private TaskScheduler taskScheduler;
    private TaskExecutor taskExecutor;

    private boolean isStart = false;

    private static final Object LOCK = new Object();

    /**
     * 初始化方法
     */
    private void init() {
        LOGGER.info("#Begin to init TaskFactory.");
        taskScheduler = new TaskScheduler(blockingQueue);
        taskExecutor = new TaskExecutor(blockingQueue);
        start();
    }

    public void start() {
        if (isStart) {
            return;
        }
        synchronized (LOCK) {
            if (isStart) {
                return;
            }
            taskExecutor.exec();
        }
    }

    /**
     * 放入任务
     *
     * @param task
     */
    public void addTask(Task task) {
        if (task != null) {
            taskScheduler.addTask(task);
        }
    }
}
