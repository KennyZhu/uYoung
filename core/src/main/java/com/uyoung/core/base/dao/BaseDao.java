package com.uyoung.core.base.dao;

import com.uyoung.core.base.bean.Page;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 所有的Dao须继承BaseDao
 * User: KennyZhu
 * Date: 2014-7-20
 * Time: 11:55
 */
public abstract class BaseDao<T> {
    private SqlSessionWrapper sqlSessionWrapper;
    //TODO 暂时写死 从公共配置文件中读取
    private static final String ENV = "sme";

    protected String nameSpace = this.getClass().getName() + ".";

    public BaseDao() {
        sqlSessionWrapper = SqlSessionWrapper.getInstance(ENV);
    }

    public SqlSessionWrapper getSessionWrapper() {
        return sqlSessionWrapper;
    }

    protected Object selectOne(String statement) {
        return selectOne(statement, null);
    }

    protected T selectOne(String statement, Object parameter) {
        String operationId = statement.substring(statement.lastIndexOf(".") + 1);
        if (!operationId.equals("get")) {
            List<T> list = selectList(statement, parameter, RowBounds.DEFAULT);
            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        } else {
            return (T) sqlSessionWrapper.selectOne(nameSpace + statement, parameter);
        }
    }

    protected List<T> selectList(String statement) {
        return selectList(statement, null);
    }

    protected List<T> selectList(String statement, Object parameter) {
        return selectList(statement, parameter, RowBounds.DEFAULT);
    }

    protected List<T> selectList(String statement, Object parameter, RowBounds rowBounds) {
        return (List) sqlSessionWrapper.selectList(nameSpace + statement, parameter, rowBounds);
    }

    protected Page<T> selectPage(String statement, Object parameter, RowBounds rowBounds) {
        List<T> list = selectList(statement, parameter, rowBounds);
        Page<T> page = new Page<>();
        if (CollectionUtils.isEmpty(list)) {
            page.setTotalPage(0);
        }
        page.setPageSize(rowBounds.getLimit());
        page.setDataList(list);
        return page;
    }


    protected int insert(String statement) {
        return insert(statement, null);
    }

    protected int insert(String statement, Object parameter) {
        return sqlSessionWrapper.insert(nameSpace + statement, parameter);
    }

    protected int update(String statement) {
        return update(statement, null);
    }

    protected int update(String statement, Object parameter) {
        return sqlSessionWrapper.update(nameSpace + statement, parameter);
    }

    protected int delete(String statement) {
        return delete(statement, null);
    }

    protected int delete(String statement, Object parameter) {
        return sqlSessionWrapper.delete(nameSpace + statement, parameter);
    }

}
