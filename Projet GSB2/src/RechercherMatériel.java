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
 * Classe RechercherMat�riel
 * @author ldatchi
 *
 */
public class RechercherMat�riel extends JPanel implements ActionListener{

	/**
	 * Attributs priv�s de la classe RechercherMat�riel
	 */
	//Attributs priv�s
	//Panel
	private JPanel panelRechercherMat�riel;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
	private JLabel lblMessage;
	private JLabel lblInsertion;
	
	//JComboBox
    private JComboBox<String> jcbNomMat�riel;
	
	//Bouton
	private JButton btnValider;
	
	//Constructeur
	public RechercherMat�riel(ArrayList<Mat�rielRes> listeMat�riel) {	
	    /**
	     * Instanciation de mes panels "panelRechercherMat�riel", "panelMessage" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelRechercherMat�riel = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelRechercherMat�riel", "panelMessage" et "panelChamps"
	     */
	    //Background des panels
	    this.panelRechercherMat�riel.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelRechercherMat�riel", "panelMessage" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelRechercherMat�riel.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez choisir le mat�riel � rechercher.");
	    this.lblMessage.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    //Instanciation et remplissage du JComboBox
	    this.jcbNomMat�riel = new JComboBox<String>();
	    for (Mat�rielRes monMat�riel: listeMat�riel) {
	    	this.jcbNomMat�riel.addItem(monMat�riel.getNomMat�riel());
	    } 
		this.jcbNomMat�riel.setMaximumSize(new Dimension(100,30));
	    
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
	    this.panelRechercherMat�riel.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelRechercherMat�riel.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(jcbNomMat�riel);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
		
	    //Toujours � la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours � la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelRechercherMat�riel() {
    	return panelRechercherMat�riel;
    }
	
	/**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnValider) {
            String nomMat = jcbNomMat�riel.getSelectedItem().toString();
            JTextField result = new JTextField ("Erreur");
            if(Modele.rechercherMat�riel(nomMat)) {
                lblInsertion.setText("Le mat�riel est bien pr�sent."); 
            }
            else {
                lblInsertion.setText("Le mat�riel n'est pas pr�sent."); 
            }
        }
	}
}