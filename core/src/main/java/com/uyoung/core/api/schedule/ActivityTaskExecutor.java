package com.uyoung.core.api.schedule;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: KennyZhu
 * Date: 16/4/16
 * Desc:
 */
@Service
public class ActivityTaskExecutor {
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    public void run(ActivityScheduleTask task){
        executorService.submit(task);
    }
}
