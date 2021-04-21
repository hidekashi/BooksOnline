/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Admins;
import entities.DevvnQuanhuyen;
import entities.DevvnTinhthanhpho;
import entities.DevvnXaphuongthitran;
import entities.OrderDetails;
import entities.Orders;
import entities.Products;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hide
 */
public class OrderDAOImpl implements OrderDAO{
    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    

    @Override
    public List<OrderDetails> getAllOderDetails() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From OrderDetails").list();
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
    public int getOrderRecord() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            int size = session.createQuery("From Orders").list().size();
            session.getTransaction().commit();
            session.close();
            return size;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return 0;
    }

    @Override
    public List<OrderDetails> getAllByStatus() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From OrderDetails Where orderDetailStatus = 1").list();
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
    public List<OrderDetails> getAll(Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From OrderDetails Order By orderDetailId Desc").setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
        }
        return null;
    }

    @Override
    public long getTotalOdtByOdId(Integer id) {
        long total = 0;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            total = session.createQuery("From OrderDetails Where orderId.orderId = :orderId").setParameter("orderId", id).list().size();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return total;
    }

    @Override
    public boolean add(OrderDetails odt) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(odt);
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
    public boolean del(Integer odtId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("Delete From OrderDetails Where orderDetailId = :orderDetailId");
            query.setParameter("orderDetailId", odtId);
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
    public boolean update(OrderDetails odt) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.update(odt);
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
    public DevvnTinhthanhpho getTinhById(String matp) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            DevvnTinhthanhpho tinh = (DevvnTinhthanhpho) session.createQuery("From DevvnTinhthanhpho Where matp = :matp").setParameter("matp", matp).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return tinh;
        } catch (Exception e) {
            session.close();
        }
        return null;
    }

    @Override
    public DevvnQuanhuyen getHuyenById(String maqh) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            DevvnQuanhuyen huyen = (DevvnQuanhuyen) session.createQuery("From DevvnQuanhuyen Where maqh = :maqh").setParameter("maqh", maqh).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return huyen;
        } catch (Exception e) {
            session.close();
        }
        return null;
    }

    @Override
    public DevvnXaphuongthitran getXaById(String xaid) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            DevvnXaphuongthitran xa = (DevvnXaphuongthitran) session.createQuery("From DevvnXaphuongthitran Where xaid = :xaid").setParameter("xaid", xaid).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return xa;
        } catch (Exception e) {
            session.close();
        }
        return null;
    }

    @Override
    public boolean add(Orders od) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(od);
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
    public Orders getNewOrderId() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Orders od = (Orders) session.createQuery("From Orders Order By orderDate Desc").setMaxResults(1).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return od;
        } catch (Exception e) {
            session.close();
        }
        return null;
    }

    @Override
    public List<Orders> getAllOrders(Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Orders Order By orderId Desc").setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
        }
        return null;
    }

    @Override
    public long getTotalOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delOrders(Integer odId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("Delete From Orders Where orderId = :orderId");
            query.setParameter("orderId", odId);
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
    public boolean update(Orders od) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.update(od);
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
    public List<OrderDetails> getOrderDetailsByOrderId(Integer id, Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From OrderDetails Where orderId.orderId = :orderId Order By orderDetailId Desc").setParameter("orderId", id).setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            session.close();
        }
        return null;
    }
    
    @Override
    public List<OrderDetails> getOrderDetailsByOrderId(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From OrderDetails Where orderId.orderId = :orderId").setParameter("orderId", id).list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            session.close();
        }
        return null;
    }

    @Override
    public boolean updateOrderAdminId(Admins adminId, Integer orderId) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("UPDATE Orders SET adminId = :adminId, orderStatus = 1 WHERE orderId = :orderId").setParameter("adminId", adminId).setParameter("orderId", orderId);
            int i = query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            if(i>0) return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return bl;
    }

    @Override
    public List<Orders> getOrderByCusId(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From Orders Where customerId.customerId = :id Order By orderId Desc").setParameter("id", id).list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            session.close();
        }
        return null;
    }
    
    @Override
    public Orders getOrderById(Integer orderId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Orders where orderId = :orderId");
            query.setParameter("orderId", orderId);
            Orders od = (Orders) query.uniqueResult();
            session.getTransaction().commit();
            session.close();
            return od;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }
    
    @Override
    public List<Orders> search(String name, Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            if(name==null || name.length()==0){
                name = "%";
            } else {
                name = "%" + name + "%";;
            }
            List list = session.createQuery("from Orders where customerId.customerName like :name Order By orderId Desc").setParameter("name", name).setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
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
                name ="%" + name + "%";
            }
            int total = session.createQuery("from Orders where customerId.customerName like :name").setParameter("name", name).list().size();
            session.getTransaction().commit();
            session.close();
            return total;
        } catch (Exception e) {
            session.close();
        }
        return 0;
    }

    @Override
    public List<OrderDetails> searchOdt(Integer id, String name, Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List list = session.createQuery("From OrderDetails Where orderId.orderId = :orderId and productId.productName like :name Order By orderDetailId Desc").setParameter("orderId", id).setParameter("name", name).setFirstResult(offset==null?0:offset).setMaxResults(maxResult==null?5:maxResult).list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            session.close();
        }
        return null;
    }

    @Override
    public long getTotalSearchOdt(Integer id, String name) {
        long total = 0;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            total = session.createQuery("From OrderDetails Where orderId.orderId = :orderId and productId.productName like :name").setParameter("orderId", id).setParameter("name", name).list().size();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return total;
    }
    
    @Override
    public boolean updateProQuan(Integer proId, Integer quantity) {
        boolean bl = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("UPDATE Products SET productQuantity = productQuantity - :quantity WHERE productId = :productId").setParameter("quantity", quantity).setParameter("productId", proId);
            int i = query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            if(i>0) return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return bl;
    }
    
}
