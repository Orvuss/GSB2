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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Classe AffichageRéservationPage
 * @author ldatchi
 *
 */
public class AffichageRéservationPage extends JFrame implements ActionListener{

	/**
	 * Attributs privés de la classe AffichageRéservationPage
	 */
	//Attributs privés
	//Panel
	private JPanel panelAffichageResPage;
	private JPanel panelBouton;
	
	//Jmenu
	private JMenu jmMenu;
	
	//JMenuBar
	private JMenuBar jmbBarre;
	
	//JmenuItem
	private JMenuItem jmiRetour;
	private JMenuItem jmiQuitter;
	
	//Bouton
	private JButton btnVéhicule;
	private JButton btnMatériel;
	
	//Constructeur
	public AffichageRéservationPage() {
		//Configuration fenetre
		/**
		 * Titre, localisation, taille etc.. indispensable au début de chaque page IHM
		 */
	    this.setTitle("Catalogue réservation");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(700, 500);
	    this.setResizable(false);
			    
	    /**
	     * Instanciation de mes panels "panelAffichageResPage" et "panelBouton"
	     */
	    //Instanciation des panels
	    this.panelAffichageResPage = new JPanel();
	    this.panelBouton = new JPanel();

	    /**
	     * Mise en place des background des panels "panelAffichageResPage" et "panelBouton"
	     */
	    //Background des panels
	    this.panelAffichageResPage.setBackground(Color.white);
	    this.panelBouton.setBackground(Color.black);
	    this.panelAffichageResPage.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelAffichageResPage" et "panelBouton"
	     */
	    //Disposition des panels
	    this.panelAffichageResPage.setLayout(new BorderLayout());
	    this.panelBouton.setLayout(new FlowLayout());

	    /**
	     * Instanciation du tableau avec les options de navigation
	     */
	    //Instanciation 
	    this.jmMenu = new JMenu("Réservation");
	    this.jmMenu.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    //Instanciation JMenuBar
	    this.jmbBarre = new JMenuBar();
	    //Instanciation des éléments JMenuItem
	    this.jmiRetour = new JMenuItem("Retour");
	    this.jmiRetour.setFont(new Font("Century Gothic", Font.PLAIN, 13));
	    this.jmiRetour.addActionListener(this);
	    this.jmiQuitter = new JMenuItem("Quitter");
	    this.jmiQuitter.addActionListener(this);
	    
	    /**
	     * Ajout des boutons au menu
	     */
	    //Ajout des boutons au menu
	    this.jmMenu.add(jmiRetour);
	    this.jmMenu.add(jmiQuitter);
	    //Ajout du JMenu à la barre
	    this.jmbBarre.add(jmMenu);
	    this.setJMenuBar(jmbBarre);
	    
	    /**
	     * Instanciation de mes boutons "btnVéhicule" et "btnMatériel"
	     * avec l'écoute des boutons
	     */
	    //Instanciation des boutons
	    this.btnVéhicule = new JButton("Affichage véhicule");
	    this.btnVéhicule.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnVéhicule.addActionListener(this);
	    
	    this.btnMatériel = new JButton("Affichage matériel");
	    this.btnMatériel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnMatériel.addActionListener(this);

	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelAffichageResPage.add(panelBouton, BorderLayout.PAGE_START);

	    this.panelBouton.add(btnVéhicule);
	    this.panelBouton.add(btnMatériel);
	    
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelAffichageResPage);
  		this.setVisible(true);
	}	
	
	public JPanel getMonPanelAffichageReservationPage() {
    	return panelAffichageResPage;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnVéhicule) {
			ArrayList<Véhicule> listeVéhicule;
			listeVéhicule = new ArrayList<Véhicule>();
			listeVéhicule = Modele.affichageVéhicule();
			this.panelAffichageResPage.removeAll();
			this.panelAffichageResPage.add(new AffichageVéhicule(listeVéhicule).getMonPanelAffichageVéhicule());
			this.panelAffichageResPage.revalidate();
			this.panelAffichageResPage.repaint();
		}
		if(e.getSource() == btnMatériel) {
			ArrayList<Matériel> listeMatériel;
			listeMatériel = new ArrayList<Matériel>();
			listeMatériel = Modele.affichageMatériel();
			this.panelAffichageResPage.removeAll();
			this.panelAffichageResPage.add(new AffichageMatériel(listeMatériel).getMonPanelAffichageMatériel());
			this.panelAffichageResPage.revalidate();
			this.panelAffichageResPage.repaint();
		}
		if(e.getSource().equals(jmiRetour)) {
			this.dispose();
			AffichageRéservationPage monAffichage = new AffichageRéservationPage();
		}
		if(e.getSource() == jmiQuitter) {
			this.dispose();
			AccueilVisiteur monAccueil = new AccueilVisiteur();
		}
	}
}