 package entities;
 
 import java.io.Serializable;
 import java.util.Date;
 import java.util.List;
 import javax.persistence.Basic;
 import javax.persistence.Entity;
 import javax.persistence.FetchType;
 import javax.persistence.Id;
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
 @NamedQueries({@javax.persistence.NamedQuery(name="Entredirect.findAll", query="SELECT e FROM Entredirect e"), @javax.persistence.NamedQuery(name="Entredirect.findByIdentredirect", query="SELECT e FROM Entredirect e WHERE e.identredirect = :identredirect"), @javax.persistence.NamedQuery(name="Entredirect.findByDateentree", query="SELECT e FROM Entredirect e WHERE e.dateentree = :dateentree"), @javax.persistence.NamedQuery(name="Entredirect.findByMontant", query="SELECT e FROM Entredirect e WHERE e.montant = :montant"), @javax.persistence.NamedQuery(name="Entredirect.findByCode", query="SELECT e FROM Entredirect e WHERE e.code = :code")})
 public class Entredirect
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Integer identredirect;
 
   @Temporal(TemporalType.DATE)
   private Date dateentree;
   private Double montant;
 
   @Size(max=254)
   private String code;
 
   @OneToMany(mappedBy="identredirect", fetch=FetchType.LAZY)
   private List<Ligneentreedirect> ligneentreedirectList;
 
   public Entredirect()
   {
   }
 
   public Entredirect(Integer identredirect)
   {
/*  56 */     this.identredirect = identredirect;
   }
 
   public Integer getIdentredirect() {
/*  60 */     return this.identredirect;
   }
 
   public void setIdentredirect(Integer identredirect) {
/*  64 */     this.identredirect = identredirect;
   }
 
   public Date getDateentree() {
/*  68 */     return this.dateentree;
   }
 
   public void setDateentree(Date dateentree) {
/*  72 */     this.dateentree = dateentree;
   }
 
   public Double getMontant() {
/*  76 */     return this.montant;
   }
 
   public void setMontant(Double montant) {
/*  80 */     this.montant = montant;
   }
 
   public String getCode() {
/*  84 */     return this.code;
   }
 
   public void setCode(String code) {
/*  88 */     this.code = code;
   }
 
   @XmlTransient
   public List<Ligneentreedirect> getLigneentreedirectList() {
/*  93 */     return this.ligneentreedirectList;
   }
 
   public void setLigneentreedirectList(List<Ligneentreedirect> ligneentreedirectList) {
/*  97 */     this.ligneentreedirectList = ligneentreedirectList;
   }
 
   public int hashCode()
   {
/* 102 */     int hash = 0;
/* 103 */     hash += (this.identredirect != null ? this.identredirect.hashCode() : 0);
/* 104 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 110 */     if (!(object instanceof Entredirect)) {
/* 111 */       return false;
     }
/* 113 */     Entredirect other = (Entredirect)object;
/* 114 */     if (((this.identredirect == null) && (other.identredirect != null)) || ((this.identredirect != null) && (!this.identredirect.equals(other.identredirect)))) {
/* 115 */       return false;
     }
/* 117 */     return true;
   }
 
   public String toString()
   {
/* 122 */     return "entities.Entredirect[ identredirect=" + this.identredirect + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Entredirect
 * JD-Core Version:    0.6.2
 */