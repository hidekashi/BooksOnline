/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hide
 */
@Entity
@Table(name = "Products")
@XmlRootElement

public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private Integer productId;
    @Size(max = 100)
    @Column(name = "ProductName")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductAddedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date productAddedTime;
    @Column(name = "ProductQuantity")
    private Integer productQuantity;
    @Size(max = 1073741823)
    @Column(name = "ProductDescription")
    private String productDescription;
    @Size(max = 100)
    @Column(name = "ProductFeatureImage")
    private String productFeatureImage;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ProductPrice")
    private Double productPrice;
    @Column(name = "ProductDiscount")
    private Double productDiscount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductStatus")
    private boolean productStatus;
    @JoinColumn(name = "AuthorId", referencedColumnName = "AuthorId")
    @ManyToOne(optional = false)
    private Authors authorId;
    @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")
    @ManyToOne(optional = false)
    private Categories categoryId;
    @JoinColumn(name = "CountryId", referencedColumnName = "CountryId")
    @ManyToOne(optional = false)
    private Countries countryId;
    @JoinColumn(name = "PublisherId", referencedColumnName = "PublisherId")
    @ManyToOne(optional = false)
    private Publishers publisherId;
    @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    private Collection<OrderDetails> orderDetailsCollection;
    @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    private Collection<BannerDetails> bannerDetailsCollection;
    @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    private Collection<ProductImages> productImagesCollection;
    @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    private Collection<PromotionDetails> promotionDetailsCollection;

    public Products() {
    }

    public Products(Integer productId) {
        this.productId = productId;
    }

    public Products(Integer productId, Date productAddedTime, boolean productStatus) {
        this.productId = productId;
        this.productAddedTime = productAddedTime;
        this.productStatus = productStatus;
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

    @XmlTransient
    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
    }

    @XmlTransient
    public Collection<BannerDetails> getBannerDetailsCollection() {
        return bannerDetailsCollection;
    }

    public void setBannerDetailsCollection(Collection<BannerDetails> bannerDetailsCollection) {
        this.bannerDetailsCollection = bannerDetailsCollection;
    }

    @XmlTransient
    public Collection<ProductImages> getProductImagesCollection() {
        return productImagesCollection;
    }

    public void setProductImagesCollection(Collection<ProductImages> productImagesCollection) {
        this.productImagesCollection = productImagesCollection;
    }

    @XmlTransient
    public Collection<PromotionDetails> getPromotionDetailsCollection() {
        return promotionDetailsCollection;
    }

    public void setPromotionDetailsCollection(Collection<PromotionDetails> promotionDetailsCollection) {
        this.promotionDetailsCollection = promotionDetailsCollection;
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
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
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
