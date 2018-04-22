/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projethopital;

import java.sql.SQLException;
import vue.Fenetre;
import ProjetHopital.Connexion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vue.BDDinteractionDOCTEUR;
import vue.BDDinteractionINFIRMIER;
import vue.BDDinteractionMALADES;
import vue.FenConnexion;

/**
 *
 * @author adrie
 */
public class Test {

    public static Connexion c1;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //Fenetre fen = new Fenetre("Fenetre de gestion de l'hopital");
        //FenConnexion fenc = new FenConnexion();
        Test t1 = new Test("hopital", "root", "");
        ArrayList <ArrayList <ArrayList<Object>>> test = new ArrayList();
        test = t1.ExecuteDocteur("", "", "", "4");

        /*for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }*/

        //t1.AfficherInformations("malade");
        //FENETRES
        //BDDinteractionDOCTEUR fenBDDdocteur = new BDDinteractionDOCTEUR(c1);
        //BDDinteractionINFIRMIER fenBDDinfirmier = new BDDinteractionINFIRMIER(c1);
        //BDDinteractionMALADES fendBDDmalades = new BDDinteractionMALADES(c1);
        
        //fenBDDdocteur.affiche_resultat(t1.ExecuteDocteur("Safin","","",""));
    }

    public Test(String database, String login, String password) throws SQLException, ClassNotFoundException {
        c1 = new Connexion(database, login, password);
    }

    public ArrayList<ArrayList<ArrayList<Object>>> ExecuteDocteur(String nom, String prenom, String specialite, String numero) throws SQLException {
        //On declare les tables
        ArrayList<Object> list = new ArrayList<Object>();
        ArrayList<Object> list2 = new ArrayList<Object>();
        ArrayList<Object> list3 = new ArrayList<Object>();
        ArrayList<Object> list4 = new ArrayList<Object>();
        ArrayList<Object> list5 = new ArrayList<Object>();
        ArrayList<Object> listCopie = new ArrayList<Object>();
        ArrayList<ArrayList<Object>> InfoDocteur = new ArrayList();
        ArrayList<ArrayList<ArrayList<Object>>> TouteLesInfos = new ArrayList();
        
        //Les differentes requêtes qui auront lieux
        String requete ="";
        String requete2="";
        String requete3="";
        String requete4="";
        String requete5="";
        String requete6="";
                        
        String requeteSpecia ="";
        String requeteSoigne ="";
        String requeteMalade ="";

        //On créer des boolean pour savoir si le champ est vide
        boolean nomB = true;
        boolean prenomB = true;
        boolean specialiteB = true;
        boolean numeroB = true;

        ///Si les champs sont vides les booleens sont faux
        if (nom.equals("")) {
            nomB = false;
        }
        if (prenom.equals("")) {
            prenomB = false;
        }
        if (specialite.equals("")) {
            specialiteB = false;
        }
        if (numero.equals("")) {
            numeroB = false;
        }

        //Si on recoit que des champs vides
        if ((!specialiteB) && (!numeroB) && (!nomB) && (!prenomB)) {
            System.out.println("Veuillez rentrer au moins une information");
        }

        //Si on recoit uniquement le nom du docteur ou bien uniquement le prenom ou les deux
        if (((nomB) && (!prenomB)) || ((!nomB) && (prenomB)) || ((nomB) && (prenomB))) {
            //on verifi son nom
            if ((nomB) && (!prenomB)) {
                requete = "SELECT employe.numero FROM employe WHERE nom = '" + nom + "'";
                requete2= "SELECT employe.nom FROM employe WHERE nom = '" + nom + "'";
                requete3= "SELECT employe.prenom FROM employe WHERE nom = '" + nom + "'";
                requete4= "SELECT employe.adresse FROM employe WHERE nom = '" + nom + "'";
                requete5= "SELECT employe.tel FROM employe WHERE nom = '" + nom + "'";
                requete6= "SELECT * FROM employe WHERE nom = '" + nom + "'";
            }

            //on verifi son prenom
            if ((!nomB) && (prenomB)) {
                requete = "SELECT employe.numero FROM employe WHERE prenom = '" + prenom + "'";
                requete2= "SELECT employe.nom FROM employe WHERE prenom = '" + prenom + "'";
                requete3= "SELECT employe.prenom FROM employe WHERE prenom = '" + prenom + "'";
                requete4= "SELECT employe.adresse FROM employe WHERE prenom = '" + prenom + "'";
                requete5= "SELECT employe.tel FROM employe WHERE prenom = '" + prenom + "'";
                requete6= "SELECT * FROM employe WHERE prenom = '" + prenom + "'";

            }

            //on verifi les prenom et le nom
            if ((nomB) && (prenomB)) {
                requete = "SELECT employe.numero FROM employe WHERE prenom = '" + prenom + "' AND nom = '" + nom + "'";
                requete2= "SELECT employe.nom FROM employe WHERE prenom = '" + prenom + "' AND nom = '" + nom + "'";
                requete3= "SELECT employe.prenom FROM employe WHERE prenom = '" + prenom + "' AND nom = '" + nom + "'";
                requete4= "SELECT employe.adresse FROM employe WHERE prenom = '" + prenom + "' AND nom = '" + nom + "'";
                requete5= "SELECT employe.tel FROM employe WHERE prenom = '" + prenom + "' AND nom = '" + nom + "'";
                requete6= "SELECT * FROM employe WHERE prenom = '" + prenom + "' AND nom = '" + nom + "'";
            }

            //On verifi sa specialite
            requeteSpecia = "SELECT docteur.specialite FROM docteur INNER JOIN employe ON docteur.numero=employe.numero";

            list2 = c1.remplirChampsRequete(requeteSpecia);
            list.add(list2.get(0));
            list2 = c1.remplirChampsRequete(requete2);
            list.add(list2.get(0));
            list2 = c1.remplirChampsRequete(requete3);
            list.add(list2.get(0));
            list2 = c1.remplirChampsRequete(requete4);
            list.add(list2.get(0));
            list2 = c1.remplirChampsRequete(requete5);
            list.add(list2.get(0));
            
            list2 = c1.remplirChampsRequete(requete);
            
            //on regarde tout les numeros des malades qu'il soigne
            requeteSoigne = "SELECT soigne.no_malade FROM soigne WHERE soigne.no_docteur= "+list2.get(0) ;
            list3 = c1.remplirChampsRequete(requeteSoigne);
            
           for (int i = 0; i < list3.size(); i++) {
                //on regarde le prenom de tout les patient qu'il soigne
                requeteSoigne = "SELECT malade.nom,malade.prenom FROM malade INNER JOIN soigne ON malade.numero=" + list3.get(i);
                list4 = c1.remplirChampsRequete(requeteSoigne);
                listCopie.add(list4.get(i));
            }
                InfoDocteur.add(list);
                InfoDocteur.add(listCopie);
                TouteLesInfos.add(InfoDocteur);
        }
        
        //Si on recoit uniquement une specialite
        if ((!nomB) && (!prenomB) && (specialiteB) && (!numeroB)) 
        {
            //On ajoute la specialite
            //Recherche des docteurs ayant cette specialité
           requete="SELECT docteur.numero FROM docteur WHERE docteur.specialite = '"+specialite+"'";
           list=c1.remplirChampsRequete(requete);
           
            //On parcours le nombre de docteur 
            for (int i = 0; i < list.size(); i++) 
            {
                //On affiche les infos du docteur 
                //requete="SELECT * FROM employe INNER JOIN docteur ON employe.numero="+list.get(i);
                requete = "SELECT employe.numero FROM employe INNER JOIN docteur ON employe.numero="+list.get(i);
                requete2= "SELECT employe.nom FROM employe INNER JOIN docteur ON employe.numero="+list.get(i);
                requete3= "SELECT employe.prenom FROM employe INNER JOIN docteur ON employe.numero="+list.get(i);
                requete4= "SELECT employe.adresse FROM employe INNER JOIN docteur ON employe.numero="+list.get(i);
                requete5= "SELECT employe.tel FROM employe INNER JOIN docteur ON employe.numero="+list.get(i);

                //on ajoute les infos du docteur
                list5 = new ArrayList();
                
                list2 = c1.remplirChampsRequete(requete);
                list5.add(list2.get(0));
                list2 = c1.remplirChampsRequete(requete2);
                list5.add(list2.get(0));
                list2 = c1.remplirChampsRequete(requete3);
                list5.add(list2.get(0));
                list2 = c1.remplirChampsRequete(requete4);
                list5.add(list2.get(0));
                list2 = c1.remplirChampsRequete(requete5);
                list5.add(list2.get(0));             
                
                //on regarde tout les numeros des malades qu'il soigne
                requeteSoigne="SELECT soigne.no_malade FROM soigne WHERE soigne.no_docteur="+list.get(i);
                list3=c1.remplirChampsRequete(requeteSoigne);
                
                listCopie = new ArrayList();
                //On parcoure tout les malades
                for(int j=0;j<list3.size();j++)
                {
                    requeteSoigne = "SELECT malade.nom,malade.prenom FROM malade INNER JOIN soigne ON malade.numero=" + list3.get(j);
                    list4 = c1.remplirChampsRequete(requeteSoigne);
                    listCopie.add(list4.get(i));
                }
                //On ajoute les informations
                InfoDocteur.add(list5);
                InfoDocteur.add(listCopie);
                TouteLesInfos.add(InfoDocteur);
                InfoDocteur = new ArrayList();

            }
            
        }
        
        //Si on recoit uniquement un numero peut importe la specialite
        if ((!nomB) && (!prenomB) && (numeroB)) 
        {       
                //On obtient toutes les informations de l'employé de manière séparée
                requete = "SELECT employe.numero FROM employe WHERE numero = '" + numero + "'";
                requete2= "SELECT employe.nom FROM employe WHERE numero = '" + numero + "'";
                requete3= "SELECT employe.prenom FROM employe WHERE numero = '" + numero + "'";
                requete4= "SELECT employe.adresse FROM employe WHERE numero = '" + numero + "'";
                requete5= "SELECT employe.tel FROM employe WHERE numero = '" + numero + "'";
                requete6= "SELECT * FROM employe WHERE WHERE numero = '" + numero + "'";
           
                            //On verifi sa specialite
            requeteSpecia = "SELECT docteur.specialite FROM docteur INNER JOIN employe ON "+numero+"=employe.numero";
            
            //On ajoute toutes les informations dans un tableau
            list2 = c1.remplirChampsRequete(requeteSpecia);
            System.out.println(list2.get(0));
            list.add(list2.get(0));
            list2 = c1.remplirChampsRequete(requete2);
            list.add(list2.get(0));
            list2 = c1.remplirChampsRequete(requete3);
            list.add(list2.get(0));
            list2 = c1.remplirChampsRequete(requete4);
            list.add(list2.get(0));
            list2 = c1.remplirChampsRequete(requete5);
            list.add(list2.get(0));
            
            list2 = c1.remplirChampsRequete(requete);
            
            //on regarde tout les numeros des malades qu'il soigne
            requeteSoigne = "SELECT soigne.no_malade FROM soigne WHERE soigne.no_docteur= "+numero ;
            list3 = c1.remplirChampsRequete(requeteSoigne);
            
           for (int i = 0; i < list3.size(); i++) {
                //on regarde le prenom de tout les patient qu'il soigne
                requeteSoigne = "SELECT malade.nom,malade.prenom FROM malade INNER JOIN soigne ON malade.numero=" + list3.get(i);
                list4 = c1.remplirChampsRequete(requeteSoigne);
                listCopie.add(list4.get(i));
            }
                InfoDocteur.add(list);
                InfoDocteur.add(listCopie);
                TouteLesInfos.add(InfoDocteur);
                
        }
        //Info docteur contient 2 cases: le nom des malades qu'il soigne ainsi que ses informations personnelles
        return TouteLesInfos;
    }

    
    public ArrayList remplirChampsRequete(String str) throws SQLException {

        return c1.remplirChampsRequete(str);

    }
}
