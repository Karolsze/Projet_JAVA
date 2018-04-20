/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author adrie
 */
public class Fenetre extends JFrame{
    
    Selection sel = new Selection();
    JButton mod = new JButton("MODIFICATIONS");
    JButton graph = new JButton("GRAPHIQUES");
    
    public Fenetre(){
        
        
        this.setLayout(new GridLayout(1,3));
        
        this.setSize(1200,1080); this.setResizable(false);
        
        mod.setBackground(new Color(44,79,219)); mod.setFocusPainted(false);
        graph.setBackground(new Color(44,79,219)); graph.setFocusPainted(false);
        this.add(sel,0,0);
        this.add(mod,0,1);
        this.add(graph,0,2);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public Fenetre(String str)
    {
        this();
        this.setTitle(str);
    }
    
}
