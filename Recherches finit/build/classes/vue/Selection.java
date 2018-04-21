/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author adrie
 */
public class Selection extends JPanel{
    
    public Selection(){
        
        this.setLayout(new GridLayout(3,1));
        CaseDeSelection docteur = new CaseDeSelection("DOCTEUR");
        CaseDeSelection infirmier = new CaseDeSelection("INFIRMIER");
        CaseDeSelection  malade = new CaseDeSelection("MALADE");
        
        this.setPreferredSize(new Dimension(400,1200));

        docteur.setIcon(new ImageIcon("Images/docteur.png"));
        infirmier.setIcon(new ImageIcon("Images/infirmier.png"));
        malade.setIcon(new ImageIcon("Images/malade.png"));
        
        this.add(docteur,0,0);
        this.add(infirmier,0,1);
        this.add(malade,0,2);
        
        this.setVisible(true);
                
        
    }
    
}
