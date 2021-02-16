package utils;

import entities.Lot;
import entities.Magasin;
import entities.Mouchard;
import entities.Personnel;
import entities.Projet;
import entities.Utilisateur;
import entities.Utilisateurmagasin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import sessions.MagasinFacadeLocal;
import sessions.MouchardFacadeLocal;
import sessions.ProjetFacadeLocal;
import sessions.UtilisateurmagasinFacadeLocal;

public class Utilitaires {

    private static final ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    public static final String path = servletContext.getRealPath("");
    public static final String repertoireParDefaultNotesTrim = "rapport/notes/trimestriel";
    public static final String chemin = servletContext.getContextPath();

    public static void saveOperation(MouchardFacadeLocal mouchardFacadeLocal, String action, Utilisateur utilisateur) {
        try {
            Mouchard traceur = new Mouchard();
            traceur.setIdmouchard(mouchardFacadeLocal.nextVal());
            traceur.setAction(action);
            traceur.setIdutilisateur(utilisateur);
            traceur.setDate(new Date());
            traceur.setHeure(new Date());
            mouchardFacadeLocal.create(traceur);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkPeremption(Lot lot) {
        if (!lot.getIdarticle().getPerissable()) {
            return false;
        }

        if ((new Date().after(lot.getDateperemption())) || (new Date().equals(lot.getDateperemption()))) {
            return true;
        }
        return false;
    }

    public static String getExtension(String nomFichier) {
        int taille = nomFichier.length();
        String extension = "";
        for (int i = 0; i < taille; i++) {
            if (nomFichier.charAt(i) == '.') {
                extension = "";
            } else {
                extension = extension + nomFichier.charAt(i);
            }
        }
        return extension;
    }

    public static boolean estExtensionImage(String extension) {
        if ((extension == null) || (extension.equals(""))) {
            return false;
        }
        String ext = extension.toUpperCase();
        if (ext.equals("JPG")) {
            return true;
        }
        if (ext.equals("JPEG")) {
            return true;
        }
        if (ext.equals("GIF")) {
            return true;
        }
        if (ext.equals("PNG")) {
            return true;
        }
        if (ext.equals("BMP")) {
            return true;
        }
        return false;
    }

    public static boolean estFichierImage(String nom) {
        String extension = getExtension(nom);
        if ((extension == null) || (extension.equals(""))) {
            return false;
        }
        String ext = extension.toUpperCase();
        if (ext.equals("JPG")) {
            return true;
        }
        if (ext.equals("JPEG")) {
            return true;
        }
        if (ext.equals("GIF")) {
            return true;
        }
        if (ext.equals("PNG")) {
            return true;
        }
        if (ext.equals("BMP")) {
            return true;
        }
        return false;
    }

    public static boolean handleFileUpload(FileUploadEvent event, String absoluteSavePath) {
        try {
            /* 138 */ OutputStream saveFile = new FileOutputStream(new File(absoluteSavePath));
            /* 139 */ InputStream in = event.getFile().getInputstream();
            /* 140 */ byte[] buff = new byte[8];
            int n;
            /* 142 */ while ((n = in.read(buff)) >= 0) {
                /* 143 */ saveFile.write(buff);
                /* 144 */ buff = new byte[8];
            }
        } catch (IOException ex) {
            /* 147 */ FacesMessage message = new FacesMessage("Error", "Error While uploading " + event.getFile().getFileName());
            /* 148 */ FacesContext.getCurrentInstance().addMessage(null, message);
            /* 149 */ Logger.getLogger(Utilitaires.class.getName()).log(Level.SEVERE, null, ex);
            /* 150 */ return false;
        }
        OutputStream saveFile;
        /* 152 */ return true;
    }

    public static boolean handleFileUpload(UploadedFile file, String absoluteSavePath) {
        try {
            /* 159 */ OutputStream saveFile = new FileOutputStream(new File(absoluteSavePath));
            /* 160 */ InputStream in = file.getInputstream();
            /* 161 */ byte[] buff = new byte[8];
            int n;
            /* 163 */ while ((n = in.read(buff)) >= 0) {
                /* 164 */ saveFile.write(buff);
                /* 165 */ buff = new byte[8];
            }
        } catch (IOException ex) {
            /* 168 */ FacesMessage message = new FacesMessage("Error", "Error While uploading " + file.getFileName());
            /* 169 */ FacesContext.getCurrentInstance().addMessage(null, message);
            /* 170 */ Logger.getLogger(Utilitaires.class.getName()).log(Level.SEVERE, null, ex);
            /* 171 */ return false;
        }
        OutputStream saveFile;
        /* 173 */ return true;
    }

    public static boolean CopierFichier(File Source, File Destination) {
        /* 177 */ boolean resultat = false;

        /* 179 */ FileInputStream filesource = null;
        /* 180 */ FileOutputStream fileDestination = null;
        try {
            /* 182 */ filesource = new FileInputStream(Source);
            /* 183 */ fileDestination = new FileOutputStream(Destination);
            /* 184 */ byte[] buffer = new byte[1000];
            int nblecture;
            /* 186 */ while ((nblecture = filesource.read(buffer)) != -1) {
                /* 187 */ fileDestination.write(buffer, 0, nblecture);
                /* 188 */ buffer = new byte[8];
            }
            /* 190 */ resultat = true;
        } catch (FileNotFoundException nf) {
            /* 192 */ nf.printStackTrace();
        } catch (IOException io) {
            /* 194 */ io.printStackTrace();
        } finally {
            try {
                /* 197 */ filesource.close();
            } catch (Exception e) {
                /* 199 */ e.printStackTrace();
            }
            try {
                /* 202 */ fileDestination.close();
            } catch (Exception e) {
                /* 204 */ e.printStackTrace();
            }
        }
        /* 207 */ return resultat;
    }

    public static Double arrondiNDecimales(double x, int n) {
        /* 211 */ double pow = Math.pow(10.0D, n);
        /* 212 */ return Double.valueOf(Math.floor(x * pow) / pow);
    }

    public static String formatPrenomMaj(String prenom) {
        /* 216 */ if (prenom.isEmpty()) {
            /* 217 */ return " ";
        }
        /* 219 */ char prenLettre = '0';

        /* 223 */ prenLettre = prenom.charAt(0);

        /* 225 */ String leReste = prenom.substring(1, prenom.length());

        /* 227 */ String lettre1 = String.valueOf(prenLettre);

        /* 229 */ leReste = leReste.toLowerCase();

        /* 231 */ return lettre1.toUpperCase() + leReste;
    }

    public static boolean isAccess(Long menu) {
        /* 235 */ if (SessionMBean.getAccess().isEmpty()) {
            /* 236 */ return false;
        }
        /* 238 */ if (SessionMBean.getAccess().contains(Long.valueOf(1L))) {
            /* 239 */ return true;
        }
        /* 241 */ if (SessionMBean.getAccess().contains(menu)) {
            /* 242 */ return true;
        }
        /* 244 */ return false;
    }

    public static boolean isDayClosed() {
        /* 252 */ return false;
    }

    public static void permuteDate(Date date1, Date date2) {
    }

    public static boolean checkBenefice(double prix_achat, double prix_vente) {
        /* 260 */ if (prix_vente >= prix_achat) {
            /* 261 */ return true;
        }
        /* 263 */ return false;
    }

    public static String genererCodeDemande(String code, Long nextPayement) {
        /* 268 */ if (nextPayement < 10L) /* 269 */ {
            code = code + "00000" + nextPayement.toString();
        } /* 270 */ else if ((nextPayement >= 10L) && (nextPayement < 100L)) /* 271 */ {
            code = code + "0000" + nextPayement.toString();
        } /* 272 */ else if ((nextPayement >= 100L) && (nextPayement < 1000L)) /* 273 */ {
            code = code + "000" + nextPayement.toString();
        } /* 274 */ else if ((nextPayement >= 1000L) && (nextPayement < 10000L)) /* 275 */ {
            code = code + "00" + nextPayement.toString();
        } /* 276 */ else if ((nextPayement >= 10000L) && (nextPayement < 100000L)) /* 277 */ {
            code = code + "0" + nextPayement.toString();
        } /* 278 */ else if ((nextPayement >= 100000L) && (nextPayement < 1000000L)) {
            /* 279 */ code = code + "" + nextPayement.toString();
        }
        /* 281 */ return code;
    }

    public static String genererCodeStock(String code, Long nextPayement) {
        if (nextPayement < 10L) {
            code = code + "000" + nextPayement.toString();
        } /* 287 */ else if ((nextPayement >= 10L) && (nextPayement < 100L)) {
            code = code + "00" + nextPayement.toString();
        } /* 289 */ else if ((nextPayement >= 100L) && (nextPayement < 1000L)) {
            code = code + "0" + nextPayement.toString();
        } else {
            /* 292 */ code = code + "" + nextPayement.toString();
        }
        /* 294 */ return code;
    }

    public static String genererCodeInventaire(String code, Long nextPayement) {
        /* 298 */ if (nextPayement < 10L) /* 299 */ {
            code = code + "00" + nextPayement.toString();
        } /* 300 */ else if ((nextPayement >= 10L) && (nextPayement < 100L)) /* 301 */ {
            code = code + "0" + nextPayement.toString();
        } else {
            /* 303 */ code = code + "" + nextPayement.toString();
        }
        /* 305 */ return code;
    }

    public static Integer duration(Date date1, Date date2) {
        /* 309 */ DateTime dateDebut = new DateTime("" + (date1.getYear() + 1900) + "-" + (date1.getMonth() + 1) + "-" + date1.getDate() + "");
        /* 310 */ DateTime dateFin = new DateTime("" + (date2.getYear() + 1900) + "-" + (date2.getMonth() + 1) + "-" + date2.getDate() + "");

        /* 312 */ Integer nbjr = Integer.valueOf(Days.daysBetween(dateDebut, dateFin).getDays());
        /* 313 */ return nbjr;
    }

    public static List<Lot> filterNotPeremptLot(List<Lot> lots) {
        /* 317 */ List resultat = new ArrayList();
        try {
            /* 319 */ for (Lot l : lots) {
                try {
                    /* 321 */ if (l.getDateperemption() != null) {
                        /* 322 */ if (new Date().before(l.getDateperemption())) /* 323 */ {
                            resultat.add(l);
                        }
                    } else /* 326 */ {
                        resultat.add(l);
                    }
                } catch (Exception e) {
                    /* 329 */ resultat.add(l);
                }
            }
        } catch (Exception e) {
            /* 333 */ e.printStackTrace();
        }
        /* 335 */ return resultat;
    }

    public static List<Magasin> returMagasinByUser(MagasinFacadeLocal magasinFacadeLocal, UtilisateurmagasinFacadeLocal umfl, Personnel personnel) {
        List<Magasin> magasins = magasinFacadeLocal.findAllRange();

        List<Magasin> listMagasin = new ArrayList();
        listMagasin.add(personnel.getIdmagasin());
        for (Magasin m : magasins) {

            if ((m.getCentral()) && (!listMagasin.contains(m))) {
                listMagasin.add(m);
            }
        }
        List<Utilisateurmagasin> listUtilisateurMagasin = umfl.findByIdutilisateur(SessionMBean.getUserAccount().getIdutilisateur().intValue());
        if (!listUtilisateurMagasin.isEmpty()) {
            for (Utilisateurmagasin um : listUtilisateurMagasin) {
                if (!listMagasin.contains(um.getIdmagasin())) {
                    listMagasin.add(um.getIdmagasin());
                }
            }
        }
        return listMagasin;
    }

    public static List<Projet> searchProjetctByMagasin(ProjetFacadeLocal pfl, List<Magasin> magasins) {
        List projets = new ArrayList();
        for (Magasin m : magasins) {
            if (!m.getCentral()) {
                projets.addAll(pfl.findByIdmagasin(m.getIdmagasin()));
            }
        }
        return projets;
    }
}
