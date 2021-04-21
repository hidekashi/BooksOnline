/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Admins;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hide
 */
public class AdminDAOImpl implements AdminDAO{
    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Admins> getAllAdmins() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Admins").list();
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
    public Admins checkLogin(Admins admin) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Admins where adminUser = :adminUser and adminPassword = :adminPassword and adminStatus = 1");
            query.setParameter("adminUser", admin.getAdminUser());
            query.setParameter("adminPassword", admin.getAdminPassword());
            Admins a = (Admins) query.uniqueResult();            
            session.getTransaction().commit();
            session.close();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }

    @Override
    public List<Admins> getAll(Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Admins Order By adminId Desc").setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
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
            total = session.createQuery("From Admins").list().size();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        
        return total;
    }

    @Override
    public boolean add(Admins admin) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(admin);
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
    public boolean del(Integer adminId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("Delete From Admins Where adminId = :adminId");
            query.setParameter("adminId", adminId);
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
    public boolean update(Admins admin) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.update(admin);
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
    public Admins getAdminByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Admins admin = (Admins) session.createQuery("From Admins Where adminName = :adminName And adminStatus = 1").setParameter("adminName", name).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }

    @Override
    public Admins getAdminById(Integer adminId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("From Admins Where adminId = :adminId");
            query.setParameter("adminId", adminId);
            Admins admin = (Admins) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }
    
    @Override
    public List<Admins> search(String name, Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            if(name==null || name.length()==0){
                name = "%";
            } else {
                name = "%" + name + "%";
            }
            List list = session.createQuery("from Admins where adminName like :name Order By adminId Desc").setParameter("name", name).setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            session.close();
        }
        return null;
    }

    @Override
    public int getTotalSearch(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            if(name==null || name.length()==0){
                name = "%";
            } else {
                name = "%" + name + "%";
            }
            int total = session.createQuery("from Admins where adminName like :name").setParameter("name", name).list().size();
            session.getTransaction().commit();
            session.close();
            return total;
        } catch (Exception e) {
            session.close();
        }
        return 0;
    }
    
}
