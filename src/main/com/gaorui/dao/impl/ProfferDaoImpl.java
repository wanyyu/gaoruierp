package com.gaorui.dao.impl;

import com.gaorui.dao.ProfferDao;
import com.gaorui.entity.Proffer;
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
public class ProfferDaoImpl extends HibernateDaoSupport implements ProfferDao {
    @Override
    public List<Proffer> getAllProffer() {
        String hql="From Proffer";
        Query<Proffer> query = this.getSessionFactory().getCurrentSession().createQuery(hql);
        return query.list();
    }
}
