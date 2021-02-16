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
/*    */ @NamedQueries({@javax.persistence.NamedQuery(name="Laboratoire.findAll", query="SELECT l FROM Laboratoire l"), @javax.persistence.NamedQuery(name="Laboratoire.findByIdlaboratoire", query="SELECT l FROM Laboratoire l WHERE l.idlaboratoire = :idlaboratoire"), @javax.persistence.NamedQuery(name="Laboratoire.findByNom", query="SELECT l FROM Laboratoire l WHERE l.nom = :nom"), @javax.persistence.NamedQuery(name="Laboratoire.findByCode", query="SELECT l FROM Laboratoire l WHERE l.code = :code")})
/*    */ public class Laboratoire
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @Basic(optional=false)
/*    */   @NotNull
/*    */   private Integer idlaboratoire;
/*    */ 
/*    */   @Size(max=60)
/*    */   private String nom;
/*    */ 
/*    */   @Size(max=20)
/*    */   private String code;
/*    */ 
/*    */   public Laboratoire()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Laboratoire(Integer idlaboratoire)
/*    */   {
/* 44 */     this.idlaboratoire = idlaboratoire;
/*    */   }
/*    */ 
/*    */   public Integer getIdlaboratoire() {
/* 48 */     return this.idlaboratoire;
/*    */   }
/*    */ 
/*    */   public void setIdlaboratoire(Integer idlaboratoire) {
/* 52 */     this.idlaboratoire = idlaboratoire;
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
/* 74 */     hash += (this.idlaboratoire != null ? this.idlaboratoire.hashCode() : 0);
/* 75 */     return hash;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object object)
/*    */   {
/* 81 */     if (!(object instanceof Laboratoire)) {
/* 82 */       return false;
/*    */     }
/* 84 */     Laboratoire other = (Laboratoire)object;
/* 85 */     if (((this.idlaboratoire == null) && (other.idlaboratoire != null)) || ((this.idlaboratoire != null) && (!this.idlaboratoire.equals(other.idlaboratoire)))) {
/* 86 */       return false;
/*    */     }
/* 88 */     return true;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 93 */     return "entities.Laboratoire[ idlaboratoire=" + this.idlaboratoire + " ]";
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Laboratoire
 * JD-Core Version:    0.6.2
 */