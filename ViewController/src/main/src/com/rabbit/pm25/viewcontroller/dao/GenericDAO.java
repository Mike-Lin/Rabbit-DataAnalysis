package com.rabbit.pm25.viewcontroller.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mac
 * Date: 13-8-18
 * Time: 下午11:44
 * To change this template use File | Settings | File Templates.
 */
public abstract class GenericDAO<T> implements IGenericDAO<T> {

    private Class<T> entityClass;

    public GenericDAO(Class<T> clazz) {

        this.entityClass = clazz;

        //sessionFactory = HibernateUtil.configureSessionFactory();

    }

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        //事务必须是开启的(Required)，否则获取不到
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insert(T t) {
        getSession().save(t);
    }

    @Override
    public void batchInsert(List<T> list)
    {
        Session session = getSession();

        for ( int i=0; i<list.size(); i++ ) {
            T t = list.get(i);
            session.save(t);
            if ( i % 20 == 0 ) { //20, same as the JDBC batch size
                //flush a batch of inserts and release memory:
                session.flush();
                session.clear();
            }
        }
    }

    @Override
    public void delete(T t) {
        getSession().delete(t);
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T queryById(String id) {
        return (T) getSession().get(entityClass, id);
    }

    @Override
    public List<T> queryAll() {
        String hql = "from " + entityClass.getSimpleName();
        return queryForList(hql, null);
    }

    @Override
    public List<T> queryWithHQL(String hql, Object[] params) {

        return queryForList(hql, params);
    }

    @Override
    public void saveOrUpdate(List<T> list)
    {

        Session session = getSession();

        for ( int i=0; i<list.size(); i++ ) {

            T t = list.get(i);

            session.saveOrUpdate(t);

            if ( i % 20 == 0 ) {

                session.flush();

                session.clear();

            }

        }

    }

    @SuppressWarnings("unchecked")
    protected T queryForObject(String hql, Object[] params) {
        Query query = getSession().createQuery(hql);
        setQueryParams(query, params);
        return (T) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    protected T queryForTopObject(String hql, Object[] params) {
        Query query = getSession().createQuery(hql);
        setQueryParams(query, params);
        return (T) query.setFirstResult(0).setMaxResults(1).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    protected List<T> queryForList(String hql, Object[] params) {
        Query query = getSession().createQuery(hql);
        setQueryParams(query, params);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    protected List<T> queryForList(final String hql, final Object[] params,
                                   final int recordNum) {
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        setQueryParams(query, params);
        return query.setFirstResult(0).setMaxResults(recordNum).list();
    }

    private void setQueryParams(Query query, Object[] params) {
        if (null == params) {
            return;
        }
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
    }

}

