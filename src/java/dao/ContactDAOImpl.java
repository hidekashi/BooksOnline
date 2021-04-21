/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Contacts;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hide
 */
public class ContactDAOImpl implements ContactDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Contacts> getAllByStatus() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Contacts Where contactStatus = 1").list();
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
    public List<Contacts> getAll(Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Contacts Order By contactId Desc").setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
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
            total = session.createQuery("From Contacts").list().size();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return total;
    }

    @Override
    public boolean add(Contacts cont) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(cont);
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
    public boolean del(Integer contId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("Delete From Contacts Where contactId = :contactId");
            query.setParameter("contactId", contId);
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
    public boolean update(Contacts cont) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.update(cont);
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
    public Contacts getContactById(Integer contId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("From Contacts Where contactId = :contactId");
            query.setParameter("contactId", contId);
            Contacts cont = (Contacts) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return cont;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }
    
}
