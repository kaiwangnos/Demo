package com.ssm.dao.impl;

import com.ssm.dao.GeneralDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class GeneralDaoImpl implements GeneralDao {
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public <T> T getEntity(Class<T> beanClass, String sqlId, Object value) {
        T bean = null;
        try {
            Object obj = sqlSessionTemplate.selectOne(sqlId, value);
            if (obj == null) {
                return null;
            } else {
                return (T) obj;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bean;

    }

    @Override
    public <T> List<T> getEntityList(Class<T> beanClass, String sqlId, Object value) {
        List<T> beanList = null;
        try {
            beanList = sqlSessionTemplate.selectList(sqlId, value);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return beanList;
    }

    @Override
    public int addEntity(String sqlId, Object value) {
        int updateResult = -1;
        try {
            updateResult = sqlSessionTemplate.insert(sqlId, value);
        } catch (Exception ex) {
            ex.printStackTrace();
            return updateResult;
        }
        return updateResult;
    }

    @Override
    public int updateEntity(String sqlId, Object value) {
        int updateResult = -1;
        try {
            updateResult = sqlSessionTemplate.update(sqlId, value);
        } catch (Exception ex) {
            ex.printStackTrace();
            return updateResult;
        }
        return updateResult;
    }
}
