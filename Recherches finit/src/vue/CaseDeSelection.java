/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author adrie
 */
public class CaseDeSelection extends JPanel{
    
    JButton bouton;
    JLabel lab;
    
    public CaseDeSelection(String str){
        
        this.setLayout(new BorderLayout());
        bouton = new JButton(str); bouton.setFocusPainted(false);
        lab = new JLabel();
        
        bouton.setPreferredSize(new Dimension(400,40));
        lab.setBackground(Color.red);
        this.add(bouton,BorderLayout.SOUTH);
        this.add(lab,BorderLayout.CENTER);
        
        this.setVisible(true);
        
        
    }
    
    public void setIcon(ImageIcon im){
        lab.setIcon(im);
    }
    
}
