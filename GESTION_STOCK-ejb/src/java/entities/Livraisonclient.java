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
 @NamedQueries({@javax.persistence.NamedQuery(name="Livraisonclient.findAll", query="SELECT l FROM Livraisonclient l"), @javax.persistence.NamedQuery(name="Livraisonclient.findByIdlivraisonclient", query="SELECT l FROM Livraisonclient l WHERE l.idlivraisonclient = :idlivraisonclient"), @javax.persistence.NamedQuery(name="Livraisonclient.findByLivraisondirecte", query="SELECT l FROM Livraisonclient l WHERE l.livraisondirecte = :livraisondirecte"), @javax.persistence.NamedQuery(name="Livraisonclient.findByMontant", query="SELECT l FROM Livraisonclient l WHERE l.montant = :montant"), @javax.persistence.NamedQuery(name="Livraisonclient.findByCode", query="SELECT l FROM Livraisonclient l WHERE l.code = :code"), @javax.persistence.NamedQuery(name="Livraisonclient.findByDatelivraison", query="SELECT l FROM Livraisonclient l WHERE l.datelivraison = :datelivraison")})
 public class Livraisonclient
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idlivraisonclient;
   private Boolean livraisondirecte;
   private Double montant;
 
   @Size(max=40)
   private String code;
 
   @Temporal(TemporalType.DATE)
   private Date datelivraison;
 
   @JoinColumn(name="iddemande", referencedColumnName="iddemande")
   @ManyToOne(fetch=FetchType.LAZY)
   private Demande iddemande;
 
   @JoinColumn(name="idmagasin", referencedColumnName="idmagasin")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasin idmagasin;
 
   @JoinColumn(name="idmvtstock", referencedColumnName="idmvtstock")
   @ManyToOne(fetch=FetchType.LAZY)
   private Mvtstock idmvtstock;
 
   @JoinColumn(name="idpersonnel", referencedColumnName="idpersonnel")
   @ManyToOne(fetch=FetchType.LAZY)
   private Personnel idpersonnel;
 
   @OneToMany(mappedBy="idlivraisonclient", fetch=FetchType.LAZY)
   private List<Lignelivraisonclient> lignelivraisonclientList;
 
   public Livraisonclient()
   {
   }
 
   public Livraisonclient(Long idlivraisonclient)
   {
/*  72 */     this.idlivraisonclient = idlivraisonclient;
   }
 
   public Long getIdlivraisonclient() {
/*  76 */     return this.idlivraisonclient;
   }
 
   public void setIdlivraisonclient(Long idlivraisonclient) {
/*  80 */     this.idlivraisonclient = idlivraisonclient;
   }
 
   public Boolean getLivraisondirecte() {
/*  84 */     return this.livraisondirecte;
   }
 
   public void setLivraisondirecte(Boolean livraisondirecte) {
/*  88 */     this.livraisondirecte = livraisondirecte;
   }
 
   public Double getMontant() {
/*  92 */     return this.montant;
   }
 
   public void setMontant(Double montant) {
/*  96 */     this.montant = montant;
   }
 
   public String getCode() {
/* 100 */     return this.code;
   }
 
   public void setCode(String code) {
/* 104 */     this.code = code;
   }
 
   public Date getDatelivraison() {
/* 108 */     return this.datelivraison;
   }
 
   public void setDatelivraison(Date datelivraison) {
/* 112 */     this.datelivraison = datelivraison;
   }
 
   public Demande getIddemande() {
/* 116 */     return this.iddemande;
   }
 
   public void setIddemande(Demande iddemande) {
/* 120 */     this.iddemande = iddemande;
   }
 
   public Magasin getIdmagasin() {
/* 124 */     return this.idmagasin;
   }
 
   public void setIdmagasin(Magasin idmagasin) {
/* 128 */     this.idmagasin = idmagasin;
   }
 
   public Mvtstock getIdmvtstock() {
/* 132 */     return this.idmvtstock;
   }
 
   public void setIdmvtstock(Mvtstock idmvtstock) {
/* 136 */     this.idmvtstock = idmvtstock;
   }
 
   public Personnel getIdpersonnel() {
/* 140 */     return this.idpersonnel;
   }
 
   public void setIdpersonnel(Personnel idpersonnel) {
/* 144 */     this.idpersonnel = idpersonnel;
   }
 
   @XmlTransient
   public List<Lignelivraisonclient> getLignelivraisonclientList() {
/* 149 */     return this.lignelivraisonclientList;
   }
 
   public void setLignelivraisonclientList(List<Lignelivraisonclient> lignelivraisonclientList) {
/* 153 */     this.lignelivraisonclientList = lignelivraisonclientList;
   }
 
   public int hashCode()
   {
/* 158 */     int hash = 0;
/* 159 */     hash += (this.idlivraisonclient != null ? this.idlivraisonclient.hashCode() : 0);
/* 160 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 166 */     if (!(object instanceof Livraisonclient)) {
/* 167 */       return false;
     }
/* 169 */     Livraisonclient other = (Livraisonclient)object;
/* 170 */     if (((this.idlivraisonclient == null) && (other.idlivraisonclient != null)) || ((this.idlivraisonclient != null) && (!this.idlivraisonclient.equals(other.idlivraisonclient)))) {
/* 171 */       return false;
     }
/* 173 */     return true;
   }
 
   public String toString()
   {
/* 178 */     return "entities.Livraisonclient[ idlivraisonclient=" + this.idlivraisonclient + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Livraisonclient
 * JD-Core Version:    0.6.2
 */