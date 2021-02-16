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
 @NamedQueries({@javax.persistence.NamedQuery(name="Commandefournisseur.findAll", query="SELECT c FROM Commandefournisseur c"), @javax.persistence.NamedQuery(name="Commandefournisseur.findByIdcommandefournisseur", query="SELECT c FROM Commandefournisseur c WHERE c.idcommandefournisseur = :idcommandefournisseur"), @javax.persistence.NamedQuery(name="Commandefournisseur.findByMontant", query="SELECT c FROM Commandefournisseur c WHERE c.montant = :montant"), @javax.persistence.NamedQuery(name="Commandefournisseur.findByDateprevlivrasion", query="SELECT c FROM Commandefournisseur c WHERE c.dateprevlivrasion = :dateprevlivrasion"), @javax.persistence.NamedQuery(name="Commandefournisseur.findByDateeffectlivraison", query="SELECT c FROM Commandefournisseur c WHERE c.dateeffectlivraison = :dateeffectlivraison"), @javax.persistence.NamedQuery(name="Commandefournisseur.findByLivre", query="SELECT c FROM Commandefournisseur c WHERE c.livre = :livre"), @javax.persistence.NamedQuery(name="Commandefournisseur.findByCode", query="SELECT c FROM Commandefournisseur c WHERE c.code = :code"), @javax.persistence.NamedQuery(name="Commandefournisseur.findByDatecommande", query="SELECT c FROM Commandefournisseur c WHERE c.datecommande = :datecommande"), @javax.persistence.NamedQuery(name="Commandefournisseur.findByPaye", query="SELECT c FROM Commandefournisseur c WHERE c.paye = :paye"), @javax.persistence.NamedQuery(name="Commandefournisseur.findByTauxsatisfaction", query="SELECT c FROM Commandefournisseur c WHERE c.tauxsatisfaction = :tauxsatisfaction")})
 public class Commandefournisseur
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idcommandefournisseur;
   private Double montant;
 
   @Temporal(TemporalType.DATE)
   private Date dateprevlivrasion;
 
   @Temporal(TemporalType.DATE)
   private Date dateeffectlivraison;
   private Boolean livre;
 
   @Size(max=254)
   private String code;
 
   @Temporal(TemporalType.DATE)
   private Date datecommande;
   private Boolean paye;
   private Double tauxsatisfaction;
 
   @OneToMany(mappedBy="idcommandefournisseur", fetch=FetchType.LAZY)
   private List<Livraisonfournisseur> livraisonfournisseurList;
 
   @OneToMany(mappedBy="idcommandefournisseur", fetch=FetchType.LAZY)
   private List<Lignecommandefournisseur> lignecommandefournisseurList;
 
   @JoinColumn(name="idfournisseur", referencedColumnName="idfournisseur")
   @ManyToOne(fetch=FetchType.LAZY)
   private Fournisseur idfournisseur;
 
   public Commandefournisseur()
   {
   }
 
   public Commandefournisseur(Long idcommandefournisseur)
   {
/*  75 */     this.idcommandefournisseur = idcommandefournisseur;
   }
 
   public Long getIdcommandefournisseur() {
/*  79 */     return this.idcommandefournisseur;
   }
 
   public void setIdcommandefournisseur(Long idcommandefournisseur) {
/*  83 */     this.idcommandefournisseur = idcommandefournisseur;
   }
 
   public Double getMontant() {
/*  87 */     return this.montant;
   }
 
   public void setMontant(Double montant) {
/*  91 */     this.montant = montant;
   }
 
   public Date getDateprevlivrasion() {
/*  95 */     return this.dateprevlivrasion;
   }
 
   public void setDateprevlivrasion(Date dateprevlivrasion) {
/*  99 */     this.dateprevlivrasion = dateprevlivrasion;
   }
 
   public Date getDateeffectlivraison() {
/* 103 */     return this.dateeffectlivraison;
   }
 
   public void setDateeffectlivraison(Date dateeffectlivraison) {
/* 107 */     this.dateeffectlivraison = dateeffectlivraison;
   }
 
   public Boolean getLivre() {
/* 111 */     return this.livre;
   }
 
   public void setLivre(Boolean livre) {
/* 115 */     this.livre = livre;
   }
 
   public String getCode() {
/* 119 */     return this.code;
   }
 
   public void setCode(String code) {
/* 123 */     this.code = code;
   }
 
   public Date getDatecommande() {
/* 127 */     return this.datecommande;
   }
 
   public void setDatecommande(Date datecommande) {
/* 131 */     this.datecommande = datecommande;
   }
 
   public Boolean getPaye() {
/* 135 */     return this.paye;
   }
 
   public void setPaye(Boolean paye) {
/* 139 */     this.paye = paye;
   }
 
   public Double getTauxsatisfaction() {
/* 143 */     return this.tauxsatisfaction;
   }
 
   public void setTauxsatisfaction(Double tauxsatisfaction) {
/* 147 */     this.tauxsatisfaction = tauxsatisfaction;
   }
 
   @XmlTransient
   public List<Livraisonfournisseur> getLivraisonfournisseurList() {
/* 152 */     return this.livraisonfournisseurList;
   }
 
   public void setLivraisonfournisseurList(List<Livraisonfournisseur> livraisonfournisseurList) {
/* 156 */     this.livraisonfournisseurList = livraisonfournisseurList;
   }
 
   @XmlTransient
   public List<Lignecommandefournisseur> getLignecommandefournisseurList() {
/* 161 */     return this.lignecommandefournisseurList;
   }
 
   public void setLignecommandefournisseurList(List<Lignecommandefournisseur> lignecommandefournisseurList) {
/* 165 */     this.lignecommandefournisseurList = lignecommandefournisseurList;
   }
 
   public Fournisseur getIdfournisseur() {
/* 169 */     return this.idfournisseur;
   }
 
   public void setIdfournisseur(Fournisseur idfournisseur) {
/* 173 */     this.idfournisseur = idfournisseur;
   }
 
   public int hashCode()
   {
/* 178 */     int hash = 0;
/* 179 */     hash += (this.idcommandefournisseur != null ? this.idcommandefournisseur.hashCode() : 0);
/* 180 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 186 */     if (!(object instanceof Commandefournisseur)) {
/* 187 */       return false;
     }
/* 189 */     Commandefournisseur other = (Commandefournisseur)object;
/* 190 */     if (((this.idcommandefournisseur == null) && (other.idcommandefournisseur != null)) || ((this.idcommandefournisseur != null) && (!this.idcommandefournisseur.equals(other.idcommandefournisseur)))) {
/* 191 */       return false;
     }
/* 193 */     return true;
   }
 
   public String toString()
   {
/* 198 */     return "entities.Commandefournisseur[ idcommandefournisseur=" + this.idcommandefournisseur + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Commandefournisseur
 * JD-Core Version:    0.6.2
 */