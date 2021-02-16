/*    */ package sessions;
/*    */ 
/*    */ import entities.Service;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ @Stateless
/*    */ public class ServiceFacade extends AbstractFacade<Service>
/*    */   implements ServiceFacadeLocal
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
/*    */   public ServiceFacade() {
/* 30 */     super(Service.class);
/*    */   }
/*    */ 
/*    */   public Integer nextVal()
/*    */   {
/* 35 */     Query query = this.em.createQuery("SELECT MAX(s.idservice) FROM Service s");
/* 36 */     Integer result = (Integer)query.getSingleResult();
/* 37 */     if (result == null)
/* 38 */       result = Integer.valueOf(1);
/*    */     else {
/* 40 */       result = Integer.valueOf(result.intValue() + 1);
/*    */     }
/* 42 */     return result;
/*    */   }
/*    */ 
/*    */   public List<Service> findAllRange()
/*    */   {
/* 47 */     return this.em.createQuery("SELECT s FROM Service s ORDER BY s.nom").getResultList();
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.ServiceFacade
 * JD-Core Version:    0.6.2
 */