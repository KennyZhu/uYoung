package com.uyoung.core.api.anno.parse;

import com.uyoung.core.api.anno.Sort;
import com.uyoung.core.api.bean.ActivityConditionBean;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.enums.SortEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * User: KennyZhu
 * Date: 16/1/2
 * Desc:Anno Sort 解析
 */
public class SortParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortParser.class);

    /**
     * 解析方法
     *
     * @param object
     * @return
     */
    public static String parser(Object object) {
        if (object == null) {
            LOGGER.error("Invalid param. Null");
            return null;
        }

        Class clazz = object.getClass();
        clazz.getAnnotations();
        Field[] fields = clazz.getDeclaredFields();
        if (fields == null || fields.length == 0) {
            LOGGER.error("Invalid param.No field");
            return null;
        }
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Sort sort = field.getDeclaredAnnotation(Sort.class);
                if (sort != null && field.getInt(object) != 0) {
                    return sort.column();
                }

            }
        } catch (Exception e) {
            LOGGER.error("Get sortColumn error.Cause:", e);
        }
        return null;
    }

    public static void main(String[] args) {
        ActivityConditionBean conditionBean = new ActivityConditionBean();
        conditionBean.setStatus(ActivityStatusEnum.ACTIVE.getStatus());
        conditionBean.setBeginTimeSort(1);
        conditionBean.setSort(SortEnum.DESC.getValue());
        conditionBean.setSortColumn(SortParser.parser(conditionBean));
        System.out.println("Condition is " + conditionBean.toString());
    }

}
