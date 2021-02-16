/*    */ package sessions;
/*    */ 
/*    */ import entities.Fournisseur;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ @Stateless
/*    */ public class FournisseurFacade extends AbstractFacade<Fournisseur>
/*    */   implements FournisseurFacadeLocal
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
/*    */   public FournisseurFacade() {
/* 31 */     super(Fournisseur.class);
/*    */   }
/*    */ 
/*    */   public Integer nextVal()
/*    */   {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(f.idfournisseur) FROM Fournisseur f");
/* 37 */     Integer result = (Integer)query.getSingleResult();
/* 38 */     if (result == null)
/* 39 */       result = Integer.valueOf(1);
/*    */     else {
/* 41 */       result = Integer.valueOf(result.intValue() + 1);
/*    */     }
/* 43 */     return result;
/*    */   }
/*    */ 
/*    */   public List<Fournisseur> findAllRange()
/*    */   {
/* 48 */     return this.em.createQuery("SELECT f FROM Fournisseur f ORDER BY f.nom").getResultList();
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.FournisseurFacade
 * JD-Core Version:    0.6.2
 */