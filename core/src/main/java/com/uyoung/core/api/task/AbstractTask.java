package com.uyoung.core.api.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desc:
 * <p/>Date: 2016-01-07
 * <br/>Time: 10:58
 * <br/>User: ylzhu
 */
public abstract class AbstractTask implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTask.class);

    protected abstract boolean exec();

    @Override
    public Boolean call() throws Exception {
        try {
            LOGGER.info("#Begin to run:" + this.getClass().getName());
            boolean result = exec();
            if (!result) {
                LOGGER.error("#Execute task:" + this.getClass().getName() + " return false.");
            }

        } catch (Exception e) {
            LOGGER.error("#Execute task:" + this.getClass().getName() + " error.Cause:", e);
        }
        return false;
    }
}
