package sessions;

import entities.Unite;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface UniteFacadeLocal
{
  public abstract void create(Unite paramUnite);

  public abstract void edit(Unite paramUnite);

  public abstract void remove(Unite paramUnite);

  public abstract Unite find(Object paramObject);

  public abstract List<Unite> findAll();

  public abstract List<Unite> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Long nextVal();

  public abstract List<Unite> findAllRange();
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.UniteFacadeLocal
 * JD-Core Version:    0.6.2
 */