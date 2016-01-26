package com.uyoung.core.base.spring;

/**
 * Desc:
 * <p/>Date: 2016-01-26
 * <br/>Time: 11:40
 * <br/>User: ylzhu
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * get parameter from Request Attribute
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestAttribute {

    /**
     * The request attribute parameter to bind to.
     */
    String value();

}