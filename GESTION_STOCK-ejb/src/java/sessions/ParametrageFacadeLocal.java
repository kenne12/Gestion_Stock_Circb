package sessions;

import entities.Parametrage;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface ParametrageFacadeLocal
{
  public abstract void create(Parametrage paramParametrage);

  public abstract void edit(Parametrage paramParametrage);

  public abstract void remove(Parametrage paramParametrage);

  public abstract Parametrage find(Object paramObject);

  public abstract List<Parametrage> findAll();

  public abstract List<Parametrage> findRange(int[] paramArrayOfInt);

  public abstract int count();
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.ParametrageFacadeLocal
 * JD-Core Version:    0.6.2
 */