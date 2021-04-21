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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hide
 */
@Entity
@Table(name = "SocialNetworks")
@XmlRootElement

public class SocialNetworks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "SocialNetorkId")
    private Integer socialNetorkId;
    @Size(max = 50)
    @Column(name = "SocialNetworkName")
    private String socialNetworkName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SocialNetworkLink")
    private String socialNetworkLink;
    @Size(max = 50)
    @Column(name = "SocialNetworkIcon")
    private String socialNetworkIcon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SocialNetworkStatus")
    private boolean socialNetworkStatus;

    public SocialNetworks() {
    }

    public SocialNetworks(Integer socialNetorkId) {
        this.socialNetorkId = socialNetorkId;
    }

    public SocialNetworks(Integer socialNetorkId, String socialNetworkLink, boolean socialNetworkStatus) {
        this.socialNetorkId = socialNetorkId;
        this.socialNetworkLink = socialNetworkLink;
        this.socialNetworkStatus = socialNetworkStatus;
    }

    public Integer getSocialNetorkId() {
        return socialNetorkId;
    }

    public void setSocialNetorkId(Integer socialNetorkId) {
        this.socialNetorkId = socialNetorkId;
    }

    public String getSocialNetworkName() {
        return socialNetworkName;
    }

    public void setSocialNetworkName(String socialNetworkName) {
        this.socialNetworkName = socialNetworkName;
    }

    public String getSocialNetworkLink() {
        return socialNetworkLink;
    }

    public void setSocialNetworkLink(String socialNetworkLink) {
        this.socialNetworkLink = socialNetworkLink;
    }

    public String getSocialNetworkIcon() {
        return socialNetworkIcon;
    }

    public void setSocialNetworkIcon(String socialNetworkIcon) {
        this.socialNetworkIcon = socialNetworkIcon;
    }

    public boolean getSocialNetworkStatus() {
        return socialNetworkStatus;
    }

    public void setSocialNetworkStatus(boolean socialNetworkStatus) {
        this.socialNetworkStatus = socialNetworkStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (socialNetorkId != null ? socialNetorkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SocialNetworks)) {
            return false;
        }
        SocialNetworks other = (SocialNetworks) object;
        if ((this.socialNetorkId == null && other.socialNetorkId != null) || (this.socialNetorkId != null && !this.socialNetorkId.equals(other.socialNetorkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SocialNetworks[ socialNetorkId=" + socialNetorkId + " ]";
    }
    
}
