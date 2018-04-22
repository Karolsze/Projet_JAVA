/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import tempo.Connexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import tempo.Test;

/**
 *
 * @author 931702281
 */
public class BDDinteractionDOCTEUR extends BDDinteractionBASE implements ActionListener{
    
    ArrayList<ArrayList<ArrayList<String>>> req;
    
    public BDDinteractionDOCTEUR(Connexion c1) throws SQLException {
        
        super(c1, "DOCTEUR", "Nom", "Prénom", "Spécialité", "Numéros", 
                "SELECT nom FROM docteur,employe WHERE docteur.numero=employe.numero ORDER BY nom",
                "SELECT prenom FROM docteur,employe WHERE docteur.numero=employe.numero ORDER BY prenom",
                "SELECT DISTINCT specialite FROM docteur,employe WHERE docteur.numero=employe.numero ORDER BY specialite",
                "SELECT docteur.numero FROM docteur,employe WHERE docteur.numero=employe.numero ORDER BY docteur.numero");
        
        ok.addActionListener(this);
        suiv.addActionListener(this);
        prec.addActionListener(this);
    }

    
    @Override
    public void affiche_resultat(ArrayList<ArrayList<String>> arr) {
        
        System.out.println(arr);
        String resultat="<html><center>Informations du Docteur n°"+index+"<br/>";
        ArrayList arr1=arr.get(0);
        ArrayList arr2=arr.get(1);
 
        for(int i=arr1.size()-1;i>=0;i--)
        {
            resultat+=arr1.get(i).toString();
            resultat+="<br/>";
        }
        
        
        resultat+="</center></html>";
        resulatstotal.setText(resultat);
        
        
        list5.removeAllItems();
        for (Object arr21 : arr2) {
            list5.addItem(arr21.toString());
        }
        this.revalidate();
        this.repaint();
    }
    
    @Override
    public ArrayList<String> getSelect(){
        ArrayList<String> result = new ArrayList<>();
        result.add((String)list1.getSelectedItem());
        result.add((String)list2.getSelectedItem());
        result.add((String)list3.getSelectedItem());
        result.add((String)list4.getSelectedItem());
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==ok)
        {
            index=0;
            ArrayList<String> resultats = this.getSelect();
            req = new ArrayList<ArrayList<ArrayList<String>>>();
            
            String nom = resultats.get(0); String prenom = resultats.get(1);
            String spe = resultats.get(2); String num = resultats.get(3);
            
            try {
                req=Test.ExecuteDocteurAd(nom, prenom, spe, num);
                System.out.println(req);
            } catch (SQLException | ArrayIndexOutOfBoundsException ex) { System.out.println("echec de la requète"); }
            
            affiche_resultat(req.get(index));
        }
        
        if(e.getSource()==prec && index!=-1)
        {
            System.out.println(index);
            index--;
            if(index<0)
            {
                index=req.size()-1;
            }
            affiche_resultat(req.get(index));
        }
        
        if(e.getSource()==suiv && index!=-1)
        {
            System.out.println(index);
            index++;
            if(index>=req.size()) // ici on regarde si index est supérieur à la taille de l'arraylist
            {
                index=0;
            }
            affiche_resultat(req.get(index));
        }
        
    }
   
    
}
