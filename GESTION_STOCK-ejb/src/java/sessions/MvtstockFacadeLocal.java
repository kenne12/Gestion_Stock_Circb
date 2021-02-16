package sessions;

import entities.Mvtstock;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface MvtstockFacadeLocal
{
  public abstract void create(Mvtstock paramMvtstock);

  public abstract void edit(Mvtstock paramMvtstock);

  public abstract void remove(Mvtstock paramMvtstock);

  public abstract Mvtstock find(Object paramObject);

  public abstract List<Mvtstock> findAll();

  public abstract List<Mvtstock> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Long nextVal();
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.MvtstockFacadeLocal
 * JD-Core Version:    0.6.2
 */