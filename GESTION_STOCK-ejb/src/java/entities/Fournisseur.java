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
 @NamedQueries({@javax.persistence.NamedQuery(name="Fournisseur.findAll", query="SELECT f FROM Fournisseur f"), @javax.persistence.NamedQuery(name="Fournisseur.findByIdfournisseur", query="SELECT f FROM Fournisseur f WHERE f.idfournisseur = :idfournisseur"), @javax.persistence.NamedQuery(name="Fournisseur.findByNom", query="SELECT f FROM Fournisseur f WHERE f.nom = :nom"), @javax.persistence.NamedQuery(name="Fournisseur.findByAdresse", query="SELECT f FROM Fournisseur f WHERE f.adresse = :adresse"), @javax.persistence.NamedQuery(name="Fournisseur.findByContact", query="SELECT f FROM Fournisseur f WHERE f.contact = :contact"), @javax.persistence.NamedQuery(name="Fournisseur.findByEmail", query="SELECT f FROM Fournisseur f WHERE f.email = :email")})
 public class Fournisseur
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Integer idfournisseur;
 
   @Size(max=254)
   private String nom;
 
   @Size(max=254)
   private String adresse;
 
   @Size(max=254)
   private String contact;
 
   @Size(max=254)
   private String email;
 
   @OneToMany(mappedBy="idfournisseur", fetch=FetchType.LAZY)
   private List<Livraisonfournisseur> livraisonfournisseurList;
 
   @OneToMany(mappedBy="idfournisseur", fetch=FetchType.LAZY)
   private List<Commandefournisseur> commandefournisseurList;
 
   public Fournisseur()
   {
   }
 
   public Fournisseur(Integer idfournisseur)
   {
/*  59 */     this.idfournisseur = idfournisseur;
   }
 
   public Integer getIdfournisseur() {
/*  63 */     return this.idfournisseur;
   }
 
   public void setIdfournisseur(Integer idfournisseur) {
/*  67 */     this.idfournisseur = idfournisseur;
   }
 
   public String getNom() {
/*  71 */     return this.nom;
   }
 
   public void setNom(String nom) {
/*  75 */     this.nom = nom;
   }
 
   public String getAdresse() {
/*  79 */     return this.adresse;
   }
 
   public void setAdresse(String adresse) {
/*  83 */     this.adresse = adresse;
   }
 
   public String getContact() {
/*  87 */     return this.contact;
   }
 
   public void setContact(String contact) {
/*  91 */     this.contact = contact;
   }
 
   public String getEmail() {
/*  95 */     return this.email;
   }
 
   public void setEmail(String email) {
/*  99 */     this.email = email;
   }
 
   @XmlTransient
   public List<Livraisonfournisseur> getLivraisonfournisseurList() {
/* 104 */     return this.livraisonfournisseurList;
   }
 
   public void setLivraisonfournisseurList(List<Livraisonfournisseur> livraisonfournisseurList) {
/* 108 */     this.livraisonfournisseurList = livraisonfournisseurList;
   }
 
   @XmlTransient
   public List<Commandefournisseur> getCommandefournisseurList() {
/* 113 */     return this.commandefournisseurList;
   }
 
   public void setCommandefournisseurList(List<Commandefournisseur> commandefournisseurList) {
/* 117 */     this.commandefournisseurList = commandefournisseurList;
   }
 
   public int hashCode()
   {
/* 122 */     int hash = 0;
/* 123 */     hash += (this.idfournisseur != null ? this.idfournisseur.hashCode() : 0);
/* 124 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 130 */     if (!(object instanceof Fournisseur)) {
/* 131 */       return false;
     }
/* 133 */     Fournisseur other = (Fournisseur)object;
/* 134 */     if (((this.idfournisseur == null) && (other.idfournisseur != null)) || ((this.idfournisseur != null) && (!this.idfournisseur.equals(other.idfournisseur)))) {
/* 135 */       return false;
     }
/* 137 */     return true;
   }
 
   public String toString()
   {
/* 142 */     return "entities.Fournisseur[ idfournisseur=" + this.idfournisseur + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Fournisseur
 * JD-Core Version:    0.6.2
 */