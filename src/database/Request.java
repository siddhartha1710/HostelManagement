/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Siddhartha
 */
@Entity
@Table(name = "REQUEST")
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r")
    , @NamedQuery(name = "Request.findById", query = "SELECT r FROM Request r WHERE r.id = :id")
    , @NamedQuery(name = "Request.findByName", query = "SELECT r FROM Request r WHERE r.name = :name")
    , @NamedQuery(name = "Request.findByRnum", query = "SELECT r FROM Request r WHERE r.rnum = :rnum")
    , @NamedQuery(name = "Request.findByStdrequest", query = "SELECT r FROM Request r WHERE r.stdrequest = :stdrequest")
    , @NamedQuery(name = "Request.findByDate", query = "SELECT r FROM Request r WHERE r.date = :date")})
public class Request implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "RNUM")
    private String rnum;
    @Basic(optional = false)
    @Column(name = "STDREQUEST")
    private String stdrequest;
    @Basic(optional = false)
    @Column(name = "DATE")
    private String date;

    public Request() {
    }

    public Request(String id) {
        this.id = id;
    }

    public Request(String id, String name, String rnum, String stdrequest, String date) {
        this.id = id;
        this.name = name;
        this.rnum = rnum;
        this.stdrequest = stdrequest;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        String oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getRnum() {
        return rnum;
    }

    public void setRnum(String rnum) {
        String oldRnum = this.rnum;
        this.rnum = rnum;
        changeSupport.firePropertyChange("rnum", oldRnum, rnum);
    }

    public String getStdrequest() {
        return stdrequest;
    }

    public void setStdrequest(String stdrequest) {
        String oldStdrequest = this.stdrequest;
        this.stdrequest = stdrequest;
        changeSupport.firePropertyChange("stdrequest", oldStdrequest, stdrequest);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        String oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Request[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
