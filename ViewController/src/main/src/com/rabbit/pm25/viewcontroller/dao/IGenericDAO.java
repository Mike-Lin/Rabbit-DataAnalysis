package com.rabbit.pm25.viewcontroller.dao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-18
 * Time: 下午11:44
 * To change this template use File | Settings | File Templates.
 */
public interface IGenericDAO<T> {

    void insert(T t);

    void batchInsert(List<T> list);

    void delete(T t);

    void update(T t);

    T queryById(String id);

    List<T> queryAll();

    List<T> queryWithHQL(String hql, Object[] params);

    void saveOrUpdate(List<T> list);
}
