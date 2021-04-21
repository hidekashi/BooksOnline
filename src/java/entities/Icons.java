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
@Table(name = "Icons")
@XmlRootElement

public class Icons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "IconId")
    private Integer iconId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IconName")
    private String iconName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IconStatus")
    private boolean iconStatus;

    public Icons() {
    }

    public Icons(Integer iconId) {
        this.iconId = iconId;
    }

    public Icons(Integer iconId, String iconName, boolean iconStatus) {
        this.iconId = iconId;
        this.iconName = iconName;
        this.iconStatus = iconStatus;
    }

    public Integer getIconId() {
        return iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public boolean getIconStatus() {
        return iconStatus;
    }

    public void setIconStatus(boolean iconStatus) {
        this.iconStatus = iconStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iconId != null ? iconId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Icons)) {
            return false;
        }
        Icons other = (Icons) object;
        if ((this.iconId == null && other.iconId != null) || (this.iconId != null && !this.iconId.equals(other.iconId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Icons[ iconId=" + iconId + " ]";
    }
    
}
