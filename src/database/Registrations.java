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
@Table(name = "REGISTRATIONS")
@NamedQueries({
    @NamedQuery(name = "Registrations.findAll", query = "SELECT r FROM Registrations r")
    , @NamedQuery(name = "Registrations.findById", query = "SELECT r FROM Registrations r WHERE r.id = :id")
    , @NamedQuery(name = "Registrations.findByPassword", query = "SELECT r FROM Registrations r WHERE r.password = :password")
    , @NamedQuery(name = "Registrations.findByName", query = "SELECT r FROM Registrations r WHERE r.name = :name")
    , @NamedQuery(name = "Registrations.findByRoomno", query = "SELECT r FROM Registrations r WHERE r.roomno = :roomno")
    , @NamedQuery(name = "Registrations.findByFathersname", query = "SELECT r FROM Registrations r WHERE r.fathersname = :fathersname")
    , @NamedQuery(name = "Registrations.findByAddress", query = "SELECT r FROM Registrations r WHERE r.address = :address")
    , @NamedQuery(name = "Registrations.findByLguardian", query = "SELECT r FROM Registrations r WHERE r.lguardian = :lguardian")
    , @NamedQuery(name = "Registrations.findByPhoneno", query = "SELECT r FROM Registrations r WHERE r.phoneno = :phoneno")})
public class Registrations implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "ROOMNO")
    private String roomno;
    @Basic(optional = false)
    @Column(name = "FATHERSNAME")
    private String fathersname;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @Column(name = "LGUARDIAN")
    private String lguardian;
    @Basic(optional = false)
    @Column(name = "PHONENO")
    private String phoneno;

    public Registrations() {
    }

    public Registrations(String id) {
        this.id = id;
    }

    public Registrations(String id, String password, String name, String roomno, String fathersname, String address, String lguardian, String phoneno) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.roomno = roomno;
        this.fathersname = fathersname;
        this.address = address;
        this.lguardian = lguardian;
        this.phoneno = phoneno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        String oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        String oldRoomno = this.roomno;
        this.roomno = roomno;
        changeSupport.firePropertyChange("roomno", oldRoomno, roomno);
    }

    public String getFathersname() {
        return fathersname;
    }

    public void setFathersname(String fathersname) {
        String oldFathersname = this.fathersname;
        this.fathersname = fathersname;
        changeSupport.firePropertyChange("fathersname", oldFathersname, fathersname);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getLguardian() {
        return lguardian;
    }

    public void setLguardian(String lguardian) {
        String oldLguardian = this.lguardian;
        this.lguardian = lguardian;
        changeSupport.firePropertyChange("lguardian", oldLguardian, lguardian);
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        String oldPhoneno = this.phoneno;
        this.phoneno = phoneno;
        changeSupport.firePropertyChange("phoneno", oldPhoneno, phoneno);
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
        if (!(object instanceof Registrations)) {
            return false;
        }
        Registrations other = (Registrations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Registrations[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
