/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Logos;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface LogoDAO {
    public List<Logos> getAllByStatus();
    public List<Logos> getAll(Integer offset, Integer maxResult);
    public long getTotal();
    public boolean add(Logos logo);
    public boolean del(Integer logoId);
    public boolean update(Logos logo);
}
