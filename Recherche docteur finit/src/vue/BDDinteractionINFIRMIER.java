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
public class BDDinteractionINFIRMIER extends BDDinteractionBASE{

    public BDDinteractionINFIRMIER(Connexion c1) throws SQLException {
        
        super(c1, "INFIRMIER", "Nom", "Prenom", "Numéro", "Code de service", 
                "SELECT employe.nom from employe,infirmier WHERE employe.numero=infirmier.numero ORDER BY employe.nom",
                "SELECT employe.prenom from employe,infirmier WHERE employe.numero=infirmier.numero ORDER BY employe.prenom",
                "SELECT employe.numero from employe,infirmier WHERE employe.numero=infirmier.numero",
                "SELECT DISTINCT code_service from employe,infirmier WHERE employe.numero=infirmier.numero");
    }

    @Override
    void affiche_resultat(ArrayList<ArrayList<Object>> arr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
