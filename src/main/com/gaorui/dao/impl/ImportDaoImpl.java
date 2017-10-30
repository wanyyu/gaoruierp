package com.gaorui.dao.impl;

import com.gaorui.dao.ImportDao;
import com.gaorui.entity.Import;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
@Repository
@Transactional
public class ImportDaoImpl extends HibernateDaoSupport implements ImportDao {
    @Override
   public List<Import> getAllImport(Import im) {
        StringBuilder hql = new StringBuilder("From Import where 1=1");
        if(im!=null){
            if(im.getImportid()!=null&&im.getImportid()!="")
                hql.append(" and importid = :importid");
            if(im.getUser()!=null) {
                if (im.getUser().getLoginid() != null && im.getUser().getLoginid() != "")
                    hql.append(" and user.loginid like :name");
            }
        }
        Query query = this.getSessionFactory().getCurrentSession().createQuery(hql.toString());
        if(im!=null){
            if(im.getImportid()!=null&&im.getImportid()!="")
                query.setParameter("importid", im.getImportid());
            if(im.getUser()!=null) {
                if (null != im.getUser().getLoginid() && "" != im.getUser().getLoginid())
                    query.setParameter("name", "%" + im.getUser().getLoginid() + "%");
            }

        }
        return (List<Import>) query.list();
    }

    @Override
    public Import getImport(String importid) {
        String hql="From Import where importid=:importid";
        Query query = this.getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setParameter("importid",importid);
        return (Import) query.uniqueResult();
    }

    @Override
    public boolean InsertImport(Import newImport) {
        boolean bool=false;
        try {
            Session session=this.getSessionFactory().getCurrentSession();
            session.save(newImport);
            bool = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bool;
    }
}
