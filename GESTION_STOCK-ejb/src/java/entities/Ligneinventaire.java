 package entities;
 
 import java.io.Serializable;
 import javax.persistence.Basic;
 import javax.persistence.Entity;
 import javax.persistence.FetchType;
 import javax.persistence.Id;
 import javax.persistence.JoinColumn;
 import javax.persistence.ManyToOne;
 import javax.persistence.NamedQueries;
 import javax.validation.constraints.NotNull;
 import javax.validation.constraints.Size;
 import javax.xml.bind.annotation.XmlRootElement;
 
 @Entity
 @XmlRootElement
 @NamedQueries({@javax.persistence.NamedQuery(name="Ligneinventaire.findAll", query="SELECT l FROM Ligneinventaire l"), @javax.persistence.NamedQuery(name="Ligneinventaire.findByIdligneinventaire", query="SELECT l FROM Ligneinventaire l WHERE l.idligneinventaire = :idligneinventaire"), @javax.persistence.NamedQuery(name="Ligneinventaire.findByQtetheorique", query="SELECT l FROM Ligneinventaire l WHERE l.qtetheorique = :qtetheorique"), @javax.persistence.NamedQuery(name="Ligneinventaire.findByQtephysique", query="SELECT l FROM Ligneinventaire l WHERE l.qtephysique = :qtephysique"), @javax.persistence.NamedQuery(name="Ligneinventaire.findByEcart", query="SELECT l FROM Ligneinventaire l WHERE l.ecart = :ecart"), @javax.persistence.NamedQuery(name="Ligneinventaire.findByObservation", query="SELECT l FROM Ligneinventaire l WHERE l.observation = :observation")})
 public class Ligneinventaire
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idligneinventaire;
   private Double qtetheorique;
   private Double qtephysique;
   private Double ecart;
 
   @Size(max=100)
   private String observation;
 
   @JoinColumn(name="idinventaire", referencedColumnName="idinventaire")
   @ManyToOne(fetch=FetchType.LAZY)
   private Inventaire idinventaire;
 
   @JoinColumn(name="idlot", referencedColumnName="idlot")
   @ManyToOne(fetch=FetchType.LAZY)
   private Lot idlot;
 
   @JoinColumn(name="idmagasinlot", referencedColumnName="idmagasinlot")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasinlot idmagasinlot;
 
   public Ligneinventaire()
   {
   }
 
   public Ligneinventaire(Long idligneinventaire)
   {
/*  60 */     this.idligneinventaire = idligneinventaire;
   }
 
   public Long getIdligneinventaire() {
/*  64 */     return this.idligneinventaire;
   }
 
   public void setIdligneinventaire(Long idligneinventaire) {
/*  68 */     this.idligneinventaire = idligneinventaire;
   }
 
   public Double getQtetheorique() {
/*  72 */     return this.qtetheorique;
   }
 
   public void setQtetheorique(Double qtetheorique) {
/*  76 */     this.qtetheorique = qtetheorique;
   }
 
   public Double getQtephysique() {
/*  80 */     return this.qtephysique;
   }
 
   public void setQtephysique(Double qtephysique) {
/*  84 */     this.qtephysique = qtephysique;
   }
 
   public Double getEcart() {
/*  88 */     return this.ecart;
   }
 
   public void setEcart(Double ecart) {
/*  92 */     this.ecart = ecart;
   }
 
   public String getObservation() {
/*  96 */     return this.observation;
   }
 
   public void setObservation(String observation) {
/* 100 */     this.observation = observation;
   }
 
   public Inventaire getIdinventaire() {
/* 104 */     return this.idinventaire;
   }
 
   public void setIdinventaire(Inventaire idinventaire) {
/* 108 */     this.idinventaire = idinventaire;
   }
 
   public Lot getIdlot() {
/* 112 */     return this.idlot;
   }
 
   public void setIdlot(Lot idlot) {
/* 116 */     this.idlot = idlot;
   }
 
   public Magasinlot getIdmagasinlot() {
/* 120 */     return this.idmagasinlot;
   }
 
   public void setIdmagasinlot(Magasinlot idmagasinlot) {
/* 124 */     this.idmagasinlot = idmagasinlot;
   }
 
   public int hashCode()
   {
/* 129 */     int hash = 0;
/* 130 */     hash += (this.idligneinventaire != null ? this.idligneinventaire.hashCode() : 0);
/* 131 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 137 */     if (!(object instanceof Ligneinventaire)) {
/* 138 */       return false;
     }
/* 140 */     Ligneinventaire other = (Ligneinventaire)object;
/* 141 */     if (((this.idligneinventaire == null) && (other.idligneinventaire != null)) || ((this.idligneinventaire != null) && (!this.idligneinventaire.equals(other.idligneinventaire)))) {
/* 142 */       return false;
     }
/* 144 */     return true;
   }
 
   public String toString()
   {
/* 149 */     return "entities.Ligneinventaire[ idligneinventaire=" + this.idligneinventaire + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Ligneinventaire
 * JD-Core Version:    0.6.2
 */