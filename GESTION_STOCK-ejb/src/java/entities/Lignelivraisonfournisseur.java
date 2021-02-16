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
 @NamedQueries({@javax.persistence.NamedQuery(name="Lignelivraisonfournisseur.findAll", query="SELECT l FROM Lignelivraisonfournisseur l"), @javax.persistence.NamedQuery(name="Lignelivraisonfournisseur.findByIdlignelivraisonfournisseur", query="SELECT l FROM Lignelivraisonfournisseur l WHERE l.idlignelivraisonfournisseur = :idlignelivraisonfournisseur"), @javax.persistence.NamedQuery(name="Lignelivraisonfournisseur.findByQuantite", query="SELECT l FROM Lignelivraisonfournisseur l WHERE l.quantite = :quantite"), @javax.persistence.NamedQuery(name="Lignelivraisonfournisseur.findByTauxsatisfaction", query="SELECT l FROM Lignelivraisonfournisseur l WHERE l.tauxsatisfaction = :tauxsatisfaction"), @javax.persistence.NamedQuery(name="Lignelivraisonfournisseur.findByQuantitemultiple", query="SELECT l FROM Lignelivraisonfournisseur l WHERE l.quantitemultiple = :quantitemultiple"), @javax.persistence.NamedQuery(name="Lignelivraisonfournisseur.findByUnite", query="SELECT l FROM Lignelivraisonfournisseur l WHERE l.unite = :unite"), @javax.persistence.NamedQuery(name="Lignelivraisonfournisseur.findByPrixachat", query="SELECT l FROM Lignelivraisonfournisseur l WHERE l.prixachat = :prixachat"), @javax.persistence.NamedQuery(name="Lignelivraisonfournisseur.findByQuantitereduite", query="SELECT l FROM Lignelivraisonfournisseur l WHERE l.quantitereduite = :quantitereduite")})
 public class Lignelivraisonfournisseur
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idlignelivraisonfournisseur;
   private Double quantite;
   private Double tauxsatisfaction;
   private Double quantitemultiple;
   private Double unite;
   private Double prixachat;
   private Double quantitereduite;
 
   @JoinColumn(name="idlignecommandefournisseur", referencedColumnName="idlignecommandefournisseur")
   @ManyToOne(fetch=FetchType.LAZY)
   private Lignecommandefournisseur idlignecommandefournisseur;
 
   @JoinColumn(name="idlivraisonfournisseur", referencedColumnName="idlivraisonfournisseur")
   @ManyToOne(fetch=FetchType.LAZY)
   private Livraisonfournisseur idlivraisonfournisseur;
 
   @JoinColumn(name="idlot", referencedColumnName="idlot")
   @ManyToOne(fetch=FetchType.LAZY)
   private Lot idlot;
 
   @JoinColumn(name="idmagasinlot", referencedColumnName="idmagasinlot")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasinlot idmagasinlot;
 
   @JoinColumn(name="idunite", referencedColumnName="idunite")
   @ManyToOne(fetch=FetchType.LAZY)
   private Unite idunite;
 
   public Lignelivraisonfournisseur()
   {
   }
 
   public Lignelivraisonfournisseur(Long idlignelivraisonfournisseur)
   {
/*  68 */     this.idlignelivraisonfournisseur = idlignelivraisonfournisseur;
   }
 
   public Long getIdlignelivraisonfournisseur() {
/*  72 */     return this.idlignelivraisonfournisseur;
   }
 
   public void setIdlignelivraisonfournisseur(Long idlignelivraisonfournisseur) {
/*  76 */     this.idlignelivraisonfournisseur = idlignelivraisonfournisseur;
   }
 
   public Double getQuantite() {
/*  80 */     return this.quantite;
   }
 
   public void setQuantite(Double quantite) {
/*  84 */     this.quantite = quantite;
   }
 
   public Double getTauxsatisfaction() {
/*  88 */     return this.tauxsatisfaction;
   }
 
   public void setTauxsatisfaction(Double tauxsatisfaction) {
/*  92 */     this.tauxsatisfaction = tauxsatisfaction;
   }
 
   public Double getQuantitemultiple() {
/*  96 */     return this.quantitemultiple;
   }
 
   public void setQuantitemultiple(Double quantitemultiple) {
/* 100 */     this.quantitemultiple = quantitemultiple;
   }
 
   public Double getUnite() {
/* 104 */     return this.unite;
   }
 
   public void setUnite(Double unite) {
/* 108 */     this.unite = unite;
   }
 
   public Double getPrixachat() {
/* 112 */     return this.prixachat;
   }
 
   public void setPrixachat(Double prixachat) {
/* 116 */     this.prixachat = prixachat;
   }
 
   public Double getQuantitereduite() {
/* 120 */     return this.quantitereduite;
   }
 
   public void setQuantitereduite(Double quantitereduite) {
/* 124 */     this.quantitereduite = quantitereduite;
   }
 
   public Lignecommandefournisseur getIdlignecommandefournisseur() {
/* 128 */     return this.idlignecommandefournisseur;
   }
 
   public void setIdlignecommandefournisseur(Lignecommandefournisseur idlignecommandefournisseur) {
/* 132 */     this.idlignecommandefournisseur = idlignecommandefournisseur;
   }
 
   public Livraisonfournisseur getIdlivraisonfournisseur() {
/* 136 */     return this.idlivraisonfournisseur;
   }
 
   public void setIdlivraisonfournisseur(Livraisonfournisseur idlivraisonfournisseur) {
/* 140 */     this.idlivraisonfournisseur = idlivraisonfournisseur;
   }
 
   public Lot getIdlot() {
/* 144 */     return this.idlot;
   }
 
   public void setIdlot(Lot idlot) {
/* 148 */     this.idlot = idlot;
   }
 
   public Magasinlot getIdmagasinlot() {
/* 152 */     return this.idmagasinlot;
   }
 
   public void setIdmagasinlot(Magasinlot idmagasinlot) {
/* 156 */     this.idmagasinlot = idmagasinlot;
   }
 
   public Unite getIdunite() {
/* 160 */     return this.idunite;
   }
 
   public void setIdunite(Unite idunite) {
/* 164 */     this.idunite = idunite;
   }
 
   public int hashCode()
   {
/* 169 */     int hash = 0;
/* 170 */     hash += (this.idlignelivraisonfournisseur != null ? this.idlignelivraisonfournisseur.hashCode() : 0);
/* 171 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 177 */     if (!(object instanceof Lignelivraisonfournisseur)) {
/* 178 */       return false;
     }
/* 180 */     Lignelivraisonfournisseur other = (Lignelivraisonfournisseur)object;
/* 181 */     if (((this.idlignelivraisonfournisseur == null) && (other.idlignelivraisonfournisseur != null)) || ((this.idlignelivraisonfournisseur != null) && (!this.idlignelivraisonfournisseur.equals(other.idlignelivraisonfournisseur)))) {
/* 182 */       return false;
     }
/* 184 */     return true;
   }
 
   public String toString()
   {
/* 189 */     return "entities.Lignelivraisonfournisseur[ idlignelivraisonfournisseur=" + this.idlignelivraisonfournisseur + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Lignelivraisonfournisseur
 * JD-Core Version:    0.6.2
 */