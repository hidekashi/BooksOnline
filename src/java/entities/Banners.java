/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hide
 */
@Entity
@Table(name = "Banners")
@XmlRootElement

public class Banners implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "BannerId")
    private Integer bannerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BannerName")
    private String bannerName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BannerStatus")
    private boolean bannerStatus;
    @OneToMany(mappedBy = "bannerId", fetch = FetchType.EAGER)
    private Collection<BannerDetails> bannerDetailsCollection;

    public Banners() {
    }

    public Banners(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public Banners(Integer bannerId, String bannerName, boolean bannerStatus) {
        this.bannerId = bannerId;
        this.bannerName = bannerName;
        this.bannerStatus = bannerStatus;
    }

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public boolean getBannerStatus() {
        return bannerStatus;
    }

    public void setBannerStatus(boolean bannerStatus) {
        this.bannerStatus = bannerStatus;
    }

    @XmlTransient
    public Collection<BannerDetails> getBannerDetailsCollection() {
        return bannerDetailsCollection;
    }

    public void setBannerDetailsCollection(Collection<BannerDetails> bannerDetailsCollection) {
        this.bannerDetailsCollection = bannerDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bannerId != null ? bannerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banners)) {
            return false;
        }
        Banners other = (Banners) object;
        if ((this.bannerId == null && other.bannerId != null) || (this.bannerId != null && !this.bannerId.equals(other.bannerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Banners[ bannerId=" + bannerId + " ]";
    }
    
}
