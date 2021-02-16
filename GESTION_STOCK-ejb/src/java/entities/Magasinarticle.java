 package entities;
 
 import java.io.Serializable;
 import java.util.List;
 import javax.persistence.Basic;
 import javax.persistence.Entity;
 import javax.persistence.FetchType;
 import javax.persistence.Id;
 import javax.persistence.JoinColumn;
 import javax.persistence.ManyToOne;
 import javax.persistence.NamedQueries;
 import javax.persistence.OneToMany;
 import javax.validation.constraints.NotNull;
 import javax.xml.bind.annotation.XmlRootElement;
 import javax.xml.bind.annotation.XmlTransient;
 
 @Entity
 @XmlRootElement
 @NamedQueries({@javax.persistence.NamedQuery(name="Magasinarticle.findAll", query="SELECT m FROM Magasinarticle m"), @javax.persistence.NamedQuery(name="Magasinarticle.findByIdmagasinarticle", query="SELECT m FROM Magasinarticle m WHERE m.idmagasinarticle = :idmagasinarticle"), @javax.persistence.NamedQuery(name="Magasinarticle.findByQuantite", query="SELECT m FROM Magasinarticle m WHERE m.quantite = :quantite"), @javax.persistence.NamedQuery(name="Magasinarticle.findByQuantitemultiple", query="SELECT m FROM Magasinarticle m WHERE m.quantitemultiple = :quantitemultiple"), @javax.persistence.NamedQuery(name="Magasinarticle.findByUnite", query="SELECT m FROM Magasinarticle m WHERE m.unite = :unite"), @javax.persistence.NamedQuery(name="Magasinarticle.findByEtat", query="SELECT m FROM Magasinarticle m WHERE m.etat = :etat"), @javax.persistence.NamedQuery(name="Magasinarticle.findByQuantitereduite", query="SELECT m FROM Magasinarticle m WHERE m.quantitereduite = :quantitereduite"), @javax.persistence.NamedQuery(name="Magasinarticle.findByQuantitevirtuelle", query="SELECT m FROM Magasinarticle m WHERE m.quantitevirtuelle = :quantitevirtuelle"), @javax.persistence.NamedQuery(name="Magasinarticle.findByQuantitesecurite", query="SELECT m FROM Magasinarticle m WHERE m.quantitesecurite = :quantitesecurite")})
 public class Magasinarticle
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idmagasinarticle;
   private Double quantite;
   private Double quantitemultiple;
   private Double unite;
   private Boolean etat;
   private Double quantitereduite;
   private Double quantitevirtuelle;
   private Double quantitesecurite;
 
   @JoinColumn(name="idarticle", referencedColumnName="idarticle")
   @ManyToOne(fetch=FetchType.LAZY)
   private Article idarticle;
 
   @JoinColumn(name="idmagasin", referencedColumnName="idmagasin")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasin idmagasin;
 
   @OneToMany(mappedBy="idmagasinarticle", fetch=FetchType.LAZY)
   private List<Lignedemande> lignedemandeList;
 
   @OneToMany(mappedBy="idmagasinarticle", fetch=FetchType.LAZY)
   private List<Magasinlot> magasinlotList;
 
   public Magasinarticle()
   {
   }
 
   public Magasinarticle(Long idmagasinarticle)
   {
/*  68 */     this.idmagasinarticle = idmagasinarticle;
   }
 
   public Long getIdmagasinarticle() {
/*  72 */     return this.idmagasinarticle;
   }
 
   public void setIdmagasinarticle(Long idmagasinarticle) {
/*  76 */     this.idmagasinarticle = idmagasinarticle;
   }
 
   public Double getQuantite() {
/*  80 */     return this.quantite;
   }
 
   public void setQuantite(Double quantite) {
/*  84 */     this.quantite = quantite;
   }
 
   public Double getQuantitemultiple() {
/*  88 */     return this.quantitemultiple;
   }
 
   public void setQuantitemultiple(Double quantitemultiple) {
/*  92 */     this.quantitemultiple = quantitemultiple;
   }
 
   public Double getUnite() {
/*  96 */     return this.unite;
   }
 
   public void setUnite(Double unite) {
/* 100 */     this.unite = unite;
   }
 
   public Boolean getEtat() {
/* 104 */     return this.etat;
   }
 
   public void setEtat(Boolean etat) {
/* 108 */     this.etat = etat;
   }
 
   public Double getQuantitereduite() {
/* 112 */     return this.quantitereduite;
   }
 
   public void setQuantitereduite(Double quantitereduite) {
/* 116 */     this.quantitereduite = quantitereduite;
   }
 
   public Double getQuantitevirtuelle() {
/* 120 */     return this.quantitevirtuelle;
   }
 
   public void setQuantitevirtuelle(Double quantitevirtuelle) {
/* 124 */     this.quantitevirtuelle = quantitevirtuelle;
   }
 
   public Double getQuantitesecurite() {
/* 128 */     return this.quantitesecurite;
   }
 
   public void setQuantitesecurite(Double quantitesecurite) {
/* 132 */     this.quantitesecurite = quantitesecurite;
   }
 
   public Article getIdarticle() {
/* 136 */     return this.idarticle;
   }
 
   public void setIdarticle(Article idarticle) {
/* 140 */     this.idarticle = idarticle;
   }
 
   public Magasin getIdmagasin() {
/* 144 */     return this.idmagasin;
   }
 
   public void setIdmagasin(Magasin idmagasin) {
/* 148 */     this.idmagasin = idmagasin;
   }
 
   @XmlTransient
   public List<Lignedemande> getLignedemandeList() {
/* 153 */     return this.lignedemandeList;
   }
 
   public void setLignedemandeList(List<Lignedemande> lignedemandeList) {
/* 157 */     this.lignedemandeList = lignedemandeList;
   }
 
   @XmlTransient
   public List<Magasinlot> getMagasinlotList() {
/* 162 */     return this.magasinlotList;
   }
 
   public void setMagasinlotList(List<Magasinlot> magasinlotList) {
/* 166 */     this.magasinlotList = magasinlotList;
   }
 
   public int hashCode()
   {
/* 171 */     int hash = 0;
/* 172 */     hash += (this.idmagasinarticle != null ? this.idmagasinarticle.hashCode() : 0);
/* 173 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 179 */     if (!(object instanceof Magasinarticle)) {
/* 180 */       return false;
     }
/* 182 */     Magasinarticle other = (Magasinarticle)object;
/* 183 */     if (((this.idmagasinarticle == null) && (other.idmagasinarticle != null)) || ((this.idmagasinarticle != null) && (!this.idmagasinarticle.equals(other.idmagasinarticle)))) {
/* 184 */       return false;
     }
/* 186 */     return true;
   }
 
   public String toString()
   {
/* 191 */     return "entities.Magasinarticle[ idmagasinarticle=" + this.idmagasinarticle + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Magasinarticle
 * JD-Core Version:    0.6.2
 */