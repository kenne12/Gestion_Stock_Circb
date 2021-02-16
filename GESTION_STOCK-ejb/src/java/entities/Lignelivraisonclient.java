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
 @NamedQueries({@javax.persistence.NamedQuery(name="Lignelivraisonclient.findAll", query="SELECT l FROM Lignelivraisonclient l"), @javax.persistence.NamedQuery(name="Lignelivraisonclient.findByIdlignelivraisonclient", query="SELECT l FROM Lignelivraisonclient l WHERE l.idlignelivraisonclient = :idlignelivraisonclient"), @javax.persistence.NamedQuery(name="Lignelivraisonclient.findByQuantite", query="SELECT l FROM Lignelivraisonclient l WHERE l.quantite = :quantite"), @javax.persistence.NamedQuery(name="Lignelivraisonclient.findByTauxsatisfaction", query="SELECT l FROM Lignelivraisonclient l WHERE l.tauxsatisfaction = :tauxsatisfaction"), @javax.persistence.NamedQuery(name="Lignelivraisonclient.findByQuantitemultiple", query="SELECT l FROM Lignelivraisonclient l WHERE l.quantitemultiple = :quantitemultiple"), @javax.persistence.NamedQuery(name="Lignelivraisonclient.findByUnite", query="SELECT l FROM Lignelivraisonclient l WHERE l.unite = :unite"), @javax.persistence.NamedQuery(name="Lignelivraisonclient.findByMontant", query="SELECT l FROM Lignelivraisonclient l WHERE l.montant = :montant"), @javax.persistence.NamedQuery(name="Lignelivraisonclient.findByQuantitereduite", query="SELECT l FROM Lignelivraisonclient l WHERE l.quantitereduite = :quantitereduite")})
 public class Lignelivraisonclient
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idlignelivraisonclient;
   private Double quantite;
   private Double tauxsatisfaction;
   private Double quantitemultiple;
   private Double unite;
   private Double montant;
   private Double quantitereduite;
 
   @JoinColumn(name="idlivraisonclient", referencedColumnName="idlivraisonclient")
   @ManyToOne(fetch=FetchType.LAZY)
   private Livraisonclient idlivraisonclient;
 
   @JoinColumn(name="idlot", referencedColumnName="idlot")
   @ManyToOne(fetch=FetchType.LAZY)
   private Lot idlot;
 
   @JoinColumn(name="idmagasinlot", referencedColumnName="idmagasinlot")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasinlot idmagasinlot;
 
   @JoinColumn(name="idunite", referencedColumnName="idunite")
   @ManyToOne(fetch=FetchType.LAZY)
   private Unite idunite;
 
   public Lignelivraisonclient()
   {
   }
 
   public Lignelivraisonclient(Long idlignelivraisonclient)
   {
/*  65 */     this.idlignelivraisonclient = idlignelivraisonclient;
   }
 
   public Long getIdlignelivraisonclient() {
/*  69 */     return this.idlignelivraisonclient;
   }
 
   public void setIdlignelivraisonclient(Long idlignelivraisonclient) {
/*  73 */     this.idlignelivraisonclient = idlignelivraisonclient;
   }
 
   public Double getQuantite() {
/*  77 */     return this.quantite;
   }
 
   public void setQuantite(Double quantite) {
/*  81 */     this.quantite = quantite;
   }
 
   public Double getTauxsatisfaction() {
/*  85 */     return this.tauxsatisfaction;
   }
 
   public void setTauxsatisfaction(Double tauxsatisfaction) {
/*  89 */     this.tauxsatisfaction = tauxsatisfaction;
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
 
   public Double getMontant() {
/* 109 */     return this.montant;
   }
 
   public void setMontant(Double montant) {
/* 113 */     this.montant = montant;
   }
 
   public Double getQuantitereduite() {
/* 117 */     return this.quantitereduite;
   }
 
   public void setQuantitereduite(Double quantitereduite) {
/* 121 */     this.quantitereduite = quantitereduite;
   }
 
   public Livraisonclient getIdlivraisonclient() {
/* 125 */     return this.idlivraisonclient;
   }
 
   public void setIdlivraisonclient(Livraisonclient idlivraisonclient) {
/* 129 */     this.idlivraisonclient = idlivraisonclient;
   }
 
   public Lot getIdlot() {
/* 133 */     return this.idlot;
   }
 
   public void setIdlot(Lot idlot) {
/* 137 */     this.idlot = idlot;
   }
 
   public Magasinlot getIdmagasinlot() {
/* 141 */     return this.idmagasinlot;
   }
 
   public void setIdmagasinlot(Magasinlot idmagasinlot) {
/* 145 */     this.idmagasinlot = idmagasinlot;
   }
 
   public Unite getIdunite() {
/* 149 */     return this.idunite;
   }
 
   public void setIdunite(Unite idunite) {
/* 153 */     this.idunite = idunite;
   }
 
   public int hashCode()
   {
/* 158 */     int hash = 0;
/* 159 */     hash += (this.idlignelivraisonclient != null ? this.idlignelivraisonclient.hashCode() : 0);
/* 160 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 166 */     if (!(object instanceof Lignelivraisonclient)) {
/* 167 */       return false;
     }
/* 169 */     Lignelivraisonclient other = (Lignelivraisonclient)object;
/* 170 */     if (((this.idlignelivraisonclient == null) && (other.idlignelivraisonclient != null)) || ((this.idlignelivraisonclient != null) && (!this.idlignelivraisonclient.equals(other.idlignelivraisonclient)))) {
/* 171 */       return false;
     }
/* 173 */     return true;
   }
 
   public String toString()
   {
/* 178 */     return "entities.Lignelivraisonclient[ idlignelivraisonclient=" + this.idlignelivraisonclient + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Lignelivraisonclient
 * JD-Core Version:    0.6.2
 */