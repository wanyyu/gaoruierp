package com.gaorui.dao.impl;

import com.gaorui.dao.MerchDao;
import com.gaorui.entity.Merch;
import com.gaorui.entity.User;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31 0031.
 */
@Repository
@Transactional
public class MerchDaoImpl extends HibernateDaoSupport implements MerchDao {
    @Override
    public List<Merch> getAllMerch() {
        String hql = "From Merch";
        Query<Merch> query = getSessionFactory().getCurrentSession().createQuery(hql);
        return query.list();
    }
}
