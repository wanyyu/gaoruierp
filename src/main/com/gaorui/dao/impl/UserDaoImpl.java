package com.gaorui.dao.impl;

import com.gaorui.dao.UserDao;
import com.gaorui.entity.User;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
@Repository
@Transactional
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public User getUser(String id) {
        String hql = "from User u where u.loginid=?";
        Query<User> query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setParameter(0, id);
        return query.uniqueResult();
    }
}
