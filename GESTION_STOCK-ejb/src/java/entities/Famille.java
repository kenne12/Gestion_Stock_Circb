 package entities;
 
 import java.io.Serializable;
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
 @NamedQueries({@javax.persistence.NamedQuery(name="Famille.findAll", query="SELECT f FROM Famille f"), @javax.persistence.NamedQuery(name="Famille.findByIdfamille", query="SELECT f FROM Famille f WHERE f.idfamille = :idfamille"), @javax.persistence.NamedQuery(name="Famille.findByNom", query="SELECT f FROM Famille f WHERE f.nom = :nom"), @javax.persistence.NamedQuery(name="Famille.findByCode", query="SELECT f FROM Famille f WHERE f.code = :code"), @javax.persistence.NamedQuery(name="Famille.findByEtat", query="SELECT f FROM Famille f WHERE f.etat = :etat"), @javax.persistence.NamedQuery(name="Famille.findByDateEnregistre", query="SELECT f FROM Famille f WHERE f.dateEnregistre = :dateEnregistre"), @javax.persistence.NamedQuery(name="Famille.findByDerniereModif", query="SELECT f FROM Famille f WHERE f.derniereModif = :derniereModif")})
 public class Famille
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idfamille;
 
   @Size(max=254)
   private String nom;
 
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
 
   @OneToMany(mappedBy="idfamille", fetch=FetchType.LAZY)
   private List<Article> articleList;
 
   public Famille()
   {
   }
 
   public Famille(Long idfamille)
   {
/*  65 */     this.idfamille = idfamille;
   }
 
   public Long getIdfamille() {
/*  69 */     return this.idfamille;
   }
 
   public void setIdfamille(Long idfamille) {
/*  73 */     this.idfamille = idfamille;
   }
 
   public String getNom() {
/*  77 */     return this.nom;
   }
 
   public void setNom(String nom) {
/*  81 */     this.nom = nom;
   }
 
   public String getCode() {
/*  85 */     return this.code;
   }
 
   public void setCode(String code) {
/*  89 */     this.code = code;
   }
 
   public String getEtat() {
/*  93 */     return this.etat;
   }
 
   public void setEtat(String etat) {
/*  97 */     this.etat = etat;
   }
 
   public Date getDateEnregistre() {
/* 101 */     return this.dateEnregistre;
   }
 
   public void setDateEnregistre(Date dateEnregistre) {
/* 105 */     this.dateEnregistre = dateEnregistre;
   }
 
   public Date getDerniereModif() {
/* 109 */     return this.derniereModif;
   }
 
   public void setDerniereModif(Date derniereModif) {
/* 113 */     this.derniereModif = derniereModif;
   }
 
   @XmlTransient
   public List<Article> getArticleList() {
/* 118 */     return this.articleList;
   }
 
   public void setArticleList(List<Article> articleList) {
/* 122 */     this.articleList = articleList;
   }
 
   public int hashCode()
   {
/* 127 */     int hash = 0;
/* 128 */     hash += (this.idfamille != null ? this.idfamille.hashCode() : 0);
/* 129 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 135 */     if (!(object instanceof Famille)) {
/* 136 */       return false;
     }
/* 138 */     Famille other = (Famille)object;
/* 139 */     if (((this.idfamille == null) && (other.idfamille != null)) || ((this.idfamille != null) && (!this.idfamille.equals(other.idfamille)))) {
/* 140 */       return false;
     }
/* 142 */     return true;
   }
 
   public String toString()
   {
/* 147 */     return "entities.Famille[ idfamille=" + this.idfamille + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Famille
 * JD-Core Version:    0.6.2
 */