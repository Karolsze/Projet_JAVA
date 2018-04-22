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
public class BDDinteractionINFIRMIER extends BDDinteractionBASE implements ActionListener{

    ArrayList<ArrayList<ArrayList<String>>> req;
    
    public BDDinteractionINFIRMIER(Connexion c1) throws SQLException {
        
        super(c1, "INFIRMIER", "Nom", "Prenom", "Numéro", "Code de service", 
                "SELECT employe.nom from employe,infirmier WHERE employe.numero=infirmier.numero ORDER BY employe.nom",
                "SELECT employe.prenom from employe,infirmier WHERE employe.numero=infirmier.numero ORDER BY employe.prenom",
                "SELECT employe.numero from employe,infirmier WHERE employe.numero=infirmier.numero",
                "SELECT DISTINCT code_service from employe,infirmier WHERE employe.numero=infirmier.numero");
        
        ok.addActionListener(this);
        suiv.addActionListener(this);
        prec.addActionListener(this);
    }

    @Override
    void affiche_resultat(ArrayList<ArrayList<String>> arr) {
        
        System.out.println(arr);
        String resultat="<html><center>Informations de l'infirmier n°"+index+"<br/>";
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
        result.add(list1.getSelectedItem().toString());
        result.add(list2.getSelectedItem().toString());
        result.add(list3.getSelectedItem().toString());
        result.add(list4.getSelectedItem().toString());
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
                req=Test.ExecuteInfirmierAd(nom, prenom, spe, num);
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
