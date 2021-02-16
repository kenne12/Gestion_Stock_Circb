/*    */ package sessions;
/*    */ 
/*    */ import entities.Lignecommandefournisseur;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ @Stateless
/*    */ public class LignecommandefournisseurFacade extends AbstractFacade<Lignecommandefournisseur>
/*    */   implements LignecommandefournisseurFacadeLocal
/*    */ {
/*    */ 
/*    */   @PersistenceContext(unitName="GESTION_STOCK-ejbPU")
/*    */   private EntityManager em;
/*    */ 
/*    */   protected EntityManager getEntityManager()
/*    */   {
/* 27 */     return this.em;
/*    */   }
/*    */ 
/*    */   public LignecommandefournisseurFacade() {
/* 31 */     super(Lignecommandefournisseur.class);
/*    */   }
/*    */ 
/*    */   public Long nextVal()
/*    */   {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(l.idlignecommandefournisseur) FROM Lignecommandefournisseur l");
/* 37 */     Long result = (Long)query.getSingleResult();
/* 38 */     if (result == null)
/* 39 */       result = Long.valueOf(1L);
/*    */     else {
/* 41 */       result = Long.valueOf(result.longValue() + 1L);
/*    */     }
/* 43 */     return result;
/*    */   }
/*    */ 
/*    */   public List<Lignecommandefournisseur> findAllRange()
/*    */   {
/* 48 */     return this.em.createQuery("SELECT l FROM Lignecommandefournisseur l").getResultList();
/*    */   }
/*    */ 
/*    */   public List<Lignecommandefournisseur> findByCommande(long idcommande)
/*    */   {
/* 53 */     Query query = this.em.createQuery("SELECT l FROM Lignecommandefournisseur l WHERE l.idcommandefournisseur.idcommandefournisseur=:idcommande");
/* 54 */     query.setParameter("idcommande", Long.valueOf(idcommande));
/* 55 */     return query.getResultList();
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LignecommandefournisseurFacade
 * JD-Core Version:    0.6.2
 */