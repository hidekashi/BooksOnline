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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hide
 */
@Entity
@Table(name = "BannerDetails")
@XmlRootElement

public class BannerDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer bannerDetailId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BannerDetailStatus")
    private boolean bannerDetailStatus;
    @JoinColumn(name = "BannerId", referencedColumnName = "BannerId")
    @ManyToOne(optional = false)
    private Banners bannerId;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne(optional = false)
    private Products productId;
    @JoinColumn(name = "PromotionId", referencedColumnName = "PromotionId")
    @ManyToOne(optional = false)
    private Promotions promotionId;

    public BannerDetails() {
    }

    public BannerDetails(Integer bannerDetailId) {
        this.bannerDetailId = bannerDetailId;
    }

    public BannerDetails(Integer bannerDetailId, boolean bannerDetailStatus) {
        this.bannerDetailId = bannerDetailId;
        this.bannerDetailStatus = bannerDetailStatus;
    }

    public Integer getBannerDetailId() {
        return bannerDetailId;
    }

    public void setBannerDetailId(Integer bannerDetailId) {
        this.bannerDetailId = bannerDetailId;
    }

    public boolean getBannerDetailStatus() {
        return bannerDetailStatus;
    }

    public void setBannerDetailStatus(boolean bannerDetailStatus) {
        this.bannerDetailStatus = bannerDetailStatus;
    }

    public Banners getBannerId() {
        return bannerId;
    }

    public void setBannerId(Banners bannerId) {
        this.bannerId = bannerId;
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
        hash += (bannerDetailId != null ? bannerDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BannerDetails)) {
            return false;
        }
        BannerDetails other = (BannerDetails) object;
        if ((this.bannerDetailId == null && other.bannerDetailId != null) || (this.bannerDetailId != null && !this.bannerDetailId.equals(other.bannerDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BannerDetails[ bannerDetailId=" + bannerDetailId + " ]";
    }
    
}
