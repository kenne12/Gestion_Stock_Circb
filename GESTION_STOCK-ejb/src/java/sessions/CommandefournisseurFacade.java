package sessions;

import entities.Commandefournisseur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CommandefournisseurFacade extends AbstractFacade<Commandefournisseur> implements CommandefournisseurFacadeLocal {

    @PersistenceContext(unitName = "GESTION_STOCK-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        /* 27 */ return this.em;
    }

    public CommandefournisseurFacade() {
        /* 31 */ super(Commandefournisseur.class);
    }

    @Override
    public Long nextVal() {
         Query query = this.em.createQuery("SELECT MAX(c.idcommandefournisseur) FROM Commandefournisseur c");
        Long result = (Long) query.getSingleResult();
       if (result == null) /* 39 */ {
            result = Long.valueOf(1L);
        } else {
            result = Long.valueOf(result.longValue() + 1L);
        }
      return result;
    }

    @Override
    public List<Commandefournisseur> findAllRange() {
        return this.em.createQuery("SELECT c FROM Commandefournisseur c ORDER BY c.datecommande DESC").getResultList();
    }

    @Override
    public List<Commandefournisseur> findByLivre(boolean livree) {
        Query query = this.em.createQuery("SELECT c FROM Commandefournisseur c WHERE c.livre=:livree ORDER BY c.datecommande DESC");
        query.setParameter("livree", Boolean.valueOf(livree));
        return query.getResultList();
    }
}
