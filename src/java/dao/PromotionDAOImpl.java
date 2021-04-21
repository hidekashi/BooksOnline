/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.PromotionDetails;
import entities.Promotions;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hide
 */
public class PromotionDAOImpl implements PromotionDAO{
    private SessionFactory sessionFactory;

    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    

    @Override
    public List<Promotions> get3Promotion() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Promotions Where promotionStatus = 1 order by promotionId DESC").setMaxResults(3).list();
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
    public List<Promotions> getAllByStatus() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Promotions Where promotionStatus = 1").list();
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
    public List<Promotions> getAll(Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Promotions Order By promotionId Desc").setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
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
            total = session.createQuery("From Promotions").list().size();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return total;
    }

    @Override
    public boolean add(Promotions promo) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(promo);
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
    public boolean del(Integer promoId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("Delete From Promotions Where promotionId = :promotionId");
            query.setParameter("promotionId", promoId);
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
    public boolean update(Promotions promo) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.update(promo);
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
    public Promotions getPromobyId(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Promotions promo = (Promotions) session.createQuery("From Promotions Where promotionId = :id And promotionStatus = 1").setParameter("id", id).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return promo;
        } catch (Exception e) {
            session.close();
            
        }
        return null;
    }

    @Override
    public List<PromotionDetails> getPromoDeById(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From PromotionDetails Where promotionId.promotionId = :id And promotionDetailStatus = 1").setParameter("id", id).list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            session.close();
        }
        return null;
    }
    
    @Override
    public List<PromotionDetails> get1PromoDeById(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List<PromotionDetails> lstPromodt = session.createQuery("From PromotionDetails Where promotionId.promotionId = :id And promotionDetailStatus = 1").setParameter("id", id).setMaxResults(1).list();
            session.getTransaction().commit();
            session.close();
            return lstPromodt;
        } catch (Exception e) {
            session.close();
        }
        return null;
    }
    
}
