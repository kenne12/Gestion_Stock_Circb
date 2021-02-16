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
 @NamedQueries({@javax.persistence.NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m"), @javax.persistence.NamedQuery(name="Menu.findByIdmenu", query="SELECT m FROM Menu m WHERE m.idmenu = :idmenu"), @javax.persistence.NamedQuery(name="Menu.findByNom", query="SELECT m FROM Menu m WHERE m.nom = :nom"), @javax.persistence.NamedQuery(name="Menu.findByRessource", query="SELECT m FROM Menu m WHERE m.ressource = :ressource")})
 public class Menu
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Integer idmenu;
 
   @Size(max=254)
   private String nom;
 
   @Size(max=254)
   private String ressource;
   private Boolean etat;
 
   @OneToMany(mappedBy="idmenu", fetch=FetchType.LAZY)
   private List<Privilege> privilegeList;
 
   public Menu()
   {
   }
 
   public Menu(Integer idmenu)
   {
/*  52 */     this.idmenu = idmenu;
   }
 
   public Integer getIdmenu() {
/*  56 */     return this.idmenu;
   }
 
   public void setIdmenu(Integer idmenu) {
/*  60 */     this.idmenu = idmenu;
   }
 
   public String getNom() {
/*  64 */     return this.nom;
   }
 
   public void setNom(String nom) {
/*  68 */     this.nom = nom;
   }
 
   public Boolean getEtat() {
/*  72 */     return this.etat;
   }
 
   public void setEtat(Boolean etat) {
/*  76 */     this.etat = etat;
   }
 
   public String getRessource() {
/*  80 */     return this.ressource;
   }
 
   public void setRessource(String ressource) {
/*  84 */     this.ressource = ressource;
   }
 
   @XmlTransient
   public List<Privilege> getPrivilegeList() {
/*  89 */     return this.privilegeList;
   }
 
   public void setPrivilegeList(List<Privilege> privilegeList) {
/*  93 */     this.privilegeList = privilegeList;
   }
 
   public int hashCode()
   {
/*  98 */     int hash = 0;
/*  99 */     hash += (this.idmenu != null ? this.idmenu.hashCode() : 0);
/* 100 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 106 */     if (!(object instanceof Menu)) {
/* 107 */       return false;
     }
/* 109 */     Menu other = (Menu)object;
/* 110 */     if (((this.idmenu == null) && (other.idmenu != null)) || ((this.idmenu != null) && (!this.idmenu.equals(other.idmenu)))) {
/* 111 */       return false;
     }
/* 113 */     return true;
   }
 
   public String toString()
   {
/* 118 */     return "entities.Menu[ idmenu=" + this.idmenu + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Menu
 * JD-Core Version:    0.6.2
 */