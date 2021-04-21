/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.SocialNetworks;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface SocialNetworkDAO {
    public List<SocialNetworks> getAll(Integer offset, Integer maxResult);
    public List<SocialNetworks> getAllByStatus();
    public long getTotal();
    public boolean add(SocialNetworks sw);
    public boolean del(Integer swId);
    public boolean update(SocialNetworks sw);
}
