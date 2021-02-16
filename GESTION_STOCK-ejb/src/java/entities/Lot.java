 package entities;
 
 import java.io.Serializable;
 import java.util.Date;
 import java.util.List;
 import javax.persistence.Basic;
 import javax.persistence.Entity;
 import javax.persistence.FetchType;
 import javax.persistence.Id;
 import javax.persistence.JoinColumn;
 import javax.persistence.ManyToOne;
 import javax.persistence.NamedQueries;
 import javax.persistence.OneToMany;
 import javax.persistence.Temporal;
 import javax.persistence.TemporalType;
 import javax.validation.constraints.NotNull;
 import javax.validation.constraints.Size;
 import javax.xml.bind.annotation.XmlRootElement;
 import javax.xml.bind.annotation.XmlTransient;
 
 @Entity
 @XmlRootElement
 @NamedQueries({@javax.persistence.NamedQuery(name="Lot.findAll", query="SELECT l FROM Lot l"), @javax.persistence.NamedQuery(name="Lot.findByIdlot", query="SELECT l FROM Lot l WHERE l.idlot = :idlot"), @javax.persistence.NamedQuery(name="Lot.findByNumero", query="SELECT l FROM Lot l WHERE l.numero = :numero"), @javax.persistence.NamedQuery(name="Lot.findByDatefabrication", query="SELECT l FROM Lot l WHERE l.datefabrication = :datefabrication"), @javax.persistence.NamedQuery(name="Lot.findByDateperemption", query="SELECT l FROM Lot l WHERE l.dateperemption = :dateperemption"), @javax.persistence.NamedQuery(name="Lot.findByQuantite", query="SELECT l FROM Lot l WHERE l.quantite = :quantite"), @javax.persistence.NamedQuery(name="Lot.findByPrixachat", query="SELECT l FROM Lot l WHERE l.prixachat = :prixachat"), @javax.persistence.NamedQuery(name="Lot.findByPrixunitaire", query="SELECT l FROM Lot l WHERE l.prixunitaire = :prixunitaire"), @javax.persistence.NamedQuery(name="Lot.findByDateenregistrement", query="SELECT l FROM Lot l WHERE l.dateenregistrement = :dateenregistrement"), @javax.persistence.NamedQuery(name="Lot.findByEtat", query="SELECT l FROM Lot l WHERE l.etat = :etat"), @javax.persistence.NamedQuery(name="Lot.findByQuantitemultiple", query="SELECT l FROM Lot l WHERE l.quantitemultiple = :quantitemultiple"), @javax.persistence.NamedQuery(name="Lot.findByUnitesortie", query="SELECT l FROM Lot l WHERE l.unitesortie = :unitesortie"), @javax.persistence.NamedQuery(name="Lot.findByQuantitereduite", query="SELECT l FROM Lot l WHERE l.quantitereduite = :quantitereduite"), @javax.persistence.NamedQuery(name="Lot.findByUniteentree", query="SELECT l FROM Lot l WHERE l.uniteentree = :uniteentree"), @javax.persistence.NamedQuery(name="Lot.findByQuantitevirtuelle", query="SELECT l FROM Lot l WHERE l.quantitevirtuelle = :quantitevirtuelle"), @javax.persistence.NamedQuery(name="Lot.findByQuantitesecurite", query="SELECT l FROM Lot l WHERE l.quantitesecurite = :quantitesecurite")})
 public class Lot
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idlot;
 
   @Size(max=254)
   private String numero;
 
   @Temporal(TemporalType.DATE)
   private Date datefabrication;
 
   @Temporal(TemporalType.DATE)
   private Date dateperemption;
   private Double quantite;
   private Double prixachat;
   private Double prixunitaire;
 
   @Temporal(TemporalType.DATE)
   private Date dateenregistrement;
   private Boolean etat;
   private Double quantitemultiple;
   private Double unitesortie;
   private Double quantitereduite;
   private Double uniteentree;
   private Double quantitevirtuelle;
   private Double quantitesecurite;
 
   @OneToMany(mappedBy="idlot", fetch=FetchType.LAZY)
   private List<Ligneinventaire> ligneinventaireList;
 
   @JoinColumn(name="idarticle", referencedColumnName="idarticle")
   @ManyToOne(fetch=FetchType.LAZY)
   private Article idarticle;
 
   @OneToMany(mappedBy="idlot", fetch=FetchType.LAZY)
   private List<Lignerepartitiontemp> lignerepartitiontempList;
 
   @OneToMany(mappedBy="idlot", fetch=FetchType.LAZY)
   private List<Magasinlot> magasinlotList;
 
   @OneToMany(mappedBy="idlot", fetch=FetchType.LAZY)
   private List<Lignelivraisonclient> lignelivraisonclientList;
 
   @OneToMany(mappedBy="idlot", fetch=FetchType.LAZY)
   private List<Lignelivraisonfournisseur> lignelivraisonfournisseurList;
 
   @OneToMany(mappedBy="idlot", fetch=FetchType.LAZY)
   private List<Lignemvtstock> lignemvtstockList;
 
   public Lot()
   {
   }
 
   public Lot(Long idlot)
   {
/*  95 */     this.idlot = idlot;
   }
 
   public Long getIdlot() {
/*  99 */     return this.idlot;
   }
 
   public void setIdlot(Long idlot) {
/* 103 */     this.idlot = idlot;
   }
 
   public String getNumero() {
/* 107 */     return this.numero;
   }
 
   public void setNumero(String numero) {
/* 111 */     this.numero = numero;
   }
 
   public Date getDatefabrication() {
/* 115 */     return this.datefabrication;
   }
 
   public void setDatefabrication(Date datefabrication) {
/* 119 */     this.datefabrication = datefabrication;
   }
 
   public Date getDateperemption() {
/* 123 */     return this.dateperemption;
   }
 
   public void setDateperemption(Date dateperemption) {
/* 127 */     this.dateperemption = dateperemption;
   }
 
   public Double getQuantite() {
/* 131 */     return this.quantite;
   }
 
   public void setQuantite(Double quantite) {
/* 135 */     this.quantite = quantite;
   }
 
   public Double getPrixachat() {
/* 139 */     return this.prixachat;
   }
 
   public void setPrixachat(Double prixachat) {
/* 143 */     this.prixachat = prixachat;
   }
 
   public Double getPrixunitaire() {
/* 147 */     return this.prixunitaire;
   }
 
   public void setPrixunitaire(Double prixunitaire) {
/* 151 */     this.prixunitaire = prixunitaire;
   }
 
   public Date getDateenregistrement() {
/* 155 */     return this.dateenregistrement;
   }
 
   public void setDateenregistrement(Date dateenregistrement) {
/* 159 */     this.dateenregistrement = dateenregistrement;
   }
 
   public Boolean getEtat() {
/* 163 */     return this.etat;
   }
 
   public void setEtat(Boolean etat) {
/* 167 */     this.etat = etat;
   }
 
   public Double getQuantitemultiple() {
/* 171 */     return this.quantitemultiple;
   }
 
   public void setQuantitemultiple(Double quantitemultiple) {
/* 175 */     this.quantitemultiple = quantitemultiple;
   }
 
   public Double getUnitesortie() {
/* 179 */     return this.unitesortie;
   }
 
   public void setUnitesortie(Double unitesortie) {
/* 183 */     this.unitesortie = unitesortie;
   }
 
   public Double getQuantitereduite() {
/* 187 */     return this.quantitereduite;
   }
 
   public void setQuantitereduite(Double quantitereduite) {
/* 191 */     this.quantitereduite = quantitereduite;
   }
 
   public Double getUniteentree() {
/* 195 */     return this.uniteentree;
   }
 
   public void setUniteentree(Double uniteentree) {
/* 199 */     this.uniteentree = uniteentree;
   }
 
   public Double getQuantitevirtuelle() {
/* 203 */     return this.quantitevirtuelle;
   }
 
   public void setQuantitevirtuelle(Double quantitevirtuelle) {
/* 207 */     this.quantitevirtuelle = quantitevirtuelle;
   }
 
   public Double getQuantitesecurite() {
/* 211 */     return this.quantitesecurite;
   }
 
   public void setQuantitesecurite(Double quantitesecurite) {
/* 215 */     this.quantitesecurite = quantitesecurite;
   }
 
   @XmlTransient
   public List<Ligneinventaire> getLigneinventaireList() {
/* 220 */     return this.ligneinventaireList;
   }
 
   public void setLigneinventaireList(List<Ligneinventaire> ligneinventaireList) {
/* 224 */     this.ligneinventaireList = ligneinventaireList;
   }
 
   public Article getIdarticle() {
/* 228 */     return this.idarticle;
   }
 
   public void setIdarticle(Article idarticle) {
/* 232 */     this.idarticle = idarticle;
   }
 
   @XmlTransient
   public List<Lignerepartitiontemp> getLignerepartitiontempList() {
/* 237 */     return this.lignerepartitiontempList;
   }
 
   public void setLignerepartitiontempList(List<Lignerepartitiontemp> lignerepartitiontempList) {
/* 241 */     this.lignerepartitiontempList = lignerepartitiontempList;
   }
 
   @XmlTransient
   public List<Magasinlot> getMagasinlotList() {
/* 246 */     return this.magasinlotList;
   }
 
   public void setMagasinlotList(List<Magasinlot> magasinlotList) {
/* 250 */     this.magasinlotList = magasinlotList;
   }
 
   @XmlTransient
   public List<Lignelivraisonclient> getLignelivraisonclientList() {
/* 255 */     return this.lignelivraisonclientList;
   }
 
   public void setLignelivraisonclientList(List<Lignelivraisonclient> lignelivraisonclientList) {
/* 259 */     this.lignelivraisonclientList = lignelivraisonclientList;
   }
 
   @XmlTransient
   public List<Lignelivraisonfournisseur> getLignelivraisonfournisseurList() {
/* 264 */     return this.lignelivraisonfournisseurList;
   }
 
   public void setLignelivraisonfournisseurList(List<Lignelivraisonfournisseur> lignelivraisonfournisseurList) {
/* 268 */     this.lignelivraisonfournisseurList = lignelivraisonfournisseurList;
   }
 
   @XmlTransient
   public List<Lignemvtstock> getLignemvtstockList() {
/* 273 */     return this.lignemvtstockList;
   }
 
   public void setLignemvtstockList(List<Lignemvtstock> lignemvtstockList) {
/* 277 */     this.lignemvtstockList = lignemvtstockList;
   }
 
   public int hashCode()
   {
/* 282 */     int hash = 0;
/* 283 */     hash += (this.idlot != null ? this.idlot.hashCode() : 0);
/* 284 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 290 */     if (!(object instanceof Lot)) {
/* 291 */       return false;
     }
/* 293 */     Lot other = (Lot)object;
/* 294 */     if (((this.idlot == null) && (other.idlot != null)) || ((this.idlot != null) && (!this.idlot.equals(other.idlot)))) {
/* 295 */       return false;
     }
/* 297 */     return true;
   }
 
   public String toString()
   {
/* 302 */     return "entities.Lot[ idlot=" + this.idlot + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Lot
 * JD-Core Version:    0.6.2
 */