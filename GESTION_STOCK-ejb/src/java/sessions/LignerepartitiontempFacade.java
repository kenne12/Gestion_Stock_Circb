/*    */ package sessions;
/*    */ 
/*    */ import entities.Lignerepartitiontemp;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ @Stateless
/*    */ public class LignerepartitiontempFacade extends AbstractFacade<Lignerepartitiontemp>
/*    */   implements LignerepartitiontempFacadeLocal
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
/*    */   public LignerepartitiontempFacade() {
/* 31 */     super(Lignerepartitiontemp.class);
/*    */   }
/*    */ 
/*    */   public Long nextVal()
/*    */   {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(l.idlignerepartitiontemp) FROM Lignerepartitiontemp l");
/* 37 */     Long result = (Long)query.getSingleResult();
/* 38 */     if (result == null)
/* 39 */       result = Long.valueOf(1L);
/*    */     else {
/* 41 */       result = Long.valueOf(result.longValue() + 1L);
/*    */     }
/* 43 */     return result;
/*    */   }
/*    */ 
/*    */   public List<Lignerepartitiontemp> findByIdRepartition(int idRepartition)
/*    */   {
/* 48 */     Query query = this.em.createQuery("SELECT l FROM Lignerepartitiontemp l WHERE l.idrepartitionarticle.idrepartitionarticle=:idrepartition");
/* 49 */     query.setParameter("idrepartition", Integer.valueOf(idRepartition));
/* 50 */     return query.getResultList();
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LignerepartitiontempFacade
 * JD-Core Version:    0.6.2
 */