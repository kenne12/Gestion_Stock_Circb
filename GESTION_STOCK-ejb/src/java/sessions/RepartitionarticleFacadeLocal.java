package sessions;

import entities.Repartitionarticle;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface RepartitionarticleFacadeLocal
{
  public abstract void create(Repartitionarticle paramRepartitionarticle);

  public abstract void edit(Repartitionarticle paramRepartitionarticle);

  public abstract void remove(Repartitionarticle paramRepartitionarticle);

  public abstract Repartitionarticle find(Object paramObject);

  public abstract List<Repartitionarticle> findAll();

  public abstract List<Repartitionarticle> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Integer nextVal();

  public abstract List<Repartitionarticle> findAllRange();
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.RepartitionarticleFacadeLocal
 * JD-Core Version:    0.6.2
 */