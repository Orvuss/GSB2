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
 * Classe SupprimerPage
 * @author ldatchi
 *
 */
public class SupprimerPage extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe SupprimerPage
	 */
	//Attributs privés
	//Panel
	private JPanel panelSupprimer;
	private JPanel panelBouton;
	
	//Bouton
	private JButton btnVéhicule;
	private JButton btnMatériel;
	
	//Constructeur
	public SupprimerPage() {
	    /**
	     * Instanciation de mes panels "panelSupprimer", "panelBouton" et "panelBtnQuitter"
	     */
	    //Instanciation des panels
	    this.panelSupprimer = new JPanel();
	    this.panelBouton = new JPanel();
	    
	    /**
	     * Mise en place des background des panels "panelSupprimer", "panelBouton" et "panelBtnQuitter"
	     */
	    //Background des panels
	    this.panelSupprimer.setBackground(Color.white);
	    this.panelBouton.setBackground(Color.black);
	    this.panelSupprimer.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelSupprimer", "panelBouton" et "panelBtnQuitter"
	     */
	    //Disposition des panels
	    this.panelSupprimer.setLayout(new BorderLayout());
	    this.panelBouton.setLayout(new FlowLayout());
	    
	    /**
	     * Instanciation de mes boutons "btnEcurie", "btnCourse", "btnCircuit", "btnPersonnel" et "btnQuitter"
	     * avec l'écoute des boutons
	     */
	    //Instanciation des boutons
	    this.btnVéhicule = new JButton("Supprimer véhicule");
	    this.btnVéhicule.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnVéhicule.addActionListener(this);
	    
	    this.btnMatériel = new JButton("Supprimer matériel");
	    this.btnMatériel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnMatériel.addActionListener(this);

	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelSupprimer.add(panelBouton, BorderLayout.PAGE_START);
	    
	    this.panelBouton.add(btnVéhicule);
	    this.panelBouton.add(btnMatériel);
	    
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
	}	
	
	public JPanel getMonPanelSupprimerPage() {
    	return panelSupprimer;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnVéhicule) {
			ArrayList<Véhicule> listeVéhicule;
			listeVéhicule = new ArrayList<Véhicule>();
			listeVéhicule = Modele.affichageVéhicule();
			this.panelSupprimer.removeAll();
			this.panelSupprimer.add(new SupprimerVéhicule(listeVéhicule).getMonPanelSupprimerVéhicule());
			this.panelSupprimer.revalidate();
			this.panelSupprimer.repaint();
		}
		if(e.getSource() == btnMatériel) {
			ArrayList<Matériel> listeMatériel;
			listeMatériel = new ArrayList<Matériel>();
			listeMatériel = Modele.affichageMatériel();
			this.panelSupprimer.removeAll();
			this.panelSupprimer.add(new SupprimerMatériel(listeMatériel).getMonPanelSupprimerMatériel());
			this.panelSupprimer.revalidate();
			this.panelSupprimer.repaint();
		}
//		if(e.getSource() == btnStatistiques) {
//			this.dispose();
//			Circuit monCircuit = new Circuit();
//		}
//		if(e.getSource() == btnPdf) {
//			this.dispose();
//			Personnel monPersonnel = new Personnel();
//		}
//		if(e.getSource() == btnQuitter) {
//			this.dispose();
//		}
	}
}