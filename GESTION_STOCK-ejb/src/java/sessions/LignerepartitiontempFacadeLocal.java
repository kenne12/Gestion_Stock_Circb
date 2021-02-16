package sessions;

import entities.Lignerepartitiontemp;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface LignerepartitiontempFacadeLocal
{
  public abstract void create(Lignerepartitiontemp paramLignerepartitiontemp);

  public abstract void edit(Lignerepartitiontemp paramLignerepartitiontemp);

  public abstract void remove(Lignerepartitiontemp paramLignerepartitiontemp);

  public abstract Lignerepartitiontemp find(Object paramObject);

  public abstract List<Lignerepartitiontemp> findAll();

  public abstract List<Lignerepartitiontemp> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Long nextVal();

  public abstract List<Lignerepartitiontemp> findByIdRepartition(int paramInt);
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LignerepartitiontempFacadeLocal
 * JD-Core Version:    0.6.2
 */