package sessions;

import entities.Ligneinventaire;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface LigneinventaireFacadeLocal
{
  public abstract void create(Ligneinventaire paramLigneinventaire);

  public abstract void edit(Ligneinventaire paramLigneinventaire);

  public abstract void remove(Ligneinventaire paramLigneinventaire);

  public abstract Ligneinventaire find(Object paramObject);

  public abstract List<Ligneinventaire> findAll();

  public abstract List<Ligneinventaire> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Long nextVal();

  public abstract List<Ligneinventaire> findByIdInventaire(long paramLong);

  public abstract void removeByIdInventaire(long paramLong);
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LigneinventaireFacadeLocal
 * JD-Core Version:    0.6.2
 */