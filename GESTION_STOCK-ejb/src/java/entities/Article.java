 package entities;
 
 import java.io.Serializable;
 import java.util.Date;
 import java.util.List;
 import javax.persistence.Basic;
 import javax.persistence.Column;
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
 @NamedQueries({@javax.persistence.NamedQuery(name="Article.findAll", query="SELECT a FROM Article a"), @javax.persistence.NamedQuery(name="Article.findByIdarticle", query="SELECT a FROM Article a WHERE a.idarticle = :idarticle"), @javax.persistence.NamedQuery(name="Article.findByCode", query="SELECT a FROM Article a WHERE a.code = :code"), @javax.persistence.NamedQuery(name="Article.findByLibelle", query="SELECT a FROM Article a WHERE a.libelle = :libelle"), @javax.persistence.NamedQuery(name="Article.findByDescription", query="SELECT a FROM Article a WHERE a.description = :description"), @javax.persistence.NamedQuery(name="Article.findByCoutachat", query="SELECT a FROM Article a WHERE a.coutachat = :coutachat"), @javax.persistence.NamedQuery(name="Article.findByPoids", query="SELECT a FROM Article a WHERE a.poids = :poids"), @javax.persistence.NamedQuery(name="Article.findByPrixunit", query="SELECT a FROM Article a WHERE a.prixunit = :prixunit"), @javax.persistence.NamedQuery(name="Article.findByTva", query="SELECT a FROM Article a WHERE a.tva = :tva"), @javax.persistence.NamedQuery(name="Article.findByQuantitestock", query="SELECT a FROM Article a WHERE a.quantitestock = :quantitestock"), @javax.persistence.NamedQuery(name="Article.findByQuantitemin", query="SELECT a FROM Article a WHERE a.quantitemin = :quantitemin"), @javax.persistence.NamedQuery(name="Article.findByQuantitealerte", query="SELECT a FROM Article a WHERE a.quantitealerte = :quantitealerte"), @javax.persistence.NamedQuery(name="Article.findByQuantiteavarie", query="SELECT a FROM Article a WHERE a.quantiteavarie = :quantiteavarie"), @javax.persistence.NamedQuery(name="Article.findByQuantitepv", query="SELECT a FROM Article a WHERE a.quantitepv = :quantitepv"), @javax.persistence.NamedQuery(name="Article.findByQuantiteminpv", query="SELECT a FROM Article a WHERE a.quantiteminpv = :quantiteminpv"), @javax.persistence.NamedQuery(name="Article.findByQuantitealertepv", query="SELECT a FROM Article a WHERE a.quantitealertepv = :quantitealertepv"), @javax.persistence.NamedQuery(name="Article.findByPhoto", query="SELECT a FROM Article a WHERE a.photo = :photo"), @javax.persistence.NamedQuery(name="Article.findByPhotoRelatif", query="SELECT a FROM Article a WHERE a.photoRelatif = :photoRelatif"), @javax.persistence.NamedQuery(name="Article.findByDateEnregistre", query="SELECT a FROM Article a WHERE a.dateEnregistre = :dateEnregistre"), @javax.persistence.NamedQuery(name="Article.findByDerniereModif", query="SELECT a FROM Article a WHERE a.derniereModif = :derniereModif"), @javax.persistence.NamedQuery(name="Article.findByPerissable", query="SELECT a FROM Article a WHERE a.perissable = :perissable"), @javax.persistence.NamedQuery(name="Article.findByUnite", query="SELECT a FROM Article a WHERE a.unite = :unite"), @javax.persistence.NamedQuery(name="Article.findByEtat", query="SELECT a FROM Article a WHERE a.etat = :etat"), @javax.persistence.NamedQuery(name="Article.findByFabricant", query="SELECT a FROM Article a WHERE a.fabricant = :fabricant"), @javax.persistence.NamedQuery(name="Article.findByNbjralerte", query="SELECT a FROM Article a WHERE a.nbjralerte = :nbjralerte"), @javax.persistence.NamedQuery(name="Article.findByQuantitemultiple", query="SELECT a FROM Article a WHERE a.quantitemultiple = :quantitemultiple"), @javax.persistence.NamedQuery(name="Article.findByUnitesortie", query="SELECT a FROM Article a WHERE a.unitesortie = :unitesortie"), @javax.persistence.NamedQuery(name="Article.findByQuantitereduite", query="SELECT a FROM Article a WHERE a.quantitereduite = :quantitereduite"), @javax.persistence.NamedQuery(name="Article.findByUniteentree", query="SELECT a FROM Article a WHERE a.uniteentree = :uniteentree"), @javax.persistence.NamedQuery(name="Article.findByQuantitevirtuelle", query="SELECT a FROM Article a WHERE a.quantitevirtuelle = :quantitevirtuelle"), @javax.persistence.NamedQuery(name="Article.findByQuantitesecurite", query="SELECT a FROM Article a WHERE a.quantitesecurite = :quantitesecurite")})
 public class Article
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idarticle;
 
   @Size(max=50)
   private String code;
 
   @Size(max=254)
   private String libelle;
 
   @Size(max=2147483647)
   private String description;
   private Double coutachat;
   private Double poids;
   private Double prixunit;
   private Boolean tva;
   private Double quantitestock;
   private Integer quantitemin;
   private Double quantitealerte;
   private Integer quantiteavarie;
   private Integer quantitepv;
   private Integer quantiteminpv;
   private Integer quantitealertepv;
 
   @Size(max=254)
   private String photo;
 
   @Size(max=254)
   @Column(name="photo_relatif")
   private String photoRelatif;
 
   @Column(name="date_enregistre")
   @Temporal(TemporalType.DATE)
   private Date dateEnregistre;
 
   @Column(name="derniere_modif")
   @Temporal(TemporalType.DATE)
   private Date derniereModif;
   private Boolean perissable;
   private Double unite;
   private Boolean etat;
 
   @Size(max=2147483647)
   private String fabricant;
   private Integer nbjralerte;
   private Double quantitemultiple;
   private Double unitesortie;
   private Double quantitereduite;
   private Double uniteentree;
   private Double quantitevirtuelle;
   private Double quantitesecurite;
 
   @OneToMany(mappedBy="idarticle", fetch=FetchType.LAZY)
   private List<Lot> lotList;
 
   @OneToMany(mappedBy="idarticle", fetch=FetchType.LAZY)
   private List<Magasinarticle> magasinarticleList;
 
   @OneToMany(mappedBy="idarticle", fetch=FetchType.LAZY)
   private List<Lignecommandefournisseur> lignecommandefournisseurList;
 
   @JoinColumn(name="idfamille", referencedColumnName="idfamille")
   @ManyToOne(fetch=FetchType.LAZY)
   private Famille idfamille;
 
   @JoinColumn(name="idunite", referencedColumnName="idunite")
   @ManyToOne(fetch=FetchType.LAZY)
   private Unite idunite;
 
   public Article()
   {
   }
 
   public Article(Long idarticle)
   {
/* 130 */     this.idarticle = idarticle;
   }
 
   public Long getIdarticle() {
/* 134 */     return this.idarticle;
   }
 
   public void setIdarticle(Long idarticle) {
/* 138 */     this.idarticle = idarticle;
   }
 
   public String getCode() {
/* 142 */     return this.code;
   }
 
   public void setCode(String code) {
/* 146 */     this.code = code;
   }
 
   public String getLibelle() {
/* 150 */     return this.libelle;
   }
 
   public void setLibelle(String libelle) {
/* 154 */     this.libelle = libelle;
   }
 
   public String getDescription() {
/* 158 */     return this.description;
   }
 
   public void setDescription(String description) {
/* 162 */     this.description = description;
   }
 
   public Double getCoutachat() {
/* 166 */     return this.coutachat;
   }
 
   public void setCoutachat(Double coutachat) {
/* 170 */     this.coutachat = coutachat;
   }
 
   public Double getPoids() {
/* 174 */     return this.poids;
   }
 
   public void setPoids(Double poids) {
/* 178 */     this.poids = poids;
   }
 
   public Double getPrixunit() {
/* 182 */     return this.prixunit;
   }
 
   public void setPrixunit(Double prixunit) {
/* 186 */     this.prixunit = prixunit;
   }
 
   public Boolean getTva() {
/* 190 */     return this.tva;
   }
 
   public void setTva(Boolean tva) {
/* 194 */     this.tva = tva;
   }
 
   public Double getQuantitestock() {
/* 198 */     return this.quantitestock;
   }
 
   public void setQuantitestock(Double quantitestock) {
/* 202 */     this.quantitestock = quantitestock;
   }
 
   public Integer getQuantitemin() {
/* 206 */     return this.quantitemin;
   }
 
   public void setQuantitemin(Integer quantitemin) {
/* 210 */     this.quantitemin = quantitemin;
   }
 
   public Double getQuantitealerte() {
/* 214 */     return this.quantitealerte;
   }
 
   public void setQuantitealerte(Double quantitealerte) {
/* 218 */     this.quantitealerte = quantitealerte;
   }
 
   public Integer getQuantiteavarie() {
/* 222 */     return this.quantiteavarie;
   }
 
   public void setQuantiteavarie(Integer quantiteavarie) {
/* 226 */     this.quantiteavarie = quantiteavarie;
   }
 
   public Integer getQuantitepv() {
/* 230 */     return this.quantitepv;
   }
 
   public void setQuantitepv(Integer quantitepv) {
/* 234 */     this.quantitepv = quantitepv;
   }
 
   public Integer getQuantiteminpv() {
/* 238 */     return this.quantiteminpv;
   }
 
   public void setQuantiteminpv(Integer quantiteminpv) {
/* 242 */     this.quantiteminpv = quantiteminpv;
   }
 
   public Integer getQuantitealertepv() {
/* 246 */     return this.quantitealertepv;
   }
 
   public void setQuantitealertepv(Integer quantitealertepv) {
/* 250 */     this.quantitealertepv = quantitealertepv;
   }
 
   public String getPhoto() {
/* 254 */     return this.photo;
   }
 
   public void setPhoto(String photo) {
/* 258 */     this.photo = photo;
   }
 
   public String getPhotoRelatif() {
/* 262 */     return this.photoRelatif;
   }
 
   public void setPhotoRelatif(String photoRelatif) {
/* 266 */     this.photoRelatif = photoRelatif;
   }
 
   public Date getDateEnregistre() {
/* 270 */     return this.dateEnregistre;
   }
 
   public void setDateEnregistre(Date dateEnregistre) {
/* 274 */     this.dateEnregistre = dateEnregistre;
   }
 
   public Date getDerniereModif() {
/* 278 */     return this.derniereModif;
   }
 
   public void setDerniereModif(Date derniereModif) {
/* 282 */     this.derniereModif = derniereModif;
   }
 
   public Boolean getPerissable() {
/* 286 */     return this.perissable;
   }
 
   public void setPerissable(Boolean perissable) {
/* 290 */     this.perissable = perissable;
   }
 
   public Double getUnite() {
/* 294 */     return this.unite;
   }
 
   public void setUnite(Double unite) {
/* 298 */     this.unite = unite;
   }
 
   public Boolean getEtat() {
/* 302 */     return this.etat;
   }
 
   public void setEtat(Boolean etat) {
/* 306 */     this.etat = etat;
   }
 
   public String getFabricant() {
/* 310 */     return this.fabricant;
   }
 
   public void setFabricant(String fabricant) {
/* 314 */     this.fabricant = fabricant;
   }
 
   public Integer getNbjralerte() {
/* 318 */     return this.nbjralerte;
   }
 
   public void setNbjralerte(Integer nbjralerte) {
/* 322 */     this.nbjralerte = nbjralerte;
   }
 
   public Double getQuantitemultiple() {
/* 326 */     return this.quantitemultiple;
   }
 
   public void setQuantitemultiple(Double quantitemultiple) {
/* 330 */     this.quantitemultiple = quantitemultiple;
   }
 
   public Double getUnitesortie() {
/* 334 */     return this.unitesortie;
   }
 
   public void setUnitesortie(Double unitesortie) {
/* 338 */     this.unitesortie = unitesortie;
   }
 
   public Double getQuantitereduite() {
/* 342 */     return this.quantitereduite;
   }
 
   public void setQuantitereduite(Double quantitereduite) {
/* 346 */     this.quantitereduite = quantitereduite;
   }
 
   public Double getUniteentree() {
/* 350 */     return this.uniteentree;
   }
 
   public void setUniteentree(Double uniteentree) {
/* 354 */     this.uniteentree = uniteentree;
   }
 
   public Double getQuantitevirtuelle() {
/* 358 */     return this.quantitevirtuelle;
   }
 
   public void setQuantitevirtuelle(Double quantitevirtuelle) {
/* 362 */     this.quantitevirtuelle = quantitevirtuelle;
   }
 
   public Double getQuantitesecurite() {
/* 366 */     return this.quantitesecurite;
   }
 
   public void setQuantitesecurite(Double quantitesecurite) {
/* 370 */     this.quantitesecurite = quantitesecurite;
   }
 
   @XmlTransient
   public List<Lot> getLotList() {
/* 375 */     return this.lotList;
   }
 
   public void setLotList(List<Lot> lotList) {
/* 379 */     this.lotList = lotList;
   }
 
   @XmlTransient
   public List<Magasinarticle> getMagasinarticleList() {
/* 384 */     return this.magasinarticleList;
   }
 
   public void setMagasinarticleList(List<Magasinarticle> magasinarticleList) {
/* 388 */     this.magasinarticleList = magasinarticleList;
   }
 
   @XmlTransient
   public List<Lignecommandefournisseur> getLignecommandefournisseurList() {
/* 393 */     return this.lignecommandefournisseurList;
   }
 
   public void setLignecommandefournisseurList(List<Lignecommandefournisseur> lignecommandefournisseurList) {
/* 397 */     this.lignecommandefournisseurList = lignecommandefournisseurList;
   }
 
   public Famille getIdfamille() {
/* 401 */     return this.idfamille;
   }
 
   public void setIdfamille(Famille idfamille) {
/* 405 */     this.idfamille = idfamille;
   }
 
   public Unite getIdunite() {
/* 409 */     return this.idunite;
   }
 
   public void setIdunite(Unite idunite) {
/* 413 */     this.idunite = idunite;
   }
 
   public int hashCode()
   {
/* 418 */     int hash = 0;
/* 419 */     hash += (this.idarticle != null ? this.idarticle.hashCode() : 0);
/* 420 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 426 */     if (!(object instanceof Article)) {
/* 427 */       return false;
     }
/* 429 */     Article other = (Article)object;
/* 430 */     if (((this.idarticle == null) && (other.idarticle != null)) || ((this.idarticle != null) && (!this.idarticle.equals(other.idarticle)))) {
/* 431 */       return false;
     }
/* 433 */     return true;
   }
 
   public String toString()
   {
/* 438 */     return "entities.Article[ idarticle=" + this.idarticle + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Article
 * JD-Core Version:    0.6.2
 */