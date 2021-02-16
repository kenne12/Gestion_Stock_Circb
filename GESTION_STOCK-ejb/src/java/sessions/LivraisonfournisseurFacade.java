/*    */ package sessions;
/*    */ 
/*    */ import entities.Livraisonfournisseur;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ @Stateless
/*    */ public class LivraisonfournisseurFacade extends AbstractFacade<Livraisonfournisseur>
/*    */   implements LivraisonfournisseurFacadeLocal
/*    */ {
/*    */ 
/*    */   @PersistenceContext(unitName="GESTION_STOCK-ejbPU")
/*    */   private EntityManager em;
/*    */ 
/*    */   protected EntityManager getEntityManager()
/*    */   {
/* 28 */     return this.em;
/*    */   }
/*    */ 
/*    */   public LivraisonfournisseurFacade() {
/* 32 */     super(Livraisonfournisseur.class);
/*    */   }
/*    */ 
/*    */   public Long nextVal()
/*    */   {
/* 37 */     Query query = this.em.createQuery("SELECT MAX(l.idlivraisonfournisseur) FROM Livraisonfournisseur l");
/* 38 */     Long result = (Long)query.getSingleResult();
/* 39 */     if (result == null)
/* 40 */       result = Long.valueOf(1L);
/*    */     else {
/* 42 */       result = Long.valueOf(result.longValue() + 1L);
/*    */     }
/* 44 */     return result;
/*    */   }
/*    */ 
/*    */   public List<Livraisonfournisseur> findAllRange()
/*    */   {
/* 49 */     return this.em.createQuery("SELECT l FROM Livraisonfournisseur l ORDER BY l.datelivraison DESC").getResultList();
/*    */   }
/*    */ 
/*    */   public List<Livraisonfournisseur> findAllRange(boolean livraisonDirecte)
/*    */   {
/* 54 */     return this.em.createQuery("SELECT l FROM Livraisonfournisseur l WHERE l.livraisondirecte=:livraisonDirecte ORDER BY l.datelivraison DESC").setParameter("livraisonDirecte", Boolean.valueOf(livraisonDirecte)).getResultList();
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LivraisonfournisseurFacade
 * JD-Core Version:    0.6.2
 */