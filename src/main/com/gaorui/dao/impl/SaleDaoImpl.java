package com.gaorui.dao.impl;

import com.gaorui.dao.SaleDao;
import com.gaorui.entity.Import;
import com.gaorui.entity.Sale;
import com.gaorui.entity.Store;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/11/3 0003.
 */
@Repository
@Transactional
public class SaleDaoImpl extends HibernateDaoSupport implements SaleDao {
    @Override
    public List<Sale> getAllSale() {
        String hql="From Sale";
        Query<Sale> query = this.getSessionFactory().getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public Sale getSale(String saleid) {
        String hql="From Sale where saleid=:saleid";
        Query<Sale> query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setParameter("saleid", saleid);
        return query.uniqueResult();
    }

    @Override
    public boolean insertSale(Sale sale) {
        boolean bool=false;
        try {
            Session session=this.getSessionFactory().getCurrentSession();
            session.save(sale);
            bool = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bool;
    }

    @Override
    public boolean updateSale(Sale sale) {
        boolean bool=false;
        try {
            Session session=this.getSessionFactory().getCurrentSession();
            session.update(sale);
            bool = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool;
    }

    @Override
    public boolean deleteSale(String saleid) {
        boolean bool=false;
        try {
            Session session=this.getSessionFactory().getCurrentSession();
           Sale sale=session.get(Sale.class,saleid);
            session.delete(sale);
            bool = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool;
    }
}
