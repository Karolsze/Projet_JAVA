/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import tempo.Connexion;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author 931702281
 */
public abstract class BDDinteractionBASE extends JFrame{
    
    public Connexion c1;
    
    protected JLabel TopText1;
    protected JLabel Res;
    protected JLabel lab1;
    protected JLabel lab2;
    protected JLabel lab3;
    protected JLabel lab4;
    protected JLabel resulatstotal;

    protected JComboBox list1;
    protected JComboBox list2;
    protected JComboBox list3;
    protected JComboBox list4;
    protected JComboBox list5;
    
    protected JButton ok;
    protected JButton prec;
    protected JButton suiv;
    
    protected int index = -1;
    
    public BDDinteractionBASE(Connexion c1 , String Text1 , String Lab1 , String Lab2 , String Lab3 , String Lab4,
            String rech1, String rech2 , String rech3 , String rech4) throws SQLException{
        
        this.c1=c1;
        this.setLayout(new GridBagLayout());
        
        //Liste des éléments de cette fenetre
        TopText1 = new JLabel(Text1);
        Res = new JLabel ("RESULTATS");
        lab1 = new JLabel(Lab1);
        lab2 = new JLabel(Lab2);
        lab3 = new JLabel(Lab3);
        lab4 = new JLabel(Lab4);
        resulatstotal = new JLabel("<html><html>");
        //on met le texte au centre
        TopText1.setHorizontalAlignment(JLabel.CENTER);
        Res.setHorizontalAlignment(JLabel.CENTER);
        lab1.setHorizontalAlignment(JLabel.CENTER);
        lab2.setHorizontalAlignment(JLabel.CENTER);
        lab4.setHorizontalAlignment(JLabel.CENTER);
        lab3.setHorizontalAlignment(JLabel.CENTER);
        resulatstotal.setHorizontalAlignment(JLabel.CENTER);
        //on ajuste la taille du texte
        TopText1.setFont(new Font("Arial", Font.BOLD ,70));
        Res.setFont(new Font("Arial", Font.BOLD ,70));
        
        
        //Listes déroulantes, à créés en f° de la BDD
        
        //nom
        String recherche1 = rech1;
        ArrayList<String> resultat1 = c1.remplirChampsRequete(recherche1);
        String[] arr1 = conversion(resultat1);
        list1 = new JComboBox(arr1);
        
        //Prenom
        String recherche2 = rech2;
        ArrayList<String> resultat2 = c1.remplirChampsRequete(recherche2);
        String[] arr2 = conversion(resultat2);
        list2 = new JComboBox(arr2);
        
        //Spécialité
        String recherche3 = rech3;
        ArrayList<String> resultat3 = c1.remplirChampsRequete(recherche3);
        String[] arr3 = conversion(resultat3);
        list3 = new JComboBox(arr3); 
        
        //Numéros de docteur
        String recherche4 = rech4;
        ArrayList<String> resultat4 = c1.remplirChampsRequete(recherche4);
        String[] arr4 = conversion(resultat4);;
        list4 = new JComboBox(arr4);
        
        //différents boutons + la liste de résultats
        ok = new JButton("OK");
        prec = new JButton("Précédent");
        suiv = new JButton("Suivant");
        list5=new JComboBox();
        
        //Mise en place du GridBagLayout
        GridBagConstraints c = new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.weightx=1; c.weighty=1;
        
        //Remplissage du Layout
        
        //...avec les JLabel
        ////c.insets=new Insets(3,3,3,3); //padding exterieur
        c.ipady=0;
        c.gridx=0;
        c.gridy=0;
        c.gridheight=7;
        c.gridwidth=2;
        this.add(TopText1,c);
        //
        c.ipady=40;
        c.gridx=2;
        c.gridy=0;
        c.gridheight=7;
        c.gridwidth=2;
        this.add(Res,c);
        //
        c.ipady=0;
        c.gridx=0;
        c.gridy=7;
        c.gridheight=3;
        c.gridwidth=1;
        this.add(lab1,c);
        //
        c.ipady=0;
        c.gridx=0;
        c.gridy=10;
        c.gridheight=3;
        c.gridwidth=1;
        this.add(lab2,c);
        //
        c.ipady=0;
        c.gridx=0;
        c.gridy=13;
        c.gridheight=3;
        c.gridwidth=1;
        this.add(lab3,c);
        //
        c.ipady=0;
        c.gridx=0;
        c.gridy=16;
        c.gridheight=3;
        c.gridwidth=1;
        this.add(lab4,c);
        
        //le bouton ok
        c.ipady=0;
        c.gridx=0;
        c.gridy=19;
        c.gridheight=1;
        c.gridwidth=2;
        this.add(ok,c);
        
        //les liste déroulantes
        c.ipady=0;
        c.gridx=1;
        c.gridy=7;
        c.gridheight=3;
        c.gridwidth=1;
        this.add(list1,c);
        //
        c.ipady=0;
        c.gridx=1;
        c.gridy=10;
        c.gridheight=3;
        c.gridwidth=1;
        this.add(list2,c);
        //
        c.ipady=0;
        c.gridx=1;
        c.gridy=13;
        c.gridheight=3;
        c.gridwidth=1;
        this.add(list3,c);
        //
        c.ipady=0;
        c.gridx=1;
        c.gridy=16;
        c.gridheight=3;
        c.gridwidth=1;
        this.add(list4,c);
        
        //on ajoute le JLabel qui contient les résultats et les boutons de navigation
        c.ipady=0;
        c.gridx=2;
        c.gridy=7;
        c.gridheight=9;
        c.gridwidth=2;
        this.add(resulatstotal,c);
        //
        c.ipady=0;
        c.gridx=2;
        c.gridy=19;
        c.gridheight=1;
        c.gridwidth=1;
        this.add(prec,c);
        //
        c.ipady=0;
        c.gridx=3;
        c.gridy=19;
        c.gridheight=1;
        c.gridwidth=1;
        this.add(suiv,c);
        //
        c.ipady=0;
        c.gridx=2;
        c.gridy=16;
        c.gridheight=3;
        c.gridwidth=2;
        this.add(list5,c);
        
        
        //this.add(listnom); this.add(listprenom); this.add(listspe); this.add(listnum);
        
        this.setSize(1440,810);
        this.setVisible(true);
        
    }
    
    //conversion de l'array + ajout d'un champ vide
    public static String[] conversion(ArrayList<String> arr)
    {
        int l = arr.size();
        String[] tabstr = new String[l+1];
        tabstr[0]="";
        for(int i=1;i<=l;i++)
        {
            tabstr[i]=arr.get(i-1);
        }
        return tabstr;
    }
    
    abstract void affiche_resultat(ArrayList<ArrayList<String>> arr);
    abstract ArrayList<String> getSelect();
}
