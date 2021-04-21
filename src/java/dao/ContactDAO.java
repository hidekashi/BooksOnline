/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Contacts;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface ContactDAO {
    public List<Contacts> getAllByStatus();
    public List<Contacts> getAll(Integer offset, Integer maxResult);
    public long getTotal();
    public boolean add(Contacts cont);
    public boolean del(Integer contId);
    public boolean update(Contacts cont);
    public Contacts getContactById(Integer contId);
}
