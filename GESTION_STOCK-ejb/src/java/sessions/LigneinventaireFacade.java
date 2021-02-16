/*    */ package sessions;
/*    */ 
/*    */ import entities.Ligneinventaire;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ @Stateless
/*    */ public class LigneinventaireFacade extends AbstractFacade<Ligneinventaire>
/*    */   implements LigneinventaireFacadeLocal
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
/*    */   public LigneinventaireFacade() {
/* 31 */     super(Ligneinventaire.class);
/*    */   }
/*    */ 
/*    */   public Long nextVal()
/*    */   {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(l.idligneinventaire) FROM Ligneinventaire l");
/* 37 */     Long result = (Long)query.getSingleResult();
/* 38 */     if (result == null)
/* 39 */       result = Long.valueOf(1L);
/*    */     else {
/* 41 */       result = Long.valueOf(result.longValue() + 1L);
/*    */     }
/* 43 */     return result;
/*    */   }
/*    */ 
/*    */   public List<Ligneinventaire> findByIdInventaire(long idinventaire)
/*    */   {
/* 48 */     Query query = this.em.createQuery("SELECT l FROM Ligneinventaire l WHERE l.idinventaire.idinventaire=:idinventaire");
/* 49 */     query.setParameter("idinventaire", Long.valueOf(idinventaire));
/* 50 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   public void removeByIdInventaire(long idinventaire)
/*    */   {
/* 55 */     Query query = this.em.createQuery("DELETE FROM Ligneinventaire l WHERE l.idinventaire.idinventaire=:idinventaire");
/* 56 */     query.setParameter("idinventaire", Long.valueOf(idinventaire));
/* 57 */     query.executeUpdate();
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LigneinventaireFacade
 * JD-Core Version:    0.6.2
 */