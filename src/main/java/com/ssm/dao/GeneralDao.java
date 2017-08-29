package com.ssm.dao;

import java.util.List;

public interface GeneralDao {
    public <T> T getEntity(Class<T> beanClass, String sqlId, Object value);

    public <T> List<T> getEntityList(Class<T> beanClass, String sqlId, Object value);

    public int addEntity(String sqlId, Object value);

    public int updateEntity(String sqlId, Object value);
}
