 package controllers.sortie_directe;
 
 import entities.Famille;
 import entities.Lignelivraisonclient;
 import entities.Lignemvtstock;
 import entities.Livraisonclient;
 import entities.Magasin;
 import entities.Magasinarticle;
 import entities.Magasinlot;
 import entities.Mvtstock;
 import entities.Personnel;
 import entities.Unite;
 import java.io.Serializable;
 import java.util.Date;
 import java.util.List;
 import javax.annotation.PostConstruct;
 import javax.faces.bean.ManagedBean;
 import javax.faces.bean.SessionScoped;
 import org.primefaces.context.RequestContext;
 import utils.JsfUtil;
 import utils.SessionMBean;
 import utils.Utilitaires;
 
 @ManagedBean
 @SessionScoped
 public class SortiedirectController extends AbstractSortiedirectController
   implements Serializable
 {
   @PostConstruct
   private void init()
   {
/*  45 */     this.conteur = 0;
   }
 
   public void updateCalculTva() {
/*  49 */     updateTotal();
   }
 
   public void prepareCreate() {
     try {
/*  54 */       if (Utilitaires.isDayClosed()) {
/*  55 */         notifyError("journee_cloturee");
/*  56 */         return;
       }
 
/*  59 */       if (!Utilitaires.isAccess(Long.valueOf(23L))) {
/*  60 */         notifyError("acces_refuse");
/*  61 */         return;
       }
/*  63 */       RequestContext.getCurrentInstance().execute("PF('SortieDirecteCreateDialog').show()");
/*  64 */       this.mode = "Create";
/*  65 */       this.magasinarticle = new Magasinarticle();
/*  66 */       this.livraisonclient = new Livraisonclient();
/*  67 */       this.personnel = new Personnel();
/*  68 */       this.livraisonclient.setDatelivraison(new Date());
/*  69 */       this.magasin = new Magasin();
 
/*  71 */       this.livraisonclient.setMontant(Double.valueOf(0.0D));
/*  72 */       this.lignelivraisonclients.clear();
/*  73 */       this.payement_credit = false;
/*  74 */       this.mvtstock = new Mvtstock();
/*  75 */       this.total = Double.valueOf(0.0D);
/*  76 */       this.conteur = 0;
     } catch (Exception e) {
/*  78 */       this.routine.catchException(e, this.routine.localizeMessage("echec_operation"));
/*  79 */       RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
     }
   }
 
   public void prepareAddArticle() {
/*  84 */     this.famille = new Famille();
/*  85 */     this.unite = new Unite();
/*  86 */     this.magasinarticle = new Magasinarticle();
/*  87 */     this.lignelivraisonclient = new Lignelivraisonclient();
/*  88 */     this.magasinlot = new Magasinlot();
/*  89 */     if (this.conteur == 11) {
/*  90 */       this.conteur = 0;
     }
/*  92 */     this.cout_quantite = Double.valueOf(0.0D);
/*  93 */     RequestContext.getCurrentInstance().execute("PF('ArticleCreateDialog').show()");
/*  94 */     if (this.conteur == 0) {
/*  95 */       this.magasinarticles = this.magasinarticleFacadeLocal.findByIdmagasin(this.magasin.getIdmagasin().intValue(), true);
/*  96 */       return;
/*  97 */     }if ((this.conteur > 0) && (this.conteur <= 10)) {
/*  98 */       return;
     }
/* 100 */     this.magasinarticles = this.magasinarticleFacadeLocal.findByIdmagasin(this.magasin.getIdmagasin().intValue(), true);
   }
 
   public void prepareEdit()
   {
     try
     {
/* 107 */       if (this.livraisonclient.getLivraisondirecte().booleanValue())
       {
/* 109 */         if (Utilitaires.isDayClosed()) {
/* 110 */           notifyError("journee_cloturee");
/* 111 */           return;
         }
 
/* 114 */         if (!Utilitaires.isAccess(Long.valueOf(24L))) {
/* 115 */           notifyError("acces_refuse");
/* 116 */           this.livraisonclient = null;
/* 117 */           return;
         }
 
/* 120 */         this.mode = "Edit";
/* 121 */         this.showSelector = Boolean.valueOf(false);
 
/* 123 */         if (this.livraisonclient != null) {
/* 124 */           this.lignelivraisonclients = this.lignelivraisonclientFacadeLocal.findByIdlivraisonclient(this.livraisonclient.getIdlivraisonclient().longValue());
/* 125 */           this.personnel = this.livraisonclient.getIdpersonnel();
/* 126 */           this.total = this.livraisonclient.getMontant();
/* 127 */           this.mvtstock = this.livraisonclient.getIdmvtstock();
/* 128 */           this.magasin = this.livraisonclient.getIdmagasin();
         }
/* 130 */         RequestContext.getCurrentInstance().execute("PF('SortieDirecteCreateDialog').show()");
       }
       else {
/* 133 */         notifyError("vente_effectuee_par_lignelivraisonclient");
       }
     } catch (Exception e) {
/* 136 */       notifyError("echec_operation");
     }
   }
 
   public void prepareview() {
     try {
/* 142 */       if (this.livraisonclient != null) {
/* 143 */         this.lignelivraisonclients = this.lignelivraisonclientFacadeLocal.findByIdlivraisonclient(this.livraisonclient.getIdlivraisonclient().longValue());
/* 144 */         if (!this.lignelivraisonclients.isEmpty()) {
/* 145 */           RequestContext.getCurrentInstance().execute("PF('SortieDirecteDetailDialog').show()");
/* 146 */           return;
         }
/* 148 */         notifyError("liste_article_vide");
       }
       else {
/* 151 */         notifyError("not_row_selected");
       }
     } catch (Exception e) {
/* 154 */       notifyError("echec_operation");
     }
   }
 
   public void filterArticle() {
     try {
/* 160 */       this.magasinarticles.clear();
/* 161 */       this.magasinlots.clear();
/* 162 */       this.magasinarticle = new Magasinarticle();
/* 163 */       this.magasinlot = new Magasinlot();
/* 164 */       this.lignelivraisonclient = new Lignelivraisonclient();
/* 165 */       if (this.famille.getIdfamille() != null)
/* 166 */         this.magasinarticles = this.magasinarticleFacadeLocal.findByIdmagasinIdfamille(this.magasin.getIdmagasin().intValue(), this.famille.getIdfamille().longValue(), true);
     }
     catch (Exception e) {
/* 169 */       e.printStackTrace();
     }
   }
 
   public void create()
   {
     try
     {
       String message;
/* 175 */       if ("Create".equals(this.mode))
       {
/* 177 */         if (!this.lignelivraisonclients.isEmpty())
         {
/* 179 */           message = "";
 
/* 181 */           updateTotal();
 
/* 183 */           this.ut.begin();
 
/* 185 */           this.personnel = this.personnelFacadeLocal.find(this.personnel.getIdpersonnel());
/* 186 */           this.magasin = this.magasinFacadeLocal.find(this.magasin.getIdmagasin());
 
/* 188 */           Long nextMvt = this.mvtstockFacadeLocal.nextVal();
/* 189 */           String codeMvt = "MVT";
/* 190 */           codeMvt = Utilitaires.genererCodeStock(codeMvt, nextMvt);
 
/* 192 */           this.mvtstock.setCode(codeMvt);
/* 193 */           this.mvtstock.setIdmvtstock(nextMvt);
/* 194 */           this.mvtstock.setDatemvt(this.livraisonclient.getDatelivraison());
/* 195 */           this.mvtstock.setType("-");
/* 196 */           this.mvtstock.setClient("-");
/* 197 */           this.mvtstock.setFournisseur("-");
/* 198 */           this.mvtstock.setMagasin("-");
/* 199 */           this.mvtstockFacadeLocal.create(this.mvtstock);
 
/* 201 */           String code = "F";
/* 202 */           Long nextPayement = this.livraisonclientFacadeLocal.nextVal();
/* 203 */           code = Utilitaires.genererCodeStock(code, nextPayement);
 
/* 205 */           this.livraisonclient.setCode(code);
/* 206 */           this.livraisonclient.setIdlivraisonclient(nextPayement);
/* 207 */           this.livraisonclient.setIdpersonnel(this.personnel);
/* 208 */           this.livraisonclient.setIdmagasin(this.magasin);
/* 209 */           this.livraisonclient.setMontant(this.total);
/* 210 */           this.livraisonclient.setLivraisondirecte(Boolean.valueOf(true));
 
/* 212 */           this.livraisonclient.setIdmvtstock(this.mvtstock);
/* 213 */           this.livraisonclientFacadeLocal.create(this.livraisonclient);
 
/* 215 */           for (Lignelivraisonclient c : this.lignelivraisonclients) {
/* 216 */             c.setIdlignelivraisonclient(this.lignelivraisonclientFacadeLocal.nextVal());
/* 217 */             c.setIdlivraisonclient(this.livraisonclient);
/* 218 */             c.setQuantitemultiple(Double.valueOf(c.getQuantite().doubleValue() * c.getUnite().doubleValue()));
/* 219 */             this.lignelivraisonclientFacadeLocal.create(c);
 
/* 221 */             c.setIdmagasinlot(this.magasinlotFacadeLocal.find(c.getIdmagasinlot().getIdmagasinlot()));
/* 222 */             c.getIdmagasinlot().setQuantite(Double.valueOf(c.getIdmagasinlot().getQuantite().doubleValue() - c.getQuantite().doubleValue()));
/* 223 */             c.getIdmagasinlot().setQuantitemultiple(Double.valueOf(c.getIdmagasinlot().getQuantitemultiple().doubleValue() - c.getQuantitemultiple().doubleValue()));
/* 224 */             c.getIdmagasinlot().setQuantitereduite(Double.valueOf(c.getIdmagasinlot().getQuantitereduite().doubleValue() - c.getQuantitereduite().doubleValue()));
/* 225 */             this.magasinlotFacadeLocal.edit(c.getIdmagasinlot());
 
/* 227 */             c.getIdmagasinlot().setIdmagasinarticle(this.magasinarticleFacadeLocal.find(c.getIdmagasinlot().getIdmagasinarticle().getIdmagasinarticle()));
/* 228 */             c.getIdmagasinlot().getIdmagasinarticle().setQuantite(Double.valueOf(c.getIdmagasinlot().getIdmagasinarticle().getQuantite().doubleValue() - c.getQuantite().doubleValue()));
/* 229 */             c.getIdmagasinlot().getIdmagasinarticle().setQuantitemultiple(Double.valueOf(c.getIdmagasinlot().getIdmagasinarticle().getQuantitemultiple().doubleValue() - c.getQuantitemultiple().doubleValue()));
/* 230 */             c.getIdmagasinlot().getIdmagasinarticle().setQuantitereduite(Double.valueOf(c.getIdmagasinlot().getIdmagasinarticle().getQuantitereduite().doubleValue() - c.getQuantitereduite().doubleValue()));
/* 231 */             this.magasinarticleFacadeLocal.edit(c.getIdmagasinlot().getIdmagasinarticle());
 
/* 233 */             Lignemvtstock lmvts = new Lignemvtstock();
/* 234 */             lmvts.setIdlignemvtstock(this.ligneMvtstockFacadeLocal.nextVal());
/* 235 */             lmvts.setIdmvtstock(this.mvtstock);
/* 236 */             lmvts.setIdlot(c.getIdmagasinlot().getIdlot());
 
/* 238 */             lmvts.setQteentree(Double.valueOf(0.0D));
/* 239 */             lmvts.setQtesortie(c.getQuantitemultiple());
/* 240 */             lmvts.setReste(c.getIdmagasinlot().getQuantitemultiple());
 
/* 242 */             lmvts.setType("SORTIE");
/* 243 */             lmvts.setClient(this.personnel.getNom() + " " + this.personnel.getPrenom());
/* 244 */             lmvts.setFournisseur(this.magasin.getNom());
/* 245 */             lmvts.setMagasin(this.magasin.getNom());
/* 246 */             this.ligneMvtstockFacadeLocal.create(lmvts);
           }
 
/* 249 */           Utilitaires.saveOperation(this.mouchardFacadeLocal, "Enregistrement de la sortie  : " + code, SessionMBean.getUserAccount());
 
/* 251 */           this.ut.commit();
/* 252 */           this.livraisonclient = null;
/* 253 */           this.supprimer = (this.modifier = this.imprimer = Boolean.valueOf(true));
/* 254 */           JsfUtil.addSuccessMessage(message);
 
/* 256 */           notifySuccess();
/* 257 */           RequestContext.getCurrentInstance().execute("PF('SortieDirecteCreateDialog').hide()");
         } else {
/* 259 */           notifyError("liste_article_vide");
         }
       }
/* 262 */       else if (this.livraisonclient != null)
       {
/* 264 */         calculTotal();
/* 265 */         this.ut.begin();
 
/* 267 */         this.personnel = this.personnelFacadeLocal.find(this.personnel.getIdpersonnel());
/* 268 */         this.livraisonclient.setIdpersonnel(this.personnel);
/* 269 */         this.livraisonclientFacadeLocal.edit(this.livraisonclient);
 
/* 271 */         if (!this.lignelivraisonclients.isEmpty()) {
/* 272 */           for (Lignelivraisonclient llc : this.lignelivraisonclients) {
/* 273 */             if (llc.getIdlignelivraisonclient().longValue() != 0L) {
/* 274 */               Lignelivraisonclient cc = this.lignelivraisonclientFacadeLocal.find(llc.getIdlignelivraisonclient());
/* 275 */               if (llc.getQuantite() != cc.getQuantite())
               {
/* 277 */                 Magasinarticle pro = this.magasinarticleFacadeLocal.find(cc.getIdmagasinlot().getIdmagasinarticle().getIdmagasinarticle());
/* 278 */                 pro.setQuantite(Double.valueOf(pro.getQuantite().doubleValue() + cc.getQuantite().doubleValue() - llc.getQuantite().doubleValue()));
/* 279 */                 pro.setQuantitemultiple(Double.valueOf(pro.getQuantitemultiple().doubleValue() + cc.getQuantitemultiple().doubleValue() - llc.getQuantitemultiple().doubleValue()));
/* 280 */                 pro.setQuantitereduite(Double.valueOf(pro.getQuantitereduite().doubleValue() + cc.getQuantitereduite().doubleValue() - llc.getQuantitereduite().doubleValue()));
/* 281 */                 this.magasinarticleFacadeLocal.edit(pro);
 
/* 283 */                 Magasinlot l = this.magasinlotFacadeLocal.find(cc.getIdmagasinlot().getIdmagasinlot());
/* 284 */                 l.setQuantite(Double.valueOf(l.getQuantite().doubleValue() + cc.getQuantite().doubleValue() - llc.getQuantite().doubleValue()));
/* 285 */                 l.setQuantitemultiple(Double.valueOf(l.getQuantitemultiple().doubleValue() + cc.getQuantitemultiple().doubleValue() - llc.getQuantitemultiple().doubleValue()));
/* 286 */                 l.setQuantitereduite(Double.valueOf(l.getQuantitereduite().doubleValue() + cc.getQuantitereduite().doubleValue() - llc.getQuantitereduite().doubleValue()));
/* 287 */                 this.magasinlotFacadeLocal.edit(l);
 
/* 289 */                 Lignemvtstock lmvts = new Lignemvtstock();
/* 290 */                 lmvts.setIdlignemvtstock(this.ligneMvtstockFacadeLocal.nextVal());
/* 291 */                 lmvts.setIdmvtstock(this.mvtstock);
/* 292 */                 lmvts.setIdlot(llc.getIdmagasinlot().getIdlot());
/* 293 */                 lmvts.setIdmagasinlot(llc.getIdmagasinlot());
 
/* 295 */                 lmvts.setClient(this.personnel.getNom() + " " + this.personnel.getPrenom());
/* 296 */                 lmvts.setFournisseur(this.magasin.getNom());
/* 297 */                 lmvts.setMagasin(this.magasin.getNom());
 
/* 299 */                 if (llc.getQuantitemultiple().doubleValue() > cc.getQuantitemultiple().doubleValue()) {
/* 300 */                   lmvts.setQteentree(Double.valueOf(0.0D));
/* 301 */                   lmvts.setQtesortie(Double.valueOf(llc.getQuantitemultiple().doubleValue() - cc.getQuantitemultiple().doubleValue()));
/* 302 */                   lmvts.setReste(llc.getIdmagasinlot().getQuantitemultiple());
/* 303 */                   lmvts.setType("SORTIE");
                 } else {
/* 305 */                   lmvts.setQteentree(Double.valueOf(cc.getQuantitemultiple().doubleValue() - llc.getQuantitemultiple().doubleValue()));
/* 306 */                   lmvts.setQtesortie(Double.valueOf(0.0D));
/* 307 */                   lmvts.setReste(llc.getIdmagasinlot().getQuantitemultiple());
/* 308 */                   lmvts.setType("ENTREE");
                 }
/* 310 */                 this.ligneMvtstockFacadeLocal.create(lmvts);
               }
/* 312 */               this.lignelivraisonclientFacadeLocal.edit(llc);
             } else {
/* 314 */               llc.setIdlignelivraisonclient(this.lignelivraisonclientFacadeLocal.nextVal());
/* 315 */               llc.setIdlivraisonclient(this.livraisonclient);
/* 316 */               this.lignelivraisonclientFacadeLocal.create(llc);
/* 317 */               llc.getIdmagasinlot().setIdmagasinarticle(this.magasinarticleFacadeLocal.find(llc.getIdmagasinlot().getIdmagasinarticle().getIdmagasinarticle()));
/* 318 */               llc.getIdmagasinlot().getIdmagasinarticle().setQuantite(Double.valueOf(llc.getIdmagasinlot().getIdmagasinarticle().getQuantite().doubleValue() - llc.getQuantite().doubleValue()));
/* 319 */               this.magasinarticleFacadeLocal.edit(llc.getIdmagasinlot().getIdmagasinarticle());
 
/* 321 */               Magasinlot l = this.magasinlotFacadeLocal.find(llc.getIdmagasinlot().getIdmagasinlot());
/* 322 */               l.setQuantite(Double.valueOf(l.getQuantite().doubleValue() - llc.getQuantite().doubleValue()));
/* 323 */               this.magasinlotFacadeLocal.edit(l);
 
/* 325 */               Lignemvtstock lmvts = new Lignemvtstock();
/* 326 */               lmvts.setIdlignemvtstock(this.ligneMvtstockFacadeLocal.nextVal());
/* 327 */               lmvts.setIdmvtstock(this.mvtstock);
/* 328 */               lmvts.setIdlot(llc.getIdmagasinlot().getIdlot());
/* 329 */               lmvts.setIdmagasinlot(llc.getIdmagasinlot());
 
/* 331 */               lmvts.setQteentree(Double.valueOf(0.0D));
/* 332 */               lmvts.setQtesortie(llc.getQuantitemultiple());
/* 333 */               lmvts.setReste(llc.getIdmagasinlot().getQuantitemultiple());
 
/* 335 */               lmvts.setClient(this.personnel.getNom() + " " + this.personnel.getPrenom());
/* 336 */               lmvts.setFournisseur(this.magasin.getNom());
/* 337 */               lmvts.setMagasin(this.magasin.getNom());
 
/* 339 */               this.ligneMvtstockFacadeLocal.create(lmvts);
             }
           }
         }
 
/* 344 */         this.ut.commit();
/* 345 */         this.livraisonclient = null;
/* 346 */         this.supprimer = (this.modifier = this.imprimer = Boolean.valueOf(true));
 
/* 348 */         notifySuccess();
/* 349 */         RequestContext.getCurrentInstance().execute("PF('SortieDirecteCreateDialog').hide()");
       } else {
/* 351 */         notifyError("not_row_selected");
       }
     }
     catch (Exception e) {
/* 355 */       notifyFail(e);
     }
   }
 
   public void delete() {
     try {
/* 361 */       if (this.livraisonclient != null)
       {
/* 363 */         if (this.livraisonclient.getLivraisondirecte().booleanValue())
         {
/* 365 */           if (!Utilitaires.isAccess(Long.valueOf(25L))) {
/* 366 */             notifyError("acces_refuse");
/* 367 */             this.supprimer = (this.modifier = this.imprimer = Boolean.valueOf(true));
/* 368 */             this.livraisonclient = null;
/* 369 */             return;
           }
 
/* 372 */           this.ut.begin();
 
/* 374 */           List<Lignelivraisonclient> temp = this.lignelivraisonclientFacadeLocal.findByIdlivraisonclient(this.livraisonclient.getIdlivraisonclient().longValue());
/* 375 */           if (!temp.isEmpty()) {
/* 376 */             for (Lignelivraisonclient c : temp)
             {
/* 378 */               c.getIdmagasinlot().setIdmagasinarticle(this.magasinarticleFacadeLocal.find(this.magasinarticleFacadeLocal.find(c.getIdmagasinlot().getIdmagasinarticle().getIdmagasinarticle())));
/* 379 */               c.getIdmagasinlot().getIdmagasinarticle().setQuantite(Double.valueOf(c.getIdmagasinlot().getIdmagasinarticle().getQuantite().doubleValue() + c.getQuantite().doubleValue()));
/* 380 */               c.getIdmagasinlot().getIdmagasinarticle().setQuantitemultiple(Double.valueOf(c.getIdmagasinlot().getIdmagasinarticle().getQuantitemultiple().doubleValue() - c.getQuantitemultiple().doubleValue()));
/* 381 */               c.getIdmagasinlot().getIdmagasinarticle().setQuantitereduite(Double.valueOf(c.getIdmagasinlot().getIdmagasinarticle().getQuantitereduite().doubleValue() - c.getQuantitereduite().doubleValue()));
/* 382 */               this.magasinarticleFacadeLocal.edit(c.getIdmagasinlot().getIdmagasinarticle());
 
/* 384 */               c.setIdmagasinlot(this.magasinlotFacadeLocal.find(c.getIdmagasinlot().getIdmagasinlot()));
/* 385 */               c.getIdmagasinlot().setQuantite(Double.valueOf(c.getIdmagasinlot().getQuantite().doubleValue() + c.getQuantite().doubleValue()));
/* 386 */               c.getIdmagasinlot().setQuantitereduite(Double.valueOf(c.getIdmagasinlot().getQuantitereduite().doubleValue() + c.getQuantitereduite().doubleValue()));
/* 387 */               c.getIdmagasinlot().setQuantitemultiple(Double.valueOf(c.getIdmagasinlot().getQuantitemultiple().doubleValue() + c.getQuantitemultiple().doubleValue()));
/* 388 */               this.magasinlotFacadeLocal.edit(c.getIdmagasinlot());
 
/* 390 */               this.lignelivraisonclientFacadeLocal.remove(c);
             }
           }
/* 393 */           this.livraisonclientFacadeLocal.remove(this.livraisonclient);
 
/* 395 */           Mvtstock mTemp = this.livraisonclient.getIdmvtstock();
 
/* 397 */           List<Lignemvtstock> lmvt = this.ligneMvtstockFacadeLocal.findByIdmvt(mTemp.getIdmvtstock().longValue());
/* 398 */           for (Lignemvtstock l : lmvt) {
/* 399 */             this.ligneMvtstockFacadeLocal.remove(l);
           }
/* 401 */           this.mvtstockFacadeLocal.remove(mTemp);
 
/* 403 */           this.ut.commit();
/* 404 */           Utilitaires.saveOperation(this.mouchardFacadeLocal, "Annulation de la sortie : " + this.livraisonclient.getCode() + " Montant : " + this.livraisonclient.getMontant() + " Personnel : " + this.livraisonclient.getIdpersonnel().getNom(), SessionMBean.getUserAccount());
/* 405 */           this.livraisonclient = null;
/* 406 */           this.supprimer = (this.modifier = this.imprimer = Boolean.valueOf(true));
/* 407 */           notifySuccess();
         }
         else {
/* 410 */           notifyError("vente_effectuee_par_lignelivraisonclient");
         }
       }
/* 413 */       else notifyError("not_row_selected"); 
     }
     catch (Exception e)
     {
/* 416 */       notifyFail(e);
     }
   }
 
   public void initPrinter(Livraisonclient l) {
/* 421 */     this.livraisonclient = l;
/* 422 */     print();
   }
 
   public void initEdit(Livraisonclient l) {
/* 426 */     this.livraisonclient = l;
/* 427 */     prepareEdit();
   }
 
   public void initView(Livraisonclient l) {
/* 431 */     this.livraisonclient = l;
/* 432 */     prepareview();
   }
 
   public void initDelete(Livraisonclient l) {
/* 436 */     this.livraisonclient = l;
/* 437 */     delete();
   }
 
   public void print() {
     try {
/* 442 */       if (!Utilitaires.isAccess(Long.valueOf(26L))) {
/* 443 */         notifyError("acces_refuse");
/* 444 */         this.livraisonclient = null;
/* 445 */         return;
       }
 
/* 448 */       if (this.livraisonclient != null) {
/* 449 */         List c = this.lignelivraisonclientFacadeLocal.findByIdlivraisonclient(this.livraisonclient.getIdlivraisonclient().longValue());
/* 450 */         this.livraisonclient.setLignelivraisonclientList(c);
 
/* 452 */         RequestContext.getCurrentInstance().execute("PF('SortieDirecteImprimerDialog').show()");
       } else {
/* 454 */         notifyError("not_row_selected");
       }
     } catch (Exception e) {
/* 457 */       notifyFail(e);
     }
   }
 
   public void addArticle()
   {
     try {
/* 464 */       if (this.magasinlot == null) {
/* 465 */         JsfUtil.addErrorMessage(this.routine.localizeMessage("article_invalide"));
/* 466 */         return;
       }
 
/* 469 */       Lignelivraisonclient llc = this.lignelivraisonclient;
 
/* 471 */       llc.setIdlignelivraisonclient(Long.valueOf(0L));
 
/* 473 */       this.magasinarticle = this.magasinarticleFacadeLocal.find(this.magasinarticle.getIdmagasinarticle());
/* 474 */       this.magasinlot = this.magasinlotFacadeLocal.find(this.magasinlot.getIdmagasinlot());
 
/* 476 */       double q = 0.0D;
/* 477 */       for (Lignelivraisonclient c1 : this.lignelivraisonclients) {
/* 478 */         if (c1.getIdmagasinlot().equals(this.magasinlot)) {
/* 479 */           q += c1.getQuantitemultiple().doubleValue();
         }
       }
 
/* 483 */       if (llc.getQuantitemultiple().doubleValue() + q > this.magasinlot.getQuantitemultiple().doubleValue()) {
/* 484 */         JsfUtil.addErrorMessage(this.routine.localizeMessage("quantite_debordee"));
/* 485 */         return;
       }
 
/* 488 */       Unite u = this.unite;
/* 489 */       llc.setIdunite(u);
/* 490 */       llc.setIdmagasinlot(this.magasinlot);
/* 491 */       this.lignelivraisonclients.add(llc);
 
/* 493 */       RequestContext.getCurrentInstance().execute("PF('ArticleCreateDialog').hide()");
/* 494 */       JsfUtil.addSuccessMessage(this.routine.localizeMessage("operation_reussie"));
 
/* 496 */       updateTotal();
/* 497 */       this.conteur += 1;
 
/* 499 */       this.lignelivraisonclient = null;
/* 500 */       this.magasinarticle = null;
     } catch (Exception e) {
/* 502 */       e.printStackTrace();
/* 503 */       this.routine.feedBack("information", "/resources/tool_images/error.png", this.routine.localizeMessage("formulaire_incomplet"));
/* 504 */       RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
     }
   }
 
   public void removeArticle(int index) {
     try {
/* 510 */       boolean trouve = false;
/* 511 */       this.ut.begin();
 
/* 513 */       Lignelivraisonclient c1 = (Lignelivraisonclient)this.lignelivraisonclients.get(index);
/* 514 */       if (c1.getIdlignelivraisonclient().longValue() != 0L) {
/* 515 */         trouve = true;
/* 516 */         this.lignelivraisonclientFacadeLocal.remove(c1);
/* 517 */         Utilitaires.saveOperation(this.mouchardFacadeLocal, "Suppression de l'article : " + c1.getIdmagasinlot().getIdmagasinarticle().getIdarticle().getLibelle() + " quantité : " + c1.getQuantite() + " dans la sortie : " + this.livraisonclient.getCode(), SessionMBean.getUserAccount());
 
/* 519 */         Magasinarticle pro = this.magasinarticleFacadeLocal.find(c1.getIdmagasinlot().getIdmagasinarticle().getIdmagasinarticle());
/* 520 */         pro.setQuantite(Double.valueOf(pro.getQuantite().doubleValue() + c1.getQuantite().doubleValue()));
/* 521 */         this.magasinarticleFacadeLocal.edit(pro);
       }
/* 523 */       this.lignelivraisonclients.remove(index);
 
/* 525 */       updateTotal();
/* 526 */       if (trouve) {
/* 527 */         this.livraisonclientFacadeLocal.edit(this.livraisonclient);
       }
/* 529 */       this.ut.commit();
/* 530 */       JsfUtil.addSuccessMessage("Supprimé");
     } catch (Exception e) {
/* 532 */       e.printStackTrace();
/* 533 */       JsfUtil.addErrorMessage(this.routine.localizeMessage("echec_operation"));
     }
   }
 
   public Double calculTotal() {
/* 538 */     Double resultat = Double.valueOf(0.0D);
/* 539 */     int i = 0;
/* 540 */     for (Lignelivraisonclient llc : this.lignelivraisonclients) {
/* 541 */       resultat = Double.valueOf(resultat.doubleValue() + llc.getMontant().doubleValue() * llc.getQuantite().doubleValue());
/* 542 */       ((Lignelivraisonclient)this.lignelivraisonclients.get(i)).setQuantitemultiple(Double.valueOf(llc.getUnite().doubleValue() * llc.getQuantite().doubleValue()));
/* 543 */       ((Lignelivraisonclient)this.lignelivraisonclients.get(i)).setQuantitereduite(Double.valueOf(((Lignelivraisonclient)this.lignelivraisonclients.get(i)).getQuantitemultiple().doubleValue() / llc.getIdmagasinlot().getIdlot().getIdarticle().getUnite().doubleValue()));
     }
/* 545 */     return resultat;
   }
 
   public void updateTotal() {
     try {
/* 550 */       this.total = calculTotal();
/* 551 */       this.livraisonclient.setMontant(this.total);
     } catch (Exception e) {
/* 553 */       e.printStackTrace();
     }
   }
 
   public void updateTotaux() {
     try {
/* 559 */       this.cout_quantite = Double.valueOf(0.0D);
/* 560 */       if ((this.lignelivraisonclient.getQuantite() != null) && 
/* 561 */         (this.lignelivraisonclient.getMontant() != null)) {
/* 562 */         if (this.lignelivraisonclient.getUnite() != null) {
/* 563 */           this.lignelivraisonclient.setQuantitemultiple(Double.valueOf(this.lignelivraisonclient.getUnite().doubleValue() * this.lignelivraisonclient.getQuantite().doubleValue()));
/* 564 */           this.lignelivraisonclient.setQuantitereduite(Double.valueOf(this.lignelivraisonclient.getQuantitemultiple().doubleValue() / this.magasinarticle.getIdarticle().getUnite().doubleValue()));
         }
/* 566 */         this.cout_quantite = Double.valueOf(this.lignelivraisonclient.getMontant().doubleValue() * this.lignelivraisonclient.getQuantite().doubleValue());
       }
     }
     catch (Exception e) {
/* 570 */       e.printStackTrace();
/* 571 */       this.cout_quantite = Double.valueOf(0.0D);
     }
   }
 
   public void updatedata() {
     try {
/* 577 */       if (this.magasinarticle != null) {
/* 578 */         this.magasinlot = new Magasinlot();
/* 579 */         this.famille = this.magasinarticle.getIdarticle().getIdfamille();
 
/* 581 */         this.lignelivraisonclient.setMontant(this.magasinarticle.getIdarticle().getPrixunit());
/* 582 */         this.lignelivraisonclient.setUnite(this.magasinarticle.getIdarticle().getUnite());
/* 583 */         this.unite = this.magasinarticle.getIdarticle().getIdunite();
 
/* 585 */         this.magasinlots = this.magasinlotFacadeLocal.findByArticleIsavailable(this.magasin.getIdmagasin().intValue(), this.magasinarticle.getIdarticle().getIdarticle().longValue(), this.magasinarticle.getIdarticle().getPerissable().booleanValue(), new Date());
 
/* 587 */         if (this.magasinlots.size() == 0) {
/* 588 */           this.magasinlot = null;
/* 589 */           return;
         }
/* 591 */         if (this.magasinlots.size() == 1) {
/* 592 */           this.magasinlot = ((Magasinlot)this.magasinlots.get(0));
/* 593 */           this.lignelivraisonclient.setMontant(this.magasinlot.getIdlot().getPrixunitaire());
/* 594 */           this.lignelivraisonclient.setUnite(this.magasinlot.getIdlot().getIdarticle().getUnite());
/* 595 */           return;
         }
       }
     }
     catch (Exception e) {
/* 600 */       e.printStackTrace();
     }
   }
 
   public void updatedataLot() {
     try {
/* 606 */       if (this.magasinlot != null) {
/* 607 */         this.lignelivraisonclient.setMontant(this.magasinlot.getIdlot().getPrixunitaire());
/* 608 */         this.lignelivraisonclient.setUnite(this.magasinlot.getIdlot().getIdarticle().getUnite());
       }
     } catch (Exception e) {
/* 611 */       e.printStackTrace();
     }
   }
 
   public void notifyError(String message) {
/* 616 */     this.routine.feedBack("avertissement", "/resources/tool_images/warning.jpeg", this.routine.localizeMessage(message));
/* 617 */     RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
   }
 
   public void notifySuccess() {
/* 621 */     RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
/* 622 */     this.routine.feedBack("information", "/resources/tool_images/success.png", this.routine.localizeMessage("operation_reussie"));
/* 623 */     RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
   }
 
   public void notifyFail(Exception e) {
/* 627 */     RequestContext.getCurrentInstance().execute("PF('AjaxNotifyDialog').hide()");
/* 628 */     this.routine.catchException(e, this.routine.localizeMessage("echec_operation"));
/* 629 */     RequestContext.getCurrentInstance().execute("PF('NotifyDialog1').show()");
   }
 }

