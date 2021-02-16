/*    */ package sessions;
/*    */ 
/*    */ import entities.Lignelivraisonfournisseur;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ @Stateless
/*    */ public class LignelivraisonfournisseurFacade extends AbstractFacade<Lignelivraisonfournisseur>
/*    */   implements LignelivraisonfournisseurFacadeLocal
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
/*    */   public LignelivraisonfournisseurFacade() {
/* 31 */     super(Lignelivraisonfournisseur.class);
/*    */   }
/*    */ 
/*    */   public Long nextVal()
/*    */   {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(l.idlignelivraisonfournisseur) FROM Lignelivraisonfournisseur l");
/* 37 */     Long result = (Long)query.getSingleResult();
/* 38 */     if (result == null)
/* 39 */       result = Long.valueOf(1L);
/*    */     else {
/* 41 */       result = Long.valueOf(result.longValue() + 1L);
/*    */     }
/* 43 */     return result;
/*    */   }
/*    */ 
/*    */   public List<Lignelivraisonfournisseur> findByIdlivraison(long idlivraison)
/*    */   {
/* 48 */     Query query = this.em.createQuery("SELECT l FROM Lignelivraisonfournisseur l WHERE l.idlivraisonfournisseur.idlivraisonfournisseur=:idlivraison");
/* 49 */     query.setParameter("idlivraison", Long.valueOf(idlivraison));
/* 50 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   public List<Lignelivraisonfournisseur> findByIdarticle(long idarticle)
/*    */   {
/* 55 */     Query query = this.em.createQuery("SELECT l FROM Lignelivraisonfournisseur l WHERE l.idlot.idarticle.idarticle=:idarticle");
/* 56 */     query.setParameter("idarticle", Long.valueOf(idarticle));
/* 57 */     return query.getResultList();
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LignelivraisonfournisseurFacade
 * JD-Core Version:    0.6.2
 */