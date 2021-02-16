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
 @NamedQueries({@javax.persistence.NamedQuery(name="Lignetransfert.findAll", query="SELECT l FROM Lignetransfert l"), @javax.persistence.NamedQuery(name="Lignetransfert.findByIdlignetransfert", query="SELECT l FROM Lignetransfert l WHERE l.idlignetransfert = :idlignetransfert"), @javax.persistence.NamedQuery(name="Lignetransfert.findByQuantite", query="SELECT l FROM Lignetransfert l WHERE l.quantite = :quantite"), @javax.persistence.NamedQuery(name="Lignetransfert.findByUnite", query="SELECT l FROM Lignetransfert l WHERE l.unite = :unite"), @javax.persistence.NamedQuery(name="Lignetransfert.findByQuantitemultiple", query="SELECT l FROM Lignetransfert l WHERE l.quantitemultiple = :quantitemultiple"), @javax.persistence.NamedQuery(name="Lignetransfert.findByMontant", query="SELECT l FROM Lignetransfert l WHERE l.montant = :montant"), @javax.persistence.NamedQuery(name="Lignetransfert.findByQuantitereduite", query="SELECT l FROM Lignetransfert l WHERE l.quantitereduite = :quantitereduite")})
 public class Lignetransfert
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idlignetransfert;
   private Double quantite;
   private Double unite;
   private Double quantitemultiple;
   private Double montant;
   private Double quantitereduite;
 
   @JoinColumn(name="idmagasinlot", referencedColumnName="idmagasinlot")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasinlot idmagasinlot;
 
   @JoinColumn(name="idtransfert", referencedColumnName="idtransfert")
   @ManyToOne(fetch=FetchType.LAZY)
   private Transfert idtransfert;
 
   @JoinColumn(name="idunite", referencedColumnName="idunite")
   @ManyToOne(fetch=FetchType.LAZY)
   private Unite idunite;
 
   public Lignetransfert()
   {
   }
 
   public Lignetransfert(Long idlignetransfert)
   {
/*  60 */     this.idlignetransfert = idlignetransfert;
   }
 
   public Long getIdlignetransfert() {
/*  64 */     return this.idlignetransfert;
   }
 
   public void setIdlignetransfert(Long idlignetransfert) {
/*  68 */     this.idlignetransfert = idlignetransfert;
   }
 
   public Double getQuantite() {
/*  72 */     return this.quantite;
   }
 
   public void setQuantite(Double quantite) {
/*  76 */     this.quantite = quantite;
   }
 
   public Double getUnite() {
/*  80 */     return this.unite;
   }
 
   public void setUnite(Double unite) {
/*  84 */     this.unite = unite;
   }
 
   public Double getQuantitemultiple() {
/*  88 */     return this.quantitemultiple;
   }
 
   public void setQuantitemultiple(Double quantitemultiple) {
/*  92 */     this.quantitemultiple = quantitemultiple;
   }
 
   public Double getMontant() {
/*  96 */     return this.montant;
   }
 
   public void setMontant(Double montant) {
/* 100 */     this.montant = montant;
   }
 
   public Double getQuantitereduite() {
/* 104 */     return this.quantitereduite;
   }
 
   public void setQuantitereduite(Double quantitereduite) {
/* 108 */     this.quantitereduite = quantitereduite;
   }
 
   public Magasinlot getIdmagasinlot() {
/* 112 */     return this.idmagasinlot;
   }
 
   public void setIdmagasinlot(Magasinlot idmagasinlot) {
/* 116 */     this.idmagasinlot = idmagasinlot;
   }
 
   public Transfert getIdtransfert() {
/* 120 */     return this.idtransfert;
   }
 
   public void setIdtransfert(Transfert idtransfert) {
/* 124 */     this.idtransfert = idtransfert;
   }
 
   public Unite getIdunite() {
/* 128 */     return this.idunite;
   }
 
   public void setIdunite(Unite idunite) {
/* 132 */     this.idunite = idunite;
   }
 
   public int hashCode()
   {
/* 137 */     int hash = 0;
/* 138 */     hash += (this.idlignetransfert != null ? this.idlignetransfert.hashCode() : 0);
/* 139 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 145 */     if (!(object instanceof Lignetransfert)) {
/* 146 */       return false;
     }
/* 148 */     Lignetransfert other = (Lignetransfert)object;
/* 149 */     if (((this.idlignetransfert == null) && (other.idlignetransfert != null)) || ((this.idlignetransfert != null) && (!this.idlignetransfert.equals(other.idlignetransfert)))) {
/* 150 */       return false;
     }
/* 152 */     return true;
   }
 
   public String toString()
   {
/* 157 */     return "entities.Lignetransfert[ idlignetransfert=" + this.idlignetransfert + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Lignetransfert
 * JD-Core Version:    0.6.2
 */