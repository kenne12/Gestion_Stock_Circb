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
 @NamedQueries({@javax.persistence.NamedQuery(name="Lignemvtstock.findAll", query="SELECT l FROM Lignemvtstock l"), @javax.persistence.NamedQuery(name="Lignemvtstock.findByIdlignemvtstock", query="SELECT l FROM Lignemvtstock l WHERE l.idlignemvtstock = :idlignemvtstock"), @javax.persistence.NamedQuery(name="Lignemvtstock.findByQteentree", query="SELECT l FROM Lignemvtstock l WHERE l.qteentree = :qteentree"), @javax.persistence.NamedQuery(name="Lignemvtstock.findByQtesortie", query="SELECT l FROM Lignemvtstock l WHERE l.qtesortie = :qtesortie"), @javax.persistence.NamedQuery(name="Lignemvtstock.findByUnite", query="SELECT l FROM Lignemvtstock l WHERE l.unite = :unite"), @javax.persistence.NamedQuery(name="Lignemvtstock.findByReste", query="SELECT l FROM Lignemvtstock l WHERE l.reste = :reste"), @javax.persistence.NamedQuery(name="Lignemvtstock.findByClient", query="SELECT l FROM Lignemvtstock l WHERE l.client = :client"), @javax.persistence.NamedQuery(name="Lignemvtstock.findByFournisseur", query="SELECT l FROM Lignemvtstock l WHERE l.fournisseur = :fournisseur"), @javax.persistence.NamedQuery(name="Lignemvtstock.findByType", query="SELECT l FROM Lignemvtstock l WHERE l.type = :type"), @javax.persistence.NamedQuery(name="Lignemvtstock.findByMagasin", query="SELECT l FROM Lignemvtstock l WHERE l.magasin = :magasin")})
 public class Lignemvtstock
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idlignemvtstock;
   private Double qteentree;
   private Double qtesortie;
   private Double unite;
   private Double reste;
 
   @Size(max=70)
   private String client;
 
   @Size(max=70)
   private String fournisseur;
 
   @Size(max=20)
   private String type;
 
   @Size(max=50)
   private String magasin;
 
   @JoinColumn(name="idlot", referencedColumnName="idlot")
   @ManyToOne(fetch=FetchType.LAZY)
   private Lot idlot;
 
   @JoinColumn(name="idmagasinlot", referencedColumnName="idmagasinlot")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasinlot idmagasinlot;
 
   @JoinColumn(name="idmvtstock", referencedColumnName="idmvtstock")
   @ManyToOne(fetch=FetchType.LAZY)
   private Mvtstock idmvtstock;
 
   public Lignemvtstock()
   {
   }
 
   public Lignemvtstock(Long idlignemvtstock)
   {
/*  71 */     this.idlignemvtstock = idlignemvtstock;
   }
 
   public Long getIdlignemvtstock() {
/*  75 */     return this.idlignemvtstock;
   }
 
   public void setIdlignemvtstock(Long idlignemvtstock) {
/*  79 */     this.idlignemvtstock = idlignemvtstock;
   }
 
   public Double getQteentree() {
/*  83 */     return this.qteentree;
   }
 
   public void setQteentree(Double qteentree) {
/*  87 */     this.qteentree = qteentree;
   }
 
   public Double getQtesortie() {
/*  91 */     return this.qtesortie;
   }
 
   public void setQtesortie(Double qtesortie) {
/*  95 */     this.qtesortie = qtesortie;
   }
 
   public Double getUnite() {
/*  99 */     return this.unite;
   }
 
   public void setUnite(Double unite) {
/* 103 */     this.unite = unite;
   }
 
   public Double getReste() {
/* 107 */     return this.reste;
   }
 
   public void setReste(Double reste) {
/* 111 */     this.reste = reste;
   }
 
   public String getClient() {
/* 115 */     return this.client;
   }
 
   public void setClient(String client) {
/* 119 */     this.client = client;
   }
 
   public String getFournisseur() {
/* 123 */     return this.fournisseur;
   }
 
   public void setFournisseur(String fournisseur) {
/* 127 */     this.fournisseur = fournisseur;
   }
 
   public String getType() {
/* 131 */     return this.type;
   }
 
   public void setType(String type) {
/* 135 */     this.type = type;
   }
 
   public String getMagasin() {
/* 139 */     return this.magasin;
   }
 
   public void setMagasin(String magasin) {
/* 143 */     this.magasin = magasin;
   }
 
   public Lot getIdlot() {
/* 147 */     return this.idlot;
   }
 
   public void setIdlot(Lot idlot) {
/* 151 */     this.idlot = idlot;
   }
 
   public Magasinlot getIdmagasinlot() {
/* 155 */     return this.idmagasinlot;
   }
 
   public void setIdmagasinlot(Magasinlot idmagasinlot) {
/* 159 */     this.idmagasinlot = idmagasinlot;
   }
 
   public Mvtstock getIdmvtstock() {
/* 163 */     return this.idmvtstock;
   }
 
   public void setIdmvtstock(Mvtstock idmvtstock) {
/* 167 */     this.idmvtstock = idmvtstock;
   }
 
   public int hashCode()
   {
/* 172 */     int hash = 0;
/* 173 */     hash += (this.idlignemvtstock != null ? this.idlignemvtstock.hashCode() : 0);
/* 174 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 180 */     if (!(object instanceof Lignemvtstock)) {
/* 181 */       return false;
     }
/* 183 */     Lignemvtstock other = (Lignemvtstock)object;
/* 184 */     if (((this.idlignemvtstock == null) && (other.idlignemvtstock != null)) || ((this.idlignemvtstock != null) && (!this.idlignemvtstock.equals(other.idlignemvtstock)))) {
/* 185 */       return false;
     }
/* 187 */     return true;
   }
 
   public String toString()
   {
/* 192 */     return "entities.Lignemvtstock[ idlignemvtstock=" + this.idlignemvtstock + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Lignemvtstock
 * JD-Core Version:    0.6.2
 */