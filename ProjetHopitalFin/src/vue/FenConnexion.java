/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import tempo.Test;

/**
 *
 * @author adrie
 */
public class FenConnexion extends JFrame implements ActionListener{
    
    JLabel cell1;
    JButton cell2;
    JLabel cell3;
    JTextField cell4;
    JLabel cell5;
    JTextField cell6;
    JLabel cell7;
    JTextField cell8;
    JLabel cell9;
    JTextField cell10;
    JLabel cell11;
    JLabel cell12;
    JButton cell13;
    JLabel cell14;
    JTextField cell15;
    
    public FenConnexion(){
        
        this.setLayout(new BorderLayout());
        
        //Composants pour la connexion à distance
        cell1 = new JLabel("Connexion à distance");              cell1.setSize(new Dimension(400,100));
        cell2 = new JButton("Connexion");                       cell2.setSize(new Dimension(400,100));
        cell3 = new JLabel("Login ECE :");                       cell3.setSize(new Dimension(200,100));
        cell4 = new JTextField();                            cell4.setSize(new Dimension(600,100));
        cell5 = new JLabel("Pass ECE :");                        cell5.setSize(new Dimension(200,100));
        cell6 = new JTextField();                            cell6.setSize(new Dimension(600,100));
        cell7 = new JLabel("Login Base :");                      cell7.setSize(new Dimension(200,100));
        cell8 = new JTextField();                            cell8.setSize(new Dimension(600,100));
        cell9 = new JLabel("Pass Base :");                       cell9.setSize(new Dimension(200,100));
        cell10 = new JTextField();                           cell10.setSize(new Dimension(600,100));
        //Séparation
        cell11 = new JLabel();                                   cell11.setSize(new Dimension(800,300));
        javax.swing.border.Border border = BorderFactory.createLineBorder(Color.black, 1);

        cell11.setBorder(border);
        //Composants pour la connexion locale
        cell12 = new JLabel("Connexion locale");                 cell12.setSize(new Dimension(400,100));
        cell13 = new JButton("Connexion");                      cell13.setSize(new Dimension(400,100));
        cell14 = new JLabel("Nom base :");                       cell1.setSize(new Dimension(200,100));
        cell15 = new JTextField();                           cell15.setSize(new Dimension(600,100));
        
        this.setSize(new Dimension(400,500));
        
        //Mise en place d'un GridbagLayout:
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx=1;
        gbc.weighty=1;
        //
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridheight=1;
        gbc.gridwidth=2;
        this.add(cell1,gbc);
        //
        gbc.gridx=2;
        gbc.gridy=0;
        this.add(cell2,gbc);
        //
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=1;
        this.add(cell3,gbc);
        //
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=3;
        this.add(cell4,gbc);
        //
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=1;
        this.add(cell5,gbc);
        //
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.gridwidth=3;
        this.add(cell6,gbc);
        //
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=1;
        this.add(cell7,gbc);
        //
        gbc.gridx=1;
        gbc.gridy=3;
        gbc.gridwidth=3;
        this.add(cell8,gbc);
        //
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=1;
        this.add(cell9,gbc);
        //
        gbc.gridx=1;
        gbc.gridy=4;
        gbc.gridwidth=3;
        this.add(cell10,gbc);        
        //
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.gridwidth=4;
        this.add(cell11,gbc);
        //
        gbc.gridx=0;
        gbc.gridy=6;
        gbc.gridwidth=2;
        this.add(cell12,gbc);
        //
        gbc.gridx=2;
        gbc.gridy=6;
        gbc.gridwidth=2;
        this.add(cell13,gbc);
        //
        gbc.gridx=0;
        gbc.gridy=7;
        gbc.gridwidth=1;
        this.add(cell14,gbc);
        //
        gbc.gridx=1;
        gbc.gridy=7;
        gbc.gridwidth=3;
        this.add(cell15,gbc);
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cell2.addActionListener(this);
        cell13.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source==cell13)
        {
            Test t1=null;
            String txt = cell15.getText();
            try { 
                t1 = new Test(txt, "root", "");
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FenConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Connexion réussie");
            t1.ouvreFenetre("Menu");
            this.setVisible(false);
        }
        
        if(source==cell2)
        {
            Test t1=null;
            //String txt = cell15.getText();
            try { 
                t1 = new Test("am175665","%RQ3qyk7234","am175665-rw","fmDXSter");
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FenConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Connexion réussie");
            t1.ouvreFenetre("Menu");
            this.setVisible(false);
        }
        
    }
    

}
