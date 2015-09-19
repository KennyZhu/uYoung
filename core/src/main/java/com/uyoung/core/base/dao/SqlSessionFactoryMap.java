package com.uyoung.core.base.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SqlSessionFactory 的获取类
 * User: KennyZhu
 * Date: 2014-7-20
 * Time: 13:54
 */
public class SqlSessionFactoryMap {
    private static final SqlSessionFactoryMap instance = new SqlSessionFactoryMap();

    private static final Logger LOGGER = LoggerFactory.getLogger(SqlSessionFactoryMap.class);

    private static final ConcurrentHashMap<String, SqlSessionFactory> FACTORY_MAP = new ConcurrentHashMap<>();

    private static final Object LOCK = new Object();

    private Reader reader;

    private SqlSessionFactoryMap() {
    }

    private final static String DEFAULT_WRITE_CONFIG = "mybatis-core-config.xml";

    public static SqlSessionFactoryMap getInstance() {
        return instance;
    }

    /**
     * 根据配置文件中environment 获取对应SqlSession
     *
     * @param environment
     * @return
     */
    public SqlSession getSqlSessionByEnvironment(String environment) {
        return this.getSqlSession(environment);
    }

    /**
     * 根据环境获取SessionFactory 从本地缓存中获取
     *
     * @param environment
     * @param configFile
     * @return
     */
    private SqlSessionFactory getSqlSessionFactory(String environment, String configFile) {
        Map<String, SqlSessionFactory> tempSqlSessionFactoryMap = FACTORY_MAP;
        if (!tempSqlSessionFactoryMap.containsKey(environment)) {
            synchronized (LOCK) {
                if (!tempSqlSessionFactoryMap.containsKey(environment)) {
                    try {
                        long start = System.currentTimeMillis();
                        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
                        reader = Resources.getResourceAsReader(configFile);
                        SqlSessionFactory factory = builder.build(reader, environment);
                        tempSqlSessionFactoryMap.put(environment, factory);
                        long end = System.currentTimeMillis();
                        if (end - start > 1000) {
                            LOGGER.warn(String.format("build datasource %s cost %d ms", environment, (end - start)));
                        }
                        return factory;
                    } catch (Exception e) {
                        LOGGER.error("Get SqlSessionFactory by environment {} error!Casue:{}", environment, e.getMessage());
                        return null;
                    } finally {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            LOGGER.error(e.getMessage());
                        }
                    }
                }
            }
        }
        return tempSqlSessionFactoryMap.get(environment);
    }

    private SqlSession getSqlSession(String environment) {
        String configFile;
        configFile = DEFAULT_WRITE_CONFIG;
        SqlSessionFactory sqlSessionFactory = this.getSqlSessionFactory(environment, configFile);
        long start = System.currentTimeMillis();
        SqlSession session = sqlSessionFactory.openSession(true);
        long end = System.currentTimeMillis();
        if (end - start > 100) {
            LOGGER.warn("open sql session:" + environment + " " + (end - start) + " millionSeconds");
        }
        return session;
    }
}
