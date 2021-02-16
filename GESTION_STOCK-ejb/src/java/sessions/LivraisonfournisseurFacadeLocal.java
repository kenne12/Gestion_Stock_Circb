package sessions;

import entities.Livraisonfournisseur;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface LivraisonfournisseurFacadeLocal
{
  public abstract void create(Livraisonfournisseur paramLivraisonfournisseur);

  public abstract void edit(Livraisonfournisseur paramLivraisonfournisseur);

  public abstract void remove(Livraisonfournisseur paramLivraisonfournisseur);

  public abstract Livraisonfournisseur find(Object paramObject);

  public abstract List<Livraisonfournisseur> findAll();

  public abstract List<Livraisonfournisseur> findRange(int[] paramArrayOfInt);

  public abstract int count();

  public abstract Long nextVal();

  public abstract List<Livraisonfournisseur> findAllRange();

  public abstract List<Livraisonfournisseur> findAllRange(boolean paramBoolean);
}

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     sessions.LivraisonfournisseurFacadeLocal
 * JD-Core Version:    0.6.2
 */