package sessions;

import entities.Inventaire;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class InventaireFacade extends AbstractFacade<Inventaire> implements InventaireFacadeLocal {

    @PersistenceContext(unitName = "GESTION_STOCK-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return this.em;
    }

    public InventaireFacade() {
        super(Inventaire.class);
    }

    @Override
    public Long nextVal() {
        Query query = this.em.createQuery("SELECT MAX(i.idinventaire) FROM Inventaire i");
        Long result = (Long) query.getSingleResult();
        if (result == null) {
            result = 1L;
        } else {
            result += 1L;
        }
        return result;
    }

    @Override
    public List<Inventaire> findAllRange() {
        Query query = this.em.createQuery("SELECT i FROM Inventaire i ORDER BY i.dateinventaire DESC");
        return query.getResultList();
    }
}
