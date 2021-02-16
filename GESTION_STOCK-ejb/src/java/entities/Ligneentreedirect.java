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
 @NamedQueries({@javax.persistence.NamedQuery(name="Ligneentreedirect.findAll", query="SELECT l FROM Ligneentreedirect l"), @javax.persistence.NamedQuery(name="Ligneentreedirect.findByIdligneentreedirect", query="SELECT l FROM Ligneentreedirect l WHERE l.idligneentreedirect = :idligneentreedirect"), @javax.persistence.NamedQuery(name="Ligneentreedirect.findByQuantite", query="SELECT l FROM Ligneentreedirect l WHERE l.quantite = :quantite"), @javax.persistence.NamedQuery(name="Ligneentreedirect.findByCunitaire", query="SELECT l FROM Ligneentreedirect l WHERE l.cunitaire = :cunitaire"), @javax.persistence.NamedQuery(name="Ligneentreedirect.findByQuantitemultiple", query="SELECT l FROM Ligneentreedirect l WHERE l.quantitemultiple = :quantitemultiple"), @javax.persistence.NamedQuery(name="Ligneentreedirect.findByUnite", query="SELECT l FROM Ligneentreedirect l WHERE l.unite = :unite")})
 public class Ligneentreedirect
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idligneentreedirect;
   private Double quantite;
   private Double cunitaire;
   private Double quantitemultiple;
   private Integer unite;
 
   @JoinColumn(name="identredirect", referencedColumnName="identredirect")
   @ManyToOne(fetch=FetchType.LAZY)
   private Entredirect identredirect;
 
   @JoinColumn(name="idmagasinlot", referencedColumnName="idmagasinlot")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasinlot idmagasinlot;
 
   public Ligneentreedirect()
   {
   }
 
   public Ligneentreedirect(Long idligneentreedirect)
   {
/*  55 */     this.idligneentreedirect = idligneentreedirect;
   }
 
   public Long getIdligneentreedirect() {
/*  59 */     return this.idligneentreedirect;
   }
 
   public void setIdligneentreedirect(Long idligneentreedirect) {
/*  63 */     this.idligneentreedirect = idligneentreedirect;
   }
 
   public Double getQuantite() {
/*  67 */     return this.quantite;
   }
 
   public void setQuantite(Double quantite) {
/*  71 */     this.quantite = quantite;
   }
 
   public Double getCunitaire() {
/*  75 */     return this.cunitaire;
   }
 
   public void setCunitaire(Double cunitaire) {
/*  79 */     this.cunitaire = cunitaire;
   }
 
   public Double getQuantitemultiple() {
/*  83 */     return this.quantitemultiple;
   }
 
   public void setQuantitemultiple(Double quantitemultiple) {
/*  87 */     this.quantitemultiple = quantitemultiple;
   }
 
   public Integer getUnite() {
/*  91 */     return this.unite;
   }
 
   public void setUnite(Integer unite) {
/*  95 */     this.unite = unite;
   }
 
   public Entredirect getIdentredirect() {
/*  99 */     return this.identredirect;
   }
 
   public void setIdentredirect(Entredirect identredirect) {
/* 103 */     this.identredirect = identredirect;
   }
 
   public Magasinlot getIdmagasinlot() {
/* 107 */     return this.idmagasinlot;
   }
 
   public void setIdmagasinlot(Magasinlot idmagasinlot) {
/* 111 */     this.idmagasinlot = idmagasinlot;
   }
 
   public int hashCode()
   {
/* 116 */     int hash = 0;
/* 117 */     hash += (this.idligneentreedirect != null ? this.idligneentreedirect.hashCode() : 0);
/* 118 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 124 */     if (!(object instanceof Ligneentreedirect)) {
/* 125 */       return false;
     }
/* 127 */     Ligneentreedirect other = (Ligneentreedirect)object;
/* 128 */     if (((this.idligneentreedirect == null) && (other.idligneentreedirect != null)) || ((this.idligneentreedirect != null) && (!this.idligneentreedirect.equals(other.idligneentreedirect)))) {
/* 129 */       return false;
     }
/* 131 */     return true;
   }
 
   public String toString()
   {
/* 136 */     return "entities.Ligneentreedirect[ idligneentreedirect=" + this.idligneentreedirect + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Ligneentreedirect
 * JD-Core Version:    0.6.2
 */