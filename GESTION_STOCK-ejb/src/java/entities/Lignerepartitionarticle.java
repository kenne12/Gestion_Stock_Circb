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
 @NamedQueries({@javax.persistence.NamedQuery(name="Lignerepartitionarticle.findAll", query="SELECT l FROM Lignerepartitionarticle l"), @javax.persistence.NamedQuery(name="Lignerepartitionarticle.findByIdlignerepartitionarticle", query="SELECT l FROM Lignerepartitionarticle l WHERE l.idlignerepartitionarticle = :idlignerepartitionarticle"), @javax.persistence.NamedQuery(name="Lignerepartitionarticle.findByQuantite", query="SELECT l FROM Lignerepartitionarticle l WHERE l.quantite = :quantite"), @javax.persistence.NamedQuery(name="Lignerepartitionarticle.findByQuantitemultiple", query="SELECT l FROM Lignerepartitionarticle l WHERE l.quantitemultiple = :quantitemultiple"), @javax.persistence.NamedQuery(name="Lignerepartitionarticle.findByUnite", query="SELECT l FROM Lignerepartitionarticle l WHERE l.unite = :unite"), @javax.persistence.NamedQuery(name="Lignerepartitionarticle.findByMontant", query="SELECT l FROM Lignerepartitionarticle l WHERE l.montant = :montant"), @javax.persistence.NamedQuery(name="Lignerepartitionarticle.findByQuantitereduite", query="SELECT l FROM Lignerepartitionarticle l WHERE l.quantitereduite = :quantitereduite")})
 public class Lignerepartitionarticle
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idlignerepartitionarticle;
   private Double quantite;
   private Double quantitemultiple;
   private Double unite;
   private Double montant;
   private Double quantitereduite;
 
   @JoinColumn(name="idlignerepartitiontemp", referencedColumnName="idlignerepartitiontemp")
   @ManyToOne(fetch=FetchType.LAZY)
   private Lignerepartitiontemp idlignerepartitiontemp;
 
   @JoinColumn(name="idmagasinlot", referencedColumnName="idmagasinlot")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasinlot idmagasinlot;
 
   @JoinColumn(name="idrepartitionarticle", referencedColumnName="idrepartitionarticle")
   @ManyToOne(fetch=FetchType.LAZY)
   private Repartitionarticle idrepartitionarticle;
 
   @JoinColumn(name="idunite", referencedColumnName="idunite")
   @ManyToOne(fetch=FetchType.LAZY)
   private Unite idunite;
 
   public Lignerepartitionarticle()
   {
   }
 
   public Lignerepartitionarticle(Long idlignerepartitionarticle)
   {
/*  63 */     this.idlignerepartitionarticle = idlignerepartitionarticle;
   }
 
   public Long getIdlignerepartitionarticle() {
/*  67 */     return this.idlignerepartitionarticle;
   }
 
   public void setIdlignerepartitionarticle(Long idlignerepartitionarticle) {
/*  71 */     this.idlignerepartitionarticle = idlignerepartitionarticle;
   }
 
   public Double getQuantite() {
/*  75 */     return this.quantite;
   }
 
   public void setQuantite(Double quantite) {
/*  79 */     this.quantite = quantite;
   }
 
   public Double getQuantitemultiple() {
/*  83 */     return this.quantitemultiple;
   }
 
   public void setQuantitemultiple(Double quantitemultiple) {
/*  87 */     this.quantitemultiple = quantitemultiple;
   }
 
   public Double getUnite() {
/*  91 */     return this.unite;
   }
 
   public void setUnite(Double unite) {
/*  95 */     this.unite = unite;
   }
 
   public Double getMontant() {
/*  99 */     return this.montant;
   }
 
   public void setMontant(Double montant) {
/* 103 */     this.montant = montant;
   }
 
   public Double getQuantitereduite() {
/* 107 */     return this.quantitereduite;
   }
 
   public void setQuantitereduite(Double quantitereduite) {
/* 111 */     this.quantitereduite = quantitereduite;
   }
 
   public Lignerepartitiontemp getIdlignerepartitiontemp() {
/* 115 */     return this.idlignerepartitiontemp;
   }
 
   public void setIdlignerepartitiontemp(Lignerepartitiontemp idlignerepartitiontemp) {
/* 119 */     this.idlignerepartitiontemp = idlignerepartitiontemp;
   }
 
   public Magasinlot getIdmagasinlot() {
/* 123 */     return this.idmagasinlot;
   }
 
   public void setIdmagasinlot(Magasinlot idmagasinlot) {
/* 127 */     this.idmagasinlot = idmagasinlot;
   }
 
   public Repartitionarticle getIdrepartitionarticle() {
/* 131 */     return this.idrepartitionarticle;
   }
 
   public void setIdrepartitionarticle(Repartitionarticle idrepartitionarticle) {
/* 135 */     this.idrepartitionarticle = idrepartitionarticle;
   }
 
   public Unite getIdunite() {
/* 139 */     return this.idunite;
   }
 
   public void setIdunite(Unite idunite) {
/* 143 */     this.idunite = idunite;
   }
 
   public int hashCode()
   {
/* 148 */     int hash = 0;
/* 149 */     hash += (this.idlignerepartitionarticle != null ? this.idlignerepartitionarticle.hashCode() : 0);
/* 150 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 156 */     if (!(object instanceof Lignerepartitionarticle)) {
/* 157 */       return false;
     }
/* 159 */     Lignerepartitionarticle other = (Lignerepartitionarticle)object;
/* 160 */     if (((this.idlignerepartitionarticle == null) && (other.idlignerepartitionarticle != null)) || ((this.idlignerepartitionarticle != null) && (!this.idlignerepartitionarticle.equals(other.idlignerepartitionarticle)))) {
/* 161 */       return false;
     }
/* 163 */     return true;
   }
 
   public String toString()
   {
/* 168 */     return "entities.Lignerepartitionarticle[ idlignerepartitionarticle=" + this.idlignerepartitionarticle + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Lignerepartitionarticle
 * JD-Core Version:    0.6.2
 */