package sessions;

import entities.Projet;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface ProjetFacadeLocal
{
  public abstract void create(Projet paramProjet);

  public abstract void edit(Projet paramProjet);

  public abstract void remove(Projet paramProjet);

  public abstract Projet find(Object paramObject);

  public abstract List<Projet> findAll();

  public abstract List<Projet> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Integer nextVal();

  public abstract List<Projet> findAllRange();

  public abstract List<Projet> findByIdmagasin(int paramInt);
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.ProjetFacadeLocal
 * JD-Core Version:    0.6.2
 */