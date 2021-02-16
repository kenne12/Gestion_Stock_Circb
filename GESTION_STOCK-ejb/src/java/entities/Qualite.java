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
 @NamedQueries({@javax.persistence.NamedQuery(name="Qualite.findAll", query="SELECT q FROM Qualite q"), @javax.persistence.NamedQuery(name="Qualite.findByIdqualite", query="SELECT q FROM Qualite q WHERE q.idqualite = :idqualite"), @javax.persistence.NamedQuery(name="Qualite.findByNom", query="SELECT q FROM Qualite q WHERE q.nom = :nom"), @javax.persistence.NamedQuery(name="Qualite.findByCode", query="SELECT q FROM Qualite q WHERE q.code = :code")})
 public class Qualite
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Integer idqualite;
 
   @Size(max=254)
   private String nom;
 
   @Size(max=254)
   private String code;
 
   @OneToMany(mappedBy="idqualite", fetch=FetchType.LAZY)
   private List<Personnel> personnelList;
 
   public Qualite()
   {
   }
 
   public Qualite(Integer idqualite)
   {
/*  50 */     this.idqualite = idqualite;
   }
 
   public Integer getIdqualite() {
/*  54 */     return this.idqualite;
   }
 
   public void setIdqualite(Integer idqualite) {
/*  58 */     this.idqualite = idqualite;
   }
 
   public String getNom() {
/*  62 */     return this.nom;
   }
 
   public void setNom(String nom) {
/*  66 */     this.nom = nom;
   }
 
   public String getCode() {
/*  70 */     return this.code;
   }
 
   public void setCode(String code) {
/*  74 */     this.code = code;
   }
 
   @XmlTransient
   public List<Personnel> getPersonnelList() {
/*  79 */     return this.personnelList;
   }
 
   public void setPersonnelList(List<Personnel> personnelList) {
/*  83 */     this.personnelList = personnelList;
   }
 
   public int hashCode()
   {
/*  88 */     int hash = 0;
/*  89 */     hash += (this.idqualite != null ? this.idqualite.hashCode() : 0);
/*  90 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/*  96 */     if (!(object instanceof Qualite)) {
/*  97 */       return false;
     }
/*  99 */     Qualite other = (Qualite)object;
/* 100 */     if (((this.idqualite == null) && (other.idqualite != null)) || ((this.idqualite != null) && (!this.idqualite.equals(other.idqualite)))) {
/* 101 */       return false;
     }
/* 103 */     return true;
   }
 
   public String toString()
   {
/* 108 */     return "entities.Qualite[ idqualite=" + this.idqualite + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Qualite
 * JD-Core Version:    0.6.2
 */