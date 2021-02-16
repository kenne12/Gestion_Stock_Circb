/*    */ package sessions;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.persistence.EntityManager;
/*    */ import javax.persistence.Query;
/*    */ import javax.persistence.TypedQuery;
/*    */ import javax.persistence.criteria.CriteriaBuilder;
/*    */ import javax.persistence.criteria.CriteriaQuery;
/*    */ import javax.persistence.criteria.Root;
/*    */ 
/*    */ public abstract class AbstractFacade<T>
/*    */ {
/*    */   private Class<T> entityClass;
/*    */ 
/*    */   public AbstractFacade(Class<T> entityClass)
/*    */   {
/* 19 */     this.entityClass = entityClass;
/*    */   }
/*    */ 
/*    */   protected abstract EntityManager getEntityManager();
/*    */ 
/*    */   public void create(T entity) {
/* 25 */     getEntityManager().persist(entity);
/*    */   }
/*    */ 
/*    */   public void edit(T entity) {
/* 29 */     getEntityManager().merge(entity);
/*    */   }
/*    */ 
/*    */   public void remove(T entity) {
/* 33 */     getEntityManager().remove(getEntityManager().merge(entity));
/*    */   }
/*    */ 
/*    */   public T find(Object id) {
/* 37 */     return getEntityManager().find(this.entityClass, id);
/*    */   }
/*    */ 
/*    */   public List<T> findAll() {
/* 41 */     CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
/* 42 */     cq.select(cq.from(this.entityClass));
/* 43 */     return getEntityManager().createQuery(cq).getResultList();
/*    */   }
/*    */ 
/*    */   public List<T> findRange(int[] range) {
/* 47 */     CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
/* 48 */     cq.select(cq.from(this.entityClass));
/* 49 */     Query q = getEntityManager().createQuery(cq);
/* 50 */     q.setMaxResults(range[1] - range[0] + 1);
/* 51 */     q.setFirstResult(range[0]);
/* 52 */     return q.getResultList();
/*    */   }
/*    */ 
/*    */   public int count() {
/* 56 */     CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
/* 57 */     Root rt = cq.from(this.entityClass);
/* 58 */     cq.select(getEntityManager().getCriteriaBuilder().count(rt));
/* 59 */     Query q = getEntityManager().createQuery(cq);
/* 60 */     return ((Long)q.getSingleResult()).intValue();
/*    */   }
/*    */ }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.AbstractFacade
 * JD-Core Version:    0.6.2
 */