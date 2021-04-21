/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Categories;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hide
 */
public class CategoryDAOImpl implements CategoryDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Categories> getAllByStatus() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Categories Where CategoryStatus = 1").list();
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
    public List<Categories> getAll(Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Categories Order By categoryId Desc").setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
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
            total = session.createQuery("From Categories").list().size();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return total;
    }

    @Override
    public boolean add(Categories cate) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(cate);
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
    public boolean del(Integer cateId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("Delete From Categories Where categoryId = :categoryId");
            query.setParameter("categoryId", cateId);
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
    public boolean update(Categories cate) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.update(cate);
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
    public Categories getCategoryById(Integer cateId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("From Categories Where categoryId = :categoryId");
            query.setParameter("categoryId", cateId);
            Categories cate = (Categories) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return cate;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }
    
    @Override
    public List<Categories> search(String name, Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            if(name==null || name.length()==0){
                name = "%";
            } else {
                name = "%" + name + "%";
            }
            List list = session.createQuery("from Categories where categoryName like :name Order By categoryId Desc").setParameter("name", name).setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
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
            int total = session.createQuery("from Categories where categoryName like :name").setParameter("name", name).list().size();
            session.getTransaction().commit();
            session.close();
            return total;
        } catch (Exception e) {
            session.close();
        }
        return 0;
    }
    
}
