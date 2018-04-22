/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author 931702281
 */
public class ListeBasique extends JComboBox{
    
    public ListeBasique(String[] str){
        
        super(str);
        ((JLabel)this.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
    }
    
}
