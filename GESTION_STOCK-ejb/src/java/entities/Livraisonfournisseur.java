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
 @NamedQueries({@javax.persistence.NamedQuery(name="Livraisonfournisseur.findAll", query="SELECT l FROM Livraisonfournisseur l"), @javax.persistence.NamedQuery(name="Livraisonfournisseur.findByIdlivraisonfournisseur", query="SELECT l FROM Livraisonfournisseur l WHERE l.idlivraisonfournisseur = :idlivraisonfournisseur"), @javax.persistence.NamedQuery(name="Livraisonfournisseur.findByDatelivraison", query="SELECT l FROM Livraisonfournisseur l WHERE l.datelivraison = :datelivraison"), @javax.persistence.NamedQuery(name="Livraisonfournisseur.findByMontant", query="SELECT l FROM Livraisonfournisseur l WHERE l.montant = :montant"), @javax.persistence.NamedQuery(name="Livraisonfournisseur.findByRepartie", query="SELECT l FROM Livraisonfournisseur l WHERE l.repartie = :repartie"), @javax.persistence.NamedQuery(name="Livraisonfournisseur.findByCode", query="SELECT l FROM Livraisonfournisseur l WHERE l.code = :code"), @javax.persistence.NamedQuery(name="Livraisonfournisseur.findByLivraisondirecte", query="SELECT l FROM Livraisonfournisseur l WHERE l.livraisondirecte = :livraisondirecte")})
 public class Livraisonfournisseur
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idlivraisonfournisseur;
 
   @Temporal(TemporalType.DATE)
   private Date datelivraison;
   private Double montant;
   private Boolean repartie;
 
   @Size(max=254)
   private String code;
   private Boolean livraisondirecte;
 
   @JoinColumn(name="idcommandefournisseur", referencedColumnName="idcommandefournisseur")
   @ManyToOne(fetch=FetchType.LAZY)
   private Commandefournisseur idcommandefournisseur;
 
   @JoinColumn(name="idfournisseur", referencedColumnName="idfournisseur")
   @ManyToOne(fetch=FetchType.LAZY)
   private Fournisseur idfournisseur;
 
   @JoinColumn(name="idmagasin", referencedColumnName="idmagasin")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasin idmagasin;
 
   @JoinColumn(name="idmvtstock", referencedColumnName="idmvtstock")
   @ManyToOne(fetch=FetchType.LAZY)
   private Mvtstock idmvtstock;
 
   @OneToMany(mappedBy="idlivraisonfournisseur", fetch=FetchType.LAZY)
   private List<Lignelivraisonfournisseur> lignelivraisonfournisseurList;
 
   public Livraisonfournisseur()
   {
   }
 
   public Livraisonfournisseur(Long idlivraisonfournisseur)
   {
/*  74 */     this.idlivraisonfournisseur = idlivraisonfournisseur;
   }
 
   public Long getIdlivraisonfournisseur() {
/*  78 */     return this.idlivraisonfournisseur;
   }
 
   public void setIdlivraisonfournisseur(Long idlivraisonfournisseur) {
/*  82 */     this.idlivraisonfournisseur = idlivraisonfournisseur;
   }
 
   public Date getDatelivraison() {
/*  86 */     return this.datelivraison;
   }
 
   public void setDatelivraison(Date datelivraison) {
/*  90 */     this.datelivraison = datelivraison;
   }
 
   public Double getMontant() {
/*  94 */     return this.montant;
   }
 
   public void setMontant(Double montant) {
/*  98 */     this.montant = montant;
   }
 
   public Boolean getRepartie() {
/* 102 */     return this.repartie;
   }
 
   public void setRepartie(Boolean repartie) {
/* 106 */     this.repartie = repartie;
   }
 
   public String getCode() {
/* 110 */     return this.code;
   }
 
   public void setCode(String code) {
/* 114 */     this.code = code;
   }
 
   public Boolean getLivraisondirecte() {
/* 118 */     return this.livraisondirecte;
   }
 
   public void setLivraisondirecte(Boolean livraisondirecte) {
/* 122 */     this.livraisondirecte = livraisondirecte;
   }
 
   public Commandefournisseur getIdcommandefournisseur() {
/* 126 */     return this.idcommandefournisseur;
   }
 
   public void setIdcommandefournisseur(Commandefournisseur idcommandefournisseur) {
/* 130 */     this.idcommandefournisseur = idcommandefournisseur;
   }
 
   public Fournisseur getIdfournisseur() {
/* 134 */     return this.idfournisseur;
   }
 
   public void setIdfournisseur(Fournisseur idfournisseur) {
/* 138 */     this.idfournisseur = idfournisseur;
   }
 
   public Magasin getIdmagasin() {
/* 142 */     return this.idmagasin;
   }
 
   public void setIdmagasin(Magasin idmagasin) {
/* 146 */     this.idmagasin = idmagasin;
   }
 
   public Mvtstock getIdmvtstock() {
/* 150 */     return this.idmvtstock;
   }
 
   public void setIdmvtstock(Mvtstock idmvtstock) {
/* 154 */     this.idmvtstock = idmvtstock;
   }
 
   @XmlTransient
   public List<Lignelivraisonfournisseur> getLignelivraisonfournisseurList() {
/* 159 */     return this.lignelivraisonfournisseurList;
   }
 
   public void setLignelivraisonfournisseurList(List<Lignelivraisonfournisseur> lignelivraisonfournisseurList) {
/* 163 */     this.lignelivraisonfournisseurList = lignelivraisonfournisseurList;
   }
 
   public int hashCode()
   {
/* 168 */     int hash = 0;
/* 169 */     hash += (this.idlivraisonfournisseur != null ? this.idlivraisonfournisseur.hashCode() : 0);
/* 170 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 176 */     if (!(object instanceof Livraisonfournisseur)) {
/* 177 */       return false;
     }
/* 179 */     Livraisonfournisseur other = (Livraisonfournisseur)object;
/* 180 */     if (((this.idlivraisonfournisseur == null) && (other.idlivraisonfournisseur != null)) || ((this.idlivraisonfournisseur != null) && (!this.idlivraisonfournisseur.equals(other.idlivraisonfournisseur)))) {
/* 181 */       return false;
     }
/* 183 */     return true;
   }
 
   public String toString()
   {
/* 188 */     return "entities.Livraisonfournisseur[ idlivraisonfournisseur=" + this.idlivraisonfournisseur + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Livraisonfournisseur
 * JD-Core Version:    0.6.2
 */