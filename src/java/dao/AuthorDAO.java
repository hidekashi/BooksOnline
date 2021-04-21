/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Authors;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface AuthorDAO {
    public List<Authors> getAll(Integer offset, Integer maxResult);
    public List<Authors> getAllByStatus();
    public List<Authors> get8ByStatus();
    public long getTotal();
    public boolean add(Authors au);
    public boolean del(Integer auId);
    public boolean softDel(Integer auId);
    public boolean update(Authors au);
    public Authors getAuthorById(Integer auId);
    public List<Authors> search(String name, Integer offset, Integer maxResult);
    public int getTotalSearch(String name);
}
