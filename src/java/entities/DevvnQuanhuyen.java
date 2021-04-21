/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "devvn_quanhuyen")
public class DevvnQuanhuyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "maqh")
    private String maqh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "matp", referencedColumnName = "matp")
    @ManyToOne(fetch = FetchType.EAGER)
    private DevvnTinhthanhpho matp;
    @OneToMany(mappedBy = "maqh", fetch = FetchType.EAGER)
    private Collection<DevvnXaphuongthitran> devvnXaphuongthitranCollection;

    public DevvnQuanhuyen() {
    }

    public DevvnQuanhuyen(String maqh) {
        this.maqh = maqh;
    }

    public DevvnQuanhuyen(String maqh, String name, String type) {
        this.maqh = maqh;
        this.name = name;
        this.type = type;
    }

    public String getMaqh() {
        return maqh;
    }

    public void setMaqh(String maqh) {
        this.maqh = maqh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DevvnTinhthanhpho getMatp() {
        return matp;
    }

    public void setMatp(DevvnTinhthanhpho matp) {
        this.matp = matp;
    }

    @XmlTransient
    public Collection<DevvnXaphuongthitran> getDevvnXaphuongthitranCollection() {
        return devvnXaphuongthitranCollection;
    }

    public void setDevvnXaphuongthitranCollection(Collection<DevvnXaphuongthitran> devvnXaphuongthitranCollection) {
        this.devvnXaphuongthitranCollection = devvnXaphuongthitranCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maqh != null ? maqh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DevvnQuanhuyen)) {
            return false;
        }
        DevvnQuanhuyen other = (DevvnQuanhuyen) object;
        if ((this.maqh == null && other.maqh != null) || (this.maqh != null && !this.maqh.equals(other.maqh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DevvnQuanhuyen[ maqh=" + maqh + " ]";
    }
    
}
