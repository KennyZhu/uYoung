package com.uyoung.core.api.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Desc:任务执行器
 * <p/>Date: 2015-12-24
 * <br/>Time: 12:05
 * <br/>User: ylzhu
 */
class TaskExecutor {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskExecutor.class);
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(10);
    private BlockingQueue<Task> blockingQueue;

    TaskExecutor(BlockingQueue<Task> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    /**
     * 任务执行
     */
    public void exec() {
        LOGGER.info("#Begin to run task Executor.");
        while (true) {
            try {
                Task task = blockingQueue.take();
                EXECUTOR.submit(task);
            } catch (Exception e) {
                LOGGER.error("#Take task error.Cause:", e);
            }
        }
    }
}
