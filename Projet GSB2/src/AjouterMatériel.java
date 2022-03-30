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
 * Classe AjouterMat�riel
 * @author ldatchi
 *
 */
public class AjouterMat�riel extends JPanel implements ActionListener{

	/**
	 * Attributs priv�s de la classe AjouterMat�riel
	 */
	//Attributs priv�s
	//Panel
	private JPanel panelAjouterMat�riel;
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
	public AjouterMat�riel() {	
	    /**
	     * Instanciation de mes panels "panelAjouterMat�riel", "panelMessage" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelAjouterMat�riel = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelAjouterMat�riel", "panelMessage" et "panelChamps"
	     */
	    //Background des panels
	    this.panelAjouterMat�riel.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelAjouterMat�riel", "panelMessage" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelAjouterMat�riel.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblLargeur", "lblLongueur", "lblType" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez remplir les champs pour ajouter un mat�riel.");
	    this.lblMessage.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    this.lblLargeur = new JLabel("Largeur du mat�riel :");
	    this.lblLongueur = new JLabel("Longueur du mat�riel :");
	    this.lblType = new JLabel("Type du mat�riel :");
	    this.lblInsertion = new JLabel("");
	    
	    /**
	     * Instanciation des entr�es "jtfLargeur", "jtfLongueur" et "jtfType"
	     */
	    //Instanciation des entr�es
	    this.jtfLargeur = new JTextField();
	    this.jtfLargeur.setPreferredSize(new Dimension(100, 30));
	    this.jtfLongueur = new JTextField();
	    this.jtfLongueur.setPreferredSize(new Dimension(100, 30));
	    this.jtfType = new JTextField();
	    this.jtfType.setPreferredSize(new Dimension(100, 30));

	    /**
	     * Mise en place de la couleur d'�criture du label "lblMessage"
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
	    this.panelAjouterMat�riel.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelAjouterMat�riel.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblLargeur);	  
	    this.panelChamps.add(jtfLargeur);
	    this.panelChamps.add(lblLongueur);	  
	    this.panelChamps.add(jtfLongueur);
	    this.panelChamps.add(lblType);	  
	    this.panelChamps.add(jtfType);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
		
	    //Toujours � la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours � la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelAjouterMat�riel() {
    	return panelAjouterMat�riel;
    }
	
	/**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnValider) {
            String uneLargeur = jtfLargeur.getText();
            String uneLongueur = jtfLongueur.getText();
            String unType = jtfType.getText();
            boolean rep = Modele.AjouterMat�riel(uneLargeur, uneLongueur, unType);
            if(rep) {
            	lblInsertion.setText("Un mat�riel � �t� ajout�e");
            }
            else {
            	lblInsertion.setText("ERREUR, l'ajout du mat�riel n'a pas pu se faire");
            }
        }
	}
}