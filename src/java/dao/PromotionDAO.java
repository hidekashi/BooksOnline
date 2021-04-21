/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Categories;
import entities.PromotionDetails;
import entities.Promotions;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface PromotionDAO {
    public List<Promotions> get3Promotion(); 
    public List<Promotions> getAllByStatus();
    public List<Promotions> getAll(Integer offset, Integer maxResult);
    public long getTotal();
    public boolean add(Promotions promo);
    public boolean del(Integer promoId);
    public boolean update(Promotions promo);
    public Promotions getPromobyId(Integer id);
    public List<PromotionDetails> getPromoDeById(Integer id);
    public List<PromotionDetails> get1PromoDeById(Integer id);
}
