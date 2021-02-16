package sessions;

import entities.Lignemvtstock;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface LignemvtstockFacadeLocal {

    public abstract void create(Lignemvtstock paramLignemvtstock);

    public abstract void edit(Lignemvtstock paramLignemvtstock);

    public abstract void remove(Lignemvtstock paramLignemvtstock);

    public abstract Lignemvtstock find(Object paramObject);

    public abstract List<Lignemvtstock> findAll();

    public abstract List<Lignemvtstock> findRange(int[] paramArrayOfInt);

    public abstract int count();

    public Long nextVal();

    public List<Lignemvtstock> findByIdmvt(long idMvt);

    public void deleteByIdmvt(long idMvt);

    public List<Lignemvtstock> findByIdarticleIntevalDate(long paramLong, Date paramDate1, Date paramDate2);

    public List<Lignemvtstock> findByIdmagasinIntevalDate(int idmagasin, Date dateDebut, Date dateFin);

}
