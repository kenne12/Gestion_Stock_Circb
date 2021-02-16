package sessions;

import entities.Qualite;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface QualiteFacadeLocal
{
  public abstract void create(Qualite paramQualite);

  public abstract void edit(Qualite paramQualite);

  public abstract void remove(Qualite paramQualite);

  public abstract Qualite find(Object paramObject);

  public abstract List<Qualite> findAll();

  public abstract List<Qualite> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Integer nextVal();

  public abstract List<Qualite> findAllRange();
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.QualiteFacadeLocal
 * JD-Core Version:    0.6.2
 */