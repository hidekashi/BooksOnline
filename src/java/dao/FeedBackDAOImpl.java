/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Categories;
import entities.FeedBacks;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hide
 */
public class FeedBackDAOImpl implements FeedBackDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    @Override
    public boolean addFeedBack(FeedBacks fb) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(fb);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();;
            session.getTransaction().rollback();
            session.close();
        }
        return bl;
    }

    @Override
    public int getFeedbackRecord() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            int size = session.createQuery("From FeedBacks").list().size();
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
    public List<FeedBacks> getAllByStatus() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From FeedBacks Where feedBackStatus = 1").list();
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
    public List<FeedBacks> getAll(Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From FeedBacks Order By feedBackId Desc").setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
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
    public boolean del(Integer cateId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("Delete From FeedBacks Where feedBackId = :feedBackId");
            query.setParameter("feedBackId", cateId);
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
    public boolean update(FeedBacks fb) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.update(fb);
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
    public FeedBacks getFeedBackById(Integer feedBackId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from FeedBacks where feedBackId= :feedBackId");
            query.setParameter("feedBackId", feedBackId);
            FeedBacks o = (FeedBacks) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }
    
    @Override
    public List<FeedBacks> search(String name, Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            if(name==null || name.length()==0){
                name = "%";
            } else {
                name = "%" + name + "%";
            }
            List list = session.createQuery("from FeedBacks where feedBackName like :name Order By feedBackId Desc").setParameter("name", name).setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
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
            int total = session.createQuery("from FeedBacks where feedBackName like :name").setParameter("name", name).list().size();
            session.getTransaction().commit();
            session.close();
            return total;
        } catch (Exception e) {
            session.close();
        }
        return 0;
    }
    
}
