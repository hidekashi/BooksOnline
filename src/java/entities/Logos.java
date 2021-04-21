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
@Table(name = "Logos")
@XmlRootElement

public class Logos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "LogoId")
    private Integer logoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LogoName")
    private String logoName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LogoStatus")
    private boolean logoStatus;

    public Logos() {
    }

    public Logos(Integer logoId) {
        this.logoId = logoId;
    }

    public Logos(Integer logoId, String logoName, boolean logoStatus) {
        this.logoId = logoId;
        this.logoName = logoName;
        this.logoStatus = logoStatus;
    }

    public Integer getLogoId() {
        return logoId;
    }

    public void setLogoId(Integer logoId) {
        this.logoId = logoId;
    }

    public String getLogoName() {
        return logoName;
    }

    public void setLogoName(String logoName) {
        this.logoName = logoName;
    }

    public boolean getLogoStatus() {
        return logoStatus;
    }

    public void setLogoStatus(boolean logoStatus) {
        this.logoStatus = logoStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logoId != null ? logoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logos)) {
            return false;
        }
        Logos other = (Logos) object;
        if ((this.logoId == null && other.logoId != null) || (this.logoId != null && !this.logoId.equals(other.logoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Logos[ logoId=" + logoId + " ]";
    }
    
}
