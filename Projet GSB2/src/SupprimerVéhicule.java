import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Classe SupprimerVéhicule
 * @author ldatchi
 *
 */
public class SupprimerVéhicule extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe SupprimerVéhicule
	 */
	//Attributs privés
	//Panel
	private JPanel panelSupprVéhicule;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
	private JLabel lblMessage;
	private JLabel lblInsertion;
	
	//JComboBox
    private JComboBox<String> jcbListeDuree;
	
	//Bouton
	private JButton btnValider;
	
	//Constructeur
	public SupprimerVéhicule(ArrayList<Véhicule> listeVéhicule) {	
	    /**
	     * Instanciation de mes panels "panelSupprVéhicule", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelSupprVéhicule = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelSupprVéhicule", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Background des panels
	    this.panelSupprVéhicule.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelSupprVéhicule", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelSupprVéhicule.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblNomCircuit", "lblTailleCircuit", "lblPaysCircuit" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez choisir le véhicule à supprimer.");
	    this.lblMessage.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    //Instanciation et remplissage du JComboBox
	    this.jcbListeDuree = new JComboBox<String>();
	    for (Véhicule monVéhicule: listeVéhicule) {
	    	this.jcbListeDuree.addItem(monVéhicule.getModeleV());
	    }
		this.jcbListeDuree.setMaximumSize(new Dimension(100,30));
	    
	    /**
	     * Mise en place de la couleur d'écriture des label "lblMessage", "lblNomCircuit", "lblTailleCircuit" et "lblPaysCircuit"
	     */
	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);

	    /**
         * Instanciation des boutons "btnValider" et "btnRetour"
         */
	    //Instanciation des boutons
	    this.btnValider = new JButton("Valider");
	    this.btnValider.addActionListener(this);
	    
	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelSupprVéhicule.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelSupprVéhicule.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(jcbListeDuree);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
		
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelSupprimerVéhicule() {
    	return panelSupprVéhicule;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnValider) {
            String modeleVe = jcbListeDuree.getSelectedItem().toString();
            JTextField result = new JTextField ("Erreur");
            if(Modele.suppressionVéhicule(modeleVe)) {
                lblInsertion.setText("Suppression effectuée."); 
            }
            else {
                lblInsertion.setText("Suppression non effectuée."); 
            }
        }
	}
}