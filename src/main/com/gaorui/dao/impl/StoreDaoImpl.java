package com.gaorui.dao.impl;

import com.gaorui.dao.StoreDao;
import com.gaorui.entity.Import;
import com.gaorui.entity.Store;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
@Repository
@Transactional
public class StoreDaoImpl extends HibernateDaoSupport implements StoreDao {
    @Override
    public List<Store> getAllStroe() {
        String hql="From Store";
        Query<Store> query = this.getSessionFactory().getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public Store getStore(String storeid) {
        String hql="From Store where storeid=:storeid";
        Query<Store> query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setParameter("storeid", storeid);
        return query.uniqueResult();
    }

    @Override
    public boolean updateStore(Store store) {
        boolean bool=false;
        try {
            Session session=this.getSessionFactory().getCurrentSession();
            session.update(store);
            bool = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool;
    }

    @Override
    public boolean insertStore(Store store) {
        boolean bool=false;
        try {
            Session session=this.getSessionFactory().getCurrentSession();
            session.save(store);
            bool = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bool;
    }

    @Override
    public boolean deleteStore(String storeid) {
        boolean bool=false;
        try {
            Session session=this.getSessionFactory().getCurrentSession();
            Store store=session.get(Store.class,storeid);
            session.delete(store);
            bool = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool;
    }

    @Override
    public Store getStoreNum(String merchid) {
        String hql="From Store where merch.merchid=:merchid";
        Query<Store> query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setParameter("merchid", merchid);
        return query.uniqueResult();
    }

}
