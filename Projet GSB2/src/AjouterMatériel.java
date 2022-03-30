import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Classe AjouterMatériel
 * @author ldatchi
 *
 */
public class AjouterMatériel extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe AjouterMatériel
	 */
	//Attributs privés
	//Panel
	private JPanel panelAjouterMatériel;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
	private JLabel lblMessage;
	private JLabel lblLargeur;
	private JLabel lblLongueur;
	private JLabel lblType;
	private JLabel lblInsertion;
	
	//JTextField
	private JTextField jtfLargeur;
	private JTextField jtfLongueur;
	private JTextField jtfType;
	
	//Bouton
	private JButton btnValider;
	
	//Constructeur
	public AjouterMatériel() {	
	    /**
	     * Instanciation de mes panels "panelAjouterMatériel", "panelMessage" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelAjouterMatériel = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelAjouterMatériel", "panelMessage" et "panelChamps"
	     */
	    //Background des panels
	    this.panelAjouterMatériel.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelAjouterMatériel", "panelMessage" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelAjouterMatériel.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblLargeur", "lblLongueur", "lblType" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez remplir les champs pour ajouter un matériel.");
	    this.lblMessage.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    this.lblLargeur = new JLabel("Largeur du matériel :");
	    this.lblLongueur = new JLabel("Longueur du matériel :");
	    this.lblType = new JLabel("Type du matériel :");
	    this.lblInsertion = new JLabel("");
	    
	    /**
	     * Instanciation des entrées "jtfLargeur", "jtfLongueur" et "jtfType"
	     */
	    //Instanciation des entrées
	    this.jtfLargeur = new JTextField();
	    this.jtfLargeur.setPreferredSize(new Dimension(100, 30));
	    this.jtfLongueur = new JTextField();
	    this.jtfLongueur.setPreferredSize(new Dimension(100, 30));
	    this.jtfType = new JTextField();
	    this.jtfType.setPreferredSize(new Dimension(100, 30));

	    /**
	     * Mise en place de la couleur d'écriture du label "lblMessage"
	     */
	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);
 
	    /**
         * Instanciation du bouton "btnValider"
         */
	    //Instanciation des boutons
	    this.btnValider = new JButton("Valider");
	    this.btnValider.addActionListener(this);
	    
	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelAjouterMatériel.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelAjouterMatériel.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblLargeur);	  
	    this.panelChamps.add(jtfLargeur);
	    this.panelChamps.add(lblLongueur);	  
	    this.panelChamps.add(jtfLongueur);
	    this.panelChamps.add(lblType);	  
	    this.panelChamps.add(jtfType);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
		
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelAjouterMatériel() {
    	return panelAjouterMatériel;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnValider) {
            String uneLargeur = jtfLargeur.getText();
            String uneLongueur = jtfLongueur.getText();
            String unType = jtfType.getText();
            boolean rep = Modele.AjouterMatériel(uneLargeur, uneLongueur, unType);
            if(rep) {
            	lblInsertion.setText("Un matériel à été ajoutée");
            }
            else {
            	lblInsertion.setText("ERREUR, l'ajout du matériel n'a pas pu se faire");
            }
        }
	}
}