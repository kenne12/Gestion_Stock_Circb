/*    */ package entities;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.NamedQueries;
/*    */ import javax.validation.constraints.NotNull;
/*    */ import javax.validation.constraints.Size;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ 
/*    */ @Entity
/*    */ @XmlRootElement
/*    */ @NamedQueries({@javax.persistence.NamedQuery(name="Service.findAll", query="SELECT s FROM Service s"), @javax.persistence.NamedQuery(name="Service.findByIdservice", query="SELECT s FROM Service s WHERE s.idservice = :idservice"), @javax.persistence.NamedQuery(name="Service.findByNom", query="SELECT s FROM Service s WHERE s.nom = :nom"), @javax.persistence.NamedQuery(name="Service.findByCode", query="SELECT s FROM Service s WHERE s.code = :code")})
/*    */ public class Service
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @Basic(optional=false)
/*    */   @NotNull
/*    */   private Integer idservice;
/*    */ 
/*    */   @Size(max=254)
/*    */   private String nom;
/*    */ 
/*    */   @Size(max=254)
/*    */   private String code;
/*    */ 
/*    */   public Service()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Service(Integer idservice)
/*    */   {
/* 44 */     this.idservice = idservice;
/*    */   }
/*    */ 
/*    */   public Integer getIdservice() {
/* 48 */     return this.idservice;
/*    */   }
/*    */ 
/*    */   public void setIdservice(Integer idservice) {
/* 52 */     this.idservice = idservice;
/*    */   }
/*    */ 
/*    */   public String getNom() {
/* 56 */     return this.nom;
/*    */   }
/*    */ 
/*    */   public void setNom(String nom) {
/* 60 */     this.nom = nom;
/*    */   }
/*    */ 
/*    */   public String getCode() {
/* 64 */     return this.code;
/*    */   }
/*    */ 
/*    */   public void setCode(String code) {
/* 68 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 73 */     int hash = 0;
/* 74 */     hash += (this.idservice != null ? this.idservice.hashCode() : 0);
/* 75 */     return hash;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object object)
/*    */   {
/* 81 */     if (!(object instanceof Service)) {
/* 82 */       return false;
/*    */     }
/* 84 */     Service other = (Service)object;
/* 85 */     if (((this.idservice == null) && (other.idservice != null)) || ((this.idservice != null) && (!this.idservice.equals(other.idservice)))) {
/* 86 */       return false;
/*    */     }
/* 88 */     return true;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 93 */     return "entities.Service[ idservice=" + this.idservice + " ]";
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Service
 * JD-Core Version:    0.6.2
 */