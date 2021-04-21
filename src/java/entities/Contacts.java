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
@Table(name = "Contacts")
@XmlRootElement

public class Contacts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ContactId")
    private Integer contactId;
    @Size(max = 25)
    @Column(name = "ContactPhone")
    private String contactPhone;
    @Size(max = 50)
    @Column(name = "ContactEmail")
    private String contactEmail;
    @Size(max = 150)
    @Column(name = "ContactAddress")
    private String contactAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ContactStatus")
    private boolean contactStatus;

    public Contacts() {
    }

    public Contacts(Integer contactId) {
        this.contactId = contactId;
    }

    public Contacts(Integer contactId, boolean contactStatus) {
        this.contactId = contactId;
        this.contactStatus = contactStatus;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public boolean getContactStatus() {
        return contactStatus;
    }

    public void setContactStatus(boolean contactStatus) {
        this.contactStatus = contactStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacts)) {
            return false;
        }
        Contacts other = (Contacts) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Contacts[ contactId=" + contactId + " ]";
    }
    
}
