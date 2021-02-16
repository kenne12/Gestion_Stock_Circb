package sessions;

import entities.Livraisonclient;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface LivraisonclientFacadeLocal {

    public abstract void create(Livraisonclient paramLivraisonclient);

    public abstract void edit(Livraisonclient paramLivraisonclient);

    public abstract void remove(Livraisonclient paramLivraisonclient);

    public abstract Livraisonclient find(Object paramObject);

    public abstract List<Livraisonclient> findAll();

    public abstract List<Livraisonclient> findRange(int[] paramArrayOfInt);

    public int count();

    public Long nextVal();

    public List<Livraisonclient> findAllRange();

    public Livraisonclient findByIddemande(long iddemande);
}
