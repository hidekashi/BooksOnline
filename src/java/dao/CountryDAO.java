/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Countries;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface CountryDAO {
    public List<Countries> getAll(Integer offset, Integer maxResult);
    public List<Countries> getAllByStatus();
    public List<Countries> get6CountryByStatus();
    public long getTotal();
    public boolean add(Countries coun);
    public boolean del(Integer counId);
    public boolean update(Countries coun);
    public Countries getCountryById(Integer counId);
    public List<Countries> search(String name, Integer offset, Integer maxResult);
    public int getTotalSearch(String name);
}
