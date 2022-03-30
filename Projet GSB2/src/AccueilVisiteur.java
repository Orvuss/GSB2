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
	 * Attributs privés de la classe AccueilVisiteur
	 */
	//Attributs privés
	//Panel
	private JPanel panelAccueilVisiteur;
	private JPanel panelBouton;
	private JPanel panelBtnQuitter;
	
	//Bouton
	private JButton btnRéservation;
	private JButton btnCatalogue;
	private JButton btnDéconnexion;
	private JButton btnQuitter;
	
	//Constructeur
	public AccueilVisiteur() {
		//Configuration fenetre
		/**
		 * Titre, localisation, taille etc.. indispensable au début de chaque page IHM
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
	     * Instanciation de mes boutons "btnRéservation", "btnCatalogue", "btnDéconnexion" et "btnQuitter"
	     * avec l'écoute des boutons
	     */
	    //Instanciation des boutons
	    this.btnRéservation = new JButton("Réservation");
	    this.btnRéservation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnRéservation.addActionListener(this);
	    
	    this.btnCatalogue = new JButton("Catalogue des prêts");
	    this.btnCatalogue.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnCatalogue.addActionListener(this);
	    
	    this.btnDéconnexion = new JButton("Déconnexion");
	    this.btnDéconnexion.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnDéconnexion.addActionListener(this);
	    
	    this.btnQuitter = new JButton("Quitter");
	    this.btnQuitter.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnQuitter.addActionListener(this);

	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelAccueilVisiteur.add(panelBouton, BorderLayout.PAGE_START);
	    this.panelAccueilVisiteur.add(panelBtnQuitter, BorderLayout.PAGE_END);
	    
	    this.panelBouton.add(btnRéservation);
	    this.panelBouton.add(btnCatalogue);
	    
	    this.panelBtnQuitter.add(btnDéconnexion);
	    this.panelBtnQuitter.add(btnQuitter);
	    
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
	    this.setAlwaysOnTop(true);
	    this.getContentPane().add(panelAccueilVisiteur);
  		this.setVisible(true);
	}	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRéservation) {
			this.dispose();
			RéservationPage maRéservation = new RéservationPage();
		}
		if(e.getSource() == btnCatalogue) {
			this.dispose();
			AffichageRéservationPage maRéservation= new AffichageRéservationPage();
		}
		if(e.getSource() == btnDéconnexion) {
			this.dispose();
			ChoixConnexion monChoixConnexion = new ChoixConnexion();
		}
		if(e.getSource() == btnQuitter) {
			this.dispose();
		}
	}
}