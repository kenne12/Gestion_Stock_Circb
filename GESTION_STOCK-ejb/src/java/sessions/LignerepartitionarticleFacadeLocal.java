package sessions;

import entities.Lignerepartitionarticle;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface LignerepartitionarticleFacadeLocal
{
  public abstract void create(Lignerepartitionarticle paramLignerepartitionarticle);

  public abstract void edit(Lignerepartitionarticle paramLignerepartitionarticle);

  public abstract void remove(Lignerepartitionarticle paramLignerepartitionarticle);

  public abstract Lignerepartitionarticle find(Object paramObject);

  public abstract List<Lignerepartitionarticle> findAll();

  public abstract List<Lignerepartitionarticle> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Long nextVal();

  public abstract List<Lignerepartitionarticle> findByIdRepartition(int paramInt);
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LignerepartitionarticleFacadeLocal
 * JD-Core Version:    0.6.2
 */