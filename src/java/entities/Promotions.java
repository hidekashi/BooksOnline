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
@Table(name = "Promotions")
@XmlRootElement

public class Promotions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "PromotionId")
    private Integer promotionId;
    @Size(max = 100)
    @Column(name = "PromotionName")
    private String promotionName;
    @Size(max = 150)
    @Column(name = "PromotionTitle")
    private String promotionTitle;
    @Size(max = 1073741823)
    @Column(name = "PromotionContent")
    private String promotionContent;
    @Size(max = 100)
    @Column(name = "PromotionImage")
    private String promotionImage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PromotionStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date promotionStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PromotionEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date promotionEndDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PromotionStatus")
    private boolean promotionStatus;
    @OneToMany(mappedBy = "promotionId", fetch = FetchType.EAGER)
    private Collection<BannerDetails> bannerDetailsCollection;
    @OneToMany(mappedBy = "promotionId", fetch = FetchType.EAGER)
    private Collection<PromotionDetails> promotionDetailsCollection;

    public Promotions() {
    }

    public Promotions(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Promotions(Integer promotionId, Date promotionStartDate, Date promotionEndDate, boolean promotionStatus) {
        this.promotionId = promotionId;
        this.promotionStartDate = promotionStartDate;
        this.promotionEndDate = promotionEndDate;
        this.promotionStatus = promotionStatus;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionTitle() {
        return promotionTitle;
    }

    public void setPromotionTitle(String promotionTitle) {
        this.promotionTitle = promotionTitle;
    }

    public String getPromotionContent() {
        return promotionContent;
    }

    public void setPromotionContent(String promotionContent) {
        this.promotionContent = promotionContent;
    }

    public String getPromotionImage() {
        return promotionImage;
    }

    public void setPromotionImage(String promotionImage) {
        this.promotionImage = promotionImage;
    }

    public Date getPromotionStartDate() {
        return promotionStartDate;
    }

    public void setPromotionStartDate(Date promotionStartDate) {
        this.promotionStartDate = promotionStartDate;
    }

    public Date getPromotionEndDate() {
        return promotionEndDate;
    }

    public void setPromotionEndDate(Date promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }

    public boolean getPromotionStatus() {
        return promotionStatus;
    }

    public void setPromotionStatus(boolean promotionStatus) {
        this.promotionStatus = promotionStatus;
    }

    @XmlTransient
    public Collection<BannerDetails> getBannerDetailsCollection() {
        return bannerDetailsCollection;
    }

    public void setBannerDetailsCollection(Collection<BannerDetails> bannerDetailsCollection) {
        this.bannerDetailsCollection = bannerDetailsCollection;
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
        hash += (promotionId != null ? promotionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotions)) {
            return false;
        }
        Promotions other = (Promotions) object;
        if ((this.promotionId == null && other.promotionId != null) || (this.promotionId != null && !this.promotionId.equals(other.promotionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Promotions[ promotionId=" + promotionId + " ]";
    }
    
}
