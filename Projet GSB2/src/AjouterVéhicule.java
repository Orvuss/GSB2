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
 * Classe AjouterV�hicule
 * @author ldatchi
 *
 */
public class AjouterV�hicule extends JPanel implements ActionListener{

	/**
	 * Attributs priv�s de la classe AjouterV�hicule
	 */
	//Attributs priv�s
	//Panel
	private JPanel panelAjouterV�hicule;
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
	public AjouterV�hicule() {	
	    /**
	     * Instanciation de mes panels "panelAjouterV�hicule", "panelMessage" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelAjouterV�hicule = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelAjouterV�hicule", "panelMessage" et "panelChamps"
	     */
	    //Background des panels
	    this.panelAjouterV�hicule.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelAjouterV�hicule", "panelMessage" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelAjouterV�hicule.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblImmat", "lblModele", "lblMarque", "lblNbPlaces" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez remplir les champs pour r�server un v�hicule.");
	    this.lblMessage.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    this.lblImmat = new JLabel("Immatriculation du v�hicule :");
	    this.lblModele = new JLabel("Modele du v�hicule :");
	    this.lblMarque = new JLabel("Marque du v�hicule :");
	    this.lblNbPlaces = new JLabel("Nombre de places du v�hicule :");
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    /**
	     * Instanciation des entr�es "jtfImmat", "jtfModele", "jtfMarque" et "jtfNbPlaces"
	     */
	    //Instanciation des entr�es
	    this.jtfImmat = new JTextField();
	    this.jtfImmat.setPreferredSize(new Dimension(100, 30));
	    this.jtfModele = new JTextField();
	    this.jtfModele.setPreferredSize(new Dimension(100, 30));
	    this.jtfMarque = new JTextField();
	    this.jtfMarque.setPreferredSize(new Dimension(100, 30));
	    this.jtfNbPlaces = new JTextField();
	    this.jtfNbPlaces.setPreferredSize(new Dimension(100, 30));
	    
	    /**
	     * Mise en place de la couleur d'�criture de label "lblMessage"
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
	     * Ajout des attributs � mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelAjouterV�hicule.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelAjouterV�hicule.add(panelChamps, BorderLayout.CENTER);
	    
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
		
	    //Toujours � la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours � la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelAjouterV�hicule() {
    	return panelAjouterV�hicule;
    }
	
	/**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnValider) {
        	String unImmat = jtfImmat.getText();
            String unModele = jtfModele.getText();
            String uneMarque = jtfMarque.getText();
            String unNbPlaces = jtfNbPlaces.getText();
            boolean rep = Modele.AjouterVehicule(unImmat, unModele, uneMarque, unNbPlaces);
            if(rep) {
            	lblInsertion.setText("Un v�hicule � �t� ajout�e");
            }
            else {
            	lblInsertion.setText("ERREUR, l'ajout du v�hicule n'a pas pu se faire");
            }
        }
	}
}