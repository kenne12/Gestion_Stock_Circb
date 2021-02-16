/*    */ package sessions;
/*    */ 
/*    */ import entities.Qualite;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ @Stateless
/*    */ public class QualiteFacade extends AbstractFacade<Qualite>
/*    */   implements QualiteFacadeLocal
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
/*    */   public QualiteFacade() {
/* 31 */     super(Qualite.class);
/*    */   }
/*    */ 
/*    */   public Integer nextVal()
/*    */   {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(q.idqualite) FROM Qualite q");
/* 37 */     Integer result = (Integer)query.getSingleResult();
/* 38 */     if (result == null)
/* 39 */       result = Integer.valueOf(1);
/*    */     else {
/* 41 */       result = Integer.valueOf(result.intValue() + 1);
/*    */     }
/* 43 */     return result;
/*    */   }
/*    */ 
/*    */   public List<Qualite> findAllRange()
/*    */   {
/* 48 */     return this.em.createQuery("SELECT q FROM Qualite q ORDER BY q.nom").getResultList();
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.QualiteFacade
 * JD-Core Version:    0.6.2
 */