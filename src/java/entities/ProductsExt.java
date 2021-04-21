/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Hide
 */
public class ProductsExt implements Serializable {

    private Integer productId;
    private String productName;
    private Date productAddedTime;
    private Integer productQuantity;
    private String productDescription;
    private String productFeatureImage;
    private Double productPrice;
    private Double productDiscount;
    private boolean productStatus;
    private Authors authorId;
    private Categories categoryId;
    private Countries countryId;
    private Publishers publisherId;
    
    private String imageOld;

    public ProductsExt() {
    }

    public ProductsExt(Integer productId) {
        this.productId = productId;
    }

    public ProductsExt(Integer productId, Date productAddedTime, boolean productStatus) {
        this.productId = productId;
        this.productAddedTime = productAddedTime;
        this.productStatus = productStatus;
    }

    public String getImageOld() {
        return imageOld;
    }

    public void setImageOld(String imageOld) {
        this.imageOld = imageOld;
    }
    
    

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getProductAddedTime() {
        return productAddedTime;
    }

    public void setProductAddedTime(Date productAddedTime) {
        this.productAddedTime = productAddedTime;
    }

     public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
    
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductFeatureImage() {
        return productFeatureImage;
    }

    public void setProductFeatureImage(String productFeatureImage) {
        this.productFeatureImage = productFeatureImage;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(Double productDiscount) {
        this.productDiscount = productDiscount;
    }

    public boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Authors getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Authors authorId) {
        this.authorId = authorId;
    }

    public Categories getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Categories categoryId) {
        this.categoryId = categoryId;
    }

    public Countries getCountryId() {
        return countryId;
    }

    public void setCountryId(Countries countryId) {
        this.countryId = countryId;
    }

    public Publishers getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publishers publisherId) {
        this.publisherId = publisherId;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductsExt)) {
            return false;
        }
        ProductsExt other = (ProductsExt) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Products[ productId=" + productId + " ]";
    }
    
}
