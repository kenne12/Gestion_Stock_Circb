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
 @NamedQueries({@javax.persistence.NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u"), @javax.persistence.NamedQuery(name="Utilisateur.findByIdutilisateur", query="SELECT u FROM Utilisateur u WHERE u.idutilisateur = :idutilisateur"), @javax.persistence.NamedQuery(name="Utilisateur.findByNom", query="SELECT u FROM Utilisateur u WHERE u.nom = :nom"), @javax.persistence.NamedQuery(name="Utilisateur.findByPrenom", query="SELECT u FROM Utilisateur u WHERE u.prenom = :prenom"), @javax.persistence.NamedQuery(name="Utilisateur.findByLogin", query="SELECT u FROM Utilisateur u WHERE u.login = :login"), @javax.persistence.NamedQuery(name="Utilisateur.findByPassword", query="SELECT u FROM Utilisateur u WHERE u.password = :password"), @javax.persistence.NamedQuery(name="Utilisateur.findByPhoto", query="SELECT u FROM Utilisateur u WHERE u.photo = :photo"), @javax.persistence.NamedQuery(name="Utilisateur.findByTemplate", query="SELECT u FROM Utilisateur u WHERE u.template = :template"), @javax.persistence.NamedQuery(name="Utilisateur.findByTheme", query="SELECT u FROM Utilisateur u WHERE u.theme = :theme"), @javax.persistence.NamedQuery(name="Utilisateur.findByDatecreation", query="SELECT u FROM Utilisateur u WHERE u.datecreation = :datecreation"), @javax.persistence.NamedQuery(name="Utilisateur.findByDatederniereconnexion", query="SELECT u FROM Utilisateur u WHERE u.datederniereconnexion = :datederniereconnexion"), @javax.persistence.NamedQuery(name="Utilisateur.findByHeurederniereconnexion", query="SELECT u FROM Utilisateur u WHERE u.heurederniereconnexion = :heurederniereconnexion"), @javax.persistence.NamedQuery(name="Utilisateur.findByActif", query="SELECT u FROM Utilisateur u WHERE u.actif = :actif")})
 public class Utilisateur
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Integer idutilisateur;
 
   @Size(max=254)
   private String nom;
 
   @Size(max=254)
   private String prenom;
 
   @Size(max=254)
   private String login;
 
   @Size(max=254)
   private String password;
 
   @Size(max=254)
   private String photo;
 
   @Size(max=254)
   private String template;
 
   @Size(max=254)
   private String theme;
 
   @Temporal(TemporalType.DATE)
   private Date datecreation;
 
   @Temporal(TemporalType.DATE)
   private Date datederniereconnexion;
 
   @Temporal(TemporalType.DATE)
   private Date heurederniereconnexion;
   private Boolean actif;
 
   @OneToMany(mappedBy="idutilisateur", fetch=FetchType.LAZY)
   private List<Privilege> privilegeList;
 
   @JoinColumn(name="idpersonnel", referencedColumnName="idpersonnel")
   @ManyToOne(fetch=FetchType.LAZY)
   private Personnel idpersonnel;
 
   @OneToMany(cascade={javax.persistence.CascadeType.ALL}, mappedBy="idutilisateur", fetch=FetchType.LAZY)
   private List<Mouchard> mouchardList;
 
   @OneToMany(mappedBy="idutilisateur", fetch=FetchType.LAZY)
   private List<Utilisateurmagasin> utilisateurmagasinList;
 
   public Utilisateur()
   {
   }
 
   public Utilisateur(Integer idutilisateur)
   {
/*  89 */     this.idutilisateur = idutilisateur;
   }
 
   public Integer getIdutilisateur() {
/*  93 */     return this.idutilisateur;
   }
 
   public void setIdutilisateur(Integer idutilisateur) {
/*  97 */     this.idutilisateur = idutilisateur;
   }
 
   public String getNom() {
/* 101 */     return this.nom;
   }
 
   public void setNom(String nom) {
/* 105 */     this.nom = nom;
   }
 
   public String getPrenom() {
/* 109 */     return this.prenom;
   }
 
   public void setPrenom(String prenom) {
/* 113 */     this.prenom = prenom;
   }
 
   public String getLogin() {
/* 117 */     return this.login;
   }
 
   public void setLogin(String login) {
/* 121 */     this.login = login;
   }
 
   public String getPassword() {
/* 125 */     return this.password;
   }
 
   public void setPassword(String password) {
/* 129 */     this.password = password;
   }
 
   public String getPhoto() {
/* 133 */     return this.photo;
   }
 
   public void setPhoto(String photo) {
/* 137 */     this.photo = photo;
   }
 
   public String getTemplate() {
/* 141 */     return this.template;
   }
 
   public void setTemplate(String template) {
/* 145 */     this.template = template;
   }
 
   public String getTheme() {
/* 149 */     return this.theme;
   }
 
   public void setTheme(String theme) {
/* 153 */     this.theme = theme;
   }
 
   public Date getDatecreation() {
/* 157 */     return this.datecreation;
   }
 
   public void setDatecreation(Date datecreation) {
/* 161 */     this.datecreation = datecreation;
   }
 
   public Date getDatederniereconnexion() {
/* 165 */     return this.datederniereconnexion;
   }
 
   public void setDatederniereconnexion(Date datederniereconnexion) {
/* 169 */     this.datederniereconnexion = datederniereconnexion;
   }
 
   public Date getHeurederniereconnexion() {
/* 173 */     return this.heurederniereconnexion;
   }
 
   public void setHeurederniereconnexion(Date heurederniereconnexion) {
/* 177 */     this.heurederniereconnexion = heurederniereconnexion;
   }
 
   public Boolean getActif() {
/* 181 */     return this.actif;
   }
 
   public void setActif(Boolean actif) {
/* 185 */     this.actif = actif;
   }
 
   @XmlTransient
   public List<Privilege> getPrivilegeList() {
/* 190 */     return this.privilegeList;
   }
 
   public void setPrivilegeList(List<Privilege> privilegeList) {
/* 194 */     this.privilegeList = privilegeList;
   }
 
   public Personnel getIdpersonnel() {
/* 198 */     return this.idpersonnel;
   }
 
   public void setIdpersonnel(Personnel idpersonnel) {
/* 202 */     this.idpersonnel = idpersonnel;
   }
 
   @XmlTransient
   public List<Mouchard> getMouchardList() {
/* 207 */     return this.mouchardList;
   }
 
   public void setMouchardList(List<Mouchard> mouchardList) {
/* 211 */     this.mouchardList = mouchardList;
   }
 
   @XmlTransient
   public List<Utilisateurmagasin> getUtilisateurmagasinList() {
/* 216 */     return this.utilisateurmagasinList;
   }
 
   public void setUtilisateurmagasinList(List<Utilisateurmagasin> utilisateurmagasinList) {
/* 220 */     this.utilisateurmagasinList = utilisateurmagasinList;
   }
 
   public int hashCode()
   {
/* 225 */     int hash = 0;
/* 226 */     hash += (this.idutilisateur != null ? this.idutilisateur.hashCode() : 0);
/* 227 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 233 */     if (!(object instanceof Utilisateur)) {
/* 234 */       return false;
     }
/* 236 */     Utilisateur other = (Utilisateur)object;
/* 237 */     if (((this.idutilisateur == null) && (other.idutilisateur != null)) || ((this.idutilisateur != null) && (!this.idutilisateur.equals(other.idutilisateur)))) {
/* 238 */       return false;
     }
/* 240 */     return true;
   }
 
   public String toString()
   {
/* 245 */     return "entities.Utilisateur[ idutilisateur=" + this.idutilisateur + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Utilisateur
 * JD-Core Version:    0.6.2
 */