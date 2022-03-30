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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
/**
 * Classe AjouterPage
 * @author ldatchi
 *
 */
public class AjouterPage extends JFrame implements ActionListener{

	/**
	 * Attributs privés de la classe AjouterPage
	 */
	//Attributs privés
	//Panel
	private JPanel panelAjouter;
	private JPanel panelMessage;
	
	//Jmenu
	private JMenu jmMenu;
	
	//JMenuBar
	private JMenuBar jmbBarre;
	
	//JmenuItem
	private JMenuItem jmiAjouterVehi;
	private JMenuItem jmiAjouterMat;
	private JMenuItem jmiSupprimerAjout;
	private JMenuItem jmiRechercherRes;
	private JMenuItem jmiQuitter;
	
	//Label
	private JLabel lblMessage;
	
	//Constructeur
	public AjouterPage() {
		//Configuration
		/**
		 * Titre, localisation, taille etc.. indispensable au début de chaque page IHM
		 */
	    this.setTitle("Ajouter");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(700, 500);
	    this.setResizable(false);
	    
	    /**
	     * Instanciation de mes panels "panelAjouter" et "panelMessage"
	     */
	    //Instanciation des panels
	    this.panelAjouter = new JPanel();
	    this.panelMessage = new JPanel();

	    /**
	     * Mise en place des background des panels "panelAjouter" et "panelMessage"
	     */
	    //Background des panels
	    this.panelAjouter.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelAjouter.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelAjouter" et "panelMessage"
	     */
	    //Disposition des panels
	    this.panelAjouter.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());

	    /**
	     * Instanciation du tableau avec les options de navigations
	     */
	    //Instanciation 
	    this.jmMenu = new JMenu("Ajouter");
	    this.jmMenu.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    //Instanciation JMenuBar
	    this.jmbBarre = new JMenuBar();
	    //Instanciation des éléments JMenuItem
	    this.jmiAjouterVehi = new JMenuItem("Ajouter véhicule");
	    this.jmiAjouterVehi.setFont(new Font("Century Gothic", Font.PLAIN, 13));
	    this.jmiAjouterVehi.addActionListener(this);
	    this.jmiAjouterMat = new JMenuItem("Ajouter matériel");
	    this.jmiAjouterMat.setFont(new Font("Century Gothic", Font.PLAIN, 13));
	    this.jmiAjouterMat.addActionListener(this);
	    this.jmiSupprimerAjout = new JMenuItem("Supprimer ajout");
	    this.jmiSupprimerAjout.setFont(new Font("Century Gothic", Font.PLAIN, 13));
	    this.jmiSupprimerAjout.addActionListener(this);
	    this.jmiRechercherRes = new JMenuItem("Rechercher réservation");
	    this.jmiRechercherRes.setFont(new Font("Century Gothic", Font.PLAIN, 13));
	    this.jmiRechercherRes.addActionListener(this);
	    this.jmiQuitter = new JMenuItem("Quitter");
	    this.jmiQuitter.addActionListener(this);
	    
	    /**
	     * Ajout des boutons au menu
	     */
	    //Ajout des boutons au menu
	    this.jmMenu.add(jmiAjouterVehi);
	    this.jmMenu.add(jmiAjouterMat);
	    this.jmMenu.add(jmiSupprimerAjout);
	    this.jmMenu.add(jmiRechercherRes);
	    this.jmMenu.add(jmiQuitter);
	    //Ajout du JMenu à la barre
	    this.jmbBarre.add(jmMenu);
	    this.setJMenuBar(jmbBarre);
	    
	    /**
	     * Instanciation du label "lblMessage"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez choisir une option.");
	    
	    /**
	     * Mise en place de la couleur d'écriture du label "lblMessage"
	     */
	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);

	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelAjouter.add(panelMessage, BorderLayout.PAGE_START);

	    this.panelMessage.add(lblMessage);
	    
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
	    //Toujours à la fin
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelAjouter);
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelAjouterPage() {
    	return panelAjouter;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(jmiAjouterVehi)) {
			this.panelAjouter.removeAll();
			this.panelAjouter.add(new AjouterVéhicule().getMonPanelAjouterVéhicule());
			this.panelAjouter.revalidate();
			this.panelAjouter.repaint();
		}
		if(e.getSource().equals(jmiAjouterMat)) {
			this.panelAjouter.removeAll();
			this.panelAjouter.add(new AjouterMatériel().getMonPanelAjouterMatériel());
			this.panelAjouter.revalidate();
			this.panelAjouter.repaint();
		}
		if(e.getSource().equals(jmiSupprimerAjout)) {
			this.panelAjouter.removeAll();
			this.panelAjouter.add(new SupprimerPage().getMonPanelSupprimerPage());
			this.panelAjouter.revalidate();
			this.panelAjouter.repaint();
		}
		if(e.getSource().equals(jmiRechercherRes)) {
			this.panelAjouter.removeAll();
			this.panelAjouter.add(new RechercherPage().getMonPanelRechercherPage());
			this.panelAjouter.revalidate();
			this.panelAjouter.repaint();
		}
		if(e.getSource() == jmiQuitter) {
			this.dispose();
			AccueilResponsable monAccueil = new AccueilResponsable();		
		}
	}


}
