package sessions;

import entities.Magasinarticle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class MagasinarticleFacade extends AbstractFacade<Magasinarticle>
        implements MagasinarticleFacadeLocal {

    @PersistenceContext(unitName = "GESTION_STOCK-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        /*  27 */ return this.em;
    }

    public MagasinarticleFacade() {
        /*  31 */ super(Magasinarticle.class);
    }

    @Override
    public Long nextVal() {
        Query query = this.em.createQuery("SELECT MAX(m.idmagasinarticle) FROM Magasinarticle m");
        Long result = (Long) query.getSingleResult();
        if (result == null) {
            result = 1L;
        } else {
            result = result + 1L;
        }
        return result;
    }

    @Override
    public List<Magasinarticle> findByIdmagasin(int idmagasin, boolean etat) {
        /*  48 */ Query query = this.em.createQuery("SELECT m FROM Magasinarticle m WHERE m.idmagasin.idmagasin=:idmagasin AND m.etat=:etat ORDER BY m.idarticle.code");
        /*  49 */ query.setParameter("idmagasin", idmagasin).setParameter("etat", Boolean.valueOf(etat));
        /*  50 */ return query.getResultList();
    }

    @Override
    public List<Magasinarticle> findByIdmagasinProductIsActif(int idmagasin, boolean etat) {
        /*  55 */ Query query = this.em.createQuery("SELECT m FROM Magasinarticle m WHERE m.idmagasin.idmagasin=:idmagasin AND m.etat=:etat AND m.idarticle.etat=true ORDER BY m.idarticle.code");
        /*  56 */ query.setParameter("idmagasin", idmagasin).setParameter("etat", Boolean.valueOf(etat));
        /*  57 */ return query.getResultList();
    }

    @Override
    public Magasinarticle findByIdmagasinIdarticle(int idmagasin, long idarticle) {
        /*  62 */ Query query = this.em.createQuery("SELECT m FROM Magasinarticle m WHERE m.idmagasin.idmagasin=:idmagasin AND m.idarticle.idarticle=:idarticle ORDER BY m.idarticle.libelle");
        /*  63 */ query.setParameter("idmagasin", idmagasin).setParameter("idarticle", Long.valueOf(idarticle));
        /*  64 */ List list = query.getResultList();
        /*  65 */ if (!list.isEmpty()) {
            /*  66 */ return (Magasinarticle) list.get(0);
        }
        /*  68 */ return null;
    }

    @Override
    public List<Magasinarticle> findByIdmagasinIsavailable(int idmagasin, boolean etat) {
        /*  73 */ Query query = this.em.createQuery("SELECT m FROM Magasinarticle m WHERE m.idmagasin.idmagasin=:idmagasin AND m.etat=:etat AND m.quantite>0D ORDER BY m.idarticle.libelle");
        /*  74 */ query.setParameter("idmagasin", Integer.valueOf(idmagasin)).setParameter("etat", Boolean.valueOf(etat));
        /*  75 */ return query.getResultList();
    }

    @Override
    public List<Magasinarticle> findByIdmagasinIdfamille(int idmagasin, long idfamille, boolean etat) {
        /*  80 */ Query query = this.em.createQuery("SELECT m FROM Magasinarticle m WHERE m.idmagasin.idmagasin=:idmagasin AND m.idarticle.idfamille.idfamille=:idfamille AND m.etat=:etat ORDER BY m.idarticle.libelle");
        /*  81 */ query.setParameter("idmagasin", idmagasin).setParameter("etat", etat).setParameter("idfamille", Long.valueOf(idfamille));
        /*  82 */ return query.getResultList();
    }

    @Override
    public List<Magasinarticle> findByIdmagasinIdfamilleIsavailable(int idmagasin, long idfamille, boolean etat) {
        /*  87 */ Query query = this.em.createQuery("SELECT m FROM Magasinarticle m WHERE m.idmagasin.idmagasin=:idmagasin AND m.idarticle.idfamille.idfamille=:idfamille AND m.etat=:etat AND m.quantite>0d ORDER BY m.idarticle.libelle");
        /*  88 */ query.setParameter("idmagasin", idmagasin).setParameter("etat", etat).setParameter("idfamille", idfamille);
        /*  89 */ return query.getResultList();
    }

    @Override
    public List<Magasinarticle> findByIdarticle(long idarticle) {
        Query query = this.em.createQuery("SELECT m FROM Magasinarticle m WHERE m.idarticle.idarticle=:idarticle");
        query.setParameter("idarticle", idarticle);
        return query.getResultList();
    }

    @Override
    public void removeAllByIdarticle(long idarticle) {
        Query query = this.em.createQuery("DELETE FROM Magasinarticle ml WHERE ml.idarticle.idarticle=:idarticle");
        query.setParameter("idarticle", idarticle);
        query.executeUpdate();
    }

    @Override
    public List<Magasinarticle> findAllEtatIsTrueAlert() {
        Query query = this.em.createQuery("SELECT m FROM Magasinarticle m WHERE m.etat=true AND m.quantitemultiple<=m.idarticle.quantitesecurite ORDER BY m.idmagasin.nom , m.idarticle.code");
        return query.getResultList();
    }

    @Override
    public List<Magasinarticle> findAllEtatIsTrue() {
        Query query = this.em.createQuery("SELECT m FROM Magasinarticle m WHERE m.etat=true  ORDER BY m.idmagasin.nom , m.idarticle.code");
        return query.getResultList();
    }

    @Override
    public List<Magasinarticle> findByIdmagasinQtyGreater(int idmagasin, boolean etat) {
        Query query = em.createQuery("SELECT m FROM Magasinarticle m WHERE m.idmagasin.idmagasin=:idmagasin AND m.etat=:etat AND m.quantite>0d");
        query.setParameter("idmagasin", idmagasin).setParameter("etat", etat);
        return query.getResultList();
    }
}
