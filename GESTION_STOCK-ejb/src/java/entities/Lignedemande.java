package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Lignedemande.findAll", query = "SELECT l FROM Lignedemande l"),
    @javax.persistence.NamedQuery(name = "Lignedemande.findByIdlignedemande", query = "SELECT l FROM Lignedemande l WHERE l.idlignedemande = :idlignedemande"),
    @javax.persistence.NamedQuery(name = "Lignedemande.findByQuantite", query = "SELECT l FROM Lignedemande l WHERE l.quantite = :quantite"),
    @javax.persistence.NamedQuery(name = "Lignedemande.findByQuantitemultiple", query = "SELECT l FROM Lignedemande l WHERE l.quantitemultiple = :quantitemultiple"),
    @javax.persistence.NamedQuery(name = "Lignedemande.findByUnite", query = "SELECT l FROM Lignedemande l WHERE l.unite = :unite"),
    @javax.persistence.NamedQuery(name = "Lignedemande.findByMontant", query = "SELECT l FROM Lignedemande l WHERE l.montant = :montant"),
    @javax.persistence.NamedQuery(name = "Lignedemande.findByTauxsatisfaction", query = "SELECT l FROM Lignedemande l WHERE l.tauxsatisfaction = :tauxsatisfaction"),
    @javax.persistence.NamedQuery(name = "Lignedemande.findByQuantitereduite", query = "SELECT l FROM Lignedemande l WHERE l.quantitereduite = :quantitereduite")})
public class Lignedemande
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    private Long idlignedemande;
    private Double quantite;
    private Double quantitemultiple;
    private Double unite;
    private Double montant;
    private Double tauxsatisfaction;
    private Double quantitereduite;
    private Double qtestock;

    @JoinColumn(name = "iddemande", referencedColumnName = "iddemande")
    @ManyToOne(fetch = FetchType.LAZY)
    private Demande iddemande;

    @JoinColumn(name = "idmagasinarticle", referencedColumnName = "idmagasinarticle")
    @ManyToOne(fetch = FetchType.LAZY)
    private Magasinarticle idmagasinarticle;

    @JoinColumn(name = "idunite", referencedColumnName = "idunite")
    @ManyToOne(fetch = FetchType.LAZY)
    private Unite idunite;

    public Lignedemande() {
    }

    public Lignedemande(Long idlignedemande) {
        this.idlignedemande = idlignedemande;
    }

    public Long getIdlignedemande() {
        return this.idlignedemande;
    }

    public void setIdlignedemande(Long idlignedemande) {
        this.idlignedemande = idlignedemande;
    }

    public Double getQuantite() {
        return this.quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Double getQuantitemultiple() {
        return this.quantitemultiple;
    }

    public void setQuantitemultiple(Double quantitemultiple) {
        this.quantitemultiple = quantitemultiple;
    }

    public Double getUnite() {
        return this.unite;
    }

    public void setUnite(Double unite) {
        this.unite = unite;
    }

    public Double getMontant() {
        /*  98 */ return this.montant;
    }

    public void setMontant(Double montant) {
        /* 102 */ this.montant = montant;
    }

    public Double getTauxsatisfaction() {
        /* 106 */ return this.tauxsatisfaction;
    }

    public void setTauxsatisfaction(Double tauxsatisfaction) {
        /* 110 */ this.tauxsatisfaction = tauxsatisfaction;
    }

    public Double getQuantitereduite() {
        /* 114 */ return this.quantitereduite;
    }

    public void setQuantitereduite(Double quantitereduite) {
        /* 118 */ this.quantitereduite = quantitereduite;
    }

    public Double getQtestock() {
        return qtestock;
    }

    public void setQtestock(Double qtestock) {
        this.qtestock = qtestock;
    }

    public Demande getIddemande() {
        /* 122 */ return this.iddemande;
    }

    public void setIddemande(Demande iddemande) {
        /* 126 */ this.iddemande = iddemande;
    }

    public Magasinarticle getIdmagasinarticle() {
        /* 130 */ return this.idmagasinarticle;
    }

    public void setIdmagasinarticle(Magasinarticle idmagasinarticle) {
        /* 134 */ this.idmagasinarticle = idmagasinarticle;
    }

    public Unite getIdunite() {
        /* 138 */ return this.idunite;
    }

    public void setIdunite(Unite idunite) {
        /* 142 */ this.idunite = idunite;
    }

    public int hashCode() {
        /* 147 */ int hash = 0;
        /* 148 */ hash += (this.idlignedemande != null ? this.idlignedemande.hashCode() : 0);
        /* 149 */ return hash;
    }

    public boolean equals(Object object) {
        /* 155 */ if (!(object instanceof Lignedemande)) {
            /* 156 */ return false;
        }
        /* 158 */ Lignedemande other = (Lignedemande) object;
        /* 159 */ if (((this.idlignedemande == null) && (other.idlignedemande != null)) || ((this.idlignedemande != null) && (!this.idlignedemande.equals(other.idlignedemande)))) {
            /* 160 */ return false;
        }
        /* 162 */ return true;
    }

    public String toString() {
        /* 167 */ return "entities.Lignedemande[ idlignedemande=" + this.idlignedemande + " ]";
    }
}
