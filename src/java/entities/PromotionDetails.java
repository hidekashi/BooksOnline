/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hide
 */
@Entity
@Table(name = "PromotionDetails")
@XmlRootElement

public class PromotionDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "PromotionDetailId")
    private Integer promotionDetailId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PromotionDetailQuantity")
    private int promotionDetailQuantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PromotionDetailDiscount")
    private int promotionDetailDiscount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PromotionDetailStatus")
    private boolean promotionDetailStatus;
    @OneToMany(mappedBy = "promotionDetailId", fetch = FetchType.EAGER)
    private Collection<OrderDetails> orderDetailsCollection;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne(optional = false)
    private Products productId;
    @JoinColumn(name = "PromotionId", referencedColumnName = "PromotionId")
    @ManyToOne(optional = false)
    private Promotions promotionId;

    public PromotionDetails() {
    }

    public PromotionDetails(Integer promotionDetailId) {
        this.promotionDetailId = promotionDetailId;
    }

    public PromotionDetails(Integer promotionDetailId, int promotionDetailQuantity, int promotionDetailDiscount, boolean promotionDetailStatus) {
        this.promotionDetailId = promotionDetailId;
        this.promotionDetailQuantity = promotionDetailQuantity;
        this.promotionDetailDiscount = promotionDetailDiscount;
        this.promotionDetailStatus = promotionDetailStatus;
    }

    public Integer getPromotionDetailId() {
        return promotionDetailId;
    }

    public void setPromotionDetailId(Integer promotionDetailId) {
        this.promotionDetailId = promotionDetailId;
    }

    public int getPromotionDetailQuantity() {
        return promotionDetailQuantity;
    }

    public void setPromotionDetailQuantity(int promotionDetailQuantity) {
        this.promotionDetailQuantity = promotionDetailQuantity;
    }

    public int getPromotionDetailDiscount() {
        return promotionDetailDiscount;
    }

    public void setPromotionDetailDiscount(int promotionDetailDiscount) {
        this.promotionDetailDiscount = promotionDetailDiscount;
    }

    public boolean getPromotionDetailStatus() {
        return promotionDetailStatus;
    }

    public void setPromotionDetailStatus(boolean promotionDetailStatus) {
        this.promotionDetailStatus = promotionDetailStatus;
    }

    @XmlTransient
    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
    }

    public Promotions getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Promotions promotionId) {
        this.promotionId = promotionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promotionDetailId != null ? promotionDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromotionDetails)) {
            return false;
        }
        PromotionDetails other = (PromotionDetails) object;
        if ((this.promotionDetailId == null && other.promotionDetailId != null) || (this.promotionDetailId != null && !this.promotionDetailId.equals(other.promotionDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PromotionDetails[ promotionDetailId=" + promotionDetailId + " ]";
    }
    
}
