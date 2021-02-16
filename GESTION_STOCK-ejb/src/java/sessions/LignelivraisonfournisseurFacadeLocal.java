package sessions;

import entities.Lignelivraisonfournisseur;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface LignelivraisonfournisseurFacadeLocal
{
  public abstract void create(Lignelivraisonfournisseur paramLignelivraisonfournisseur);

  public abstract void edit(Lignelivraisonfournisseur paramLignelivraisonfournisseur);

  public abstract void remove(Lignelivraisonfournisseur paramLignelivraisonfournisseur);

  public abstract Lignelivraisonfournisseur find(Object paramObject);

  public abstract List<Lignelivraisonfournisseur> findAll();

  public abstract List<Lignelivraisonfournisseur> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Long nextVal();

  public abstract List<Lignelivraisonfournisseur> findByIdlivraison(long paramLong);

  public abstract List<Lignelivraisonfournisseur> findByIdarticle(long paramLong);
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LignelivraisonfournisseurFacadeLocal
 * JD-Core Version:    0.6.2
 */