package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
    @javax.persistence.NamedQuery(name = "Mvtstock.findAll", query = "SELECT m FROM Mvtstock m"),
    @javax.persistence.NamedQuery(name = "Mvtstock.findByIdmvtstock", query = "SELECT m FROM Mvtstock m WHERE m.idmvtstock = :idmvtstock"),
    @javax.persistence.NamedQuery(name = "Mvtstock.findByDatemvt", query = "SELECT m FROM Mvtstock m WHERE m.datemvt = :datemvt"),
    @javax.persistence.NamedQuery(name = "Mvtstock.findByOperation", query = "SELECT m FROM Mvtstock m WHERE m.operation = :operation"),
    @javax.persistence.NamedQuery(name = "Mvtstock.findByCode", query = "SELECT m FROM Mvtstock m WHERE m.code = :code"),
    @javax.persistence.NamedQuery(name = "Mvtstock.findByClient", query = "SELECT m FROM Mvtstock m WHERE m.client = :client"),
    @javax.persistence.NamedQuery(name = "Mvtstock.findByFournisseur", query = "SELECT m FROM Mvtstock m WHERE m.fournisseur = :fournisseur"),
    @javax.persistence.NamedQuery(name = "Mvtstock.findByType", query = "SELECT m FROM Mvtstock m WHERE m.type = :type"),
    @javax.persistence.NamedQuery(name = "Mvtstock.findByMagasin", query = "SELECT m FROM Mvtstock m WHERE m.magasin = :magasin")})
public class Mvtstock implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    private Long idmvtstock;

    @Temporal(TemporalType.DATE)
    private Date datemvt;

    @Size(max = 254)
    private String operation;

    @Size(max = 35)
    private String code;

    @Size(max = 70)
    private String client;

    @Size(max = 50)
    private String fournisseur;

    @Size(max = 20)
    private String type;

    @Size(max = 50)
    private String magasin;

    @OneToMany(mappedBy = "idmvtstock", fetch = FetchType.LAZY)
    private List<Repartitionarticle> repartitionarticleList;

    @OneToMany(mappedBy = "idmvtstock", fetch = FetchType.LAZY)
    private List<Livraisonfournisseur> livraisonfournisseurList;

    @OneToMany(mappedBy = "idmvtstock", fetch = FetchType.LAZY)
    private List<Transfert> transfertList;

    @OneToMany(mappedBy = "idmvtstock", fetch = FetchType.LAZY)
    private List<Inventaire> inventaireList;

    @OneToMany(mappedBy = "idmvtstock", fetch = FetchType.LAZY)
    private List<Livraisonclient> livraisonclientList;

    @OneToMany(mappedBy = "idmvtstock", fetch = FetchType.LAZY)
    private List<Lignemvtstock> lignemvtstockList;

    public Mvtstock() {
    }

    public Mvtstock(Long idmvtstock) {
       this.idmvtstock = idmvtstock;
    }

    public Long getIdmvtstock() {
        /*  82 */ return this.idmvtstock;
    }

    public void setIdmvtstock(Long idmvtstock) {
        /*  86 */ this.idmvtstock = idmvtstock;
    }

    public Date getDatemvt() {
        /*  90 */ return this.datemvt;
    }

    public void setDatemvt(Date datemvt) {
        /*  94 */ this.datemvt = datemvt;
    }

    public String getOperation() {
        /*  98 */ return this.operation;
    }

    public void setOperation(String operation) {
        /* 102 */ this.operation = operation;
    }

    public String getCode() {
        /* 106 */ return this.code;
    }

    public void setCode(String code) {
        /* 110 */ this.code = code;
    }

    public String getClient() {
        /* 114 */ return this.client;
    }

    public void setClient(String client) {
        /* 118 */ this.client = client;
    }

    public String getFournisseur() {
        /* 122 */ return this.fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        /* 126 */ this.fournisseur = fournisseur;
    }

    public String getType() {
        /* 130 */ return this.type;
    }

    public void setType(String type) {
        /* 134 */ this.type = type;
    }

    public String getMagasin() {
        /* 138 */ return this.magasin;
    }

    public void setMagasin(String magasin) {
        /* 142 */ this.magasin = magasin;
    }

    @XmlTransient
    public List<Repartitionarticle> getRepartitionarticleList() {
        /* 147 */ return this.repartitionarticleList;
    }

    public void setRepartitionarticleList(List<Repartitionarticle> repartitionarticleList) {
        /* 151 */ this.repartitionarticleList = repartitionarticleList;
    }

    @XmlTransient
    public List<Livraisonfournisseur> getLivraisonfournisseurList() {
        /* 156 */ return this.livraisonfournisseurList;
    }

    public void setLivraisonfournisseurList(List<Livraisonfournisseur> livraisonfournisseurList) {
        /* 160 */ this.livraisonfournisseurList = livraisonfournisseurList;
    }

    @XmlTransient
    public List<Transfert> getTransfertList() {
        /* 165 */ return this.transfertList;
    }

    public void setTransfertList(List<Transfert> transfertList) {
        /* 169 */ this.transfertList = transfertList;
    }

    @XmlTransient
    public List<Inventaire> getInventaireList() {
        /* 174 */ return this.inventaireList;
    }

    public void setInventaireList(List<Inventaire> inventaireList) {
        /* 178 */ this.inventaireList = inventaireList;
    }

    @XmlTransient
    public List<Livraisonclient> getLivraisonclientList() {
        /* 183 */ return this.livraisonclientList;
    }

    public void setLivraisonclientList(List<Livraisonclient> livraisonclientList) {
        /* 187 */ this.livraisonclientList = livraisonclientList;
    }

    @XmlTransient
    public List<Lignemvtstock> getLignemvtstockList() {
        /* 192 */ return this.lignemvtstockList;
    }

    public void setLignemvtstockList(List<Lignemvtstock> lignemvtstockList) {
        /* 196 */ this.lignemvtstockList = lignemvtstockList;
    }

    public int hashCode() {
        /* 201 */ int hash = 0;
        /* 202 */ hash += (this.idmvtstock != null ? this.idmvtstock.hashCode() : 0);
        /* 203 */ return hash;
    }

    public boolean equals(Object object) {
        /* 209 */ if (!(object instanceof Mvtstock)) {
            /* 210 */ return false;
        }
        /* 212 */ Mvtstock other = (Mvtstock) object;
        /* 213 */ if (((this.idmvtstock == null) && (other.idmvtstock != null)) || ((this.idmvtstock != null) && (!this.idmvtstock.equals(other.idmvtstock)))) {
            /* 214 */ return false;
        }
        /* 216 */ return true;
    }

    public String toString() {
        /* 221 */ return "entities.Mvtstock[ idmvtstock=" + this.idmvtstock + " ]";
    }
}
