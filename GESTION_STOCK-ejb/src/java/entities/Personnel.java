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
 @NamedQueries({@javax.persistence.NamedQuery(name="Personnel.findAll", query="SELECT p FROM Personnel p"), @javax.persistence.NamedQuery(name="Personnel.findByIdpersonnel", query="SELECT p FROM Personnel p WHERE p.idpersonnel = :idpersonnel"), @javax.persistence.NamedQuery(name="Personnel.findByIdservice", query="SELECT p FROM Personnel p WHERE p.idservice = :idservice"), @javax.persistence.NamedQuery(name="Personnel.findByMatricule", query="SELECT p FROM Personnel p WHERE p.matricule = :matricule"), @javax.persistence.NamedQuery(name="Personnel.findByNiveauscolaire", query="SELECT p FROM Personnel p WHERE p.niveauscolaire = :niveauscolaire"), @javax.persistence.NamedQuery(name="Personnel.findByDateembauche", query="SELECT p FROM Personnel p WHERE p.dateembauche = :dateembauche"), @javax.persistence.NamedQuery(name="Personnel.findByNom", query="SELECT p FROM Personnel p WHERE p.nom = :nom"), @javax.persistence.NamedQuery(name="Personnel.findByContact", query="SELECT p FROM Personnel p WHERE p.contact = :contact"), @javax.persistence.NamedQuery(name="Personnel.findByPrenom", query="SELECT p FROM Personnel p WHERE p.prenom = :prenom"), @javax.persistence.NamedQuery(name="Personnel.findByAddresse", query="SELECT p FROM Personnel p WHERE p.addresse = :addresse")})
 public class Personnel
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
 
   @Id
   @Basic(optional=false)
   @NotNull
   private Long idpersonnel;
   private Integer idservice;
 
   @Size(max=1024)
   private String matricule;
 
   @Size(max=1024)
   private String niveauscolaire;
 
   @Temporal(TemporalType.DATE)
   private Date dateembauche;
 
   @Size(max=1024)
   private String nom;
 
   @Size(max=100)
   private String contact;
 
   @Size(max=100)
   private String prenom;
 
   @Size(max=100)
   private String addresse;
 
   @OneToMany(mappedBy="idpersonnel", fetch=FetchType.LAZY)
   private List<Demande> demandeList;
 
   @OneToMany(mappedBy="idpersonnel", fetch=FetchType.LAZY)
   private List<Utilisateur> utilisateurList;
 
   @OneToMany(mappedBy="idpersonnel", fetch=FetchType.LAZY)
   private List<Livraisonclient> livraisonclientList;
 
   @JoinColumn(name="idmagasin", referencedColumnName="idmagasin")
   @ManyToOne(fetch=FetchType.LAZY)
   private Magasin idmagasin;
 
   @JoinColumn(name="idqualite", referencedColumnName="idqualite")
   @ManyToOne(fetch=FetchType.LAZY)
   private Qualite idqualite;
 
   public Personnel()
   {
   }
 
   public Personnel(Long idpersonnel)
   {
/*  82 */     this.idpersonnel = idpersonnel;
   }
 
   public Long getIdpersonnel() {
/*  86 */     return this.idpersonnel;
   }
 
   public void setIdpersonnel(Long idpersonnel) {
/*  90 */     this.idpersonnel = idpersonnel;
   }
 
   public Integer getIdservice() {
/*  94 */     return this.idservice;
   }
 
   public void setIdservice(Integer idservice) {
/*  98 */     this.idservice = idservice;
   }
 
   public String getMatricule() {
/* 102 */     return this.matricule;
   }
 
   public void setMatricule(String matricule) {
/* 106 */     this.matricule = matricule;
   }
 
   public String getNiveauscolaire() {
/* 110 */     return this.niveauscolaire;
   }
 
   public void setNiveauscolaire(String niveauscolaire) {
/* 114 */     this.niveauscolaire = niveauscolaire;
   }
 
   public Date getDateembauche() {
/* 118 */     return this.dateembauche;
   }
 
   public void setDateembauche(Date dateembauche) {
/* 122 */     this.dateembauche = dateembauche;
   }
 
   public String getNom() {
/* 126 */     return this.nom;
   }
 
   public void setNom(String nom) {
/* 130 */     this.nom = nom;
   }
 
   public String getContact() {
/* 134 */     return this.contact;
   }
 
   public void setContact(String contact) {
/* 138 */     this.contact = contact;
   }
 
   public String getPrenom() {
/* 142 */     return this.prenom;
   }
 
   public void setPrenom(String prenom) {
/* 146 */     this.prenom = prenom;
   }
 
   public String getAddresse() {
/* 150 */     return this.addresse;
   }
 
   public void setAddresse(String addresse) {
/* 154 */     this.addresse = addresse;
   }
 
   @XmlTransient
   public List<Demande> getDemandeList() {
/* 159 */     return this.demandeList;
   }
 
   public void setDemandeList(List<Demande> demandeList) {
/* 163 */     this.demandeList = demandeList;
   }
 
   @XmlTransient
   public List<Utilisateur> getUtilisateurList() {
/* 168 */     return this.utilisateurList;
   }
 
   public void setUtilisateurList(List<Utilisateur> utilisateurList) {
/* 172 */     this.utilisateurList = utilisateurList;
   }
 
   @XmlTransient
   public List<Livraisonclient> getLivraisonclientList() {
/* 177 */     return this.livraisonclientList;
   }
 
   public void setLivraisonclientList(List<Livraisonclient> livraisonclientList) {
/* 181 */     this.livraisonclientList = livraisonclientList;
   }
 
   public Magasin getIdmagasin() {
/* 185 */     return this.idmagasin;
   }
 
   public void setIdmagasin(Magasin idmagasin) {
/* 189 */     this.idmagasin = idmagasin;
   }
 
   public Qualite getIdqualite() {
/* 193 */     return this.idqualite;
   }
 
   public void setIdqualite(Qualite idqualite) {
/* 197 */     this.idqualite = idqualite;
   }
 
   public int hashCode()
   {
/* 202 */     int hash = 0;
/* 203 */     hash += (this.idpersonnel != null ? this.idpersonnel.hashCode() : 0);
/* 204 */     return hash;
   }
 
   public boolean equals(Object object)
   {
/* 210 */     if (!(object instanceof Personnel)) {
/* 211 */       return false;
     }
/* 213 */     Personnel other = (Personnel)object;
/* 214 */     if (((this.idpersonnel == null) && (other.idpersonnel != null)) || ((this.idpersonnel != null) && (!this.idpersonnel.equals(other.idpersonnel)))) {
/* 215 */       return false;
     }
/* 217 */     return true;
   }
 
   public String toString()
   {
/* 222 */     return "entities.Personnel[ idpersonnel=" + this.idpersonnel + " ]";
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-ejb\dist\GESTION_STOCK-ejb.jar
 * Qualified Name:     entities.Personnel
 * JD-Core Version:    0.6.2
 */