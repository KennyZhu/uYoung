package com.uyoung.core.api.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

/**
 * Desc:任务调度器
 * <p/>Date: 2015-12-24
 * <br/>Time: 12:12
 * <br/>User: ylzhu
 */
class TaskScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskScheduler.class);
    private BlockingQueue<Task> blockingQueue;

    TaskScheduler(BlockingQueue<Task> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    /**
     * 增加任务
     *
     * @param task
     */
    public void addTask(Task task) {
        try {
            blockingQueue.put(task);
        } catch (Exception e) {
            LOGGER.error("#Add task error.Cause:", e);
        }
    }
}
