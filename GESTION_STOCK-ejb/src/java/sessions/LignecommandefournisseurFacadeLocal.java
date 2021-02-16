package sessions;

import entities.Lignecommandefournisseur;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface LignecommandefournisseurFacadeLocal
{
  public abstract void create(Lignecommandefournisseur paramLignecommandefournisseur);

  public abstract void edit(Lignecommandefournisseur paramLignecommandefournisseur);

  public abstract void remove(Lignecommandefournisseur paramLignecommandefournisseur);

  public abstract Lignecommandefournisseur find(Object paramObject);

  public abstract List<Lignecommandefournisseur> findAll();

  public abstract List<Lignecommandefournisseur> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Long nextVal();

  public abstract List<Lignecommandefournisseur> findAllRange();

  public abstract List<Lignecommandefournisseur> findByCommande(long paramLong);
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LignecommandefournisseurFacadeLocal
 * JD-Core Version:    0.6.2
 */