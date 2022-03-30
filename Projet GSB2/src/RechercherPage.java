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
 * Classe RechercherPage
 * @author ldatchi
 *
 */
public class RechercherPage extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe RechercherPage
	 */
	//Attributs privés
	//Panel
	private JPanel panelRechercherPage;
	private JPanel panelBouton;
	
	//Bouton
	private JButton btnVéhicule;
	private JButton btnMatériel;
	
	//Constructeur
	public RechercherPage() {
	    /**
	     * Instanciation de mes panels "panelRechercherPage" et "panelBouton"
	     */
	    //Instanciation des panels
	    this.panelRechercherPage = new JPanel();
	    this.panelBouton = new JPanel();
	    
	    /**
	     * Mise en place des background des panels "panelRechercherPage" et "panelBouton"
	     */
	    //Background des panels
	    this.panelRechercherPage.setBackground(Color.white);
	    this.panelBouton.setBackground(Color.black);
	    this.panelRechercherPage.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelRechercherPage" et "panelBouton"
	     */
	    //Disposition des panels
	    this.panelRechercherPage.setLayout(new BorderLayout());
	    this.panelBouton.setLayout(new FlowLayout());
	    
	    /**
	     * Instanciation de mes boutons "btnVéhicule" et "btnMatériel"
	     * avec l'écoute des boutons
	     */
	    //Instanciation des boutons
	    this.btnVéhicule = new JButton("Rechercher véhicule");
	    this.btnVéhicule.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnVéhicule.addActionListener(this);
	    
	    this.btnMatériel = new JButton("Rechercher matériel");
	    this.btnMatériel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnMatériel.addActionListener(this);

	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelRechercherPage.add(panelBouton, BorderLayout.PAGE_START);
	    
	    this.panelBouton.add(btnVéhicule);
	    this.panelBouton.add(btnMatériel);
	    
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
	}	
	
	public JPanel getMonPanelRechercherPage() {
    	return panelRechercherPage;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnVéhicule) {
			ArrayList<VéhiculeRes> listeVéhicule;
			listeVéhicule = new ArrayList<VéhiculeRes>();
			listeVéhicule = Modele.affichageVéhiculeRes();
			this.panelRechercherPage.removeAll();
			this.panelRechercherPage.add(new RechercherVéhicule(listeVéhicule).getMonPanelRechercherVéhicule());
			this.panelRechercherPage.revalidate();
			this.panelRechercherPage.repaint();
		}
		if(e.getSource() == btnMatériel) {
			ArrayList<MatérielRes> listeMatériel;
			listeMatériel = new ArrayList<MatérielRes>();
			listeMatériel = Modele.affichageMatérielRes();
			this.panelRechercherPage.removeAll();
			this.panelRechercherPage.add(new RechercherMatériel(listeMatériel).getMonPanelRechercherMatériel());
			this.panelRechercherPage.revalidate();
			this.panelRechercherPage.repaint();
		}
	}
}