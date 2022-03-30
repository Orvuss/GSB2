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
 * Classe RechercherMatériel
 * @author ldatchi
 *
 */
public class RechercherMatériel extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe RechercherMatériel
	 */
	//Attributs privés
	//Panel
	private JPanel panelRechercherMatériel;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
	private JLabel lblMessage;
	private JLabel lblInsertion;
	
	//JComboBox
    private JComboBox<String> jcbNomMatériel;
	
	//Bouton
	private JButton btnValider;
	
	//Constructeur
	public RechercherMatériel(ArrayList<MatérielRes> listeMatériel) {	
	    /**
	     * Instanciation de mes panels "panelRechercherMatériel", "panelMessage" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelRechercherMatériel = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelRechercherMatériel", "panelMessage" et "panelChamps"
	     */
	    //Background des panels
	    this.panelRechercherMatériel.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelRechercherMatériel", "panelMessage" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelRechercherMatériel.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez choisir le matériel à rechercher.");
	    this.lblMessage.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    //Instanciation et remplissage du JComboBox
	    this.jcbNomMatériel = new JComboBox<String>();
	    for (MatérielRes monMatériel: listeMatériel) {
	    	this.jcbNomMatériel.addItem(monMatériel.getNomMatériel());
	    } 
		this.jcbNomMatériel.setMaximumSize(new Dimension(100,30));
	    
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
	    this.panelRechercherMatériel.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelRechercherMatériel.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(jcbNomMatériel);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
		
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelRechercherMatériel() {
    	return panelRechercherMatériel;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnValider) {
            String nomMat = jcbNomMatériel.getSelectedItem().toString();
            JTextField result = new JTextField ("Erreur");
            if(Modele.rechercherMatériel(nomMat)) {
                lblInsertion.setText("Le matériel est bien présent."); 
            }
            else {
                lblInsertion.setText("Le matériel n'est pas présent."); 
            }
        }
	}
}