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
 * Classe R�servationPage
 * @author ldatchi
 *
 */
public class R�servationPage extends JFrame implements ActionListener{

	/**
	 * Attributs priv�s de la classe R�servationPage
	 */
	//Attributs priv�s
	//Panel
	private JPanel panelReservationPage;
	private JPanel panelMessage;
	
	//Jmenu
	private JMenu jmMenu;
	
	//JMenuBar
	private JMenuBar jmbBarre;
	
	//JmenuItem
	private JMenuItem jmiReserverVehi;
	private JMenuItem jmiReserverMat;
	private JMenuItem jmiSupprimerRes;
	private JMenuItem jmiQuitter;
	
	//Label
	private JLabel lblMessage;
	
	//Constructeur
	public R�servationPage() {
		//Configuration
		/**
		 * Titre, localisation, taille etc.. indispensable au d�but de chaque page IHM
		 */
	    this.setTitle("R�servation");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(700, 500);
	    this.setResizable(false);
	    
	    /**
	     * Instanciation de mes panels "panelReservationPage" et "panelMessage"
	     */
	    //Instanciation des panels
	    this.panelReservationPage = new JPanel();
	    this.panelMessage = new JPanel();

	    /**
	     * Mise en place des background des panels "panelReservationPage" et "panelMessage"
	     */
	    //Background des panels
	    this.panelReservationPage.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelReservationPage.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelReservationPage" et "panelMessage"
	     */
	    //Disposition des panels
	    this.panelReservationPage.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());

	    /**
	     * Instanciation du tableau avec les options de r�servation
	     */
	    //Instanciation 
	    this.jmMenu = new JMenu("R�servation");
	    this.jmMenu.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    //Instanciation JMenuBar
	    this.jmbBarre = new JMenuBar();
	    //Instanciation des �l�ments JMenuItem
	    this.jmiReserverVehi = new JMenuItem("R�server v�hicule");
	    this.jmiReserverVehi.setFont(new Font("Century Gothic", Font.PLAIN, 13));
	    this.jmiReserverVehi.addActionListener(this);
	    this.jmiReserverMat = new JMenuItem("R�server mat�riel");
	    this.jmiReserverMat.setFont(new Font("Century Gothic", Font.PLAIN, 13));
	    this.jmiReserverMat.addActionListener(this);
	    this.jmiSupprimerRes = new JMenuItem("Supprimer r�servation");
	    this.jmiSupprimerRes.setFont(new Font("Century Gothic", Font.PLAIN, 13));
	    this.jmiSupprimerRes.addActionListener(this);
	    this.jmiQuitter = new JMenuItem("Quitter");
	    this.jmiQuitter.addActionListener(this);
	    
	    /**
	     * Ajout des boutons au menu
	     */
	    //Ajout des boutons au menu
	    this.jmMenu.add(jmiReserverVehi);
	    this.jmMenu.add(jmiReserverMat);
	    this.jmMenu.add(jmiSupprimerRes);
	    this.jmMenu.add(jmiQuitter);
	    //Ajout du JMenu � la barre
	    this.jmbBarre.add(jmMenu);
	    this.setJMenuBar(jmbBarre);
	    
	    /**
	     * Instanciation du label "lblMessage"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez choisir une option.");
	    
	    /**
	     * Mise en place de la couleur d'�criture du label "lblMessage"
	     */
	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);

	    /**
	     * Ajout des attributs � mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelReservationPage.add(panelMessage, BorderLayout.PAGE_START);

	    this.panelMessage.add(lblMessage);
	    
	    //Toujours � la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours � la fin de la classe
  		 */
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelReservationPage);
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelReservationPage() {
    	return panelReservationPage;
    }
	
	/**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(jmiReserverVehi)) {
			ArrayList<V�hicule> listeV�hicule;
			listeV�hicule = new ArrayList<V�hicule>();
			listeV�hicule = Modele.affichageV�hicule();
			this.panelReservationPage.removeAll();
			this.panelReservationPage.add(new R�servationV�hicule(listeV�hicule).getMonPanelReservationV�hicule());
			this.panelReservationPage.revalidate();
			this.panelReservationPage.repaint();
		}
		if(e.getSource().equals(jmiReserverMat)) {
			ArrayList<Mat�riel> listeMat�riel;
			listeMat�riel = new ArrayList<Mat�riel>();
			listeMat�riel = Modele.affichageMat�riel();
			this.panelReservationPage.removeAll();
			this.panelReservationPage.add(new R�servationMat�riel(listeMat�riel).getMonPanelReservationMat�riel());
			this.panelReservationPage.revalidate();
			this.panelReservationPage.repaint();
		}
		if(e.getSource().equals(jmiSupprimerRes)) {
			this.panelReservationPage.removeAll();
			this.panelReservationPage.add(new SupprimerR�servationPage().getMonPanelSupprimerReservationPage());
			this.panelReservationPage.revalidate();
			this.panelReservationPage.repaint();
		}
		if(e.getSource() == jmiQuitter) {
			this.dispose();
			AccueilVisiteur monAccueil = new AccueilVisiteur();		
		}
	}


}
