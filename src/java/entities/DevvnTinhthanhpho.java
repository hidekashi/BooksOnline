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
@Table(name = "devvn_tinhthanhpho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DevvnTinhthanhpho.findAll", query = "SELECT d FROM DevvnTinhthanhpho d")
    , @NamedQuery(name = "DevvnTinhthanhpho.findByMatp", query = "SELECT d FROM DevvnTinhthanhpho d WHERE d.matp = :matp")
    , @NamedQuery(name = "DevvnTinhthanhpho.findByName", query = "SELECT d FROM DevvnTinhthanhpho d WHERE d.name = :name")
    , @NamedQuery(name = "DevvnTinhthanhpho.findByType", query = "SELECT d FROM DevvnTinhthanhpho d WHERE d.type = :type")})
public class DevvnTinhthanhpho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "matp")
    private String matp;
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
    @OneToMany(mappedBy = "matp")
    private Collection<DevvnQuanhuyen> devvnQuanhuyenCollection;

    public DevvnTinhthanhpho() {
    }

    public DevvnTinhthanhpho(String matp) {
        this.matp = matp;
    }

    public DevvnTinhthanhpho(String matp, String name, String type) {
        this.matp = matp;
        this.name = name;
        this.type = type;
    }

    public String getMatp() {
        return matp;
    }

    public void setMatp(String matp) {
        this.matp = matp;
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

    @XmlTransient
    public Collection<DevvnQuanhuyen> getDevvnQuanhuyenCollection() {
        return devvnQuanhuyenCollection;
    }

    public void setDevvnQuanhuyenCollection(Collection<DevvnQuanhuyen> devvnQuanhuyenCollection) {
        this.devvnQuanhuyenCollection = devvnQuanhuyenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matp != null ? matp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DevvnTinhthanhpho)) {
            return false;
        }
        DevvnTinhthanhpho other = (DevvnTinhthanhpho) object;
        if ((this.matp == null && other.matp != null) || (this.matp != null && !this.matp.equals(other.matp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DevvnTinhthanhpho[ matp=" + matp + " ]";
    }
    
}
