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
@Table(name = "COMPLAINTS")
@NamedQueries({
    @NamedQuery(name = "Complaints.findAll", query = "SELECT c FROM Complaints c")
    , @NamedQuery(name = "Complaints.findById", query = "SELECT c FROM Complaints c WHERE c.id = :id")
    , @NamedQuery(name = "Complaints.findByName", query = "SELECT c FROM Complaints c WHERE c.name = :name")
    , @NamedQuery(name = "Complaints.findByRoomno", query = "SELECT c FROM Complaints c WHERE c.roomno = :roomno")
    , @NamedQuery(name = "Complaints.findByStdcomplaint", query = "SELECT c FROM Complaints c WHERE c.stdcomplaint = :stdcomplaint")
    , @NamedQuery(name = "Complaints.findByDate", query = "SELECT c FROM Complaints c WHERE c.date = :date")})
public class Complaints implements Serializable {

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
    @Column(name = "ROOMNO")
    private String roomno;
    @Basic(optional = false)
    @Column(name = "STDCOMPLAINT")
    private String stdcomplaint;
    @Basic(optional = false)
    @Column(name = "DATE")
    private String date;

    public Complaints() {
    }

    public Complaints(String id) {
        this.id = id;
    }

    public Complaints(String id, String name, String roomno, String stdcomplaint, String date) {
        this.id = id;
        this.name = name;
        this.roomno = roomno;
        this.stdcomplaint = stdcomplaint;
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

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        String oldRoomno = this.roomno;
        this.roomno = roomno;
        changeSupport.firePropertyChange("roomno", oldRoomno, roomno);
    }

    public String getStdcomplaint() {
        return stdcomplaint;
    }

    public void setStdcomplaint(String stdcomplaint) {
        String oldStdcomplaint = this.stdcomplaint;
        this.stdcomplaint = stdcomplaint;
        changeSupport.firePropertyChange("stdcomplaint", oldStdcomplaint, stdcomplaint);
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
        if (!(object instanceof Complaints)) {
            return false;
        }
        Complaints other = (Complaints) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Complaints[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
