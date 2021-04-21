/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.News;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface NewDAO {
    public List<News> getAllByStatus();
    public List<News> getAll(Integer offset, Integer maxResult);
    public long getTotal();
    public boolean add(News news);
    public boolean del(Integer newsId);
    public boolean update(News news);
}
