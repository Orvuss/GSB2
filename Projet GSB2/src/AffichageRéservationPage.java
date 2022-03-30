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
 * Classe AffichageR�servationPage
 * @author ldatchi
 *
 */
public class AffichageR�servationPage extends JFrame implements ActionListener{

	/**
	 * Attributs priv�s de la classe AffichageR�servationPage
	 */
	//Attributs priv�s
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
	private JButton btnV�hicule;
	private JButton btnMat�riel;
	
	//Constructeur
	public AffichageR�servationPage() {
		//Configuration fenetre
		/**
		 * Titre, localisation, taille etc.. indispensable au d�but de chaque page IHM
		 */
	    this.setTitle("Catalogue r�servation");
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
	    this.jmMenu = new JMenu("R�servation");
	    this.jmMenu.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    //Instanciation JMenuBar
	    this.jmbBarre = new JMenuBar();
	    //Instanciation des �l�ments JMenuItem
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
	    //Ajout du JMenu � la barre
	    this.jmbBarre.add(jmMenu);
	    this.setJMenuBar(jmbBarre);
	    
	    /**
	     * Instanciation de mes boutons "btnV�hicule" et "btnMat�riel"
	     * avec l'�coute des boutons
	     */
	    //Instanciation des boutons
	    this.btnV�hicule = new JButton("Affichage v�hicule");
	    this.btnV�hicule.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnV�hicule.addActionListener(this);
	    
	    this.btnMat�riel = new JButton("Affichage mat�riel");
	    this.btnMat�riel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnMat�riel.addActionListener(this);

	    /**
	     * Ajout des attributs � mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelAffichageResPage.add(panelBouton, BorderLayout.PAGE_START);

	    this.panelBouton.add(btnV�hicule);
	    this.panelBouton.add(btnMat�riel);
	    
	    //Toujours � la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours � la fin de la classe
  		 */
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelAffichageResPage);
  		this.setVisible(true);
	}	
	
	public JPanel getMonPanelAffichageReservationPage() {
    	return panelAffichageResPage;
    }
	
	/**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnV�hicule) {
			ArrayList<V�hicule> listeV�hicule;
			listeV�hicule = new ArrayList<V�hicule>();
			listeV�hicule = Modele.affichageV�hicule();
			this.panelAffichageResPage.removeAll();
			this.panelAffichageResPage.add(new AffichageV�hicule(listeV�hicule).getMonPanelAffichageV�hicule());
			this.panelAffichageResPage.revalidate();
			this.panelAffichageResPage.repaint();
		}
		if(e.getSource() == btnMat�riel) {
			ArrayList<Mat�riel> listeMat�riel;
			listeMat�riel = new ArrayList<Mat�riel>();
			listeMat�riel = Modele.affichageMat�riel();
			this.panelAffichageResPage.removeAll();
			this.panelAffichageResPage.add(new AffichageMat�riel(listeMat�riel).getMonPanelAffichageMat�riel());
			this.panelAffichageResPage.revalidate();
			this.panelAffichageResPage.repaint();
		}
		if(e.getSource().equals(jmiRetour)) {
			this.dispose();
			AffichageR�servationPage monAffichage = new AffichageR�servationPage();
		}
		if(e.getSource() == jmiQuitter) {
			this.dispose();
			AccueilVisiteur monAccueil = new AccueilVisiteur();
		}
	}
}