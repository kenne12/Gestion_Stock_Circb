package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Demande.findAll", query = "SELECT d FROM Demande d"),
    @javax.persistence.NamedQuery(name = "Demande.findByIddemande", query = "SELECT d FROM Demande d WHERE d.iddemande = :iddemande"),
    @javax.persistence.NamedQuery(name = "Demande.findByCode", query = "SELECT d FROM Demande d WHERE d.code = :code"),
    @javax.persistence.NamedQuery(name = "Demande.findByDatedemande", query = "SELECT d FROM Demande d WHERE d.datedemande = :datedemande"),
    @javax.persistence.NamedQuery(name = "Demande.findByDateprevlivraison", query = "SELECT d FROM Demande d WHERE d.dateprevlivraison = :dateprevlivraison"),
    @javax.persistence.NamedQuery(name = "Demande.findByDateeffectlivraison", query = "SELECT d FROM Demande d WHERE d.dateeffectlivraison = :dateeffectlivraison"),
    @javax.persistence.NamedQuery(name = "Demande.findByMontant", query = "SELECT d FROM Demande d WHERE d.montant = :montant"),
    @javax.persistence.NamedQuery(name = "Demande.findByTauxsatisfaction", query = "SELECT d FROM Demande d WHERE d.tauxsatisfaction = :tauxsatisfaction"),
    @javax.persistence.NamedQuery(name = "Demande.findByValidee", query = "SELECT d FROM Demande d WHERE d.validee = :validee")})
public class Demande implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    private Long iddemande;

    @Size(max = 35)
    private String code;

    @Temporal(TemporalType.DATE)
    private Date datedemande;

    @Temporal(TemporalType.DATE)
    private Date dateprevlivraison;

    @Temporal(TemporalType.DATE)
    private Date dateeffectlivraison;
    private Double montant;
    private Double tauxsatisfaction;
    private Boolean validee;
    private String motif;

    @JoinColumn(name = "idpersonnel", referencedColumnName = "idpersonnel")
    @ManyToOne(fetch = FetchType.LAZY)
    private Personnel idpersonnel;

    @JoinColumn(name = "idprojet", referencedColumnName = "idprojet")
    @ManyToOne(fetch = FetchType.LAZY)
    private Projet idprojet;

    @OneToMany(mappedBy = "iddemande", fetch = FetchType.LAZY)
    private List<Lignedemande> lignedemandeList;

    @OneToMany(mappedBy = "iddemande", fetch = FetchType.LAZY)
    private List<Livraisonclient> livraisonclientList;

    public Demande() {
    }

    public Demande(Long iddemande) {
        /*  76 */ this.iddemande = iddemande;
    }

    public Long getIddemande() {
        /*  80 */ return this.iddemande;
    }

    public void setIddemande(Long iddemande) {
        /*  84 */ this.iddemande = iddemande;
    }

    public String getCode() {
        /*  88 */ return this.code;
    }

    public void setCode(String code) {
        /*  92 */ this.code = code;
    }

    public Date getDatedemande() {
        /*  96 */ return this.datedemande;
    }

    public void setDatedemande(Date datedemande) {
        /* 100 */ this.datedemande = datedemande;
    }

    public Date getDateprevlivraison() {
        /* 104 */ return this.dateprevlivraison;
    }

    public void setDateprevlivraison(Date dateprevlivraison) {
        /* 108 */ this.dateprevlivraison = dateprevlivraison;
    }

    public Date getDateeffectlivraison() {
        /* 112 */ return this.dateeffectlivraison;
    }

    public void setDateeffectlivraison(Date dateeffectlivraison) {
        /* 116 */ this.dateeffectlivraison = dateeffectlivraison;
    }

    public Double getMontant() {
        /* 120 */ return this.montant;
    }

    public void setMontant(Double montant) {
        /* 124 */ this.montant = montant;
    }

    public Double getTauxsatisfaction() {
        /* 128 */ return this.tauxsatisfaction;
    }

    public void setTauxsatisfaction(Double tauxsatisfaction) {
        /* 132 */ this.tauxsatisfaction = tauxsatisfaction;
    }

    public Boolean getValidee() {
        /* 136 */ return this.validee;
    }

    public void setValidee(Boolean validee) {
        /* 140 */ this.validee = validee;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Personnel getIdpersonnel() {
        /* 144 */ return this.idpersonnel;
    }

    public void setIdpersonnel(Personnel idpersonnel) {
        /* 148 */ this.idpersonnel = idpersonnel;
    }

    public Projet getIdprojet() {
        /* 152 */ return this.idprojet;
    }

    public void setIdprojet(Projet idprojet) {
        /* 156 */ this.idprojet = idprojet;
    }

    @XmlTransient
    public List<Lignedemande> getLignedemandeList() {
        /* 161 */ return this.lignedemandeList;
    }

    public void setLignedemandeList(List<Lignedemande> lignedemandeList) {
        /* 165 */ this.lignedemandeList = lignedemandeList;
    }

    @XmlTransient
    public List<Livraisonclient> getLivraisonclientList() {
        /* 170 */ return this.livraisonclientList;
    }

    public void setLivraisonclientList(List<Livraisonclient> livraisonclientList) {
        /* 174 */ this.livraisonclientList = livraisonclientList;
    }

    public int hashCode() {
        /* 179 */ int hash = 0;
        /* 180 */ hash += (this.iddemande != null ? this.iddemande.hashCode() : 0);
        /* 181 */ return hash;
    }

    public boolean equals(Object object) {
        /* 187 */ if (!(object instanceof Demande)) {
            /* 188 */ return false;
        }
        /* 190 */ Demande other = (Demande) object;
        /* 191 */ if (((this.iddemande == null) && (other.iddemande != null)) || ((this.iddemande != null) && (!this.iddemande.equals(other.iddemande)))) {
            /* 192 */ return false;
        }
        /* 194 */ return true;
    }

    public String toString() {
        /* 199 */ return "entities.Demande[ iddemande=" + this.iddemande + " ]";
    }
}
