package sessions;

import entities.Lignelivraisonclient;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LignelivraisonclientFacade extends AbstractFacade<Lignelivraisonclient> implements LignelivraisonclientFacadeLocal {

    @PersistenceContext(unitName = "GESTION_STOCK-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return this.em;
    }

    public LignelivraisonclientFacade() {
        super(Lignelivraisonclient.class);
    }

    @Override
    public Long nextVal() {
        Query query = this.em.createQuery("SELECT MAX(l.idlignelivraisonclient) FROM Lignelivraisonclient l");
        Long result = (Long) query.getSingleResult();
        if (result == null) {
            result = 1L;
        } else {
            result += 1L;
        }
        return result;
    }

    @Override
    public List<Lignelivraisonclient> findByIdlivraisonclient(long idlivraisonclient) {
        Query query = this.em.createQuery("SELECT l FROM Lignelivraisonclient l WHERE l.idlivraisonclient.idlivraisonclient=:idlivraisonclient");
        query.setParameter("idlivraisonclient", idlivraisonclient);
        return query.getResultList();
    }

    @Override
    public List<Lignelivraisonclient> findAllRange() {
        Query query = this.em.createQuery("SELECT l FROM Lignelivraisonclient l ORDER BY l.idlivraisonclient.datelivraison");
        return query.getResultList();
    }

    @Override
    public List<Lignelivraisonclient> findByIdprojet(int idprojet, Date dateDebut, Date dateFin) {
        Query query = em.createQuery("SELECT l FROM Lignelivraisonclient l WHERE l.idlivraisonclient.iddemande.idprojet.idprojet=:idprojet AND l.idlivraisonclient.datelivraison BETWEEN :dateDebut AND :dateFin");
        query.setParameter("idprojet", idprojet).setParameter("dateDebut", dateDebut).setParameter("dateFin", dateFin);
        return query.getResultList();
    }

    @Override
    public List<Lignelivraisonclient> findByIdArticle(long idarticle) {
        Query query = em.createQuery("SELECT l FROM Lignelivraisonclient l WHERE l.idmagasinlot.idmagasinarticle.idarticle.idarticle=:idarticle");
        query.setParameter("idarticle", idarticle);
        return query.getResultList();
    }
}
