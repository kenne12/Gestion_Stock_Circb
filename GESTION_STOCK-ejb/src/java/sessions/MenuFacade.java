/*    */ package sessions;
/*    */ 
/*    */ import entities.Menu;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ @Stateless
/*    */ public class MenuFacade extends AbstractFacade<Menu>
/*    */   implements MenuFacadeLocal
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
/*    */   public MenuFacade() {
/* 31 */     super(Menu.class);
/*    */   }
/*    */ 
/*    */   public Long nextVal()
/*    */   {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(p.idprivilege) FROM Privilege p");
/* 37 */     Long result = (Long)query.getSingleResult();
/* 38 */     if (result == null)
/* 39 */       result = Long.valueOf(1L);
/*    */     else {
/* 41 */       result = Long.valueOf(result.longValue() + 1L);
/*    */     }
/* 43 */     return result;
/*    */   }
/*    */ 
/*    */   public List<Menu> findAllRangeEtatIsTrue()
/*    */   {
/* 48 */     Query query = this.em.createQuery("SELECT m FROM Menu m WHERE m.etat=true ORDER BY m.nom");
/* 49 */     return query.getResultList();
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.MenuFacade
 * JD-Core Version:    0.6.2
 */