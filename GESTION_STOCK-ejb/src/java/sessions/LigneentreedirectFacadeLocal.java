package sessions;

import entities.Ligneentreedirect;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface LigneentreedirectFacadeLocal
{
  public abstract void create(Ligneentreedirect paramLigneentreedirect);

  public abstract void edit(Ligneentreedirect paramLigneentreedirect);

  public abstract void remove(Ligneentreedirect paramLigneentreedirect);

  public abstract Ligneentreedirect find(Object paramObject);

  public abstract List<Ligneentreedirect> findAll();

  public abstract List<Ligneentreedirect> findRange(int[] paramArrayOfInt);

  public abstract int count();
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LigneentreedirectFacadeLocal
 * JD-Core Version:    0.6.2
 */