/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hide
 */
@Entity
@Table(name = "News")
@XmlRootElement

public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "NewId")
    private Integer newId;
    @Size(max = 100)
    @Column(name = "NewTitle")
    private String newTitle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NewDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date newDate;
    @Size(max = 50)
    @Column(name = "NewImage")
    private String newImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "NewContent")
    private String newContent;
    @Size(max = 250)
    @Column(name = "NewDescription")
    private String newDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NewStatus")
    private boolean newStatus;
    @JoinColumn(name = "AdminId", referencedColumnName = "AdminId")
    @ManyToOne(optional = false)
    private Admins adminId;
    @JoinColumn(name = "NewsCategoryId", referencedColumnName = "NewsCategoryId")
    @ManyToOne(optional = false)
    private NewsCategories newsCategoryId;

    public News() {
    }

    public News(Integer newId) {
        this.newId = newId;
    }

    public News(Integer newId, Date newDate, String newContent, boolean newStatus) {
        this.newId = newId;
        this.newDate = newDate;
        this.newContent = newContent;
        this.newStatus = newStatus;
    }

    public Integer getNewId() {
        return newId;
    }

    public void setNewId(Integer newId) {
        this.newId = newId;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }

    public String getNewImage() {
        return newImage;
    }

    public void setNewImage(String newImage) {
        this.newImage = newImage;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public boolean getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(boolean newStatus) {
        this.newStatus = newStatus;
    }

    public Admins getAdminId() {
        return adminId;
    }

    public void setAdminId(Admins adminId) {
        this.adminId = adminId;
    }

    public NewsCategories getNewsCategoryId() {
        return newsCategoryId;
    }

    public void setNewsCategoryId(NewsCategories newsCategoryId) {
        this.newsCategoryId = newsCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newId != null ? newId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newId == null && other.newId != null) || (this.newId != null && !this.newId.equals(other.newId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.News[ newId=" + newId + " ]";
    }
    
}
