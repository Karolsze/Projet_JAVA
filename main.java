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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Test t1=new Test("hopital","root","");
        t1.ExecuteDocteur("Nadal", "", "","");
        ArrayList <ArrayList<Object>> test = new ArrayList();
        test=t1.ExecuteDocteur("Nadal", "", "","");
        
        for(int i=0;i<test.size();i++)
        {
            System.out.println(test.get(i));
        }
        
        //t1.AfficherInformations("malade");
    }
    public Test(String database,String login,String password) throws SQLException, ClassNotFoundException
    {
        c1=new Connexion(database,login,password);
    }
    public void AfficherInformations(String table)
    {
        //On declare les tables
        ArrayList<Object> list = new ArrayList<Object>();
        ArrayList<Object> list2 = new ArrayList<Object>();
        ArrayList<Object> list3 = new ArrayList<Object>();
        
        if(table=="docteur")
        {
            
            try {        
                list =c1.remplirChampsRequete("SELECT employe.nom,employe.prenom,employe.adresse FROM docteur INNER JOIN employe ON docteur.numero = employe.numero");
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                list2=c1.remplirChampsRequete("SELECT docteur.numero FROM docteur");
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Voici les informations de tout les docteur: ");
        
            for(int i=0;i<list.size();i++)
            {
            System.out.println("Docteur numero: "+list2.get(i));
            System.out.println(list.get(i));
            } ///Si tu clique on enleve la boucle for et on incremente le i
        }
       if(table=="infirmier")
       {
           try {        
                list =c1.remplirChampsRequete("SELECT employe.nom,employe.prenom,employe.adresse FROM infirmier INNER JOIN employe ON infirmier.numero = employe.numero");
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                list2=c1.remplirChampsRequete("SELECT infirmier.numero,infirmier.salaire,infirmier.rotation FROM infirmier");
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        System.out.println("Voici les informations de tout les docteur: ");
        
            for(int i=0;i<list.size();i++)
       {
            System.out.println("Infirmier numero: "+list2.get(i));
            System.out.println(list.get(i));
       } ///Si tu clique on enleve la boucle for et on incremente le i
            
       }
       
       if(table=="malade")
       {
            try {
                list=c1.remplirChampsRequete("SELECT malade.nom,malade.prenom,malade.adresse,malade.tel,malade.mutuelle FROM malade");
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Voici les informations de tout les malades: ");
        
            for(int i=0;i<list.size();i++)
            {
            System.out.println(list.get(i));
            } ///Si tu clique on enleve la boucle for et on incremente le i
       }
    }
    
    public ArrayList <ArrayList<Object>> ExecuteDocteur(String nom,String prenom,String specialite,String numero) throws SQLException
    {
        //On declare les tables
        ArrayList<Object> list = new ArrayList<Object>();
        ArrayList<Object> list2 = new ArrayList<Object>();
        ArrayList<Object> list3 = new ArrayList<Object>();
        ArrayList<Object> list4 = new ArrayList<Object>();
        ArrayList<Object> listCopie = new ArrayList<Object>();
        ArrayList <ArrayList<Object>> InfoDocteur = new ArrayList();
        ArrayList <ArrayList <ArrayList<Object>>> ToutLesInfos = new ArrayList();
        
        //Les differentes requêtes qui auront lieux
        String requete="";
        String requeteSpecia="";
        String requeteSoigne="";
        
        //On créer des boolean pour savoir si le champ est vide
        boolean nomB= true;
        boolean prenomB= true;
        boolean specialiteB= true;
        boolean numeroB= true;
        
        ///Si les champs sont vides les booleens sont faux
        if(nom.equals(""))nomB=false;
        if(prenom.equals(""))prenomB=false;
        if(specialite.equals(""))specialiteB=false;
        if(numero.equals(""))numeroB=false;
        
        //Si on recoit que des champs vides
        if((!specialiteB)&&(!numeroB)&&(!nomB)&&(!prenomB))
        {
            System.out.println("Veuillez rentrer au moins une information");
        }
        
        //Si on recoit uniquement le nom du docteur ou bien uniquement le prenom ou les deux
        if(((nomB)&&(!prenomB))||((!nomB)&&(prenomB))||((nomB)&&(prenomB)))
        {
            //on verifi son nom
            if((nomB)&&(!prenomB))
            {
                requete="SELECT * FROM employe WHERE nom = '"+nom+"'";
            }
            
            //on verifi son prenom
            if((!nomB)&&(prenomB))
            {
                requete="SELECT * FROM employe WHERE prenom = '"+prenom+"'";
                
            }
            
            //on verifi les prenom et le nom
            if((nomB)&&(prenomB))
            {
                requete="SELECT * FROM employe WHERE prenom = '"+prenom+"' AND nom = '"+nom+"'";               
            }
            
            //On verifi sa specialite
            requeteSpecia="SELECT docteur.specialite FROM docteur INNER JOIN employe ON docteur.numero=employe.numero";
            
            list=c1.remplirChampsRequete(requete);
            list2=c1.remplirChampsRequete(requeteSpecia);
            list.add(list2.get(0));
 
            //On affiche les infos du docteur et sa specialite
            /*for(int i=0;i<list.size();i++)
            {           
            System.out.println(list.get(i));
            }*/

            //on regarde tout les numeros des malades qu'il soigne
            requeteSoigne="SELECT soigne.no_malade FROM soigne INNER JOIN docteur ON docteur.numero=soigne.no_docteur";
            
            list3=c1.remplirChampsRequete(requeteSoigne);
            //System.out.println("Le docteur "+nom+" soigne: ");
            for(int i=0;i<list3.size();i++)
         {   
            //on regarde le prenom de tout les patient qu'il soigne
            requeteSoigne="SELECT malade.nom,malade.prenom FROM malade INNER JOIN soigne ON malade.numero="+list3.get(i);
            list4=c1.remplirChampsRequete(requeteSoigne);
            //System.out.println("Le malade "+list4.get(i));
            listCopie.add(list4.get(i));
         }
           /* for(int i=0;i<listCopie.size();i++)
         { 
             System.out.println("Le malade "+listCopie.get(i));
         }*/

        }
        
        //Si on recoit uniquement une specialite
        if((!nomB)&&(!prenomB)&&(specialiteB)&&(!numeroB))
        {
           requete="SELECT docteur.numero FROM docteur WHERE docteur.specialite = '"+specialite+"'";
           list=c1.remplirChampsRequete(requete);
           System.out.println("Les docteurs de la specialite "+specialite+" sont: ");
            for(int i=0;i<list.size();i++)
            {   
             requeteSpecia="SELECT employe.nom,employe.prenom FROM employe INNER JOIN docteur ON employe.numero="+list.get(i);
             list4=c1.remplirChampsRequete(requeteSpecia);
             System.out.println("Le docteur "+list4.get(i));
            }
            
         }
            
            //Info docteur contient 2 cases: le nom des malades qu'il soigne ainsi que ses informations personnelles
            InfoDocteur.add(list);
            InfoDocteur.add(listCopie);
            
           /* for(int i=0;i<InfoDocteur.size();i++)
            {           
            System.out.println(InfoDocteur.get(i));
            }*/

            return InfoDocteur;
}
}