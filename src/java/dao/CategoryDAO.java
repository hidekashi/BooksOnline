/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Categories;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface CategoryDAO {
    public List<Categories> getAllByStatus();
    public List<Categories> getAll(Integer offset, Integer maxResult);
    public long getTotal();
    public boolean add(Categories cate);
    public boolean del(Integer cateId);
    public boolean update(Categories cate);
    public Categories getCategoryById(Integer cateId);
    public List<Categories> search(String name, Integer offset, Integer maxResult);
    public int getTotalSearch(String name);
}
