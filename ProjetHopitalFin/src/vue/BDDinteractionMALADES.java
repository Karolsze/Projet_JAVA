/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tempo.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;
import tempo.Test;

/**
 *
 * @author 931702281
 */
public class BDDinteractionMALADES extends BDDinteractionBASE implements ActionListener{

    ArrayList<ArrayList<ArrayList<String>>> req;
    
    public BDDinteractionMALADES(Connexion c1) throws SQLException {
        
        super(c1, "MALADES", "Nom", "Prenom", "Numéro patient", "Mutuelle", 
                "SELECT malade.nom FROM malade ORDER BY nom",
                "SELECT malade.prenom FROM malade ORDER BY prenom",
                "SELECT malade.numero FROM malade",
                "SELECT DISTINCT mutuelle from malade");
        list5.setVisible(false);
        ok.addActionListener(this);
        suiv.addActionListener(this);
        prec.addActionListener(this);
    }
    
    @Override
    public ArrayList<String> getSelect(){
        ArrayList<String> result = new ArrayList<>();
        result.add(list1.getSelectedItem().toString());
        result.add(list2.getSelectedItem().toString());
        result.add(list3.getSelectedItem().toString());
        result.add(list4.getSelectedItem().toString());
        return result;
    }
    
    @Override
    void affiche_resultat(ArrayList<ArrayList<String>> arr) {
        
        System.out.println(arr);
        String resultat="<html><center>Informations du malade n°"+index+"<br/>";
        ArrayList arr1=arr.get(0);
 
        for(int i=arr1.size()-1;i>=0;i--)
        {
            resultat+=arr1.get(i).toString();
            resultat+="<br/>";
        }
        
        
        resultat+="</center></html>";
        resulatstotal.setText(resultat);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==ok)
        {
            index=0;
            ArrayList<String> resultats = this.getSelect();
            req = new ArrayList<ArrayList<ArrayList<String>>>();
            
            String nom = resultats.get(0); String prenom = resultats.get(1);
            String numpa = resultats.get(2); String mut = resultats.get(3);
            
            try {
                req=Test.ExecuteMaladeAd(nom, prenom, numpa, mut);
                System.out.println("eee");
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
