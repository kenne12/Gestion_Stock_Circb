/*    */ package entities;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Basic;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.FetchType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.NamedQueries;
/*    */ import javax.validation.constraints.NotNull;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ 
/*    */ @Entity
/*    */ @XmlRootElement
/*    */ @NamedQueries({@javax.persistence.NamedQuery(name="Utilisateurmagasin.findAll", query="SELECT u FROM Utilisateurmagasin u"), @javax.persistence.NamedQuery(name="Utilisateurmagasin.findByIdutilisateurmagasin", query="SELECT u FROM Utilisateurmagasin u WHERE u.idutilisateurmagasin = :idutilisateurmagasin")})
/*    */ public class Utilisateurmagasin
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   @Id
/*    */   @Basic(optional=false)
/*    */   @NotNull
/*    */   private Long idutilisateurmagasin;
/*    */ 
/*    */   @JoinColumn(name="idmagasin", referencedColumnName="idmagasin")
/*    */   @ManyToOne(fetch=FetchType.LAZY)
/*    */   private Magasin idmagasin;
/*    */ 
/*    */   @JoinColumn(name="idutilisateur", referencedColumnName="idutilisateur")
/*    */   @ManyToOne(fetch=FetchType.LAZY)
/*    */   private Utilisateur idutilisateur;
/*    */ 
/*    */   public Utilisateurmagasin()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Utilisateurmagasin(Long idutilisateurmagasin)
/*    */   {
/* 46 */     this.idutilisateurmagasin = idutilisateurmagasin;
/*    */   }
/*    */ 
/*    */   public Long getIdutilisateurmagasin() {
/* 50 */     return this.idutilisateurmagasin;
/*    */   }
/*    */ 
/*    */   public void setIdutilisateurmagasin(Long idutilisateurmagasin) {
/* 54 */     this.idutilisateurmagasin = idutilisateurmagasin;
/*    */   }
/*    */ 
/*    */   public Magasin getIdmagasin() {
/* 58 */     return this.idmagasin;
/*    */   }
/*    */ 
/*    */   public void setIdmagasin(Magasin idmagasin) {
/* 62 */     this.idmagasin = idmagasin;
/*    */   }
/*    */ 
/*    */   public Utilisateur getIdutilisateur() {
/* 66 */     return this.idutilisateur;
/*    */   }
/*    */ 
/*    */   public void setIdutilisateur(Utilisateur idutilisateur) {
/* 70 */     this.idutilisateur = idutilisateur;
/*    */   }
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 75 */     int hash = 0;
/* 76 */     hash += (this.idutilisateurmagasin != null ? this.idutilisateurmagasin.hashCode() : 0);
/* 77 */     return hash;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object object)
/*    */   {
/* 83 */     if (!(object instanceof Utilisateurmagasin)) {
/* 84 */       return false;
/*    */     }
/* 86 */     Utilisateurmagasin other = (Utilisateurmagasin)object;
/* 87 */     if (((this.idutilisateurmagasin == null) && (other.idutilisateurmagasin != null)) || ((this.idutilisateurmagasin != null) && (!this.idutilisateurmagasin.equals(other.idutilisateurmagasin)))) {
/* 88 */       return false;
/*    */     }
/* 90 */     return true;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 95 */     return "entities.Utilisateurmagasin[ idutilisateurmagasin=" + this.idutilisateurmagasin + " ]";
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Utilisateurmagasin
 * JD-Core Version:    0.6.2
 */