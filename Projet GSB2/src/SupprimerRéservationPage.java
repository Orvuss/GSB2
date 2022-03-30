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
 * Classe SupprimerRéservationPage
 * @author ldatchi
 *
 */
public class SupprimerRéservationPage extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe SupprimerRéservationPage
	 */
	//Attributs privés
	//Panel
	private JPanel panelSupprimerReservation;
	private JPanel panelBouton;
	
	//Bouton
	private JButton btnVéhicule;
	private JButton btnMatériel;
	
	//Constructeur
	public SupprimerRéservationPage() {
	    /**
	     * Instanciation de mes panels "panelSupprimerReservation", "panelBouton" et "panelBtnQuitter"
	     */
	    //Instanciation des panels
	    this.panelSupprimerReservation = new JPanel();
	    this.panelBouton = new JPanel();
	    
	    /**
	     * Mise en place des background des panels "panelSupprimerReservation", "panelBouton" et "panelBtnQuitter"
	     */
	    //Background des panels
	    this.panelSupprimerReservation.setBackground(Color.white);
	    this.panelBouton.setBackground(Color.black);
	    this.panelSupprimerReservation.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelSupprimerReservation", "panelBouton" et "panelBtnQuitter"
	     */
	    //Disposition des panels
	    this.panelSupprimerReservation.setLayout(new BorderLayout());
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
	    this.panelSupprimerReservation.add(panelBouton, BorderLayout.PAGE_START);
	    
	    this.panelBouton.add(btnVéhicule);
	    this.panelBouton.add(btnMatériel);
	    
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
	}	
	
	public JPanel getMonPanelSupprimerReservationPage() {
    	return panelSupprimerReservation;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnVéhicule) {
			ArrayList<VéhiculeRes> listeVéhicule;
			listeVéhicule = new ArrayList<VéhiculeRes>();
			listeVéhicule = Modele.affichageVéhiculeRes();
			this.panelSupprimerReservation.removeAll();
			this.panelSupprimerReservation.add(new SupprimerRéservationVéhicule(listeVéhicule).getMonPanelSupprimerReservationVéhicule());
			this.panelSupprimerReservation.revalidate();
			this.panelSupprimerReservation.repaint();
		}
		if(e.getSource() == btnMatériel) {
			ArrayList<MatérielRes> listeMatériel;
			listeMatériel = new ArrayList<MatérielRes>();
			listeMatériel = Modele.affichageMatérielRes();
			this.panelSupprimerReservation.removeAll();
			this.panelSupprimerReservation.add(new SupprimerRéservationMatériel(listeMatériel).getMonPanelSupprimerReservationMatériel());
			this.panelSupprimerReservation.revalidate();
			this.panelSupprimerReservation.repaint();
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