/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Icons;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface IconDAO {
    public List<Icons> getAllByStatus();
    public List<Icons> getAll(Integer offset, Integer maxResult);
    public long getTotal();
    public boolean add(Icons icon);
    public boolean del(Integer iconId);
    public boolean update(Icons icon);
}
