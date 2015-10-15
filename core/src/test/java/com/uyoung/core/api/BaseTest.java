package com.uyoung.core.api;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: KennyZhu
 * Date: 15/9/23
 * Desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-core-test.xml"})
public class BaseTest {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
}
