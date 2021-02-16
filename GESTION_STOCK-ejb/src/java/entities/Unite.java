 package entities;
 
 import java.io.Serializable;
 import java.math.BigInteger;
 import java.util.Date;
 import java.util.List;
 import javax.persistence.Basic;
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.FetchType;
 import javax.persistence.Id;
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
 @NamedQueries({@javax.persistence.NamedQuery(name="Unite.findAll", query="SELECT u FROM Unite u"), @javax.persistence.NamedQuery(name="Unite.findByIdunite", query="SELECT u FROM Unite u WHERE u.idunite = :idunite"), @javax.persistence.NamedQuery(name="Unite.findByIdParent", query="SELECT u FROM Unite u WHERE u.idParent = :idParent"), @javax.persistence.NamedQuery(name="Unite.findByLibelle", query="SELECT u FROM Unite u WHERE u.libelle = :libelle"), @javax.persistence.NamedQuery(name="Unite.findByCode", query="SELECT u FROM Unite u WHERE u.code = :code"), @javax.persistence.NamedQuery(name="Unite.findByEtat", query="SELECT u FROM Unite u WHERE u.etat = :etat"), @javax.persistence.NamedQuery(name="Unite.findByDateEnregistre", query="SELECT u FROM Unite u WHERE u.dateEnregistre = :dateEnregistre"), @javax.persistence.NamedQuery(name="Unite.findByDerniereModif", query="SELECT u FROM Unite u WHERE u.derniereModif = :derniereModif")})
 public class Unite
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idunite;
 
   @Column(name="id_parent")
   private BigInteger idParent;
 
   @Size(max=1024)
   private String libelle;
 
   @Size(max=1024)
   private String code;
 
   @Size(max=50)
   private String etat;
 
   @Column(name="date_enregistre")
   @Temporal(TemporalType.DATE)
   private Date dateEnregistre;
 
   @Column(name="derniere_modif")
   @Temporal(TemporalType.DATE)
   private Date derniereModif;
 
   @OneToMany(mappedBy="idunite", fetch=FetchType.LAZY)
   private List<Lignerepartitionarticle> lignerepartitionarticleList;
 
   @OneToMany(mappedBy="idunite", fetch=FetchType.LAZY)
   private List<Lignetransfert> lignetransfertList;
 
   @OneToMany(mappedBy="idunite", fetch=FetchType.LAZY)
   private List<Lignecommandefournisseur> lignecommandefournisseurList;
 
   @OneToMany(mappedBy="idunite", fetch=FetchType.LAZY)
   private List<Lignedemande> lignedemandeList;
 
   @OneToMany(mappedBy="idunite", fetch=FetchType.LAZY)
   private List<Article> articleList;
 
   @OneToMany(mappedBy="idunite", fetch=FetchType.LAZY)
   private List<Lignelivraisonclient> lignelivraisonclientList;
 
   @OneToMany(mappedBy="idunite", fetch=FetchType.LAZY)
   private List<Lignelivraisonfournisseur> lignelivraisonfournisseurList;
 
   public Unite()
   {
   }
 
   public Unite(Long idunite)
   {
/*  81 */     this.idunite = idunite;
   }
 
   public Long getIdunite() {
/*  85 */     return this.idunite;
   }
 
   public void setIdunite(Long idunite) {
/*  89 */     this.idunite = idunite;
   }
 
   public BigInteger getIdParent() {
/*  93 */     return this.idParent;
   }
 
   public void setIdParent(BigInteger idParent) {
/*  97 */     this.idParent = idParent;
   }
 
   public String getLibelle() {
/* 101 */     return this.libelle;
   }
 
   public void setLibelle(String libelle) {
/* 105 */     this.libelle = libelle;
   }
 
   public String getCode() {
/* 109 */     return this.code;
   }
 
   public void setCode(String code) {
/* 113 */     this.code = code;
   }
 
   public String getEtat() {
/* 117 */     return this.etat;
   }
 
   public void setEtat(String etat) {
/* 121 */     this.etat = etat;
   }
 
   public Date getDateEnregistre() {
/* 125 */     return this.dateEnregistre;
   }
 
   public void setDateEnregistre(Date dateEnregistre) {
/* 129 */     this.dateEnregistre = dateEnregistre;
   }
 
   public Date getDerniereModif() {
/* 133 */     return this.derniereModif;
   }
 
   public void setDerniereModif(Date derniereModif) {
/* 137 */     this.derniereModif = derniereModif;
   }
 
   @XmlTransient
   public List<Lignerepartitionarticle> getLignerepartitionarticleList() {
/* 142 */     return this.lignerepartitionarticleList;
   }
 
   public void setLignerepartitionarticleList(List<Lignerepartitionarticle> lignerepartitionarticleList) {
/* 146 */     this.lignerepartitionarticleList = lignerepartitionarticleList;
   }
 
   @XmlTransient
   public List<Lignetransfert> getLignetransfertList() {
/* 151 */     return this.lignetransfertList;
   }
 
   public void setLignetransfertList(List<Lignetransfert> lignetransfertList) {
/* 155 */     this.lignetransfertList = lignetransfertList;
   }
 
   @XmlTransient
   public List<Lignecommandefournisseur> getLignecommandefournisseurList() {
/* 160 */     return this.lignecommandefournisseurList;
   }
 
   public void setLignecommandefournisseurList(List<Lignecommandefournisseur> lignecommandefournisseurList) {
/* 164 */     this.lignecommandefournisseurList = lignecommandefournisseurList;
   }
 
   @XmlTransient
   public List<Lignedemande> getLignedemandeList() {
/* 169 */     return this.lignedemandeList;
   }
 
   public void setLignedemandeList(List<Lignedemande> lignedemandeList) {
/* 173 */     this.lignedemandeList = lignedemandeList;
   }
 
   @XmlTransient
   public List<Article> getArticleList() {
/* 178 */     return this.articleList;
   }
 
   public void setArticleList(List<Article> articleList) {
/* 182 */     this.articleList = articleList;
   }
 
   @XmlTransient
   public List<Lignelivraisonclient> getLignelivraisonclientList() {
/* 187 */     return this.lignelivraisonclientList;
   }
 
   public void setLignelivraisonclientList(List<Lignelivraisonclient> lignelivraisonclientList) {
/* 191 */     this.lignelivraisonclientList = lignelivraisonclientList;
   }
 
   @XmlTransient
   public List<Lignelivraisonfournisseur> getLignelivraisonfournisseurList() {
/* 196 */     return this.lignelivraisonfournisseurList;
   }
 
   public void setLignelivraisonfournisseurList(List<Lignelivraisonfournisseur> lignelivraisonfournisseurList) {
/* 200 */     this.lignelivraisonfournisseurList = lignelivraisonfournisseurList;
   }
 
   public int hashCode()
   {
/* 205 */     int hash = 0;
/* 206 */     hash += (this.idunite != null ? this.idunite.hashCode() : 0);
/* 207 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 213 */     if (!(object instanceof Unite)) {
/* 214 */       return false;
     }
/* 216 */     Unite other = (Unite)object;
/* 217 */     if (((this.idunite == null) && (other.idunite != null)) || ((this.idunite != null) && (!this.idunite.equals(other.idunite)))) {
/* 218 */       return false;
     }
/* 220 */     return true;
   }
 
   public String toString()
   {
/* 225 */     return "entities.Unite[ idunite=" + this.idunite + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Unite
 * JD-Core Version:    0.6.2
 */