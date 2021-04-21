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
@Table(name = "NewsCategories")
@XmlRootElement

public class NewsCategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "NewsCategoryId")
    private Integer newsCategoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NewsCategoryName")
    private String newsCategoryName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NewsCategoryStatus")
    private boolean newsCategoryStatus;
    @OneToMany(mappedBy = "newsCategoryId", fetch = FetchType.EAGER)
    private Collection<News> newsCollection;

    public NewsCategories() {
    }

    public NewsCategories(Integer newsCategoryId) {
        this.newsCategoryId = newsCategoryId;
    }

    public NewsCategories(Integer newsCategoryId, String newsCategoryName, boolean newsCategoryStatus) {
        this.newsCategoryId = newsCategoryId;
        this.newsCategoryName = newsCategoryName;
        this.newsCategoryStatus = newsCategoryStatus;
    }

    public Integer getNewsCategoryId() {
        return newsCategoryId;
    }

    public void setNewsCategoryId(Integer newsCategoryId) {
        this.newsCategoryId = newsCategoryId;
    }

    public String getNewsCategoryName() {
        return newsCategoryName;
    }

    public void setNewsCategoryName(String newsCategoryName) {
        this.newsCategoryName = newsCategoryName;
    }

    public boolean getNewsCategoryStatus() {
        return newsCategoryStatus;
    }

    public void setNewsCategoryStatus(boolean newsCategoryStatus) {
        this.newsCategoryStatus = newsCategoryStatus;
    }

    @XmlTransient
    public Collection<News> getNewsCollection() {
        return newsCollection;
    }

    public void setNewsCollection(Collection<News> newsCollection) {
        this.newsCollection = newsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsCategoryId != null ? newsCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewsCategories)) {
            return false;
        }
        NewsCategories other = (NewsCategories) object;
        if ((this.newsCategoryId == null && other.newsCategoryId != null) || (this.newsCategoryId != null && !this.newsCategoryId.equals(other.newsCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NewsCategories[ newsCategoryId=" + newsCategoryId + " ]";
    }
    
}
