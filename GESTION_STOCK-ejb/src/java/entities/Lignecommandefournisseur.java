 package entities;
 
 import java.io.Serializable;
 import java.util.List;
 import javax.persistence.Basic;
 import javax.persistence.Entity;
 import javax.persistence.FetchType;
 import javax.persistence.Id;
 import javax.persistence.JoinColumn;
 import javax.persistence.ManyToOne;
 import javax.persistence.NamedQueries;
 import javax.persistence.OneToMany;
 import javax.validation.constraints.NotNull;
 import javax.xml.bind.annotation.XmlRootElement;
 import javax.xml.bind.annotation.XmlTransient;
 
 @Entity
 @XmlRootElement
 @NamedQueries({@javax.persistence.NamedQuery(name="Lignecommandefournisseur.findAll", query="SELECT l FROM Lignecommandefournisseur l"), @javax.persistence.NamedQuery(name="Lignecommandefournisseur.findByIdlignecommandefournisseur", query="SELECT l FROM Lignecommandefournisseur l WHERE l.idlignecommandefournisseur = :idlignecommandefournisseur"), @javax.persistence.NamedQuery(name="Lignecommandefournisseur.findByMontant", query="SELECT l FROM Lignecommandefournisseur l WHERE l.montant = :montant"), @javax.persistence.NamedQuery(name="Lignecommandefournisseur.findByQuantite", query="SELECT l FROM Lignecommandefournisseur l WHERE l.quantite = :quantite"), @javax.persistence.NamedQuery(name="Lignecommandefournisseur.findByQuantitemultiple", query="SELECT l FROM Lignecommandefournisseur l WHERE l.quantitemultiple = :quantitemultiple"), @javax.persistence.NamedQuery(name="Lignecommandefournisseur.findByUnite", query="SELECT l FROM Lignecommandefournisseur l WHERE l.unite = :unite"), @javax.persistence.NamedQuery(name="Lignecommandefournisseur.findByQuantitereduite", query="SELECT l FROM Lignecommandefournisseur l WHERE l.quantitereduite = :quantitereduite")})
 public class Lignecommandefournisseur
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idlignecommandefournisseur;
   private Double montant;
   private Double quantite;
   private Double quantitemultiple;
   private Double unite;
   private Double quantitereduite;
 
   @JoinColumn(name="idarticle", referencedColumnName="idarticle")
   @ManyToOne(fetch=FetchType.LAZY)
   private Article idarticle;
 
   @JoinColumn(name="idcommandefournisseur", referencedColumnName="idcommandefournisseur")
   @ManyToOne(fetch=FetchType.LAZY)
   private Commandefournisseur idcommandefournisseur;
 
   @JoinColumn(name="idunite", referencedColumnName="idunite")
   @ManyToOne(fetch=FetchType.LAZY)
   private Unite idunite;
 
   @OneToMany(mappedBy="idlignecommandefournisseur", fetch=FetchType.LAZY)
   private List<Lignelivraisonfournisseur> lignelivraisonfournisseurList;
 
   public Lignecommandefournisseur()
   {
   }
 
   public Lignecommandefournisseur(Long idlignecommandefournisseur)
   {
/*  65 */     this.idlignecommandefournisseur = idlignecommandefournisseur;
   }
 
   public Long getIdlignecommandefournisseur() {
/*  69 */     return this.idlignecommandefournisseur;
   }
 
   public void setIdlignecommandefournisseur(Long idlignecommandefournisseur) {
/*  73 */     this.idlignecommandefournisseur = idlignecommandefournisseur;
   }
 
   public Double getMontant() {
/*  77 */     return this.montant;
   }
 
   public void setMontant(Double montant) {
/*  81 */     this.montant = montant;
   }
 
   public Double getQuantite() {
/*  85 */     return this.quantite;
   }
 
   public void setQuantite(Double quantite) {
/*  89 */     this.quantite = quantite;
   }
 
   public Double getQuantitemultiple() {
/*  93 */     return this.quantitemultiple;
   }
 
   public void setQuantitemultiple(Double quantitemultiple) {
/*  97 */     this.quantitemultiple = quantitemultiple;
   }
 
   public Double getUnite() {
/* 101 */     return this.unite;
   }
 
   public void setUnite(Double unite) {
/* 105 */     this.unite = unite;
   }
 
   public Double getQuantitereduite() {
/* 109 */     return this.quantitereduite;
   }
 
   public void setQuantitereduite(Double quantitereduite) {
/* 113 */     this.quantitereduite = quantitereduite;
   }
 
   public Article getIdarticle() {
/* 117 */     return this.idarticle;
   }
 
   public void setIdarticle(Article idarticle) {
/* 121 */     this.idarticle = idarticle;
   }
 
   public Commandefournisseur getIdcommandefournisseur() {
/* 125 */     return this.idcommandefournisseur;
   }
 
   public void setIdcommandefournisseur(Commandefournisseur idcommandefournisseur) {
/* 129 */     this.idcommandefournisseur = idcommandefournisseur;
   }
 
   public Unite getIdunite() {
/* 133 */     return this.idunite;
   }
 
   public void setIdunite(Unite idunite) {
/* 137 */     this.idunite = idunite;
   }
 
   @XmlTransient
   public List<Lignelivraisonfournisseur> getLignelivraisonfournisseurList() {
/* 142 */     return this.lignelivraisonfournisseurList;
   }
 
   public void setLignelivraisonfournisseurList(List<Lignelivraisonfournisseur> lignelivraisonfournisseurList) {
/* 146 */     this.lignelivraisonfournisseurList = lignelivraisonfournisseurList;
   }
 
   public int hashCode()
   {
/* 151 */     int hash = 0;
/* 152 */     hash += (this.idlignecommandefournisseur != null ? this.idlignecommandefournisseur.hashCode() : 0);
/* 153 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 159 */     if (!(object instanceof Lignecommandefournisseur)) {
/* 160 */       return false;
     }
/* 162 */     Lignecommandefournisseur other = (Lignecommandefournisseur)object;
/* 163 */     if (((this.idlignecommandefournisseur == null) && (other.idlignecommandefournisseur != null)) || ((this.idlignecommandefournisseur != null) && (!this.idlignecommandefournisseur.equals(other.idlignecommandefournisseur)))) {
/* 164 */       return false;
     }
/* 166 */     return true;
   }
 
   public String toString()
   {
/* 171 */     return "entities.Lignecommandefournisseur[ idlignecommandefournisseur=" + this.idlignecommandefournisseur + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Lignecommandefournisseur
 * JD-Core Version:    0.6.2
 */