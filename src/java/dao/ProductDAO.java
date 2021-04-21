/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Authors;
import entities.Countries;
import entities.Products;
import entities.Publishers;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface ProductDAO {
    public List<Products> getAll(Integer offset, Integer maxResult);
    public List<Products> getAllByStatus(Integer offset, Integer maxResult);
    public List<Products> getNewestProduct();
    public List<Products> getOfferProduct();
    public List<Products> getProductsByCategoryId(Integer categoryId, Integer offset, Integer maxResult);
    public List<Products> get4ProductsByCategoryId(Integer categoryId, Integer proId);
    public List<Authors> getAuthersByAuthorId(Integer authorId,Integer offset, Integer maxResult);
    public List<Authors> get4AuthersByAuthorId(Integer authorId);
    public List<Countries> getCountriesByCountryId(Integer countryId,Integer offset, Integer maxResult);
    public List<Countries> get4CountriesByCountryId(Integer countryId);
    public List<Publishers> getPublishersByPublisherId(Integer publisherId,Integer offset, Integer maxResult);
    public List<Publishers> get4PublishersByPublisherId(Integer publisherId);
    public Products getProductById(Integer productId);
    public boolean add(Products product);
    public long getTotal();
    public boolean del(Integer proId);
    public List<Products> search(String name,Integer offset, Integer maxResult);
    public boolean updateProduct(Products p);
    public List<Products> getAllProduct();
    public List<Products> searchProductByName(String name, Integer offset, Integer maxResult);
    public int getTotalSearch(String name);
    public int getTotalByCateId(Integer id);
    public int getTotalByAuId(Integer id);
    public int getTotalByPubId(Integer id);
    public int getTotalByCountryId(Integer id);
    public List<Products> getAllOfferProduct(Integer offset, Integer maxResult);
    public int getTotalOfferPro();
    public int getQuantity(Integer id);
}
