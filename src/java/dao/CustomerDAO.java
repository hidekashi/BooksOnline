/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Customers;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface CustomerDAO {
    public List<Customers> getAllByStatus();
    public List<Customers> getAll(Integer offset, Integer maxResult);
    public long getTotal();
    public boolean add(Customers cus);
    public boolean del(Integer cusId);
    public Customers getCustomerByName(String name);
    public Customers  checkLogin(Customers cus);
    public boolean  checkUsername(String name);
    public boolean  checkUserEmail(String mail);
    public boolean update(Customers cus);
    public Customers getCustomerById(Integer customerId);
    public List<Customers> search(String name, Integer offset, Integer maxResult);
    public int getTotalSearch(String name);
}
