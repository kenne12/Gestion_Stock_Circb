package sessions;

import entities.Fournisseur;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface FournisseurFacadeLocal
{
  public abstract void create(Fournisseur paramFournisseur);

  public abstract void edit(Fournisseur paramFournisseur);

  public abstract void remove(Fournisseur paramFournisseur);

  public abstract Fournisseur find(Object paramObject);

  public abstract List<Fournisseur> findAll();

  public abstract List<Fournisseur> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Integer nextVal();

  public abstract List<Fournisseur> findAllRange();
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.FournisseurFacadeLocal
 * JD-Core Version:    0.6.2
 */