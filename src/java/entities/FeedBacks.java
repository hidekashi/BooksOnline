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
@Table(name = "FeedBacks")
@XmlRootElement

public class FeedBacks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "FeedBackId")
    private Integer feedBackId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FeedBackName")
    private String feedBackName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FeedBackEmail")
    private String feedBackEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "FeedBackPhone")
    private String feedBackPhone;
    @Size(max = 100)
    @Column(name = "FeedBackProductLink")
    private String feedBackProductLink;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "FeedBackContent")
    private String feedBackContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FeedBackStatus")
    private boolean feedBackStatus;

    public FeedBacks() {
    }

    public FeedBacks(Integer feedBackId) {
        this.feedBackId = feedBackId;
    }

    public FeedBacks(Integer feedBackId, String feedBackName, String feedBackEmail, String feedBackPhone, String feedBackContent, boolean feedBackStatus) {
        this.feedBackId = feedBackId;
        this.feedBackName = feedBackName;
        this.feedBackEmail = feedBackEmail;
        this.feedBackPhone = feedBackPhone;
        this.feedBackContent = feedBackContent;
        this.feedBackStatus = feedBackStatus;
    }

    public Integer getFeedBackId() {
        return feedBackId;
    }

    public void setFeedBackId(Integer feedBackId) {
        this.feedBackId = feedBackId;
    }

    public String getFeedBackName() {
        return feedBackName;
    }

    public void setFeedBackName(String feedBackName) {
        this.feedBackName = feedBackName;
    }

    public String getFeedBackEmail() {
        return feedBackEmail;
    }

    public void setFeedBackEmail(String feedBackEmail) {
        this.feedBackEmail = feedBackEmail;
    }

    public String getFeedBackPhone() {
        return feedBackPhone;
    }

    public void setFeedBackPhone(String feedBackPhone) {
        this.feedBackPhone = feedBackPhone;
    }

    public String getFeedBackProductLink() {
        return feedBackProductLink;
    }

    public void setFeedBackProductLink(String feedBackProductLink) {
        this.feedBackProductLink = feedBackProductLink;
    }

    public String getFeedBackContent() {
        return feedBackContent;
    }

    public void setFeedBackContent(String feedBackContent) {
        this.feedBackContent = feedBackContent;
    }

    public boolean getFeedBackStatus() {
        return feedBackStatus;
    }

    public void setFeedBackStatus(boolean feedBackStatus) {
        this.feedBackStatus = feedBackStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feedBackId != null ? feedBackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FeedBacks)) {
            return false;
        }
        FeedBacks other = (FeedBacks) object;
        if ((this.feedBackId == null && other.feedBackId != null) || (this.feedBackId != null && !this.feedBackId.equals(other.feedBackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FeedBacks[ feedBackId=" + feedBackId + " ]";
    }
    
}
