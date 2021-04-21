/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Banners;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface BannerDAO {
    public List<Banners> getAllByStatus();
    public List<Banners> getAll(Integer offset, Integer maxResult);
    public long getTotal();
    public boolean add(Banners banner);
    public boolean del(Integer bannerId);
    public boolean update(Banners banner);
    public Banners getBannerById(Integer bannerId);
    
}
