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
 * Classe AjouterVéhicule
 * @author ldatchi
 *
 */
public class AjouterVéhicule extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe AjouterVéhicule
	 */
	//Attributs privés
	//Panel
	private JPanel panelAjouterVéhicule;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
	private JLabel lblMessage;
	private JLabel lblImmat;
	private JLabel lblModele;
	private JLabel lblMarque;
	private JLabel lblNbPlaces;
	private JLabel lblInsertion;
	
	//JTextField
	private JTextField jtfImmat;
	private JTextField jtfModele;
	private JTextField jtfMarque;
	private JTextField jtfNbPlaces;

	//Bouton
	private JButton btnValider;
	
	//Constructeur
	public AjouterVéhicule() {	
	    /**
	     * Instanciation de mes panels "panelAjouterVéhicule", "panelMessage" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelAjouterVéhicule = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelAjouterVéhicule", "panelMessage" et "panelChamps"
	     */
	    //Background des panels
	    this.panelAjouterVéhicule.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelAjouterVéhicule", "panelMessage" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelAjouterVéhicule.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblImmat", "lblModele", "lblMarque", "lblNbPlaces" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez remplir les champs pour réserver un véhicule.");
	    this.lblMessage.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    this.lblImmat = new JLabel("Immatriculation du véhicule :");
	    this.lblModele = new JLabel("Modele du véhicule :");
	    this.lblMarque = new JLabel("Marque du véhicule :");
	    this.lblNbPlaces = new JLabel("Nombre de places du véhicule :");
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    /**
	     * Instanciation des entrées "jtfImmat", "jtfModele", "jtfMarque" et "jtfNbPlaces"
	     */
	    //Instanciation des entrées
	    this.jtfImmat = new JTextField();
	    this.jtfImmat.setPreferredSize(new Dimension(100, 30));
	    this.jtfModele = new JTextField();
	    this.jtfModele.setPreferredSize(new Dimension(100, 30));
	    this.jtfMarque = new JTextField();
	    this.jtfMarque.setPreferredSize(new Dimension(100, 30));
	    this.jtfNbPlaces = new JTextField();
	    this.jtfNbPlaces.setPreferredSize(new Dimension(100, 30));
	    
	    /**
	     * Mise en place de la couleur d'écriture de label "lblMessage"
	     */
	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);
	    
	    /**
         * Instanciation de bouton "btnValider"
         */
	    //Instanciation des boutons
	    this.btnValider = new JButton("Valider");
	    this.btnValider.addActionListener(this);
	    
	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelAjouterVéhicule.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelAjouterVéhicule.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblImmat);
	    this.panelChamps.add(jtfImmat);
	    this.panelChamps.add(lblModele);
	    this.panelChamps.add(jtfModele);
	    this.panelChamps.add(lblMarque);	  
	    this.panelChamps.add(jtfMarque);
	    this.panelChamps.add(lblNbPlaces);	  
	    this.panelChamps.add(jtfNbPlaces);
	    
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
		
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelAjouterVéhicule() {
    	return panelAjouterVéhicule;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnValider) {
        	String unImmat = jtfImmat.getText();
            String unModele = jtfModele.getText();
            String uneMarque = jtfMarque.getText();
            String unNbPlaces = jtfNbPlaces.getText();
            boolean rep = Modele.AjouterVehicule(unImmat, unModele, uneMarque, unNbPlaces);
            if(rep) {
            	lblInsertion.setText("Un véhicule à été ajoutée");
            }
            else {
            	lblInsertion.setText("ERREUR, l'ajout du véhicule n'a pas pu se faire");
            }
        }
	}
}