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
 @NamedQueries({@javax.persistence.NamedQuery(name="Inventaire.findAll", query="SELECT i FROM Inventaire i"), @javax.persistence.NamedQuery(name="Inventaire.findByIdinventaire", query="SELECT i FROM Inventaire i WHERE i.idinventaire = :idinventaire"), @javax.persistence.NamedQuery(name="Inventaire.findByCode", query="SELECT i FROM Inventaire i WHERE i.code = :code"), @javax.persistence.NamedQuery(name="Inventaire.findByDateinventaire", query="SELECT i FROM Inventaire i WHERE i.dateinventaire = :dateinventaire"), @javax.persistence.NamedQuery(name="Inventaire.findByEtat", query="SELECT i FROM Inventaire i WHERE i.etat = :etat"), @javax.persistence.NamedQuery(name="Inventaire.findByCentral", query="SELECT i FROM Inventaire i WHERE i.central = :central"), @javax.persistence.NamedQuery(name="Inventaire.findByLibelle", query="SELECT i FROM Inventaire i WHERE i.libelle = :libelle"), @javax.persistence.NamedQuery(name="Inventaire.findByAllarticle", query="SELECT i FROM Inventaire i WHERE i.allarticle = :allarticle")})
 public class Inventaire
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idinventaire;
 
   @Size(max=254)
   private String code;
 
   @Temporal(TemporalType.DATE)
   private Date dateinventaire;
   private Boolean etat;
   private Boolean central;
 
   @Size(max=100)
   private String libelle;
   private Boolean allarticle;
 
   @OneToMany(mappedBy="idinventaire", fetch=FetchType.LAZY)
   private List<Ligneinventaire> ligneinventaireList;
 
   @JoinColumn(name="idmagasin", referencedColumnName="idmagasin")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasin idmagasin;
 
   @JoinColumn(name="idmvtstock", referencedColumnName="idmvtstock")
   @ManyToOne(fetch=FetchType.LAZY)
   private Mvtstock idmvtstock;
 
   public Inventaire()
   {
   }
 
   public Inventaire(Long idinventaire)
   {
/*  70 */     this.idinventaire = idinventaire;
   }
 
   public Long getIdinventaire() {
/*  74 */     return this.idinventaire;
   }
 
   public void setIdinventaire(Long idinventaire) {
/*  78 */     this.idinventaire = idinventaire;
   }
 
   public String getCode() {
/*  82 */     return this.code;
   }
 
   public void setCode(String code) {
/*  86 */     this.code = code;
   }
 
   public Date getDateinventaire() {
/*  90 */     return this.dateinventaire;
   }
 
   public void setDateinventaire(Date dateinventaire) {
/*  94 */     this.dateinventaire = dateinventaire;
   }
 
   public Boolean getEtat() {
/*  98 */     return this.etat;
   }
 
   public void setEtat(Boolean etat) {
/* 102 */     this.etat = etat;
   }
 
   public Boolean getCentral() {
/* 106 */     return this.central;
   }
 
   public void setCentral(Boolean central) {
/* 110 */     this.central = central;
   }
 
   public String getLibelle() {
/* 114 */     return this.libelle;
   }
 
   public void setLibelle(String libelle) {
/* 118 */     this.libelle = libelle;
   }
 
   public Boolean getAllarticle() {
/* 122 */     return this.allarticle;
   }
 
   public void setAllarticle(Boolean allarticle) {
/* 126 */     this.allarticle = allarticle;
   }
 
   @XmlTransient
   public List<Ligneinventaire> getLigneinventaireList() {
/* 131 */     return this.ligneinventaireList;
   }
 
   public void setLigneinventaireList(List<Ligneinventaire> ligneinventaireList) {
/* 135 */     this.ligneinventaireList = ligneinventaireList;
   }
 
   public Magasin getIdmagasin() {
/* 139 */     return this.idmagasin;
   }
 
   public void setIdmagasin(Magasin idmagasin) {
/* 143 */     this.idmagasin = idmagasin;
   }
 
   public Mvtstock getIdmvtstock() {
/* 147 */     return this.idmvtstock;
   }
 
   public void setIdmvtstock(Mvtstock idmvtstock) {
/* 151 */     this.idmvtstock = idmvtstock;
   }
 
   public int hashCode()
   {
/* 156 */     int hash = 0;
/* 157 */     hash += (this.idinventaire != null ? this.idinventaire.hashCode() : 0);
/* 158 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 164 */     if (!(object instanceof Inventaire)) {
/* 165 */       return false;
     }
/* 167 */     Inventaire other = (Inventaire)object;
/* 168 */     if (((this.idinventaire == null) && (other.idinventaire != null)) || ((this.idinventaire != null) && (!this.idinventaire.equals(other.idinventaire)))) {
/* 169 */       return false;
     }
/* 171 */     return true;
   }
 
   public String toString()
   {
/* 176 */     return "entities.Inventaire[ idinventaire=" + this.idinventaire + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Inventaire
 * JD-Core Version:    0.6.2
 */