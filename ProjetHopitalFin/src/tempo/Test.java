/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempo;

import java.sql.SQLException;
import vue.Fenetre;
import tempo.Connexion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vue.BDDinsertion;
import vue.BDDinteractionDOCTEUR;
import vue.BDDinteractionINFIRMIER;
import vue.BDDinteractionMALADES;
import vue.BDDmodification;
import vue.FenConnexion;

/**
 *
 * @author adrie
 */
public class Test {

    public static Connexion c1;

    //toutes les fenetres que l'ont peut ouvrir
    public static BDDinteractionDOCTEUR fenBDDdocteur;
    public static BDDinteractionINFIRMIER fenBDDinfirmier;
    public static BDDinteractionMALADES fenBDDmalades;
    public static BDDmodification fenBDDmodif;
    public static BDDinsertion fenBDDinser;
    public Fenetre fen;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//      Fenetre fen = new Fenetre("Fenetre de gestion de l'hopital");
        FenConnexion fenc = new FenConnexion();
        Test t1 = new Test("hopital", "root", "");
        ExecuteMaladeAd("", "", "", "301");
//        ArrayList<String> prout = new ArrayList<>();
//        //nom de la liste
//        prout.add("service");
//
//        
//        //les anciennes valeurs
//        prout.add("REA");
//        prout.add("Reanimation et Traumatologie");
//        prout.add("A");
//        prout.add("19");
//        //les nouvelles valeurs
//        prout.add("JCG");
//        prout.add("Machintruc");
//        prout.add("B");
//        prout.add("5");
//        
//
//   
//
//        modification(prout);       
//        //FENETRES
//        //fenBDDdocteur = new BDDinteractionDOCTEUR(c1);
//        //fenBDDinfirmier = new BDDinteractionINFIRMIER(c1);
//        //fenBDDmalades = new BDDinteractionMALADES(c1); 
//        //fenBDDmodif = new BDDmodification(c1);
//        //System.out.println(ExecuteDocteur("Safin","Marat", "Traumatologue", "19"));
    }

    public Test(String database, String login, String password) throws SQLException, ClassNotFoundException {
        c1 = new Connexion(database, login, password);
    }

    public Test(String usernameECE, String passwordECE, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        c1 = new Connexion(usernameECE, passwordECE, loginDatabase, passwordDatabase);
    }



    public static void modification(ArrayList<String> arr) {

        String req = "";

        if ("docteur".equals(arr.get(0))) {
            req = "UPDATE docteur SET numero=" + arr.get(1) + ", specialite=\"" + arr.get(2) + "\" WHERE numero=" + arr.get(3) + " AND specialite=\"" + arr.get(4) + "\"";
        }

        if ("malade".equals(arr.get(0))) {
            req = "UPDATE malade SET numero=" + arr.get(1) + ", nom=\"" + arr.get(2) + "\", prenom=\"" + arr.get(3) + "\", adresse=\"" + arr.get(4) + "\", tel=\"" + arr.get(5) + "\", mutuelle=\"" + arr.get(6)
                    + "\" WHERE numero=" + arr.get(7) + " AND nom=\"" + arr.get(8) + "\" AND prenom=\"" + arr.get(9) + "\" AND adresse=\"" + arr.get(10) + "\" AND tel=\"" + arr.get(11) + "\" AND mutuelle=\"" + arr.get(12) + "\"";
        }

        if ("chambre".equals(arr.get(0))) {
            req = "UPDATE chambre SET code_service=\"" + arr.get(1) + "\",no_chambre=" + arr.get(2) + ", surveillant=" + arr.get(3) + ", nb_lits=" + arr.get(4)
                    + " WHERE code_service=\"" + arr.get(5) + "\" AND no_chambre=" + arr.get(6) + " AND surveillant=" + arr.get(7) + " AND nb_lits=" + arr.get(8) + "";
        }

        if ("employe".equals(arr.get(0))) {
            req = "UPDATE employe SET numero=" + arr.get(1) + ",nom=\"" + arr.get(2) + "\",prenom=\"" + arr.get(3) + "\",adresse=\"" + arr.get(4) + "\",tel=\"" + arr.get(5)
                    + "\" WHERE numero=" + arr.get(6) + " AND nom=\"" + arr.get(7) + "\" AND prenom=\"" + arr.get(8) + "\"AND adresse=\"" + arr.get(9) + "\" AND tel=\"" + arr.get(10) + "\"";
        }

        if ("hospitalisation".equals(arr.get(0))) {
            req = "UPDATE hospitalisation SET no_malade=" + arr.get(1) + ",code_service=\"" + arr.get(2) + "\",no_chambre=" + arr.get(3) + ",lit=" + arr.get(4)
                    + " WHERE no_malade=" + arr.get(5) + " AND code_service=\"" + arr.get(6) + "\" AND no_chambre=" + arr.get(7) + " AND lit=" + arr.get(8) + "";
        }

        if ("infirmier".equals(arr.get(0))) {
            req = "UPDATE infirmier SET numero=" + arr.get(1) + ",code_service=\"" + arr.get(2) + "\",rotation=\"" + arr.get(3) + "\",salaire=" + arr.get(4)
                    + " WHERE numero=" + arr.get(5) + " AND code_service=\"" + arr.get(6) + "\" AND rotation=\"" + arr.get(7) + "\" AND salaire=" + arr.get(8) + "";

        }

        if ("service".equals(arr.get(0))) {
            req = "UPDATE service SET code=\"" + arr.get(1) + "\",nom=\"" + arr.get(2) + "\",batiment=\"" + arr.get(3) + "\",directeur=" + arr.get(4)
                    + " WHERE code=\"" + arr.get(5) + "\" AND nom=\"" + arr.get(6) + "\" AND batiment=\"" + arr.get(7) + "\" AND directeur=" + arr.get(8) + "";
        }

        if ("soigne".equals(arr.get(0))) {
            req = "UPDATE soigne SET no_docteur=" + arr.get(1) + ",no_malade=" + arr.get(2) + " WHERE  no_docteur=" + arr.get(3) + " AND no_malade=" + arr.get(4) + "";
        }
        try {
            c1.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void insertion(int u,ArrayList<String> arr)
    {
        String tabnom=arr.get(0);
        String nomchamps="(";
        String valeurs="(";
        for(int j=1;j<=u;j++)
        {
            nomchamps+=arr.get(j);
            if(j!=u)
                nomchamps+=",";
        }
        nomchamps+=")";
        
        for(int j=u+1;j<=2*u;j++)
        {
            valeurs+="\""+arr.get(j)+"\"";
            if(j!=2*u)
                valeurs+=",";
        }
        valeurs+=")";
        
        try {
            c1.executeUpdate("INSERT INTO "+tabnom+" "+nomchamps+" VALUES "+valeurs);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList remplirChampsRequete(String str) throws SQLException {

        return c1.remplirChampsRequete(str);

    }

    public void ouvreFenetre(String str) {

        if (str.equals("docteur")) {
            System.out.println("Ouverture de la fenetre");
            try {
                fenBDDdocteur = new BDDinteractionDOCTEUR(c1);
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (str.equals("malades")) {
            try {
                fenBDDmalades = new BDDinteractionMALADES(c1);
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (str.equals("infirmier")) {
            try {
                fenBDDinfirmier = new BDDinteractionINFIRMIER(c1);
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (str.equals("modification")) {
            fenBDDmodif = new BDDmodification(c1);

        }

        if (str.equals("insertion")) {
            fenBDDinser = new BDDinsertion(c1);
        }

        if (str.equals("Menu")) {
            fen = new Fenetre(this);

        }
    }
    
    public static ArrayList<ArrayList<ArrayList<String>>> ExecuteDocteurAd(String nom, String prenom, String specialite, String numero) throws SQLException{
        String strnom;
        String strprenom;
        String strspe;
        String strnum;
        ArrayList<ArrayList<ArrayList<String>>> total = new ArrayList<>();
        int nb_doc; //nombre de docteurs concernés par la requete;
        
        if(!"".equals(nom))
            strnom="employe.nom=\""+nom+"\"";
        else
            strnom="1=1";
        
        if(!"".equals(prenom))
            strprenom="employe.prenom=\""+prenom+"\"";
        else
            strprenom="1=1";
        
        if(!"".equals(specialite))
            strspe="docteur.specialite=\""+specialite+"\"";
        else
            strspe="1=1";
        
        if(!"".equals(numero))
            strnum="employe.numero="+numero;
        else
            strnum="1=1";
        
        nb_doc=Integer.parseInt(c1.remplirChampsRequete("SELECT COUNT(*) FROM docteur,employe WHERE employe.numero=docteur.numero AND "+strnom+" AND "+strprenom+" AND "+strspe+" AND "+strnum).get(0).toString());
        
        System.out.println(nb_doc);
        
        if(nb_doc==0)
        {
            ArrayList<String> couche1 = new ArrayList<>();
            couche1.add("");
            ArrayList<String> listemalade = new ArrayList<>();
            listemalade.add("");
            ArrayList<ArrayList<String>> couche2 = new ArrayList<>();
            couche2.add(couche1);
            couche2.add(listemalade);
            total.add(couche2);
        }
        
        else
        {
            String req="SELECT employe.nom,employe.prenom,employe.numero,docteur.specialite,employe.adresse,employe.tel FROM docteur,employe WHERE employe.numero=docteur.numero AND "+strnom+" AND "+strprenom+" AND "+strspe+" AND "+strnum;
            ArrayList<String> arr = c1.remplirChampsRequete(req);
            String[] tabstr;
            for(int i=0;i<arr.size();i++)
            {
                tabstr=arr.get(i).split("#");
               
                ArrayList<ArrayList<String>> couche2 = new ArrayList<>();
                ArrayList<String> couche1 = new ArrayList<>();
                
                //on recherche la liste des malades pour ce docteur en particulier
                req="SELECT malade.nom,malade.prenom FROM docteur,malade,soigne,employe WHERE docteur.numero=soigne.no_docteur AND malade.numero=soigne.no_malade AND employe.numero=docteur.numero AND "
                        +"employe.nom=\""+tabstr[0]+"\" AND employe.prenom=\""+tabstr[1]+"\" AND employe.numero="+tabstr[2]+" AND docteur.specialite=\""+tabstr[3]+"\"";
                ArrayList<String> listemalade=new ArrayList<>();
                listemalade=c1.remplirChampsRequete(req);
                
                    
                for(int j=0;j<tabstr.length;j++)
                {
                    couche1.add(tabstr[j]);
                }
                
                couche2.add(couche1);
                couche2.add(listemalade);
                total.add(couche2);
            }
            System.out.println(total);
        }
        return total;
    }
    
    public static ArrayList<ArrayList<ArrayList<String>>> ExecuteInfirmierAd(String nom, String prenom, String numero, String code_service) throws SQLException{
        String strnom;
        String strprenom;
        String strnum;
        String strcode;
        ArrayList<ArrayList<ArrayList<String>>> total = new ArrayList<>();
        int nb_inf;
        
        if(!"".equals(nom))
            strnom="employe.nom=\""+nom+"\"";
        else
            strnom="1=1";
        
        if(!"".equals(prenom))
            strprenom="employe.prenom=\""+prenom+"\"";
        else
            strprenom="1=1";
        
        if(!"".equals(numero))
            strnum="employe.numero="+numero;
        else
            strnum="1=1";
        
        if(!"".equals(code_service))
            strcode="infirmier.code_service=\""+code_service+"\"";
        else
            strcode="1=1";
        
        nb_inf=Integer.parseInt(c1.remplirChampsRequete("SELECT COUNT(*) FROM infirmier,employe WHERE infirmier.numero=employe.numero AND "+strnom+" AND "+strprenom+" AND "+strcode+" AND "+strnum).get(0).toString());
        
        System.out.println(nb_inf);
        
        if(nb_inf==0)
        {
            ArrayList<String> couche1 = new ArrayList<>();
            couche1.add("");
            ArrayList<String> liste = new ArrayList<>();
            liste.add("");
            ArrayList<ArrayList<String>> couche2 = new ArrayList<>();
            couche2.add(couche1);
            couche2.add(liste);
            total.add(couche2);
        }
        
        else
        {
            String req="SELECT employe.nom,employe.prenom,infirmier.numero,infirmier.code_service,employe.adresse,employe.tel FROM infirmier,employe WHERE employe.numero=infirmier.numero AND "+strnom+" AND "+strprenom+" AND "+strcode+" AND "+strnum;
            ArrayList<String> arr = c1.remplirChampsRequete(req);
            String[] tabstr;
            for(int i=0;i<arr.size();i++)
            {
                tabstr=arr.get(i).split("#");
               
                ArrayList<ArrayList<String>> couche2 = new ArrayList<>();
                ArrayList<String> couche1 = new ArrayList<>();
                
                //on recherche la liste des chambres surveillées
                req="SELECT chambre.no_chambre FROM chambre,infirmier,employe WHERE infirmier.numero=chambre.surveillant AND employe.numero=infirmier.numero AND "
                        +"employe.nom=\""+tabstr[0]+"\" AND employe.prenom=\""+tabstr[1]+"\" AND employe.numero="+tabstr[2]+" AND infirmier.code_service=\""+tabstr[3]+"\"";
                ArrayList<String> liste=new ArrayList<>();
                liste=c1.remplirChampsRequete(req);
                
                    
                for(int j=0;j<tabstr.length;j++)
                {
                    couche1.add(tabstr[j]);
                }
                
                couche2.add(couche1);
                couche2.add(liste);
                total.add(couche2);
            }
            System.out.println(total);
        }
        return total;
    }
    
    public static ArrayList<ArrayList<ArrayList<String>>> ExecuteMaladeAd(String nom, String prenom, String numero, String mutuelle) throws SQLException{
        String strnom;
        String strprenom;
        String strnum;
        String strmut;
        ArrayList<ArrayList<ArrayList<String>>> total = new ArrayList<>();
        int nb_mal;
        
        if(!"".equals(nom))
            strnom="malade.nom=\""+nom+"\"";
        else
            strnom="1=1";
        
        if(!"".equals(prenom))
            strprenom="malade.prenom=\""+prenom+"\"";
        else
            strprenom="1=1";
        
        if(!"".equals(numero))
            strnum="malade.numero="+numero;
        else
            strnum="1=1";
        
        if(!"".equals(mutuelle))
            strmut="malade.mutuelle=\""+mutuelle+"\"";
        else
            strmut="1=1";
        
        nb_mal=Integer.parseInt(c1.remplirChampsRequete("SELECT COUNT(*) FROM malade WHERE "
                +strnom+" AND "+strprenom+" AND "+strmut+" AND "+strnum).get(0).toString());
        
        
        if(nb_mal==0)
        {
            ArrayList<String> couche1 = new ArrayList<>();
            couche1.add("");
            ArrayList<ArrayList<String>> couche2 = new ArrayList<>();
            couche2.add(couche1);
            total.add(couche2);
        }
        
        else
        {
            String req="SELECT nom,prenom,numero,mutuelle,adresse,tel FROM malade WHERE "+strnom+" AND "+strprenom+" AND "+strmut+" AND "+strnum;
            ArrayList<String> arr = c1.remplirChampsRequete(req);
            String[] tabstr;
            for(int i=0;i<arr.size();i++)
            {
                tabstr=arr.get(i).split("#");
               
                ArrayList<ArrayList<String>> couche2 = new ArrayList<>();
                ArrayList<String> couche1 = new ArrayList<>();
                
          
                
                    
                for(int j=0;j<tabstr.length;j++)
                {
                    couche1.add(tabstr[j]);
                }
                
                couche2.add(couche1);
                total.add(couche2);
            }
            System.out.println(total);
        }
        return total;
    }
}
