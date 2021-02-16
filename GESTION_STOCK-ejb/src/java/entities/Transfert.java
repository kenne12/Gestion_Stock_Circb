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
 @NamedQueries({@javax.persistence.NamedQuery(name="Transfert.findAll", query="SELECT t FROM Transfert t"), @javax.persistence.NamedQuery(name="Transfert.findByIdtransfert", query="SELECT t FROM Transfert t WHERE t.idtransfert = :idtransfert"), @javax.persistence.NamedQuery(name="Transfert.findByMontanttotal", query="SELECT t FROM Transfert t WHERE t.montanttotal = :montanttotal"), @javax.persistence.NamedQuery(name="Transfert.findByDatetransfert", query="SELECT t FROM Transfert t WHERE t.datetransfert = :datetransfert"), @javax.persistence.NamedQuery(name="Transfert.findByCode", query="SELECT t FROM Transfert t WHERE t.code = :code"), @javax.persistence.NamedQuery(name="Transfert.findByIdmagasincible", query="SELECT t FROM Transfert t WHERE t.idmagasincible = :idmagasincible")})
 public class Transfert
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idtransfert;
   private Double montanttotal;
 
   @Temporal(TemporalType.DATE)
   private Date datetransfert;
 
   @Size(max=40)
   private String code;
   private Integer idmagasincible;
 
   @OneToMany(mappedBy="idtransfert", fetch=FetchType.LAZY)
   private List<Lignetransfert> lignetransfertList;
 
   @JoinColumn(name="idmagasin", referencedColumnName="idmagasin")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasin idmagasin;
 
   @JoinColumn(name="idmvtstock", referencedColumnName="idmvtstock")
   @ManyToOne(fetch=FetchType.LAZY)
   private Mvtstock idmvtstock;
 
   public Transfert()
   {
   }
 
   public Transfert(Long idtransfert)
   {
/*  66 */     this.idtransfert = idtransfert;
   }
 
   public Long getIdtransfert() {
/*  70 */     return this.idtransfert;
   }
 
   public void setIdtransfert(Long idtransfert) {
/*  74 */     this.idtransfert = idtransfert;
   }
 
   public Double getMontanttotal() {
/*  78 */     return this.montanttotal;
   }
 
   public void setMontanttotal(Double montanttotal) {
/*  82 */     this.montanttotal = montanttotal;
   }
 
   public Date getDatetransfert() {
/*  86 */     return this.datetransfert;
   }
 
   public void setDatetransfert(Date datetransfert) {
/*  90 */     this.datetransfert = datetransfert;
   }
 
   public String getCode() {
/*  94 */     return this.code;
   }
 
   public void setCode(String code) {
/*  98 */     this.code = code;
   }
 
   public Integer getIdmagasincible() {
/* 102 */     return this.idmagasincible;
   }
 
   public void setIdmagasincible(Integer idmagasincible) {
/* 106 */     this.idmagasincible = idmagasincible;
   }
 
   @XmlTransient
   public List<Lignetransfert> getLignetransfertList() {
/* 111 */     return this.lignetransfertList;
   }
 
   public void setLignetransfertList(List<Lignetransfert> lignetransfertList) {
/* 115 */     this.lignetransfertList = lignetransfertList;
   }
 
   public Magasin getIdmagasin() {
/* 119 */     return this.idmagasin;
   }
 
   public void setIdmagasin(Magasin idmagasin) {
/* 123 */     this.idmagasin = idmagasin;
   }
 
   public Mvtstock getIdmvtstock() {
/* 127 */     return this.idmvtstock;
   }
 
   public void setIdmvtstock(Mvtstock idmvtstock) {
/* 131 */     this.idmvtstock = idmvtstock;
   }
 
   public int hashCode()
   {
/* 136 */     int hash = 0;
/* 137 */     hash += (this.idtransfert != null ? this.idtransfert.hashCode() : 0);
/* 138 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 144 */     if (!(object instanceof Transfert)) {
/* 145 */       return false;
     }
/* 147 */     Transfert other = (Transfert)object;
/* 148 */     if (((this.idtransfert == null) && (other.idtransfert != null)) || ((this.idtransfert != null) && (!this.idtransfert.equals(other.idtransfert)))) {
/* 149 */       return false;
     }
/* 151 */     return true;
   }
 
   public String toString()
   {
/* 156 */     return "entities.Transfert[ idtransfert=" + this.idtransfert + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Transfert
 * JD-Core Version:    0.6.2
 */