/*    */ package sessions;
/*    */ 
/*    */ import entities.Parametrage;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ 
/*    */ @Stateless
/*    */ public class ParametrageFacade extends AbstractFacade<Parametrage>
/*    */   implements ParametrageFacadeLocal
/*    */ {
/*    */ 
/*    */   @PersistenceContext(unitName="GESTION_STOCK-ejbPU")
/*    */   private EntityManager em;
/*    */ 
/*    */   protected EntityManager getEntityManager()
/*    */   {
/* 24 */     return this.em;
/*    */   }
/*    */ 
/*    */   public ParametrageFacade() {
/* 28 */     super(Parametrage.class);
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.ParametrageFacade
 * JD-Core Version:    0.6.2
 */