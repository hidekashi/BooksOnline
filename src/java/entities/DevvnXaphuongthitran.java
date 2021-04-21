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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "devvn_xaphuongthitran")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DevvnXaphuongthitran.findAll", query = "SELECT d FROM DevvnXaphuongthitran d")
    , @NamedQuery(name = "DevvnXaphuongthitran.findByXaid", query = "SELECT d FROM DevvnXaphuongthitran d WHERE d.xaid = :xaid")
    , @NamedQuery(name = "DevvnXaphuongthitran.findByName", query = "SELECT d FROM DevvnXaphuongthitran d WHERE d.name = :name")
    , @NamedQuery(name = "DevvnXaphuongthitran.findByType", query = "SELECT d FROM DevvnXaphuongthitran d WHERE d.type = :type")})
public class DevvnXaphuongthitran implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "xaid")
    private String xaid;
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
    @JoinColumn(name = "maqh", referencedColumnName = "maqh")
    @ManyToOne
    private DevvnQuanhuyen maqh;

    public DevvnXaphuongthitran() {
    }

    public DevvnXaphuongthitran(String xaid) {
        this.xaid = xaid;
    }

    public DevvnXaphuongthitran(String xaid, String name, String type) {
        this.xaid = xaid;
        this.name = name;
        this.type = type;
    }

    public String getXaid() {
        return xaid;
    }

    public void setXaid(String xaid) {
        this.xaid = xaid;
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

    public DevvnQuanhuyen getMaqh() {
        return maqh;
    }

    public void setMaqh(DevvnQuanhuyen maqh) {
        this.maqh = maqh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xaid != null ? xaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DevvnXaphuongthitran)) {
            return false;
        }
        DevvnXaphuongthitran other = (DevvnXaphuongthitran) object;
        if ((this.xaid == null && other.xaid != null) || (this.xaid != null && !this.xaid.equals(other.xaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DevvnXaphuongthitran[ xaid=" + xaid + " ]";
    }
    
}
