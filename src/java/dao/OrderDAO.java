/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Admins;
import entities.Categories;
import entities.DevvnQuanhuyen;
import entities.DevvnTinhthanhpho;
import entities.DevvnXaphuongthitran;
import entities.OrderDetails;
import entities.Orders;
import entities.Products;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface OrderDAO {
    
    
//    public List<Orders> getAllOders();
//    public int getOdRecord();
    
//    public List<OrderDetails> getAllByStatus();
    public List<Orders> getAllOrders(Integer offset, Integer maxResult);
    public long getTotalOrders();
    public boolean add(Orders od);
    public Orders getNewOrderId();
    public boolean delOrders(Integer odId);
    public boolean update(Orders od);
    
    
    public List<OrderDetails> getAllOderDetails();
    public int getOrderRecord();
    
    public List<OrderDetails> getAllByStatus();
    public List<OrderDetails> getAll(Integer offset, Integer maxResult);
    public long getTotalOdtByOdId(Integer id);
    public boolean add(OrderDetails odt);
    public boolean del(Integer odtId);
    public boolean update(OrderDetails odt);
    public List<OrderDetails> getOrderDetailsByOrderId(Integer id, Integer offset, Integer maxResult);
    public List<OrderDetails> getOrderDetailsByOrderId(Integer id);
    public boolean updateOrderAdminId(Admins adminId, Integer orderId);
    public List<Orders> getOrderByCusId(Integer id);
    public Orders getOrderById(Integer orderId);
    public List<Orders> search(String name, Integer offset, Integer maxResult);
    public int getTotalSearch(String name);
    public List<OrderDetails> searchOdt(Integer id, String name, Integer offset, Integer maxResult);
    public long getTotalSearchOdt(Integer id, String name);
    public boolean updateProQuan(Integer proId, Integer quantity);
    
    
    public DevvnTinhthanhpho getTinhById(String matp);
    public DevvnQuanhuyen getHuyenById(String maqh);
    public DevvnXaphuongthitran getXaById(String xaid);
    
}
