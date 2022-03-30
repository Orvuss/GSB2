import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe AccueilVisiteur
 * @author ldatchi
 *
 */
public class AccueilVisiteur extends JFrame implements ActionListener{

	/**
	 * Attributs priv�s de la classe AccueilVisiteur
	 */
	//Attributs priv�s
	//Panel
	private JPanel panelAccueilVisiteur;
	private JPanel panelBouton;
	private JPanel panelBtnQuitter;
	
	//Bouton
	private JButton btnR�servation;
	private JButton btnCatalogue;
	private JButton btnD�connexion;
	private JButton btnQuitter;
	
	//Constructeur
	public AccueilVisiteur() {
		//Configuration fenetre
		/**
		 * Titre, localisation, taille etc.. indispensable au d�but de chaque page IHM
		 */
	    this.setTitle("Accueil visiteur");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(700, 500);
	    this.setResizable(false);
	    /**
	     * Instanciation de mes panels "panelAccueilVisiteur", "panelBouton" et "panelBtnQuitter"
	     */
	    //Instanciation des panels
	    this.panelAccueilVisiteur = new JPanel();
	    this.panelBouton = new JPanel();
	    this.panelBtnQuitter = new JPanel();
	    
	    /**
	     * Mise en place des background des panels "panelAccueilVisiteur", "panelBouton" et "panelBtnQuitter"
	     */
	    //Background des panels
	    this.panelAccueilVisiteur.setBackground(Color.white);
	    this.panelBouton.setBackground(Color.black);
	    this.panelBtnQuitter.setBackground(Color.black);
	    this.panelAccueilVisiteur.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelAccueilVisiteur", "panelBouton" et "panelBtnQuitter"
	     */
	    //Disposition des panels
	    this.panelAccueilVisiteur.setLayout(new BorderLayout());
	    this.panelBouton.setLayout(new FlowLayout());
	    this.panelBtnQuitter.setLayout(new FlowLayout());
	    
	    /**
	     * Instanciation de mes boutons "btnR�servation", "btnCatalogue", "btnD�connexion" et "btnQuitter"
	     * avec l'�coute des boutons
	     */
	    //Instanciation des boutons
	    this.btnR�servation = new JButton("R�servation");
	    this.btnR�servation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnR�servation.addActionListener(this);
	    
	    this.btnCatalogue = new JButton("Catalogue des pr�ts");
	    this.btnCatalogue.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnCatalogue.addActionListener(this);
	    
	    this.btnD�connexion = new JButton("D�connexion");
	    this.btnD�connexion.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnD�connexion.addActionListener(this);
	    
	    this.btnQuitter = new JButton("Quitter");
	    this.btnQuitter.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnQuitter.addActionListener(this);

	    /**
	     * Ajout des attributs � mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelAccueilVisiteur.add(panelBouton, BorderLayout.PAGE_START);
	    this.panelAccueilVisiteur.add(panelBtnQuitter, BorderLayout.PAGE_END);
	    
	    this.panelBouton.add(btnR�servation);
	    this.panelBouton.add(btnCatalogue);
	    
	    this.panelBtnQuitter.add(btnD�connexion);
	    this.panelBtnQuitter.add(btnQuitter);
	    
	    //Toujours � la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours � la fin de la classe
  		 */
	    this.setAlwaysOnTop(true);
	    this.getContentPane().add(panelAccueilVisiteur);
  		this.setVisible(true);
	}	
	/**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnR�servation) {
			this.dispose();
			R�servationPage maR�servation = new R�servationPage();
		}
		if(e.getSource() == btnCatalogue) {
			this.dispose();
			AffichageR�servationPage maR�servation= new AffichageR�servationPage();
		}
		if(e.getSource() == btnD�connexion) {
			this.dispose();
			ChoixConnexion monChoixConnexion = new ChoixConnexion();
		}
		if(e.getSource() == btnQuitter) {
			this.dispose();
		}
	}
}