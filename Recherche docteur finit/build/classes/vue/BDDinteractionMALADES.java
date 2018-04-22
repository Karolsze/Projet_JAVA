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
public class BDDinteractionMALADES extends BDDinteractionBASE{

    public BDDinteractionMALADES(Connexion c1) throws SQLException {
        
        super(c1, "MALADES", "Nom", "Prenom", "Numéro patient", "Numéro chambre", 
                "SELECT malade.nom FROM malade ORDER BY nom",
                "SELECT malade.prenom FROM malade ORDER BY prenom",
                "SELECT malade.numero FROM malade",
                "SELECT DISTINCT no_chambre FROM malade,hospitalisation WHERE no_malade=numero");
    }

    @Override
    void affiche_resultat(ArrayList<ArrayList<Object>> arr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
