/*    */ package sessions;
/*    */ 
/*    */ import entities.Ligneentreedirect;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ 
/*    */ @Stateless
/*    */ public class LigneentreedirectFacade extends AbstractFacade<Ligneentreedirect>
/*    */   implements LigneentreedirectFacadeLocal
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
/*    */   public LigneentreedirectFacade() {
/* 28 */     super(Ligneentreedirect.class);
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LigneentreedirectFacade
 * JD-Core Version:    0.6.2
 */