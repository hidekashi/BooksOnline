/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.News;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hide
 */
public class NewDAOImpl implements NewDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<News> getAllByStatus() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From News Where newStatus = 1").list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }

    @Override
    public List<News> getAll(Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From News Order By newId Desc").setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }

    @Override
    public long getTotal() {
        long total = 0;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            total = session.createQuery("From News").list().size();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return total;
    }

    @Override
    public boolean add(News news) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(news);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return bl;
    }

    @Override
    public boolean del(Integer newsId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("Delete From News Where newId = :newId");
            query.setParameter("newId", newsId);
            int i = query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            if(i>0) return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(News news) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.update(news);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return bl;
    }
}
