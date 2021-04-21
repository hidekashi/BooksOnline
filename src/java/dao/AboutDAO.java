/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Abouts;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface AboutDAO {
    public List<Abouts> getAll(Integer offset, Integer maxResult);
    public List<Abouts> getAllByStatus();
    public long getTotal();
    public boolean add(Abouts abou);
    public boolean del(Integer abouId);
    public boolean update(Abouts abou);
    public Abouts getAboutById(Integer abouId);
}
