package sessions;

import entities.Service;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface ServiceFacadeLocal
{
  public abstract void create(Service paramService);

  public abstract void edit(Service paramService);

  public abstract void remove(Service paramService);

  public abstract Service find(Object paramObject);

  public abstract List<Service> findAll();

  public abstract List<Service> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Integer nextVal();

  public abstract List<Service> findAllRange();
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.ServiceFacadeLocal
 * JD-Core Version:    0.6.2
 */