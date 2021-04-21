/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entities.Authors;
import entities.Countries;
import entities.Products;
import entities.Publishers;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hide
 */
public class ProductDAOImpl implements ProductDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Products> getAll(Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Products Order By productId Desc").setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
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
    public List<Products> getAllByStatus(Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Products Where productStatus = 1").setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?8:maxResult).list();
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
    public List<Products> getProductsByCategoryId(Integer categoryId, Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("From Products Where CategoryId = :categoryId");
            query.setParameter("categoryId", categoryId);
            List list = query.setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?8:maxResult).list();
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
    public List<Products> get4ProductsByCategoryId(Integer categoryId, Integer proId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("From Products Where CategoryId = :categoryId And productId <> :proId");
            query.setParameter("categoryId", categoryId);
            query.setParameter("proId", proId);
            List list = query.setMaxResults(4).list();
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
    public List<Authors> getAuthersByAuthorId(Integer authorId, Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("From Products Where AuthorId = :authorId");
            query.setParameter("authorId", authorId);
            List list = query.setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?8:maxResult).list();
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
    public List<Authors> get4AuthersByAuthorId(Integer authorId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("From Products Where AuthorId = :authorId");
            query.setParameter("authorId", authorId);
            List list = query.setMaxResults(4).list();
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
    public List<Countries> getCountriesByCountryId(Integer countryId, Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("From Products Where CountryId = :countryId");
            query.setParameter("countryId", countryId);
            List list = query.setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?8:maxResult).list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();;
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }
    
    @Override
    public List<Countries> get4CountriesByCountryId(Integer countryId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("From Products Where CountryId = :countryId");
            query.setParameter("countryId", countryId);
            List list = query.setMaxResults(4).list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();;
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }

    @Override
    public List<Publishers> getPublishersByPublisherId(Integer publisherId, Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("From Products Where PublisherId = :publisherId");
            query.setParameter("publisherId", publisherId);
            List list = query.setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?8:maxResult).list();
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
    public List<Publishers> get4PublishersByPublisherId(Integer publisherId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("From Products Where PublisherId = :publisherId");
            query.setParameter("publisherId", publisherId);
            List list = query.setMaxResults(4).list();
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
    public Products getProductById(Integer productId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("From Products Where productId = :productId");
            query.setParameter("productId", productId);
            Products p = (Products) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }

    @Override
    public boolean add(Products product) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(product);
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
    public List<Products> getNewestProduct() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Products Where productStatus = 1 order by productAddedTime DESC").setMaxResults(8).list();
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
    public List<Products> getOfferProduct() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Products Where productDiscount > 0 And productStatus = 1 order by (productPrice - productDiscount) DESC").setMaxResults(8).list();
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
            total = session.createQuery("From Products").list().size();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        
        return total;
    }

    @Override
    public boolean del(Integer proId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("Delete From Products Where productId = :productId");
            query.setParameter("productId", proId);
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
    public List<Products> search(String name, Integer offset, Integer maxResult) {
        return null;
    }

    @Override
    public boolean updateProduct(Products p) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.update(p);
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
    public List<Products> getAllProduct() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Products").list();
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
    public List<Products> searchProductByName(String name, Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            if(name==null || name.length()==0){
                name = "%";
            } else {
                name = "%" + name + "%";
            }
            List list = session.createQuery("from Products where productName like :name and productStatus = 1 Order By productId Desc").setParameter("name", name).setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?8:maxResult).list();
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
            int total = session.createQuery("from Products where productName like :name and productStatus = 1").setParameter("name", name).list().size();
            session.getTransaction().commit();
            session.close();
            return total;
        } catch (Exception e) {
            session.close();
        }
        return 0;
    }

    @Override
    public int getTotalByCateId(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            int total = session.createQuery("from Products where categoryId.categoryId = :id and productStatus = 1").setParameter("id", id).list().size();
            session.getTransaction().commit();
            session.close();
            return total;
        } catch (Exception e) {
            session.close();
        }
        return 0;
    }

    @Override
    public int getTotalByAuId(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            int total = session.createQuery("from Products where authorId.authorId = :id and productStatus = 1").setParameter("id", id).list().size();
            session.getTransaction().commit();
            session.close();
            return total;
        } catch (Exception e) {
            session.close();
        }
        return 0;
    }

    @Override
    public int getTotalByPubId(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            int total = session.createQuery("from Products where publisherId.publisherId = :id and productStatus = 1").setParameter("id", id).list().size();
            session.getTransaction().commit();
            session.close();
            return total;
        } catch (Exception e) {
            session.close();
        }
        return 0;
    }

    @Override
    public int getTotalByCountryId(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            int total = session.createQuery("from Products where countryId.countryId = :id and productStatus = 1").setParameter("id", id).list().size();
            session.getTransaction().commit();
            session.close();
            return total;
        } catch (Exception e) {
            session.close();
        }
        return 0;
    }
    
    @Override
    public List<Products> getAllOfferProduct(Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Products Where productDiscount > 0 And productStatus = 1 order by (productPrice - productDiscount) DESC").setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?8:maxResult).list();
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
    public int getTotalOfferPro() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            int total = session.createQuery("From Products Where productDiscount > 0 And productStatus = 1").list().size();
            session.getTransaction().commit();
            session.close();
            return total;
        } catch (Exception e) {
            session.close();
        }
        return 0;
    }

    @Override
    public int getQuantity(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            int total = (int) session.createQuery("Select productQuantity From Products Where productId = :id And productStatus = 1").setParameter("id", id).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return total;
        } catch (Exception e) {
            session.close();
        }
        return 0;
    }

    
    
}
