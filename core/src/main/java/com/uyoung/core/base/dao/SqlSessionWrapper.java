package com.uyoung.core.base.dao;

import org.apache.ibatis.exceptions.IbatisException;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SQL Session 包装类
 * User: KennyZhu
 * Date: 2014-7-20
 * Time: 13:29
 */
public class SqlSessionWrapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(SqlSessionWrapper.class);
    private static final ConcurrentHashMap<String, SqlSessionWrapper> INSTANCE_MAP = new ConcurrentHashMap<>();
    /**
     * 环境
     */
    private String env;

    private SqlSessionWrapper(String env) {
        this.env = env;
    }

    public static SqlSessionWrapper getInstance(String env) {
        String key = env;
        if (!INSTANCE_MAP.contains(key)) {
            SqlSessionWrapper instance = new SqlSessionWrapper(env);
            INSTANCE_MAP.put(key, instance);
        }
        return INSTANCE_MAP.get(key);


    }

    public Object selectOne(String statement, Object parameter) {
        SqlSession sqlSession = null;
        try {
            sqlSession = getSqlSession();
            return sqlSession.selectOne(statement, parameter);
        } catch (Throwable t) {
            LOGGER.error("selectOne(" + statement + ") error:" + t.getMessage());
            throw new IbatisException("selectList error:" + statement);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
                LOGGER.debug("oops, close_session_4_" + statement);
            }
        }
    }

    public List<?> selectList(String statement, Object parameter, RowBounds rowBounds) {
        SqlSession sqlSession = null;
        try {
            sqlSession = getSqlSession();
            return sqlSession.selectList(statement, parameter, rowBounds);
        } catch (Throwable t) {
            LOGGER.error("selectList(" + statement + ") error:" + t.getMessage());
            throw new IbatisException("selectList error:" + statement + "  msg is :" + t.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
                LOGGER.debug("oops, close_session_4_" + statement);
            }
        }
    }

    public int insert(String statement, Object parameter) {
        SqlSession sqlSession = null;
        try {
            sqlSession = getSqlSession();
            return sqlSession.insert(statement, parameter);
        } catch (Throwable t) {
            LOGGER.error("insert(" + statement + ") error:" + t.getMessage());
            throw new IbatisException("insert error:" + statement);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
                LOGGER.debug("oops, close_session_4_" + statement);
            }
        }
    }

    public int update(String statement, Object parameter) {
        SqlSession sqlSession = null;
        try {
            sqlSession = getSqlSession();
            return sqlSession.update(statement, parameter);
        } catch (Throwable t) {
            LOGGER.error("update(" + statement + ") error:" + t.getMessage());
            throw new IbatisException("update error:" + statement);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
                LOGGER.debug("oops, close_session_4_" + statement);
            }
        }
    }

    public int delete(String statement, Object parameter) {
        SqlSession sqlSession = null;
        try {
            sqlSession = getSqlSession();
            return sqlSession.delete(statement, parameter);
        } catch (Throwable t) {
            LOGGER.error("delete(" + statement + ") error:" + t.getMessage());
            throw new IbatisException("delete error:" + statement);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
                LOGGER.debug("oops, close_session_4_" + statement);
            }
        }
    }

    private SqlSession getSqlSession() {
        SqlSession sqlSession;
        try {
            sqlSession = SqlSessionFactoryMap.getInstance().getSqlSessionByEnvironment(this.env);
        } catch (Exception e) {
            LOGGER.error("get sqlSession error:" + e.getMessage());
            sqlSession = null;
        }
        return sqlSession;
    }

}
