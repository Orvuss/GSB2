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
	 * Attributs priv�s de la classe RechercherPage
	 */
	//Attributs priv�s
	//Panel
	private JPanel panelRechercherPage;
	private JPanel panelBouton;
	
	//Bouton
	private JButton btnV�hicule;
	private JButton btnMat�riel;
	
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
	     * Instanciation de mes boutons "btnV�hicule" et "btnMat�riel"
	     * avec l'�coute des boutons
	     */
	    //Instanciation des boutons
	    this.btnV�hicule = new JButton("Rechercher v�hicule");
	    this.btnV�hicule.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnV�hicule.addActionListener(this);
	    
	    this.btnMat�riel = new JButton("Rechercher mat�riel");
	    this.btnMat�riel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnMat�riel.addActionListener(this);

	    /**
	     * Ajout des attributs � mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelRechercherPage.add(panelBouton, BorderLayout.PAGE_START);
	    
	    this.panelBouton.add(btnV�hicule);
	    this.panelBouton.add(btnMat�riel);
	    
	    //Toujours � la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours � la fin de la classe
  		 */
  		this.setVisible(true);
	}	
	
	public JPanel getMonPanelRechercherPage() {
    	return panelRechercherPage;
    }
	
	/**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnV�hicule) {
			ArrayList<V�hiculeRes> listeV�hicule;
			listeV�hicule = new ArrayList<V�hiculeRes>();
			listeV�hicule = Modele.affichageV�hiculeRes();
			this.panelRechercherPage.removeAll();
			this.panelRechercherPage.add(new RechercherV�hicule(listeV�hicule).getMonPanelRechercherV�hicule());
			this.panelRechercherPage.revalidate();
			this.panelRechercherPage.repaint();
		}
		if(e.getSource() == btnMat�riel) {
			ArrayList<Mat�rielRes> listeMat�riel;
			listeMat�riel = new ArrayList<Mat�rielRes>();
			listeMat�riel = Modele.affichageMat�rielRes();
			this.panelRechercherPage.removeAll();
			this.panelRechercherPage.add(new RechercherMat�riel(listeMat�riel).getMonPanelRechercherMat�riel());
			this.panelRechercherPage.revalidate();
			this.panelRechercherPage.repaint();
		}
	}
}