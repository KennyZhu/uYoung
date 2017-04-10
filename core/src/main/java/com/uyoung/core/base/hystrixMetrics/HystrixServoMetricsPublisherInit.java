package com.uyoung.core.base.hystrixMetrics;

import com.netflix.hystrix.contrib.servopublisher.HystrixServoMetricsPublisher;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.servo.publish.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * desc
 * author yanlongzhu
 * date:2017/4/7.
 */
@Service
public class HystrixServoMetricsPublisherInit {

    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixServoMetricsPublisherInit.class);

    @PostConstruct
    public void init() {
        LOGGER.info("#Begin to init hystrixServoMetricsPublisher");

        HystrixServoMetricsPublisher hystrixServoMetricsPublisher = HystrixServoMetricsPublisher.getInstance();
        HystrixPlugins.getInstance().registerMetricsPublisher(hystrixServoMetricsPublisher);
        final List<MetricObserver> observers = new ArrayList<MetricObserver>();
        if (Config.isFileObserverEnabled()) {
            observers.add(createFileObserver());
        }
//
        PollScheduler.getInstance().start();
        PollRunnable task = new PollRunnable(new MonitorRegistryMetricPoller(), BasicMetricFilter.MATCH_ALL, true, observers);
        PollScheduler.getInstance().addPoller(task, 5, TimeUnit.SECONDS);
        LOGGER.info("#End to init hystrixServoMetricsPublisher");
    }

    private MetricObserver createFileObserver() {
        final File dir = Config.getFileObserverDirectory();
        final long heartbeat = Config.getPollInterval();
        return new CounterToRateMetricTransform(new FileMetricObserver("servo-uyoung", dir), heartbeat, TimeUnit.SECONDS);
    }
}
