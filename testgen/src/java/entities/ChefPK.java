/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author a
 */
@Embeddable
public class ChefPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "service")
    private int service;
    @Basic(optional = false)
    @NotNull
    @Column(name = "employe")
    private int employe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateDebut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    public ChefPK() {
    }

    public ChefPK(int service, int employe, Date dateDebut) {
        this.service = service;
        this.employe = employe;
        this.dateDebut = dateDebut;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getEmploye() {
        return employe;
    }

    public void setEmploye(int employe) {
        this.employe = employe;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) service;
        hash += (int) employe;
        hash += (dateDebut != null ? dateDebut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChefPK)) {
            return false;
        }
        ChefPK other = (ChefPK) object;
        if (this.service != other.service) {
            return false;
        }
        if (this.employe != other.employe) {
            return false;
        }
        if ((this.dateDebut == null && other.dateDebut != null) || (this.dateDebut != null && !this.dateDebut.equals(other.dateDebut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ChefPK[ service=" + service + ", employe=" + employe + ", dateDebut=" + dateDebut + " ]";
    }
    
}
