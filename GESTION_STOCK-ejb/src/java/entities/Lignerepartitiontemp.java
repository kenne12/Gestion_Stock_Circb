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
 @NamedQueries({@javax.persistence.NamedQuery(name="Lignerepartitiontemp.findAll", query="SELECT l FROM Lignerepartitiontemp l"), @javax.persistence.NamedQuery(name="Lignerepartitiontemp.findByIdlignerepartitiontemp", query="SELECT l FROM Lignerepartitiontemp l WHERE l.idlignerepartitiontemp = :idlignerepartitiontemp"), @javax.persistence.NamedQuery(name="Lignerepartitiontemp.findByQuantite", query="SELECT l FROM Lignerepartitiontemp l WHERE l.quantite = :quantite"), @javax.persistence.NamedQuery(name="Lignerepartitiontemp.findByQuantitemultiple", query="SELECT l FROM Lignerepartitiontemp l WHERE l.quantitemultiple = :quantitemultiple"), @javax.persistence.NamedQuery(name="Lignerepartitiontemp.findByUnite", query="SELECT l FROM Lignerepartitiontemp l WHERE l.unite = :unite"), @javax.persistence.NamedQuery(name="Lignerepartitiontemp.findByMontanttotal", query="SELECT l FROM Lignerepartitiontemp l WHERE l.montanttotal = :montanttotal"), @javax.persistence.NamedQuery(name="Lignerepartitiontemp.findByQuantitereduite", query="SELECT l FROM Lignerepartitiontemp l WHERE l.quantitereduite = :quantitereduite")})
 public class Lignerepartitiontemp
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idlignerepartitiontemp;
   private Double quantite;
   private Double quantitemultiple;
   private Double unite;
   private Double montanttotal;
   private Double quantitereduite;
 
   @OneToMany(mappedBy="idlignerepartitiontemp", fetch=FetchType.LAZY)
   private List<Lignerepartitionarticle> lignerepartitionarticleList;
 
   @JoinColumn(name="idlot", referencedColumnName="idlot")
   @ManyToOne(fetch=FetchType.LAZY)
   private Lot idlot;
 
   @JoinColumn(name="idrepartitionarticle", referencedColumnName="idrepartitionarticle")
   @ManyToOne(fetch=FetchType.LAZY)
   private Repartitionarticle idrepartitionarticle;
 
   public Lignerepartitiontemp()
   {
   }
 
   public Lignerepartitiontemp(Long idlignerepartitiontemp)
   {
/*  62 */     this.idlignerepartitiontemp = idlignerepartitiontemp;
   }
 
   public Long getIdlignerepartitiontemp() {
/*  66 */     return this.idlignerepartitiontemp;
   }
 
   public void setIdlignerepartitiontemp(Long idlignerepartitiontemp) {
/*  70 */     this.idlignerepartitiontemp = idlignerepartitiontemp;
   }
 
   public Double getQuantite() {
/*  74 */     return this.quantite;
   }
 
   public void setQuantite(Double quantite) {
/*  78 */     this.quantite = quantite;
   }
 
   public Double getQuantitemultiple() {
/*  82 */     return this.quantitemultiple;
   }
 
   public void setQuantitemultiple(Double quantitemultiple) {
/*  86 */     this.quantitemultiple = quantitemultiple;
   }
 
   public Double getUnite() {
/*  90 */     return this.unite;
   }
 
   public void setUnite(Double unite) {
/*  94 */     this.unite = unite;
   }
 
   public Double getMontanttotal() {
/*  98 */     return this.montanttotal;
   }
 
   public void setMontanttotal(Double montanttotal) {
/* 102 */     this.montanttotal = montanttotal;
   }
 
   public Double getQuantitereduite() {
/* 106 */     return this.quantitereduite;
   }
 
   public void setQuantitereduite(Double quantitereduite) {
/* 110 */     this.quantitereduite = quantitereduite;
   }
 
   @XmlTransient
   public List<Lignerepartitionarticle> getLignerepartitionarticleList() {
/* 115 */     return this.lignerepartitionarticleList;
   }
 
   public void setLignerepartitionarticleList(List<Lignerepartitionarticle> lignerepartitionarticleList) {
/* 119 */     this.lignerepartitionarticleList = lignerepartitionarticleList;
   }
 
   public Lot getIdlot() {
/* 123 */     return this.idlot;
   }
 
   public void setIdlot(Lot idlot) {
/* 127 */     this.idlot = idlot;
   }
 
   public Repartitionarticle getIdrepartitionarticle() {
/* 131 */     return this.idrepartitionarticle;
   }
 
   public void setIdrepartitionarticle(Repartitionarticle idrepartitionarticle) {
/* 135 */     this.idrepartitionarticle = idrepartitionarticle;
   }
 
   public int hashCode()
   {
/* 140 */     int hash = 0;
/* 141 */     hash += (this.idlignerepartitiontemp != null ? this.idlignerepartitiontemp.hashCode() : 0);
/* 142 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 148 */     if (!(object instanceof Lignerepartitiontemp)) {
/* 149 */       return false;
     }
/* 151 */     Lignerepartitiontemp other = (Lignerepartitiontemp)object;
/* 152 */     if (((this.idlignerepartitiontemp == null) && (other.idlignerepartitiontemp != null)) || ((this.idlignerepartitiontemp != null) && (!this.idlignerepartitiontemp.equals(other.idlignerepartitiontemp)))) {
/* 153 */       return false;
     }
/* 155 */     return true;
   }
 
   public String toString()
   {
/* 160 */     return "entities.Lignerepartitiontemp[ idlignerepartitiontemp=" + this.idlignerepartitiontemp + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Lignerepartitiontemp
 * JD-Core Version:    0.6.2
 */