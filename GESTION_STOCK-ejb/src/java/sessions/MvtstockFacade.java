/*    */ package sessions;
/*    */ 
/*    */ import entities.Mvtstock;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ @Stateless
/*    */ public class MvtstockFacade extends AbstractFacade<Mvtstock>
/*    */   implements MvtstockFacadeLocal
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
/*    */   public MvtstockFacade() {
/* 31 */     super(Mvtstock.class);
/*    */   }
/*    */ 
/*    */   public Long nextVal()
/*    */   {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(m.idmvtstock) FROM Mvtstock m");
/* 37 */     Long result = (Long)query.getSingleResult();
/* 38 */     if (result == null)
/* 39 */       result = Long.valueOf(1L);
/*    */     else {
/* 41 */       result = Long.valueOf(result.longValue() + 1L);
/*    */     }
/* 43 */     return result;
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.MvtstockFacade
 * JD-Core Version:    0.6.2
 */