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
	 * Attributs priv�s de la classe AffichagePage
	 */
	//Attributs priv�s
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
	private JButton btnV�hiculeRes;
	private JButton btnV�hicule;
	private JButton btnMat�rielRes;
	private JButton btnMat�riel;
	
	//Constructeur
	public AffichagePage() {
		//Configuration fenetre
		/**
		 * Titre, localisation, taille etc.. indispensable au d�but de chaque page IHM
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
	     * Instanciation de mes boutons "btnV�hiculeRes", "btnV�hicule", "btnMat�rielRes" et "btnMat�riel"
	     * avec l'�coute des boutons
	     */
	    //Instanciation des boutons
	    this.btnV�hiculeRes = new JButton("Affichage v�hicule res");
	    this.btnV�hiculeRes.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnV�hiculeRes.addActionListener(this);
	    
	    this.btnV�hicule = new JButton("Affichage v�hicule");
	    this.btnV�hicule.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnV�hicule.addActionListener(this);
	    
	    this.btnMat�rielRes = new JButton("Affichage mat�riel res");
	    this.btnMat�rielRes.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnMat�rielRes.addActionListener(this);
	    
	    this.btnMat�riel = new JButton("Affichage mat�riel");
	    this.btnMat�riel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnMat�riel.addActionListener(this);

	    /**
	     * Ajout des attributs � mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelAffichagePage.add(panelBouton, BorderLayout.PAGE_START);

	    this.panelBouton.add(btnV�hiculeRes);
	    this.panelBouton.add(btnV�hicule);
	    this.panelBouton.add(btnMat�rielRes);
	    this.panelBouton.add(btnMat�riel);
	    
	    //Toujours � la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours � la fin de la classe
  		 */
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelAffichagePage);
  		this.setVisible(true);
	}	
	
	public JPanel getMonPanelAffichagePage() {
    	return panelAffichagePage;
    }
	
	/**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnV�hiculeRes) {
			ArrayList<V�hiculeRes> listeV�hicule;
			listeV�hicule = new ArrayList<V�hiculeRes>();
			listeV�hicule = Modele.affichageV�hiculeRes();
			this.panelAffichagePage.removeAll();
			this.panelAffichagePage.add(new AffichageR�servationV�hicule(listeV�hicule).getMonPanelAffichageReservationV�hicule());
			this.panelAffichagePage.revalidate();
			this.panelAffichagePage.repaint();
		}
		if(e.getSource() == btnV�hicule) {
			ArrayList<V�hicule> listeV�hicule;
			listeV�hicule = new ArrayList<V�hicule>();
			listeV�hicule = Modele.affichageV�hicule();
			this.panelAffichagePage.removeAll();
			this.panelAffichagePage.add(new AffichageV�hicule(listeV�hicule).getMonPanelAffichageV�hicule());
			this.panelAffichagePage.revalidate();
			this.panelAffichagePage.repaint();
		}
		if(e.getSource() == btnMat�rielRes) {
			ArrayList<Mat�rielRes> listeMat�rielRes;
			listeMat�rielRes = new ArrayList<Mat�rielRes>();
			listeMat�rielRes = Modele.affichageMat�rielRes();
			this.panelAffichagePage.removeAll();
			this.panelAffichagePage.add(new AffichageR�servationMat�riel(listeMat�rielRes).getMonPanelAffichageReservationMat�riel());
			this.panelAffichagePage.revalidate();
			this.panelAffichagePage.repaint();
		}
		if(e.getSource() == btnMat�riel) {
			ArrayList<Mat�riel> listeMat�riel;
			listeMat�riel = new ArrayList<Mat�riel>();
			listeMat�riel = Modele.affichageMat�riel();
			this.panelAffichagePage.removeAll();
			this.panelAffichagePage.add(new AffichageMat�riel(listeMat�riel).getMonPanelAffichageMat�riel());
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