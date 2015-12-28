package com.uyoung.core.api.task.impl;

import com.uyoung.core.api.task.Task;
import com.uyoung.core.third.qiniu.QiNiuStoreFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Desc:删除相册
 * <p/>Date: 2015-12-25
 * <br/>Time: 18:44
 * <br/>User: ylzhu
 */
public class AlbumDeleteTask implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumDeleteTask.class);

    /**
     * 相册ID
     */
    private List<String> photoKeys;

    public AlbumDeleteTask(List<String> photoKeys) {
        this.photoKeys = photoKeys;
    }

    @Override
    public Boolean call() throws Exception {
        try {
            return batchDelFromQiNiu();
        } catch (Exception e) {
            LOGGER.error("#Execute photo delete error.Key size is " + photoKeys.size() + " Cause:", e);
        }
        return false;
    }

    private boolean batchDelFromQiNiu() {
        return QiNiuStoreFactory.getInstance().batchDel(photoKeys);
    }
}
