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
@Table(name = "DiscountCodes")
@XmlRootElement

public class DiscountCodes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "DiscountCodeId")
    private Integer discountCodeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DiscountCode")
    private String discountCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DiscountCodePrice")
    private int discountCodePrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DiscountCodeStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date discountCodeStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DiscountCodeEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date discountCodeEndDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DiscountCodeStatus")
    private boolean discountCodeStatus;
    @OneToMany(mappedBy = "discountCodeId", fetch = FetchType.EAGER)
    private Collection<Orders> ordersCollection;

    public DiscountCodes() {
    }

    public DiscountCodes(Integer discountCodeId) {
        this.discountCodeId = discountCodeId;
    }

    public DiscountCodes(Integer discountCodeId, String discountCode, int discountCodePrice, Date discountCodeStartDate, Date discountCodeEndDate, boolean discountCodeStatus) {
        this.discountCodeId = discountCodeId;
        this.discountCode = discountCode;
        this.discountCodePrice = discountCodePrice;
        this.discountCodeStartDate = discountCodeStartDate;
        this.discountCodeEndDate = discountCodeEndDate;
        this.discountCodeStatus = discountCodeStatus;
    }

    public Integer getDiscountCodeId() {
        return discountCodeId;
    }

    public void setDiscountCodeId(Integer discountCodeId) {
        this.discountCodeId = discountCodeId;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public int getDiscountCodePrice() {
        return discountCodePrice;
    }

    public void setDiscountCodePrice(int discountCodePrice) {
        this.discountCodePrice = discountCodePrice;
    }

    public Date getDiscountCodeStartDate() {
        return discountCodeStartDate;
    }

    public void setDiscountCodeStartDate(Date discountCodeStartDate) {
        this.discountCodeStartDate = discountCodeStartDate;
    }

    public Date getDiscountCodeEndDate() {
        return discountCodeEndDate;
    }

    public void setDiscountCodeEndDate(Date discountCodeEndDate) {
        this.discountCodeEndDate = discountCodeEndDate;
    }

    public boolean getDiscountCodeStatus() {
        return discountCodeStatus;
    }

    public void setDiscountCodeStatus(boolean discountCodeStatus) {
        this.discountCodeStatus = discountCodeStatus;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discountCodeId != null ? discountCodeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscountCodes)) {
            return false;
        }
        DiscountCodes other = (DiscountCodes) object;
        if ((this.discountCodeId == null && other.discountCodeId != null) || (this.discountCodeId != null && !this.discountCodeId.equals(other.discountCodeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DiscountCodes[ discountCodeId=" + discountCodeId + " ]";
    }
    
}
