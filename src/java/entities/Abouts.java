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
@Table(name = "Abouts")
@XmlRootElement

public class Abouts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "AboutId")
    private Integer aboutId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "AboutContent")
    private String aboutContent;
    @Size(max = 50)
    @Column(name = "AboutImage")
    private String aboutImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AboutAddress")
    private String aboutAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AboutStatus")
    private boolean aboutStatus;

    public Abouts() {
    }

    public Abouts(Integer aboutId) {
        this.aboutId = aboutId;
    }

    public Abouts(Integer aboutId, String aboutContent, String aboutAddress, boolean aboutStatus) {
        this.aboutId = aboutId;
        this.aboutContent = aboutContent;
        this.aboutAddress = aboutAddress;
        this.aboutStatus = aboutStatus;
    }

    public Integer getAboutId() {
        return aboutId;
    }

    public void setAboutId(Integer aboutId) {
        this.aboutId = aboutId;
    }

    public String getAboutContent() {
        return aboutContent;
    }

    public void setAboutContent(String aboutContent) {
        this.aboutContent = aboutContent;
    }

    public String getAboutImage() {
        return aboutImage;
    }

    public void setAboutImage(String aboutImage) {
        this.aboutImage = aboutImage;
    }

    public String getAboutAddress() {
        return aboutAddress;
    }

    public void setAboutAddress(String aboutAddress) {
        this.aboutAddress = aboutAddress;
    }

    public boolean getAboutStatus() {
        return aboutStatus;
    }

    public void setAboutStatus(boolean aboutStatus) {
        this.aboutStatus = aboutStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aboutId != null ? aboutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abouts)) {
            return false;
        }
        Abouts other = (Abouts) object;
        if ((this.aboutId == null && other.aboutId != null) || (this.aboutId != null && !this.aboutId.equals(other.aboutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Abouts[ aboutId=" + aboutId + " ]";
    }
    
}
