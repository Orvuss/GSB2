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
 * Classe AffichagePage
 * @author ldatchi
 *
 */
public class AffichagePage extends JFrame implements ActionListener{

	/**
	 * Attributs privés de la classe AffichagePage
	 */
	//Attributs privés
	//Panel
	private JPanel panelAffichagePage;
	private JPanel panelBouton;
	
	//Jmenu
	private JMenu jmMenu;
	
	//JMenuBar
	private JMenuBar jmbBarre;
	
	//JmenuItem
	private JMenuItem jmiRetour;
	private JMenuItem jmiQuitter;
	
	//Bouton
	private JButton btnVéhiculeRes;
	private JButton btnVéhicule;
	private JButton btnMatérielRes;
	private JButton btnMatériel;
	
	//Constructeur
	public AffichagePage() {
		//Configuration fenetre
		/**
		 * Titre, localisation, taille etc.. indispensable au début de chaque page IHM
		 */
	    this.setTitle("Catalogue");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(750, 550);
	    this.setResizable(false);
			    
	    /**
	     * Instanciation de mes panels "panelAffichagePage" et "panelBouton"
	     */
	    //Instanciation des panels
	    this.panelAffichagePage = new JPanel();
	    this.panelBouton = new JPanel();

	    /**
	     * Mise en place des background des panels "panelAffichagePage" et "panelBouton"
	     */
	    //Background des panels
	    this.panelAffichagePage.setBackground(Color.white);
	    this.panelBouton.setBackground(Color.black);
	    this.panelAffichagePage.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelAffichagePage" et "panelBouton"
	     */
	    //Disposition des panels
	    this.panelAffichagePage.setLayout(new BorderLayout());
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
	     * Instanciation de mes boutons "btnVéhiculeRes", "btnVéhicule", "btnMatérielRes" et "btnMatériel"
	     * avec l'écoute des boutons
	     */
	    //Instanciation des boutons
	    this.btnVéhiculeRes = new JButton("Affichage véhicule res");
	    this.btnVéhiculeRes.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnVéhiculeRes.addActionListener(this);
	    
	    this.btnVéhicule = new JButton("Affichage véhicule");
	    this.btnVéhicule.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnVéhicule.addActionListener(this);
	    
	    this.btnMatérielRes = new JButton("Affichage matériel res");
	    this.btnMatérielRes.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnMatérielRes.addActionListener(this);
	    
	    this.btnMatériel = new JButton("Affichage matériel");
	    this.btnMatériel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnMatériel.addActionListener(this);

	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelAffichagePage.add(panelBouton, BorderLayout.PAGE_START);

	    this.panelBouton.add(btnVéhiculeRes);
	    this.panelBouton.add(btnVéhicule);
	    this.panelBouton.add(btnMatérielRes);
	    this.panelBouton.add(btnMatériel);
	    
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelAffichagePage);
  		this.setVisible(true);
	}	
	
	public JPanel getMonPanelAffichagePage() {
    	return panelAffichagePage;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnVéhiculeRes) {
			ArrayList<VéhiculeRes> listeVéhicule;
			listeVéhicule = new ArrayList<VéhiculeRes>();
			listeVéhicule = Modele.affichageVéhiculeRes();
			this.panelAffichagePage.removeAll();
			this.panelAffichagePage.add(new AffichageRéservationVéhicule(listeVéhicule).getMonPanelAffichageReservationVéhicule());
			this.panelAffichagePage.revalidate();
			this.panelAffichagePage.repaint();
		}
		if(e.getSource() == btnVéhicule) {
			ArrayList<Véhicule> listeVéhicule;
			listeVéhicule = new ArrayList<Véhicule>();
			listeVéhicule = Modele.affichageVéhicule();
			this.panelAffichagePage.removeAll();
			this.panelAffichagePage.add(new AffichageVéhicule(listeVéhicule).getMonPanelAffichageVéhicule());
			this.panelAffichagePage.revalidate();
			this.panelAffichagePage.repaint();
		}
		if(e.getSource() == btnMatérielRes) {
			ArrayList<MatérielRes> listeMatérielRes;
			listeMatérielRes = new ArrayList<MatérielRes>();
			listeMatérielRes = Modele.affichageMatérielRes();
			this.panelAffichagePage.removeAll();
			this.panelAffichagePage.add(new AffichageRéservationMatériel(listeMatérielRes).getMonPanelAffichageReservationMatériel());
			this.panelAffichagePage.revalidate();
			this.panelAffichagePage.repaint();
		}
		if(e.getSource() == btnMatériel) {
			ArrayList<Matériel> listeMatériel;
			listeMatériel = new ArrayList<Matériel>();
			listeMatériel = Modele.affichageMatériel();
			this.panelAffichagePage.removeAll();
			this.panelAffichagePage.add(new AffichageMatériel(listeMatériel).getMonPanelAffichageMatériel());
			this.panelAffichagePage.revalidate();
			this.panelAffichagePage.repaint();
		}
		if(e.getSource().equals(jmiRetour)) {
			this.dispose();
			AffichagePage monAffichage = new AffichagePage();
		}
		if(e.getSource() == jmiQuitter) {
			this.dispose();
			AccueilResponsable monAccueil = new AccueilResponsable();
		}
	}
}