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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a
 */
@Entity
@Table(name = "chef")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chef.findAll", query = "SELECT c FROM Chef c"),
    @NamedQuery(name = "Chef.findByService", query = "SELECT c FROM Chef c WHERE c.chefPK.service = :service"),
    @NamedQuery(name = "Chef.findByEmploye", query = "SELECT c FROM Chef c WHERE c.chefPK.employe = :employe"),
    @NamedQuery(name = "Chef.findByDateDebut", query = "SELECT c FROM Chef c WHERE c.chefPK.dateDebut = :dateDebut"),
    @NamedQuery(name = "Chef.findByDateFin", query = "SELECT c FROM Chef c WHERE c.dateFin = :dateFin")})
public class Chef implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChefPK chefPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @JoinColumn(name = "service", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Service service1;
    @JoinColumn(name = "employe", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Employe employe1;

    public Chef() {
    }

    public Chef(ChefPK chefPK) {
        this.chefPK = chefPK;
    }

    public Chef(ChefPK chefPK, Date dateFin) {
        this.chefPK = chefPK;
        this.dateFin = dateFin;
    }

    public Chef(int service, int employe, Date dateDebut) {
        this.chefPK = new ChefPK(service, employe, dateDebut);
    }

    public ChefPK getChefPK() {
        return chefPK;
    }

    public void setChefPK(ChefPK chefPK) {
        this.chefPK = chefPK;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Service getService1() {
        return service1;
    }

    public void setService1(Service service1) {
        this.service1 = service1;
    }

    public Employe getEmploye1() {
        return employe1;
    }

    public void setEmploye1(Employe employe1) {
        this.employe1 = employe1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chefPK != null ? chefPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chef)) {
            return false;
        }
        Chef other = (Chef) object;
        if ((this.chefPK == null && other.chefPK != null) || (this.chefPK != null && !this.chefPK.equals(other.chefPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Chef[ chefPK=" + chefPK + " ]";
    }
    
}
