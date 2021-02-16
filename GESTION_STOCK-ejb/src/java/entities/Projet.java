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
 @NamedQueries({@javax.persistence.NamedQuery(name="Projet.findAll", query="SELECT p FROM Projet p"), @javax.persistence.NamedQuery(name="Projet.findByIdprojet", query="SELECT p FROM Projet p WHERE p.idprojet = :idprojet"), @javax.persistence.NamedQuery(name="Projet.findByNom", query="SELECT p FROM Projet p WHERE p.nom = :nom"), @javax.persistence.NamedQuery(name="Projet.findByCode", query="SELECT p FROM Projet p WHERE p.code = :code"), @javax.persistence.NamedQuery(name="Projet.findByDatecreation", query="SELECT p FROM Projet p WHERE p.datecreation = :datecreation"), @javax.persistence.NamedQuery(name="Projet.findByCloturee", query="SELECT p FROM Projet p WHERE p.cloturee = :cloturee")})
 public class Projet
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Integer idprojet;
 
   @Size(max=254)
   private String nom;
 
   @Size(max=254)
   private String code;
 
   @Temporal(TemporalType.DATE)
   private Date datecreation;
   private Boolean cloturee;
 
   @OneToMany(mappedBy="idprojet", fetch=FetchType.LAZY)
   private List<Demande> demandeList;
 
   @JoinColumn(name="idmagasin", referencedColumnName="idmagasin")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasin idmagasin;
 
   public Projet()
   {
   }
 
   public Projet(Integer idprojet)
   {
/*  63 */     this.idprojet = idprojet;
   }
 
   public Integer getIdprojet() {
/*  67 */     return this.idprojet;
   }
 
   public void setIdprojet(Integer idprojet) {
/*  71 */     this.idprojet = idprojet;
   }
 
   public String getNom() {
/*  75 */     return this.nom;
   }
 
   public void setNom(String nom) {
/*  79 */     this.nom = nom;
   }
 
   public String getCode() {
/*  83 */     return this.code;
   }
 
   public void setCode(String code) {
/*  87 */     this.code = code;
   }
 
   public Date getDatecreation() {
/*  91 */     return this.datecreation;
   }
 
   public void setDatecreation(Date datecreation) {
/*  95 */     this.datecreation = datecreation;
   }
 
   public Boolean getCloturee() {
/*  99 */     return this.cloturee;
   }
 
   public void setCloturee(Boolean cloturee) {
/* 103 */     this.cloturee = cloturee;
   }
 
   @XmlTransient
   public List<Demande> getDemandeList() {
/* 108 */     return this.demandeList;
   }
 
   public void setDemandeList(List<Demande> demandeList) {
/* 112 */     this.demandeList = demandeList;
   }
 
   public Magasin getIdmagasin() {
/* 116 */     return this.idmagasin;
   }
 
   public void setIdmagasin(Magasin idmagasin) {
/* 120 */     this.idmagasin = idmagasin;
   }
 
   public int hashCode()
   {
/* 125 */     int hash = 0;
/* 126 */     hash += (this.idprojet != null ? this.idprojet.hashCode() : 0);
/* 127 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 133 */     if (!(object instanceof Projet)) {
/* 134 */       return false;
     }
/* 136 */     Projet other = (Projet)object;
/* 137 */     if (((this.idprojet == null) && (other.idprojet != null)) || ((this.idprojet != null) && (!this.idprojet.equals(other.idprojet)))) {
/* 138 */       return false;
     }
/* 140 */     return true;
   }
 
   public String toString()
   {
/* 145 */     return "entities.Projet[ idprojet=" + this.idprojet + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Projet
 * JD-Core Version:    0.6.2
 */