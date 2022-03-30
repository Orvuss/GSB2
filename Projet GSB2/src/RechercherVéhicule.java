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
 * Classe RechercherV�hicule
 * @author ldatchi
 *
 */
public class RechercherV�hicule extends JPanel implements ActionListener{

	/**
	 * Attributs priv�s de la classe RechercherV�hicule
	 */
	//Attributs priv�s
	//Panel
	private JPanel panelRechercherV�hicule;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
	private JLabel lblMessage;
	private JLabel lblInsertion;
	
	//JComboBox
    private JComboBox<String> jcbModeleV�hicule;
	
	//Bouton
	private JButton btnValider;
	
	//Constructeur
	public RechercherV�hicule(ArrayList<V�hiculeRes> listeV�hicule) {	
	    /**
	     * Instanciation de mes panels "panelRechercherV�hicule", "panelMessage" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelRechercherV�hicule = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelRechercherV�hicule", "panelMessage" et "panelChamps"
	     */
	    //Background des panels
	    this.panelRechercherV�hicule.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(Color.white);
	    this.panelChamps.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelRechercherV�hicule", "panelMessage" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelRechercherV�hicule.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblInsertion" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez choisir le v�hicule � rechercher.");
	    this.lblMessage.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    //Instanciation et remplissage du JComboBox
	    this.jcbModeleV�hicule = new JComboBox<String>();
	    for (V�hiculeRes monV�hicule: listeV�hicule) {
	    	this.jcbModeleV�hicule.addItem(monV�hicule.getModeleV�hicule());
	    }
		this.jcbModeleV�hicule.setMaximumSize(new Dimension(100,30));
	    
	    /**
	     * Mise en place de la couleur d'�criture des label "lblMessage"
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
	     * Ajout des attributs � mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelRechercherV�hicule.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelRechercherV�hicule.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(jcbModeleV�hicule);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
		
	    //Toujours � la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours � la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelRechercherV�hicule() {
    	return panelRechercherV�hicule;
    }
	
	/**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnValider) {
            String nomMat = jcbModeleV�hicule.getSelectedItem().toString();
            JTextField result = new JTextField ("Erreur");
            if(Modele.rechercherV�hicule(nomMat)) {
                lblInsertion.setText("Le v�hicule est bien pr�sent."); 
            }
            else {
                lblInsertion.setText("Le v�hicule n'est pas pr�sent."); 
            }
        }
	}
}