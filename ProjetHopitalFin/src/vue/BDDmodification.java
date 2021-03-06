/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import tempo.Connexion;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tempo.Test;

/**
 *
 * @author 931702281
 */
public class BDDmodification extends JFrame implements ActionListener{
    
    Connexion c1;
    int nb_colonnes;
    int nb_lignes;
    int index;
    String tabactu;
    
    //Boutons
    JButton ok;
    JButton suiv;
    JButton prec;
    JButton boutonCHAMBRE; JButton boutonDOCTEUR; JButton boutonEMPLOYE; JButton boutonHOSPITALISATION;
    JButton boutonINFIRMIER; JButton boutonMALADE; JButton boutonSERVICE; JButton boutonSOIGNE;
    
    //Array de composants
    ArrayList<JTextField> listfields = new ArrayList<>();
    ArrayList<JLabel> listlab = new ArrayList<>();
    
    //JPanel qui contient les éléments des ArrayList
    JPanel panneau_princ = new JPanel();
    
    public BDDmodification(Connexion co){
        
        
        this.c1=co;
        this.setTitle("Fenetre de modification");
        this.setLayout(new GridBagLayout());
        this.tabactu="chambre"; //par défaut c'est la table chambre qui s'ouvre en 1er
        this.nb_colonnes=4;
        this.nb_lignes=24;
        this.index=0;
        
        //init des compo
        ok = new JButton("OK"); ok.addActionListener(this);
        suiv = new JButton("SUIVANT"); suiv.addActionListener(this);
        prec = new JButton("PRECEDENT"); prec.addActionListener(this);
        boutonCHAMBRE = new JButton("Chambre"); boutonCHAMBRE.addActionListener(this);
        boutonDOCTEUR = new JButton("Docteur"); boutonDOCTEUR.addActionListener(this);
        boutonEMPLOYE = new JButton("Employe"); boutonEMPLOYE.addActionListener(this);
        boutonHOSPITALISATION = new JButton("Hospitalisation"); boutonHOSPITALISATION.addActionListener(this);
        boutonINFIRMIER = new JButton("Infirmier"); boutonINFIRMIER.addActionListener(this);
        boutonMALADE = new JButton("Malade"); boutonMALADE.addActionListener(this);
        boutonSERVICE = new JButton("Service"); boutonSERVICE.addActionListener(this);
        boutonSOIGNE = new JButton("Soigne"); boutonSOIGNE.addActionListener(this);
        
        //Mise en place du GridBagLayout
        GridBagConstraints c = new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.weightx=1; c.weighty=1;
        
        //On remplit la fenetre:
        
        //Les boutons du haut
        c.ipady=0;
        c.gridx=0;
        c.gridy=0;
        c.gridheight=2;
        c.gridwidth=2;
        this.add(boutonCHAMBRE,c);
        //
        c.ipady=0;
        c.gridx=2;
        c.gridy=0;
        c.gridheight=2;
        c.gridwidth=2;
        this.add(boutonDOCTEUR,c);
        //
        c.ipady=0;
        c.gridx=4;
        c.gridy=0;
        c.gridheight=2;
        c.gridwidth=2;
        this.add(boutonEMPLOYE,c);
        //
        c.ipady=0;
        c.gridx=6;
        c.gridy=0;
        c.gridheight=2;
        c.gridwidth=2;
        this.add(boutonHOSPITALISATION,c);
        //
        c.ipady=0;
        c.gridx=8;
        c.gridy=0;
        c.gridheight=2;
        c.gridwidth=2;
        this.add(boutonINFIRMIER,c);
        //
        c.ipady=0;
        c.gridx=10;
        c.gridy=0;
        c.gridheight=2;
        c.gridwidth=2;
        this.add(boutonMALADE,c);
        //
        c.ipady=0;
        c.gridx=12;
        c.gridy=0;
        c.gridheight=2;
        c.gridwidth=2;
        this.add(boutonSERVICE,c);
        //
        c.ipady=0;
        c.gridx=14;
        c.gridy=0;
        c.gridheight=2;
        c.gridwidth=2;
        this.add(boutonSOIGNE,c);
        
        //le panneau central
        c.ipady=0;
        c.gridx=0;
        c.gridy=3;
        c.gridheight=12;
        c.gridwidth=16;
        remplirPanneau();
        this.add(panneau_princ,c);
        panneau_princ.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        //les boutons du bas
        c.ipady=0;
        c.gridx=0;
        c.gridy=16;
        c.gridheight=4;
        c.gridwidth=4;
        this.add(prec,c);
        //
        c.ipady=0;
        c.gridx=6;
        c.gridy=16;
        c.gridheight=4;
        c.gridwidth=4;
        this.add(ok,c);
        //
        c.ipady=0;
        c.gridx=12;
        c.gridy=16;
        c.gridheight=4;
        c.gridwidth=4;
        this.add(suiv,c);
        //fin de la mise en place du Layout
        
        this.setSize(1200, 800);
        this.setVisible(true);
    }
    
    public void remplirPanneau(){
        
        panneau_princ.removeAll();
        listfields.clear();
        listlab.clear();
        index=0;
        updatelignes();
        panneau_princ.setLayout(new GridLayout(nb_colonnes,2));
        for(int i=0;i<nb_colonnes;i++)
        {
            listlab.add(new JLabel("test"));
            panneau_princ.add(listlab.get(i));
            listfields.add(new JTextField());
            panneau_princ.add(listfields.get(i));
        }
        affichecarac();
        affichechamps();
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        
        if(source==ok)
        {
            //on envoie les infos
            //D'abbord on récupère les caractéristiques actuelles dans la BDD
            ArrayList<String> old = new ArrayList<>();
            try {
            old=c1.remplirChampsRequete("SELECT * FROM "+tabactu);
            } catch (SQLException ex) {
                Logger.getLogger(BDDmodification.class.getName()).log(Level.SEVERE, null, ex);
            }
            //on recupère un tableau d'infos
            String[] tabstr=old.get(index).split("#");
            
            
            ArrayList<String> arr = new ArrayList<>();
            arr.add(tabactu);
            
            for(int k=0;k<nb_colonnes;k++)
            {
                arr.add(listfields.get(k).getText());
            }
            
            for(int k=0;k<nb_colonnes;k++)
            {
                arr.add(tabstr[k]);
            }
            
            Test.modification(arr);
            
        }
        if(source==suiv)
        {
            index++;
            if(index>=nb_lignes)
                index=0;
        }
        if(source==prec)
        {
            index--;
            if(index<0)
                index=nb_lignes-1;
        }
        if(source==boutonCHAMBRE)
        {
            tabactu="chambre";
            nb_colonnes=4;
            remplirPanneau();
        }
        if(source==boutonDOCTEUR)
        {
            tabactu="docteur";
            nb_colonnes=2;
            remplirPanneau();
        }
        if(source==boutonMALADE)
        {
            tabactu="malade";
            nb_colonnes=6;
            remplirPanneau();
        }
        if(source==boutonSERVICE)
        {
            tabactu="service";
            nb_colonnes=4;
            remplirPanneau();
        }
        if(source==boutonSOIGNE)
        {
            tabactu="soigne";
            nb_colonnes=2;
            remplirPanneau();
        }
        if(source==boutonHOSPITALISATION)
        {
            tabactu="hospitalisation";
            nb_colonnes=4;
            remplirPanneau();
        }
        if(source==boutonEMPLOYE)
        {
            tabactu="employe";
            nb_colonnes=5;
            remplirPanneau();
        }
        if(source==boutonINFIRMIER)
        {
            tabactu="infirmier";
            nb_colonnes=4;
            remplirPanneau();
        }
        
        affichechamps();
    }
    
    public void affichecarac(){
        
        ArrayList<String> arr = new ArrayList<>();
        try {
            arr=c1.remplirChampsRequete("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME=\'"+tabactu+"\'");
        } catch (SQLException ex) {
            Logger.getLogger(BDDmodification.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int j=0;j<nb_colonnes;j++)
        {
            listlab.get(j).setText(arr.get(j));
        }
        
        this.revalidate();
        this.repaint();
    }
    
    public void affichechamps(){
        ArrayList<String> arr2 = new ArrayList<>();
        try {
            arr2=c1.remplirChampsRequete("SELECT * FROM "+tabactu);
        } catch (SQLException ex) {
            Logger.getLogger(BDDmodification.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] tabstr=arr2.get(index).split("#");
        for(int k=0;k<nb_colonnes;k++)
        {
            listfields.get(k).setText(tabstr[k]);
        }
        
    }
    
    public void updatelignes(){
        try {
            nb_lignes=Integer.parseInt(c1.remplirChampsRequete("SELECT COUNT(*) FROM "+tabactu).get(0).toString());
        } catch (SQLException ex) {
            Logger.getLogger(BDDmodification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
