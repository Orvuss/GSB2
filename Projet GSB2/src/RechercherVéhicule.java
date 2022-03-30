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
 * Classe RechercherVéhicule
 * @author ldatchi
 *
 */
public class RechercherVéhicule extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe RechercherVéhicule
	 */
	//Attributs privés
	//Panel
	private JPanel panelRechercherVéhicule;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
	private JLabel lblMessage;
	private JLabel lblInsertion;
	
	//JComboBox
    private JComboBox<String> jcbModeleVéhicule;
	
	//Bouton
	private JButton btnValider;
	
	//Constructeur
	public RechercherVéhicule(ArrayList<VéhiculeRes> listeVéhicule) {	
	    /**
	     * Instanciation de mes panels "panelRechercherVéhicule", "panelMessage" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelRechercherVéhicule = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelRechercherVéhicule", "panelMessage" et "panelChamps"
	     */
	    //Background des panels
	    this.panelRechercherVéhicule.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(Color.white);
	    this.panelChamps.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelRechercherVéhicule", "panelMessage" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelRechercherVéhicule.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblInsertion" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez choisir le véhicule à rechercher.");
	    this.lblMessage.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    //Instanciation et remplissage du JComboBox
	    this.jcbModeleVéhicule = new JComboBox<String>();
	    for (VéhiculeRes monVéhicule: listeVéhicule) {
	    	this.jcbModeleVéhicule.addItem(monVéhicule.getModeleVéhicule());
	    }
		this.jcbModeleVéhicule.setMaximumSize(new Dimension(100,30));
	    
	    /**
	     * Mise en place de la couleur d'écriture des label "lblMessage"
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
	    this.panelRechercherVéhicule.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelRechercherVéhicule.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(jcbModeleVéhicule);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
		
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelRechercherVéhicule() {
    	return panelRechercherVéhicule;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnValider) {
            String nomMat = jcbModeleVéhicule.getSelectedItem().toString();
            JTextField result = new JTextField ("Erreur");
            if(Modele.rechercherVéhicule(nomMat)) {
                lblInsertion.setText("Le véhicule est bien présent."); 
            }
            else {
                lblInsertion.setText("Le véhicule n'est pas présent."); 
            }
        }
	}
}