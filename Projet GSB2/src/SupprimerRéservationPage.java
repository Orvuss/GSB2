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
 * Classe SupprimerR�servationPage
 * @author ldatchi
 *
 */
public class SupprimerR�servationPage extends JPanel implements ActionListener{

	/**
	 * Attributs priv�s de la classe SupprimerR�servationPage
	 */
	//Attributs priv�s
	//Panel
	private JPanel panelSupprimerReservation;
	private JPanel panelBouton;
	
	//Bouton
	private JButton btnV�hicule;
	private JButton btnMat�riel;
	
	//Constructeur
	public SupprimerR�servationPage() {
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
	     * avec l'�coute des boutons
	     */
	    //Instanciation des boutons
	    this.btnV�hicule = new JButton("Supprimer v�hicule");
	    this.btnV�hicule.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnV�hicule.addActionListener(this);
	    
	    this.btnMat�riel = new JButton("Supprimer mat�riel");
	    this.btnMat�riel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	    this.btnMat�riel.addActionListener(this);

	    /**
	     * Ajout des attributs � mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelSupprimerReservation.add(panelBouton, BorderLayout.PAGE_START);
	    
	    this.panelBouton.add(btnV�hicule);
	    this.panelBouton.add(btnMat�riel);
	    
	    //Toujours � la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours � la fin de la classe
  		 */
  		this.setVisible(true);
	}	
	
	public JPanel getMonPanelSupprimerReservationPage() {
    	return panelSupprimerReservation;
    }
	
	/**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnV�hicule) {
			ArrayList<V�hiculeRes> listeV�hicule;
			listeV�hicule = new ArrayList<V�hiculeRes>();
			listeV�hicule = Modele.affichageV�hiculeRes();
			this.panelSupprimerReservation.removeAll();
			this.panelSupprimerReservation.add(new SupprimerR�servationV�hicule(listeV�hicule).getMonPanelSupprimerReservationV�hicule());
			this.panelSupprimerReservation.revalidate();
			this.panelSupprimerReservation.repaint();
		}
		if(e.getSource() == btnMat�riel) {
			ArrayList<Mat�rielRes> listeMat�riel;
			listeMat�riel = new ArrayList<Mat�rielRes>();
			listeMat�riel = Modele.affichageMat�rielRes();
			this.panelSupprimerReservation.removeAll();
			this.panelSupprimerReservation.add(new SupprimerR�servationMat�riel(listeMat�riel).getMonPanelSupprimerReservationMat�riel());
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