 package controllers.sortie_directe;
 
 import entities.Famille;
 import entities.Lignelivraisonclient;
 import entities.Livraisonclient;
 import entities.Magasin;
 import entities.Magasinarticle;
 import entities.Magasinlot;
 import entities.Mvtstock;
 import entities.Personnel;
 import entities.Unite;
 import java.util.ArrayList;
 import java.util.List;
 import javax.annotation.Resource;
 import javax.ejb.EJB;
 import javax.transaction.UserTransaction;
 import sessions.FamilleFacadeLocal;
 import sessions.LignelivraisonclientFacadeLocal;
 import sessions.LignemvtstockFacadeLocal;
 import sessions.LivraisonclientFacadeLocal;
 import sessions.MagasinFacadeLocal;
 import sessions.MagasinarticleFacadeLocal;
 import sessions.MagasinlotFacadeLocal;
 import sessions.MouchardFacadeLocal;
 import sessions.MvtstockFacadeLocal;
 import sessions.PersonnelFacadeLocal;
 import sessions.UniteFacadeLocal;
 import utils.Routine;
 
 public class AbstractSortiedirectController
 {
 
   @Resource
   protected UserTransaction ut;
 
   @EJB
   protected FamilleFacadeLocal familleFacadeLocal;
/*  46 */   protected Famille famille = new Famille();
/*  47 */   protected List<Famille> familles = new ArrayList();
 
   @EJB
   protected PersonnelFacadeLocal personnelFacadeLocal;
/*  51 */   protected Personnel personnel = new Personnel();
/*  52 */   protected List<Personnel> personnels = new ArrayList();
 
   @EJB
   protected LivraisonclientFacadeLocal livraisonclientFacadeLocal;
/*  56 */   protected Livraisonclient livraisonclient = new Livraisonclient();
/*  57 */   protected List<Livraisonclient> livraisonclients = new ArrayList();
 
   @EJB
   protected LignelivraisonclientFacadeLocal lignelivraisonclientFacadeLocal;
/*  61 */   protected Lignelivraisonclient lignelivraisonclient = new Lignelivraisonclient();
/*  62 */   protected List<Lignelivraisonclient> lignelivraisonclients = new ArrayList();
 
   @EJB
   protected MvtstockFacadeLocal mvtstockFacadeLocal;
/*  66 */   protected Mvtstock mvtstock = new Mvtstock();
 
   @EJB
   protected LignemvtstockFacadeLocal ligneMvtstockFacadeLocal;
 
   @EJB
   protected MagasinlotFacadeLocal magasinlotFacadeLocal;
/*  73 */   protected Magasinlot magasinlot = new Magasinlot();
/*  74 */   protected List<Magasinlot> magasinlots = new ArrayList();
 
   @EJB
   protected MagasinarticleFacadeLocal magasinarticleFacadeLocal;
/*  78 */   protected Magasinarticle magasinarticle = new Magasinarticle();
/*  79 */   protected List<Magasinarticle> magasinarticles = new ArrayList();
 
   @EJB
   protected MagasinFacadeLocal magasinFacadeLocal;
/*  83 */   protected Magasin magasin = new Magasin();
/*  84 */   protected List<Magasin> magasins = new ArrayList();
 
   @EJB
   protected UniteFacadeLocal uniteFacadeLocal;
/*  88 */   protected Unite unite = new Unite();
/*  89 */   protected List<Unite> unites = new ArrayList();
 
   @EJB
   protected MouchardFacadeLocal mouchardFacadeLocal;
/*  94 */   protected Routine routine = new Routine();
 
/*  96 */   protected Double cout_quantite = Double.valueOf(0.0D);
/*  97 */   protected Double total = Double.valueOf(0.0D);
 
/* 100 */   protected boolean nouveauPersonnel = true;
 
/* 102 */   protected Boolean saisiePersonnel = Boolean.valueOf(true);
 
/* 104 */   protected Boolean selectPersonnel = Boolean.valueOf(true);
 
/* 106 */   protected Boolean showSelector = Boolean.valueOf(true);
 
/* 108 */   protected Boolean detail = Boolean.valueOf(true);
/* 109 */   protected Boolean modifier = Boolean.valueOf(true);
/* 110 */   protected Boolean consulter = Boolean.valueOf(true);
/* 111 */   protected Boolean imprimer = Boolean.valueOf(true);
/* 112 */   protected Boolean supprimer = Boolean.valueOf(true);
 
/* 114 */   protected Boolean showEditSolde = Boolean.valueOf(true);
 
/* 116 */   protected boolean buttonActif = false;
/* 117 */   protected boolean buttonInactif = true;
 
/* 119 */   protected boolean showPersonnelSolde = false;
 
/* 121 */   protected boolean payement_espece_compte = true;
 
/* 123 */   protected boolean payement_credit = false;
 
/* 125 */   protected String fileName = "";
 
/* 127 */   protected String mode = "";
 
/* 129 */   int conteur = 0;
 
   public Personnel getPersonnel() {
/* 132 */     return this.personnel;
   }
 
   public void setPersonnel(Personnel personnel) {
/* 136 */     this.personnel = personnel;
   }
 
   public List<Personnel> getPersonnels() {
/* 140 */     this.personnels = this.personnelFacadeLocal.findAllRange();
/* 141 */     return this.personnels;
   }
 
   public Livraisonclient getLivraisonclient() {
/* 145 */     return this.livraisonclient;
   }
 
   public void setLivraisonclient(Livraisonclient livraisonclient) {
/* 149 */     this.modifier = (this.supprimer = this.detail = this.imprimer = Boolean.valueOf(livraisonclient == null));
/* 150 */     this.livraisonclient = livraisonclient;
   }
 
   public List<Livraisonclient> getLivraisonclients() {
     try {
/* 155 */       this.livraisonclients = this.livraisonclientFacadeLocal.findAllRange();
     } catch (Exception e) {
/* 157 */       e.printStackTrace();
     }
/* 159 */     return this.livraisonclients;
   }
 
   public Lignelivraisonclient getLignelivraisonclient() {
/* 163 */     return this.lignelivraisonclient;
   }
 
   public void setLignelivraisonclient(Lignelivraisonclient lignelivraisonclient) {
/* 167 */     this.lignelivraisonclient = lignelivraisonclient;
   }
 
   public List<Lignelivraisonclient> getLignelivraisonclients() {
/* 171 */     return this.lignelivraisonclients;
   }
 
   public Boolean getDetail() {
/* 175 */     return this.detail;
   }
 
   public Boolean getModifier() {
/* 179 */     return this.modifier;
   }
 
   public Boolean getConsulter() {
/* 183 */     return this.consulter;
   }
 
   public Boolean getImprimer() {
/* 187 */     return this.imprimer;
   }
 
   public Boolean getSupprimer() {
/* 191 */     return this.supprimer;
   }
 
   public Boolean getShowEditSolde() {
/* 195 */     return this.showEditSolde;
   }
 
   public boolean isButtonActif() {
/* 199 */     return this.buttonActif;
   }
 
   public void setButtonActif(boolean buttonActif) {
/* 203 */     this.buttonActif = buttonActif;
   }
 
   public boolean isButtonInactif() {
/* 207 */     return this.buttonInactif;
   }
 
   public void setButtonInactif(boolean buttonInactif) {
/* 211 */     this.buttonInactif = buttonInactif;
   }
 
   public Famille getFamille() {
/* 215 */     return this.famille;
   }
 
   public void setFamille(Famille famille) {
/* 219 */     this.famille = famille;
   }
 
   public List<Famille> getFamilles() {
/* 223 */     this.familles = this.familleFacadeLocal.findAllRange();
/* 224 */     return this.familles;
   }
 
   public Double getCout_quantite() {
/* 228 */     return this.cout_quantite;
   }
 
   public void setCout_quantite(Double cout_quantite) {
/* 232 */     this.cout_quantite = cout_quantite;
   }
 
   public Double getTotal() {
/* 236 */     return this.total;
   }
 
   public void setTotal(Double total) {
/* 240 */     this.total = total;
   }
 
   public boolean isShowPersonnelSolde() {
/* 244 */     return this.showPersonnelSolde;
   }
 
   public boolean isPayement_espece_compte() {
/* 248 */     return this.payement_espece_compte;
   }
 
   public boolean isPayement_credit() {
/* 252 */     return this.payement_credit;
   }
 
   public void setPayement_credit(boolean payement_credit) {
/* 256 */     this.payement_credit = payement_credit;
   }
 
   public String getFileName() {
/* 260 */     return this.fileName;
   }
 
   public boolean isNouveauPersonnel() {
/* 264 */     return this.nouveauPersonnel;
   }
 
   public void setNouveauPersonnel(boolean nouveauPersonnel) {
/* 268 */     this.nouveauPersonnel = nouveauPersonnel;
   }
 
   public Boolean getSaisiePersonnel() {
/* 272 */     return this.saisiePersonnel;
   }
 
   public Boolean getSelectPersonnel() {
/* 276 */     return this.selectPersonnel;
   }
 
   public Boolean getShowSelector() {
/* 280 */     return this.showSelector;
   }
 
   public Routine getRoutine() {
/* 284 */     return this.routine;
   }
 
   public Magasinlot getMagasinlot() {
/* 288 */     return this.magasinlot;
   }
 
   public void setMagasinlot(Magasinlot magasinlot) {
/* 292 */     this.magasinlot = magasinlot;
   }
 
   public List<Magasinlot> getMagasinlots() {
/* 296 */     return this.magasinlots;
   }
 
   public void setMagasinlots(List<Magasinlot> magasinlots) {
/* 300 */     this.magasinlots = magasinlots;
   }
 
   public Magasinarticle getMagasinarticle() {
/* 304 */     return this.magasinarticle;
   }
 
   public void setMagasinarticle(Magasinarticle magasinarticle) {
/* 308 */     this.magasinarticle = magasinarticle;
   }
 
   public List<Magasinarticle> getMagasinarticles() {
/* 312 */     return this.magasinarticles;
   }
 
   public void setMagasinarticles(List<Magasinarticle> magasinarticles) {
/* 316 */     this.magasinarticles = magasinarticles;
   }
 
   public Magasin getMagasin() {
/* 320 */     return this.magasin;
   }
 
   public void setMagasin(Magasin magasin) {
/* 324 */     this.magasin = magasin;
   }
 
   public List<Magasin> getMagasins() {
/* 328 */     this.magasins = this.magasinFacadeLocal.findAllRange();
/* 329 */     return this.magasins;
   }
 
   public void setMagasins(List<Magasin> magasins) {
/* 333 */     this.magasins = magasins;
   }
 
   public Unite getUnite() {
/* 337 */     return this.unite;
   }
 
   public void setUnite(Unite unite) {
/* 341 */     this.unite = unite;
   }
 
   public List<Unite> getUnites() {
/* 345 */     this.unites = this.uniteFacadeLocal.findAllRange();
/* 346 */     return this.unites;
   }
 
   public void setUnites(List<Unite> unites) {
/* 350 */     this.unites = unites;
   }
 }

/* Location:           I:\GESTION_STOCK\GESTION_STOCK-war_war\WEB-INF\classes\
 * Qualified Name:     controllers.sortie_directe.AbstractSortiedirectController
 * JD-Core Version:    0.6.2
 */