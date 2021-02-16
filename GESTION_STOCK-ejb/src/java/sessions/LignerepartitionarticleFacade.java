/*    */ package sessions;
/*    */ 
/*    */ import entities.Lignerepartitionarticle;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ @Stateless
/*    */ public class LignerepartitionarticleFacade extends AbstractFacade<Lignerepartitionarticle>
/*    */   implements LignerepartitionarticleFacadeLocal
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
/*    */   public LignerepartitionarticleFacade() {
/* 31 */     super(Lignerepartitionarticle.class);
/*    */   }
/*    */ 
/*    */   public Long nextVal()
/*    */   {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(l.idlignerepartitionarticle) FROM Lignerepartitionarticle l");
/* 37 */     Long result = (Long)query.getSingleResult();
/* 38 */     if (result == null)
/* 39 */       result = Long.valueOf(1L);
/*    */     else {
/* 41 */       result = Long.valueOf(result.longValue() + 1L);
/*    */     }
/* 43 */     return result;
/*    */   }
/*    */ 
/*    */   public List<Lignerepartitionarticle> findByIdRepartition(int idRepartition)
/*    */   {
/* 48 */     Query query = this.em.createQuery("SELECT l FROM Lignerepartitionarticle l WHERE l.idrepartitionarticle.idrepartitionarticle=:idrepartition");
/* 49 */     query.setParameter("idrepartition", Integer.valueOf(idRepartition));
/* 50 */     return query.getResultList();
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LignerepartitionarticleFacade
 * JD-Core Version:    0.6.2
 */