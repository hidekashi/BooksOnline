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
@Table(name = "Orders")
@XmlRootElement
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Size(max = 100)
    @Column(name = "OrderSoNha")
    private String orderSoNha;
    @Size(max = 100)
    @Column(name = "OrderXaPhuong")
    private String orderXaPhuong;
    @Size(max = 100)
    @Column(name = "OrderQuanHuyen")
    private String orderQuanHuyen;
    @Size(max = 100)
    @Column(name = "OrderTinhTP")
    private String orderTinhTP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderStatus")
    private boolean orderStatus;
    @JoinColumn(name = "AdminId", referencedColumnName = "AdminId")
    @ManyToOne
    private Admins adminId;
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId")
    @ManyToOne(optional = false)
    private Customers customerId;
    @JoinColumn(name = "DiscountCodeId", referencedColumnName = "DiscountCodeId")
    @ManyToOne
    private DiscountCodes discountCodeId;

    public Orders() {
    }

    public Orders(Integer orderId) {
        this.orderId = orderId;
    }

    public Orders(Integer orderId, Date orderDate, boolean orderStatus) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderSoNha() {
        return orderSoNha;
    }

    public void setOrderSoNha(String orderSoNha) {
        this.orderSoNha = orderSoNha;
    }

    public String getOrderXaPhuong() {
        return orderXaPhuong;
    }

    public void setOrderXaPhuong(String orderXaPhuong) {
        this.orderXaPhuong = orderXaPhuong;
    }

    public String getOrderQuanHuyen() {
        return orderQuanHuyen;
    }

    public void setOrderQuanHuyen(String orderQuanHuyen) {
        this.orderQuanHuyen = orderQuanHuyen;
    }

    public String getOrderTinhTP() {
        return orderTinhTP;
    }

    public void setOrderTinhTP(String orderTinhTP) {
        this.orderTinhTP = orderTinhTP;
    }

    public boolean getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Admins getAdminId() {
        return adminId;
    }

    public void setAdminId(Admins adminId) {
        this.adminId = adminId;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    public DiscountCodes getDiscountCodeId() {
        return discountCodeId;
    }

    public void setDiscountCodeId(DiscountCodes discountCodeId) {
        this.discountCodeId = discountCodeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Orders[ orderId=" + orderId + " ]";
    }
    
}
