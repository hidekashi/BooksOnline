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
@Table(name = "Publishers")
@XmlRootElement

public class Publishers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "PublisherId")
    private Integer publisherId;
    @Size(max = 50)
    @Column(name = "PublisherName")
    private String publisherName;
    @Size(max = 1073741823)
    @Column(name = "PublisherAddress")
    private String publisherAddress;
    @Size(max = 25)
    @Column(name = "PublisherPhone")
    private String publisherPhone;
    @Size(max = 50)
    @Column(name = "PublisherEmail")
    private String publisherEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PublisherStatus")
    private boolean publisherStatus;
    @OneToMany(mappedBy = "publisherId", fetch = FetchType.EAGER)
    private Collection<Products> productsCollection;

    public Publishers() {
    }

    public Publishers(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Publishers(Integer publisherId, boolean publisherStatus) {
        this.publisherId = publisherId;
        this.publisherStatus = publisherStatus;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public String getPublisherPhone() {
        return publisherPhone;
    }

    public void setPublisherPhone(String publisherPhone) {
        this.publisherPhone = publisherPhone;
    }

    public String getPublisherEmail() {
        return publisherEmail;
    }

    public void setPublisherEmail(String publisherEmail) {
        this.publisherEmail = publisherEmail;
    }

    public boolean getPublisherStatus() {
        return publisherStatus;
    }

    public void setPublisherStatus(boolean publisherStatus) {
        this.publisherStatus = publisherStatus;
    }

    @XmlTransient
    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publisherId != null ? publisherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publishers)) {
            return false;
        }
        Publishers other = (Publishers) object;
        if ((this.publisherId == null && other.publisherId != null) || (this.publisherId != null && !this.publisherId.equals(other.publisherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Publishers[ publisherId=" + publisherId + " ]";
    }
    
}
