/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hide
 */
@Entity
@Table(name = "ProductImages")
@XmlRootElement

public class ProductImages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ProductImageId")
    private Integer productImageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ProductImageName")
    private String productImageName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductImageStatus")
    private boolean productImageStatus;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne(optional = false)
    private Products productId;

    public ProductImages() {
    }

    public ProductImages(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public ProductImages(Integer productImageId, String productImageName, boolean productImageStatus) {
        this.productImageId = productImageId;
        this.productImageName = productImageName;
        this.productImageStatus = productImageStatus;
    }

    public Integer getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public String getProductImageName() {
        return productImageName;
    }

    public void setProductImageName(String productImageName) {
        this.productImageName = productImageName;
    }

    public boolean getProductImageStatus() {
        return productImageStatus;
    }

    public void setProductImageStatus(boolean productImageStatus) {
        this.productImageStatus = productImageStatus;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productImageId != null ? productImageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductImages)) {
            return false;
        }
        ProductImages other = (ProductImages) object;
        if ((this.productImageId == null && other.productImageId != null) || (this.productImageId != null && !this.productImageId.equals(other.productImageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProductImages[ productImageId=" + productImageId + " ]";
    }
    
}
