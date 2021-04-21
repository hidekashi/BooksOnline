/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Admins;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface AdminDAO {
    public List<Admins> getAllAdmins();
    public Admins checkLogin(Admins admin);
    public List<Admins> getAll(Integer offset, Integer maxResult);
    public long getTotal();
    public boolean add(Admins admin);
    public boolean del(Integer adminId);
    public boolean update(Admins admin);
    public Admins getAdminByName(String name);
    public Admins getAdminById(Integer adminId);
    public List<Admins> search(String name, Integer offset, Integer maxResult);
    public int getTotalSearch(String name);
}
