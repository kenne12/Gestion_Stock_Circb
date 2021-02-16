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
 @NamedQueries({@javax.persistence.NamedQuery(name="Magasinlot.findAll", query="SELECT m FROM Magasinlot m"), @javax.persistence.NamedQuery(name="Magasinlot.findByIdmagasinlot", query="SELECT m FROM Magasinlot m WHERE m.idmagasinlot = :idmagasinlot"), @javax.persistence.NamedQuery(name="Magasinlot.findByQuantite", query="SELECT m FROM Magasinlot m WHERE m.quantite = :quantite"), @javax.persistence.NamedQuery(name="Magasinlot.findByQuantitemultiple", query="SELECT m FROM Magasinlot m WHERE m.quantitemultiple = :quantitemultiple"), @javax.persistence.NamedQuery(name="Magasinlot.findByUnite", query="SELECT m FROM Magasinlot m WHERE m.unite = :unite"), @javax.persistence.NamedQuery(name="Magasinlot.findByEtat", query="SELECT m FROM Magasinlot m WHERE m.etat = :etat"), @javax.persistence.NamedQuery(name="Magasinlot.findByQuantitereduite", query="SELECT m FROM Magasinlot m WHERE m.quantitereduite = :quantitereduite"), @javax.persistence.NamedQuery(name="Magasinlot.findByQuantitevirtuelle", query="SELECT m FROM Magasinlot m WHERE m.quantitevirtuelle = :quantitevirtuelle"), @javax.persistence.NamedQuery(name="Magasinlot.findByQuantitesecurite", query="SELECT m FROM Magasinlot m WHERE m.quantitesecurite = :quantitesecurite")})
 public class Magasinlot
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idmagasinlot;
   private Double quantite;
   private Double quantitemultiple;
   private Double unite;
   private Boolean etat;
   private Double quantitereduite;
   private Double quantitevirtuelle;
   private Double quantitesecurite;
 
   @OneToMany(mappedBy="idmagasinlot", fetch=FetchType.LAZY)
   private List<Lignerepartitionarticle> lignerepartitionarticleList;
 
   @OneToMany(mappedBy="idmagasinlot", fetch=FetchType.LAZY)
   private List<Ligneinventaire> ligneinventaireList;
 
   @OneToMany(mappedBy="idmagasinlot", fetch=FetchType.LAZY)
   private List<Lignetransfert> lignetransfertList;
 
   @OneToMany(mappedBy="idmagasinlot", fetch=FetchType.LAZY)
   private List<Ligneentreedirect> ligneentreedirectList;
 
   @JoinColumn(name="idlot", referencedColumnName="idlot")
   @ManyToOne(fetch=FetchType.LAZY)
   private Lot idlot;
 
   @JoinColumn(name="idmagasinarticle", referencedColumnName="idmagasinarticle")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasinarticle idmagasinarticle;
 
   @OneToMany(mappedBy="idmagasinlot", fetch=FetchType.LAZY)
   private List<Lignelivraisonclient> lignelivraisonclientList;
 
   @OneToMany(mappedBy="idmagasinlot", fetch=FetchType.LAZY)
   private List<Lignelivraisonfournisseur> lignelivraisonfournisseurList;
 
   @OneToMany(mappedBy="idmagasinlot", fetch=FetchType.LAZY)
   private List<Lignemvtstock> lignemvtstockList;
 
   public Magasinlot()
   {
   }
 
   public Magasinlot(Long idmagasinlot)
   {
/*  78 */     this.idmagasinlot = idmagasinlot;
   }
 
   public Long getIdmagasinlot() {
/*  82 */     return this.idmagasinlot;
   }
 
   public void setIdmagasinlot(Long idmagasinlot) {
/*  86 */     this.idmagasinlot = idmagasinlot;
   }
 
   public Double getQuantite() {
/*  90 */     return this.quantite;
   }
 
   public void setQuantite(Double quantite) {
/*  94 */     this.quantite = quantite;
   }
 
   public Double getQuantitemultiple() {
/*  98 */     return this.quantitemultiple;
   }
 
   public void setQuantitemultiple(Double quantitemultiple) {
/* 102 */     this.quantitemultiple = quantitemultiple;
   }
 
   public Double getUnite() {
/* 106 */     return this.unite;
   }
 
   public void setUnite(Double unite) {
/* 110 */     this.unite = unite;
   }
 
   public Boolean getEtat() {
/* 114 */     return this.etat;
   }
 
   public void setEtat(Boolean etat) {
/* 118 */     this.etat = etat;
   }
 
   public Double getQuantitereduite() {
/* 122 */     return this.quantitereduite;
   }
 
   public void setQuantitereduite(Double quantitereduite) {
/* 126 */     this.quantitereduite = quantitereduite;
   }
 
   public Double getQuantitevirtuelle() {
/* 130 */     return this.quantitevirtuelle;
   }
 
   public void setQuantitevirtuelle(Double quantitevirtuelle) {
/* 134 */     this.quantitevirtuelle = quantitevirtuelle;
   }
 
   public Double getQuantitesecurite() {
/* 138 */     return this.quantitesecurite;
   }
 
   public void setQuantitesecurite(Double quantitesecurite) {
/* 142 */     this.quantitesecurite = quantitesecurite;
   }
 
   @XmlTransient
   public List<Lignerepartitionarticle> getLignerepartitionarticleList() {
/* 147 */     return this.lignerepartitionarticleList;
   }
 
   public void setLignerepartitionarticleList(List<Lignerepartitionarticle> lignerepartitionarticleList) {
/* 151 */     this.lignerepartitionarticleList = lignerepartitionarticleList;
   }
 
   @XmlTransient
   public List<Ligneinventaire> getLigneinventaireList() {
/* 156 */     return this.ligneinventaireList;
   }
 
   public void setLigneinventaireList(List<Ligneinventaire> ligneinventaireList) {
/* 160 */     this.ligneinventaireList = ligneinventaireList;
   }
 
   @XmlTransient
   public List<Lignetransfert> getLignetransfertList() {
/* 165 */     return this.lignetransfertList;
   }
 
   public void setLignetransfertList(List<Lignetransfert> lignetransfertList) {
/* 169 */     this.lignetransfertList = lignetransfertList;
   }
 
   @XmlTransient
   public List<Ligneentreedirect> getLigneentreedirectList() {
/* 174 */     return this.ligneentreedirectList;
   }
 
   public void setLigneentreedirectList(List<Ligneentreedirect> ligneentreedirectList) {
/* 178 */     this.ligneentreedirectList = ligneentreedirectList;
   }
 
   public Lot getIdlot() {
/* 182 */     return this.idlot;
   }
 
   public void setIdlot(Lot idlot) {
/* 186 */     this.idlot = idlot;
   }
 
   public Magasinarticle getIdmagasinarticle() {
/* 190 */     return this.idmagasinarticle;
   }
 
   public void setIdmagasinarticle(Magasinarticle idmagasinarticle) {
/* 194 */     this.idmagasinarticle = idmagasinarticle;
   }
 
   @XmlTransient
   public List<Lignelivraisonclient> getLignelivraisonclientList() {
/* 199 */     return this.lignelivraisonclientList;
   }
 
   public void setLignelivraisonclientList(List<Lignelivraisonclient> lignelivraisonclientList) {
/* 203 */     this.lignelivraisonclientList = lignelivraisonclientList;
   }
 
   @XmlTransient
   public List<Lignelivraisonfournisseur> getLignelivraisonfournisseurList() {
/* 208 */     return this.lignelivraisonfournisseurList;
   }
 
   public void setLignelivraisonfournisseurList(List<Lignelivraisonfournisseur> lignelivraisonfournisseurList) {
/* 212 */     this.lignelivraisonfournisseurList = lignelivraisonfournisseurList;
   }
 
   @XmlTransient
   public List<Lignemvtstock> getLignemvtstockList() {
/* 217 */     return this.lignemvtstockList;
   }
 
   public void setLignemvtstockList(List<Lignemvtstock> lignemvtstockList) {
/* 221 */     this.lignemvtstockList = lignemvtstockList;
   }
 
   public int hashCode()
   {
/* 226 */     int hash = 0;
/* 227 */     hash += (this.idmagasinlot != null ? this.idmagasinlot.hashCode() : 0);
/* 228 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 234 */     if (!(object instanceof Magasinlot)) {
/* 235 */       return false;
     }
/* 237 */     Magasinlot other = (Magasinlot)object;
/* 238 */     if (((this.idmagasinlot == null) && (other.idmagasinlot != null)) || ((this.idmagasinlot != null) && (!this.idmagasinlot.equals(other.idmagasinlot)))) {
/* 239 */       return false;
     }
/* 241 */     return true;
   }
 
   public String toString()
   {
/* 246 */     return "entities.Magasinlot[ idmagasinlot=" + this.idmagasinlot + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Magasinlot
 * JD-Core Version:    0.6.2
 */