/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.NewsCategories;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface NewCategoryDAO {
    public List<NewsCategories> getAllByStatus();
    public List<NewsCategories> getAll(Integer offset, Integer maxResult);
    public long getTotal();
    public boolean add(NewsCategories newsCate);
    public boolean del(Integer newsCateId);
    public boolean update(NewsCategories newsCate);
}
