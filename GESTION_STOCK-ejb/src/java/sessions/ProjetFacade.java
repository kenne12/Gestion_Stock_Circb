/*    */ package sessions;
/*    */ 
/*    */ import entities.Projet;
/*    */ import java.util.List;
/*    */ import javax.ejb.Stateless;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.PersistenceContext;
/*    */ import javax.persistence.Query;
/*    */ 
/*    */ @Stateless
/*    */ public class ProjetFacade extends AbstractFacade<Projet>
/*    */   implements ProjetFacadeLocal
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
/*    */   public ProjetFacade() {
/* 31 */     super(Projet.class);
/*    */   }
/*    */ 
/*    */   public Integer nextVal()
/*    */   {
/* 36 */     Query query = this.em.createQuery("SELECT MAX(p.idprojet) FROM Projet p");
/* 37 */     Integer result = (Integer)query.getSingleResult();
/* 38 */     if (result == null)
/* 39 */       result = Integer.valueOf(1);
/*    */     else {
/* 41 */       result = Integer.valueOf(result.intValue() + 1);
/*    */     }
/* 43 */     return result;
/*    */   }
/*    */ 
/*    */   public List<Projet> findAllRange()
/*    */   {
/* 48 */     Query query = this.em.createQuery("SELECT p FROM Projet p ORDER BY p.nom");
/* 49 */     return query.getResultList();
/*    */   }
/*    */ 
/*    */   public List<Projet> findByIdmagasin(int idmagasin)
/*    */   {
/* 54 */     Query query = this.em.createQuery("SELECT p FROM Projet p WHERE p.idmagasin.idmagasin=:idmagasin");
/* 55 */     query.setParameter("idmagasin", Integer.valueOf(idmagasin));
/* 56 */     return query.getResultList();
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.ProjetFacade
 * JD-Core Version:    0.6.2
 */