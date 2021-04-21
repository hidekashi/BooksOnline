/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.EmailRegistereds;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hide
 */
public class EmailRegisteredDAOImpl implements EmailRegisteredDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public boolean addEmail(EmailRegistereds em) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(em);
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
    public int getEmailRegisteredRecord() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            int size = session.createQuery("From EmailRegistereds").list().size();
            session.getTransaction().commit();
            session.close();
            return size;
        } catch (Exception e) {
            e.printStackTrace();;
            session.getTransaction().rollback();
            session.close();
        }
        return 0;
    }

    @Override
    public List<EmailRegistereds> getAllByStatus() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From EmailRegistereds Where emailRegisteredStatus = 1").list();
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
    public List<EmailRegistereds> getAll(Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From EmailRegistereds Order By emailRegisteredId Desc").setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
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
    public boolean del(Integer emId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("Delete From EmailRegistereds Where emailRegisteredId = :emailRegisteredId");
            query.setParameter("emailRegisteredId", emId);
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
    public boolean update(EmailRegistereds em) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.update(em);
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
