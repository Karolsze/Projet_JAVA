/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import ProjetHopital.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 931702281
 */
public class BDDinteractionDOCTEUR extends BDDinteractionBASE{

    public BDDinteractionDOCTEUR(Connexion c1) throws SQLException {
        
        super(c1, "DOCTEUR", "Nom", "Prénom", "Spécialité", "Numéros", 
                "SELECT nom FROM docteur,employe WHERE docteur.numero=employe.numero ORDER BY nom",
                "SELECT prenom FROM docteur,employe WHERE docteur.numero=employe.numero ORDER BY prenom",
                "SELECT DISTINCT specialite FROM docteur,employe WHERE docteur.numero=employe.numero ORDER BY specialite",
                "SELECT docteur.numero FROM docteur,employe WHERE docteur.numero=employe.numero ORDER BY docteur.numero");
    }

    
    @Override
    public void affiche_resultat(ArrayList<ArrayList<Object>> arr) {
        
        String resultat="<html>";
        ArrayList arr1=arr.get(0);
        ArrayList arr2=arr.get(1);
        
        resultat+=arr1.get(0);
        resultat+=arr.get(1);
        
        resultat+="<br/>";
        resultat+=arr2.get(0);
        resultat+="<html>";
        
        resulatstotal.setText(resultat);
        this.revalidate();
        this.repaint();
    }
    
}
