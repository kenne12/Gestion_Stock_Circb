/*    */ package sessions;
/*    */ 
/*    */ import entities.Laboratoire;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ @Stateless
/*    */ public class LaboratoireFacade extends AbstractFacade<Laboratoire>
/*    */   implements LaboratoireFacadeLocal
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
/*    */   public LaboratoireFacade() {
/* 31 */     super(Laboratoire.class);
/*    */   }
/*    */ 
/*    */   public Integer nextVal()
/*    */   {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(l.idlaboratoire) FROM Laboratoire l");
/* 37 */     Integer result = (Integer)query.getSingleResult();
/* 38 */     if (result == null)
/* 39 */       result = Integer.valueOf(1);
/*    */     else {
/* 41 */       result = Integer.valueOf(result.intValue() + 1);
/*    */     }
/* 43 */     return result;
/*    */   }
/*    */ 
/*    */   public List<Laboratoire> findAllRange()
/*    */   {
/* 48 */     return this.em.createQuery("SELECT l FROM Laboratoire l ORDER BY l.nom").getResultList();
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LaboratoireFacade
 * JD-Core Version:    0.6.2
 */