package com.uyoung.core.base.dao;

import com.uyoung.core.base.bean.Page;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 所有的Dao须继承BaseDao
 * User: KennyZhu
 * Date: 2014-7-20
 * Time: 11:55
 */
public abstract class BaseDao<T> {
    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

    private String getNameSpace() {
        Class[] interfaces = this.getClass().getInterfaces();
        System.out.println("#" + interfaces[0].getName());
        return interfaces[0].getName() + ".";
    }

    protected T selectOne(String statement) {
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
            return sqlSessionTemplate.selectOne(getNameSpace() + statement, parameter);
        }
    }

    protected List<T> selectList(String statement) {
        return selectList(statement, null);
    }

    protected List<T> selectList(String statement, Object parameter) {
        return selectList(statement, parameter, RowBounds.DEFAULT);
    }

    protected List<T> selectList(String statement, Object parameter, RowBounds rowBounds) {
        return sqlSessionTemplate.selectList(getNameSpace() + statement, parameter, rowBounds);
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
        return sqlSessionTemplate.insert(getNameSpace() + statement, parameter);
    }

    protected int update(String statement) {
        return update(statement, null);
    }

    protected int update(String statement, Object parameter) {
        return sqlSessionTemplate.update(getNameSpace() + statement, parameter);
    }

    protected int delete(String statement) {
        return delete(statement, null);
    }

    protected int delete(String statement, Object parameter) {
        return sqlSessionTemplate.delete(getNameSpace() + statement, parameter);
    }

}
