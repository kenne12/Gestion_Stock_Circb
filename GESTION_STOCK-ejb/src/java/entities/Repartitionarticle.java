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
 @NamedQueries({@javax.persistence.NamedQuery(name="Repartitionarticle.findAll", query="SELECT r FROM Repartitionarticle r"), @javax.persistence.NamedQuery(name="Repartitionarticle.findByIdrepartitionarticle", query="SELECT r FROM Repartitionarticle r WHERE r.idrepartitionarticle = :idrepartitionarticle"), @javax.persistence.NamedQuery(name="Repartitionarticle.findByDate", query="SELECT r FROM Repartitionarticle r WHERE r.date = :date"), @javax.persistence.NamedQuery(name="Repartitionarticle.findByCode", query="SELECT r FROM Repartitionarticle r WHERE r.code = :code"), @javax.persistence.NamedQuery(name="Repartitionarticle.findByMontanttotal", query="SELECT r FROM Repartitionarticle r WHERE r.montanttotal = :montanttotal")})
 public class Repartitionarticle
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Integer idrepartitionarticle;
 
   @Temporal(TemporalType.DATE)
   private Date date;
 
   @Size(max=40)
   private String code;
   private Double montanttotal;
 
   @OneToMany(mappedBy="idrepartitionarticle", fetch=FetchType.LAZY)
   private List<Lignerepartitionarticle> lignerepartitionarticleList;
 
   @JoinColumn(name="idmvtstock", referencedColumnName="idmvtstock")
   @ManyToOne(fetch=FetchType.LAZY)
   private Mvtstock idmvtstock;
 
   @OneToMany(mappedBy="idrepartitionarticle", fetch=FetchType.LAZY)
   private List<Lignerepartitiontemp> lignerepartitiontempList;
 
   public Repartitionarticle()
   {
   }
 
   public Repartitionarticle(Integer idrepartitionarticle)
   {
/*  63 */     this.idrepartitionarticle = idrepartitionarticle;
   }
 
   public Integer getIdrepartitionarticle() {
/*  67 */     return this.idrepartitionarticle;
   }
 
   public void setIdrepartitionarticle(Integer idrepartitionarticle) {
/*  71 */     this.idrepartitionarticle = idrepartitionarticle;
   }
 
   public Date getDate() {
/*  75 */     return this.date;
   }
 
   public void setDate(Date date) {
/*  79 */     this.date = date;
   }
 
   public String getCode() {
/*  83 */     return this.code;
   }
 
   public void setCode(String code) {
/*  87 */     this.code = code;
   }
 
   public Double getMontanttotal() {
/*  91 */     return this.montanttotal;
   }
 
   public void setMontanttotal(Double montanttotal) {
/*  95 */     this.montanttotal = montanttotal;
   }
 
   @XmlTransient
   public List<Lignerepartitionarticle> getLignerepartitionarticleList() {
/* 100 */     return this.lignerepartitionarticleList;
   }
 
   public void setLignerepartitionarticleList(List<Lignerepartitionarticle> lignerepartitionarticleList) {
/* 104 */     this.lignerepartitionarticleList = lignerepartitionarticleList;
   }
 
   public Mvtstock getIdmvtstock() {
/* 108 */     return this.idmvtstock;
   }
 
   public void setIdmvtstock(Mvtstock idmvtstock) {
/* 112 */     this.idmvtstock = idmvtstock;
   }
 
   @XmlTransient
   public List<Lignerepartitiontemp> getLignerepartitiontempList() {
/* 117 */     return this.lignerepartitiontempList;
   }
 
   public void setLignerepartitiontempList(List<Lignerepartitiontemp> lignerepartitiontempList) {
/* 121 */     this.lignerepartitiontempList = lignerepartitiontempList;
   }
 
   public int hashCode()
   {
/* 126 */     int hash = 0;
/* 127 */     hash += (this.idrepartitionarticle != null ? this.idrepartitionarticle.hashCode() : 0);
/* 128 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 134 */     if (!(object instanceof Repartitionarticle)) {
/* 135 */       return false;
     }
/* 137 */     Repartitionarticle other = (Repartitionarticle)object;
/* 138 */     if (((this.idrepartitionarticle == null) && (other.idrepartitionarticle != null)) || ((this.idrepartitionarticle != null) && (!this.idrepartitionarticle.equals(other.idrepartitionarticle)))) {
/* 139 */       return false;
     }
/* 141 */     return true;
   }
 
   public String toString()
   {
/* 146 */     return "entities.Repartitionarticle[ idrepartitionarticle=" + this.idrepartitionarticle + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Repartitionarticle
 * JD-Core Version:    0.6.2
 */