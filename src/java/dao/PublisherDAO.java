/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Publishers;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface PublisherDAO {
    public List<Publishers> getAll(Integer offset, Integer maxResult);
    public List<Publishers> getAllByStatus();
    public List<Publishers> get5PublisherByStatus();
    public long getTotal();
    public boolean add(Publishers pub);
    public boolean del(Integer pubId);
    public boolean update(Publishers pub);
    public Publishers getPublisherById(Integer publisherId);
    public List<Publishers> search(String name, Integer offset, Integer maxResult);
    public int getTotalSearch(String name);
}
