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
 * Classe SupprimerR�servationV�hicule
 * @author ldatchi
 *
 */
public class SupprimerR�servationV�hicule extends JPanel implements ActionListener{

	/**
	 * Attributs priv�s de la classe SupprimerR�servationV�hicule
	 */
	//Attributs priv�s
	//Panel
	private JPanel panelSupprReservationV�hicule;
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
	public SupprimerR�servationV�hicule(ArrayList<V�hiculeRes> listeV�hiculeRes) {	
	    /**
	     * Instanciation de mes panels "panelSupprReservationV�hicule", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelSupprReservationV�hicule = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelSupprReservationV�hicule", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Background des panels
	    this.panelSupprReservationV�hicule.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelSupprReservationV�hicule", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelSupprReservationV�hicule.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblNomCircuit", "lblTailleCircuit", "lblPaysCircuit" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez choisir le v�hicule � supprimer.");
	    this.lblMessage.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    //Instanciation et remplissage du JComboBox
	    this.jcbListeDuree = new JComboBox<String>();
	    for (V�hiculeRes monV�hiculeRes: listeV�hiculeRes) {
	    	this.jcbListeDuree.addItem(monV�hiculeRes.getModeleV�hicule());
	    }
		this.jcbListeDuree.setMaximumSize(new Dimension(100,30));
	    
	    /**
	     * Mise en place de la couleur d'�criture des label "lblMessage", "lblNomCircuit", "lblTailleCircuit" et "lblPaysCircuit"
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
	     * Ajout des attributs � mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelSupprReservationV�hicule.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelSupprReservationV�hicule.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(jcbListeDuree);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
		
	    //Toujours � la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours � la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelSupprimerReservationV�hicule() {
    	return panelSupprReservationV�hicule;
    }
	
	/**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnValider) {
            String nomMat = jcbListeDuree.getSelectedItem().toString();
            JTextField result = new JTextField ("Erreur");
            if(Modele.suppressionR�servationV�hicule(nomMat)) {
                lblInsertion.setText("Suppression effectu�e."); 
            }
            else {
                lblInsertion.setText("Suppression non effectu�e."); 
            }
        }
	}
}