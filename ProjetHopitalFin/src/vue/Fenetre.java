/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import tempo.Test;

/**
 *
 * @author 931702281
 */
public class Fenetre extends JFrame implements ActionListener{
    
    JLabel rech;
    JLabel modif;
    JLabel inser;
    JButton doc;
    JButton inf;
    JButton mal;
    JButton modification;
    JButton insertion;
    
    Test t1;
    
    public Fenetre(Test t1){
        this.setSize(600, 600);
        this.setTitle("Menu principal");
        this.t1=t1;
        
        //init des compo
        rech=new JLabel("Recherches",SwingConstants.CENTER);
        modif=new JLabel("Modifications",SwingConstants.CENTER);
        inser=new JLabel("Insertions",SwingConstants.CENTER);
        doc=new JButton("Docteur");
        inf=new JButton("Infirmier");
        mal=new JButton("Malades");
        modification=new JButton("<html><center>Modifier des lignes</center></html>");
        insertion=new JButton("<html><center>Inserer des lignes</center></html>");
        doc.addActionListener(this); inf.addActionListener(this);
        mal.addActionListener(this); modification.addActionListener(this);
        insertion.addActionListener(this);
        
        //mise en place d'un gridbaglayout;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.weightx=1; c.weighty=1;
        //
        c.ipady=0;
        c.gridx=0;
        c.gridy=0;
        c.gridheight=2;
        c.gridwidth=1;
        this.add(rech,c);
        //
        c.ipady=0;
        c.gridx=1;
        c.gridy=0;
        c.gridheight=2;
        c.gridwidth=1;
        this.add(modif,c);
        //
        c.ipady=0;
        c.gridx=2;
        c.gridy=0;
        c.gridheight=2;
        c.gridwidth=1;
        this.add(inser,c);
        //
        c.ipady=0;
        c.gridx=0;
        c.gridy=2;
        c.gridheight=4;
        c.gridwidth=1;
        this.add(doc,c);
        //
        c.ipady=0;
        c.gridx=0;
        c.gridy=6;
        c.gridheight=4;
        c.gridwidth=1;
        this.add(inf,c);
        //
        c.ipady=0;
        c.gridx=0;
        c.gridy=10;
        c.gridheight=4;
        c.gridwidth=1;
        this.add(mal,c);
        //
        c.ipady=0;
        c.gridx=1;
        c.gridy=2;
        c.gridheight=12;
        c.gridwidth=1;
        this.add(modification,c);
        //
        c.ipady=0;
        c.gridx=2;
        c.gridy=2;
        c.gridheight=12;
        c.gridwidth=1;
        this.add(insertion,c);
        
        //un peu de bordures
        rech.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
        modif.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
        inser.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
        
        doc.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
        inf.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
        mal.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
        modification.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
        insertion.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source==doc)
        {
            t1.ouvreFenetre("docteur");
        }
        
        if(source==inf)
        {
            t1.ouvreFenetre("infirmier");
        }
        
        if(source==mal)
        {
            t1.ouvreFenetre("malades");
        }
        
        if(source==modification)
        {
            t1.ouvreFenetre("modification");
        }
        
        if(source==insertion)
        {
            t1.ouvreFenetre("insertion");
        }
    }
    
}
