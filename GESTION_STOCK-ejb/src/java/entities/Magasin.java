 package entities;
 
 import java.io.Serializable;
 import java.util.List;
 import javax.persistence.Basic;
 import javax.persistence.Entity;
 import javax.persistence.FetchType;
 import javax.persistence.Id;
 import javax.persistence.NamedQueries;
 import javax.persistence.OneToMany;
 import javax.validation.constraints.NotNull;
 import javax.validation.constraints.Size;
 import javax.xml.bind.annotation.XmlRootElement;
 import javax.xml.bind.annotation.XmlTransient;
 
 @Entity
 @XmlRootElement
 @NamedQueries({@javax.persistence.NamedQuery(name="Magasin.findAll", query="SELECT m FROM Magasin m"), @javax.persistence.NamedQuery(name="Magasin.findByIdmagasin", query="SELECT m FROM Magasin m WHERE m.idmagasin = :idmagasin"), @javax.persistence.NamedQuery(name="Magasin.findByNom", query="SELECT m FROM Magasin m WHERE m.nom = :nom"), @javax.persistence.NamedQuery(name="Magasin.findByCode", query="SELECT m FROM Magasin m WHERE m.code = :code"), @javax.persistence.NamedQuery(name="Magasin.findByCentral", query="SELECT m FROM Magasin m WHERE m.central = :central")})
 public class Magasin
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Integer idmagasin;
 
   @Size(max=254)
   private String nom;
 
   @Size(max=254)
   private String code;
   private Boolean central;
 
   @OneToMany(mappedBy="idmagasin", fetch=FetchType.LAZY)
   private List<Livraisonfournisseur> livraisonfournisseurList;
 
   @OneToMany(mappedBy="idmagasin", fetch=FetchType.LAZY)
   private List<Magasinarticle> magasinarticleList;
 
   @OneToMany(mappedBy="idmagasin", fetch=FetchType.LAZY)
   private List<Projet> projetList;
 
   @OneToMany(mappedBy="idmagasin", fetch=FetchType.LAZY)
   private List<Transfert> transfertList;
 
   @OneToMany(mappedBy="idmagasin", fetch=FetchType.LAZY)
   private List<Inventaire> inventaireList;
 
   @OneToMany(mappedBy="idmagasin", fetch=FetchType.LAZY)
   private List<Livraisonclient> livraisonclientList;
 
   @OneToMany(mappedBy="idmagasin", fetch=FetchType.LAZY)
   private List<Personnel> personnelList;
 
   @OneToMany(mappedBy="idmagasin", fetch=FetchType.LAZY)
   private List<Utilisateurmagasin> utilisateurmagasinList;
 
   public Magasin()
   {
   }
 
   public Magasin(Integer idmagasin)
   {
/*  66 */     this.idmagasin = idmagasin;
   }
 
   public Integer getIdmagasin() {
/*  70 */     return this.idmagasin;
   }
 
   public void setIdmagasin(Integer idmagasin) {
/*  74 */     this.idmagasin = idmagasin;
   }
 
   public String getNom() {
/*  78 */     return this.nom;
   }
 
   public void setNom(String nom) {
/*  82 */     this.nom = nom;
   }
 
   public String getCode() {
/*  86 */     return this.code;
   }
 
   public void setCode(String code) {
/*  90 */     this.code = code;
   }
 
   public Boolean getCentral() {
/*  94 */     return this.central;
   }
 
   public void setCentral(Boolean central) {
/*  98 */     this.central = central;
   }
 
   @XmlTransient
   public List<Livraisonfournisseur> getLivraisonfournisseurList() {
/* 103 */     return this.livraisonfournisseurList;
   }
 
   public void setLivraisonfournisseurList(List<Livraisonfournisseur> livraisonfournisseurList) {
/* 107 */     this.livraisonfournisseurList = livraisonfournisseurList;
   }
 
   @XmlTransient
   public List<Magasinarticle> getMagasinarticleList() {
/* 112 */     return this.magasinarticleList;
   }
 
   public void setMagasinarticleList(List<Magasinarticle> magasinarticleList) {
/* 116 */     this.magasinarticleList = magasinarticleList;
   }
 
   @XmlTransient
   public List<Projet> getProjetList() {
/* 121 */     return this.projetList;
   }
 
   public void setProjetList(List<Projet> projetList) {
/* 125 */     this.projetList = projetList;
   }
 
   @XmlTransient
   public List<Transfert> getTransfertList() {
/* 130 */     return this.transfertList;
   }
 
   public void setTransfertList(List<Transfert> transfertList) {
/* 134 */     this.transfertList = transfertList;
   }
 
   @XmlTransient
   public List<Inventaire> getInventaireList() {
/* 139 */     return this.inventaireList;
   }
 
   public void setInventaireList(List<Inventaire> inventaireList) {
/* 143 */     this.inventaireList = inventaireList;
   }
 
   @XmlTransient
   public List<Livraisonclient> getLivraisonclientList() {
/* 148 */     return this.livraisonclientList;
   }
 
   public void setLivraisonclientList(List<Livraisonclient> livraisonclientList) {
/* 152 */     this.livraisonclientList = livraisonclientList;
   }
 
   @XmlTransient
   public List<Personnel> getPersonnelList() {
/* 157 */     return this.personnelList;
   }
 
   public void setPersonnelList(List<Personnel> personnelList) {
/* 161 */     this.personnelList = personnelList;
   }
 
   @XmlTransient
   public List<Utilisateurmagasin> getUtilisateurmagasinList() {
/* 166 */     return this.utilisateurmagasinList;
   }
 
   public void setUtilisateurmagasinList(List<Utilisateurmagasin> utilisateurmagasinList) {
/* 170 */     this.utilisateurmagasinList = utilisateurmagasinList;
   }
 
   public int hashCode()
   {
/* 175 */     int hash = 0;
/* 176 */     hash += (this.idmagasin != null ? this.idmagasin.hashCode() : 0);
/* 177 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 183 */     if (!(object instanceof Magasin)) {
/* 184 */       return false;
     }
/* 186 */     Magasin other = (Magasin)object;
/* 187 */     if (((this.idmagasin == null) && (other.idmagasin != null)) || ((this.idmagasin != null) && (!this.idmagasin.equals(other.idmagasin)))) {
/* 188 */       return false;
     }
/* 190 */     return true;
   }
 
   public String toString()
   {
/* 195 */     return "entities.Magasin[ idmagasin=" + this.idmagasin + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Magasin
 * JD-Core Version:    0.6.2
 */