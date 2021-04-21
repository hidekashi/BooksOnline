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
@Table(name = "EmailRegistereds")
@XmlRootElement

public class EmailRegistereds implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "EmailRegisteredId")
    private Integer emailRegisteredId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EmailRegistered")
    private String emailRegistered;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EmailRegisteredStatus")
    private boolean emailRegisteredStatus;

    public EmailRegistereds() {
    }

    public EmailRegistereds(Integer emailRegisteredId) {
        this.emailRegisteredId = emailRegisteredId;
    }

    public EmailRegistereds(Integer emailRegisteredId, String emailRegistered, boolean emailRegisteredStatus) {
        this.emailRegisteredId = emailRegisteredId;
        this.emailRegistered = emailRegistered;
        this.emailRegisteredStatus = emailRegisteredStatus;
    }

    public Integer getEmailRegisteredId() {
        return emailRegisteredId;
    }

    public void setEmailRegisteredId(Integer emailRegisteredId) {
        this.emailRegisteredId = emailRegisteredId;
    }

    public String getEmailRegistered() {
        return emailRegistered;
    }

    public void setEmailRegistered(String emailRegistered) {
        this.emailRegistered = emailRegistered;
    }

    public boolean getEmailRegisteredStatus() {
        return emailRegisteredStatus;
    }

    public void setEmailRegisteredStatus(boolean emailRegisteredStatus) {
        this.emailRegisteredStatus = emailRegisteredStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailRegisteredId != null ? emailRegisteredId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailRegistereds)) {
            return false;
        }
        EmailRegistereds other = (EmailRegistereds) object;
        if ((this.emailRegisteredId == null && other.emailRegisteredId != null) || (this.emailRegisteredId != null && !this.emailRegisteredId.equals(other.emailRegisteredId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EmailRegistereds[ emailRegisteredId=" + emailRegisteredId + " ]";
    }
    
}
