import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe AccueilDirecteur
 *
 */
public class AccueilDirecteur extends JFrame implements ActionListener{

	/**
	 * Attributs privés de la classe AccueilDirecteur
	 */
	//Attributs privés
	//Panel
	private JPanel panelAccueilDirecteur;
	private JPanel panelBouton;
	private JPanel panelBtnQuitter;
	
	//Bouton
	private JButton btnVehicule;
	private JButton btnMateriel;
	private JButton btnDéconnexion;
	private JButton btnQuitter;
	
	//Constructeur
	public AccueilDirecteur() {
		//Configuration fenetre
		/**
		 * Titre, localisation, taille etc.. indispensable au début de chaque page IHM
		 */
	    this.setTitle("Accueil directeur");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(700, 500);
	    this.setResizable(true);
	    /**
	     * Instanciation de mes panels "panelAccueilDirecteur", "panelBouton" et "panelBtnQuitter"
	     */
	    //Instanciation des panels
	    this.panelAccueilDirecteur = new JPanel();
	    this.panelBouton = new JPanel();
	    this.panelBtnQuitter = new JPanel();
	    
	    /**
	     * Mise en place des background des panels "panelAccueilDirecteur", "panelBouton" et "panelBtnQuitter"
	     */
	    //Background des panels
	    this.panelAccueilDirecteur.setBackground(Color.white);
	    this.panelBouton.setBackground(Color.black);
	    this.panelBtnQuitter.setBackground(Color.black);
	    this.panelAccueilDirecteur.setBackground(SystemColor.activeCaption);
	    
	    /**
	     * Mise en place des dispositions des panels "panelAccueilDirecteur", "panelBouton" et "panelBtnQuitter"
	     */
	    //Disposition des panels
	    this.panelAccueilDirecteur.setLayout(new BorderLayout());
	    this.panelBouton.setLayout(new FlowLayout());
	    this.panelBtnQuitter.setLayout(new FlowLayout());
	    
	    /**
	     * Instanciation de mes boutons "btnStatistiques", "btnPdf", "btnDéconnexion" et "btnQuitter"
	     * avec l'écoute des boutons
	     */
	    //Instanciation des boutons
	    this.btnVehicule = new JButton("Liste des Véhicules réservés");
	    this.btnVehicule.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnVehicule.addActionListener(this);
	    
	    this.btnMateriel = new JButton("Liste des Matériaux réservés");
	    this.btnMateriel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnMateriel.addActionListener(this);
	    
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
	    this.panelAccueilDirecteur.add(panelBouton, BorderLayout.PAGE_START);
	    this.panelAccueilDirecteur.add(panelBtnQuitter, BorderLayout.PAGE_END);
	    
	    this.panelBouton.add(btnVehicule);
	    this.panelBouton.add(btnMateriel);
	    
	    this.panelBtnQuitter.add(btnDéconnexion);
	    this.panelBtnQuitter.add(btnQuitter);
	    
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
	    this.setAlwaysOnTop(true);
	    this.getContentPane().add(panelAccueilDirecteur);
  		this.setVisible(true);
	}	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnVehicule) {
			ArrayList<VéhiculeRes> listeVéhicule;
			listeVéhicule = new ArrayList<VéhiculeRes>();
			listeVéhicule = Modele.affichageVéhiculeRes();
			this.panelAccueilDirecteur.removeAll();
			this.panelAccueilDirecteur.add(new AfficherVehiculeDirecteur(listeVéhicule).getMonPanelAfficherVehiculeDirecteur());
			this.panelAccueilDirecteur.revalidate();
			this.panelAccueilDirecteur.repaint();
		}
		if(e.getSource() == btnMateriel) {
			ArrayList<MatérielRes> listeMatérielRes;
			listeMatérielRes = new ArrayList<MatérielRes>();
			listeMatérielRes = Modele.affichageMatérielRes();
			this.panelAccueilDirecteur.removeAll();
			this.panelAccueilDirecteur.add(new AfficherMaterielDirecteur(listeMatérielRes).getMonPanelAfficherMaterielDirecteur());
			this.panelAccueilDirecteur.revalidate();
			this.panelAccueilDirecteur.repaint();
			//Ajoute la page
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