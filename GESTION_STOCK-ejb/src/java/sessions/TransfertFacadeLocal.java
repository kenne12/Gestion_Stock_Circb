package sessions;

import entities.Transfert;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface TransfertFacadeLocal
{
  public abstract void create(Transfert paramTransfert);

  public abstract void edit(Transfert paramTransfert);

  public abstract void remove(Transfert paramTransfert);

  public abstract Transfert find(Object paramObject);

  public abstract List<Transfert> findAll();

  public abstract List<Transfert> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Long nextVal();

  public abstract List<Transfert> findAllRange();
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.TransfertFacadeLocal
 * JD-Core Version:    0.6.2
 */