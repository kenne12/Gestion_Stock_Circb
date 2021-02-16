package sessions;

import entities.Laboratoire;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface LaboratoireFacadeLocal
{
  public abstract void create(Laboratoire paramLaboratoire);

  public abstract void edit(Laboratoire paramLaboratoire);

  public abstract void remove(Laboratoire paramLaboratoire);

  public abstract Laboratoire find(Object paramObject);

  public abstract List<Laboratoire> findAll();

  public abstract List<Laboratoire> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Integer nextVal();

  public abstract List<Laboratoire> findAllRange();
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LaboratoireFacadeLocal
 * JD-Core Version:    0.6.2
 */