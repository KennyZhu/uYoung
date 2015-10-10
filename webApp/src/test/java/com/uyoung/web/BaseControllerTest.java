package com.uyoung.web;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: KennyZhu
 * Date: 15/9/28
 * Desc:
 */
@ContextConfiguration(locations = {"classpath:spring-*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseControllerTest extends AbstractTransactionalJUnit4SpringContextTests {
}
