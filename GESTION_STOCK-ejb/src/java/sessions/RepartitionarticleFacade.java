/*    */ package sessions;
/*    */ 
/*    */ import entities.Repartitionarticle;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ @Stateless
/*    */ public class RepartitionarticleFacade extends AbstractFacade<Repartitionarticle>
/*    */   implements RepartitionarticleFacadeLocal
/*    */ {
/*    */ 
/*    */   @PersistenceContext(unitName="GESTION_STOCK-ejbPU")
/*    */   private EntityManager em;
/*    */ 
/*    */   protected EntityManager getEntityManager()
/*    */   {
/* 26 */     return this.em;
/*    */   }
/*    */ 
/*    */   public RepartitionarticleFacade() {
/* 30 */     super(Repartitionarticle.class);
/*    */   }
/*    */ 
/*    */   public Integer nextVal()
/*    */   {
/* 35 */     Query query = this.em.createQuery("SELECT MAX(r.idrepartitionarticle) FROM Repartitionarticle r");
/* 36 */     Integer result = (Integer)query.getSingleResult();
/* 37 */     if (result == null)
/* 38 */       result = Integer.valueOf(1);
/*    */     else {
/* 40 */       result = Integer.valueOf(result.intValue() + 1);
/*    */     }
/* 42 */     return result;
/*    */   }
/*    */ 
/*    */   public List<Repartitionarticle> findAllRange()
/*    */   {
/* 47 */     return this.em.createQuery("SELECT r FROM Repartitionarticle r ORDER BY r.date DESC").getResultList();
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.RepartitionarticleFacade
 * JD-Core Version:    0.6.2
 */