package sessions;

import entities.Menu;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface MenuFacadeLocal
{
  public abstract void create(Menu paramMenu);

  public abstract void edit(Menu paramMenu);

  public abstract void remove(Menu paramMenu);

  public abstract Menu find(Object paramObject);

  public abstract List<Menu> findAll();

  public abstract List<Menu> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Long nextVal();

  public abstract List<Menu> findAllRangeEtatIsTrue();
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.MenuFacadeLocal
 * JD-Core Version:    0.6.2
 */