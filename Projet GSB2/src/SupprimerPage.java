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
	 * Attributs priv�s de la classe SupprimerPage
	 */
	//Attributs priv�s
	//Panel
	private JPanel panelSupprimer;
	private JPanel panelBouton;
	
	//Bouton
	private JButton btnV�hicule;
	private JButton btnMat�riel;
	
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
	    this.panelSupprimer.add(panelBouton, BorderLayout.PAGE_START);
	    
	    this.panelBouton.add(btnV�hicule);
	    this.panelBouton.add(btnMat�riel);
	    
	    //Toujours � la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours � la fin de la classe
  		 */
  		this.setVisible(true);
	}	
	
	public JPanel getMonPanelSupprimerPage() {
    	return panelSupprimer;
    }
	
	/**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnV�hicule) {
			ArrayList<V�hicule> listeV�hicule;
			listeV�hicule = new ArrayList<V�hicule>();
			listeV�hicule = Modele.affichageV�hicule();
			this.panelSupprimer.removeAll();
			this.panelSupprimer.add(new SupprimerV�hicule(listeV�hicule).getMonPanelSupprimerV�hicule());
			this.panelSupprimer.revalidate();
			this.panelSupprimer.repaint();
		}
		if(e.getSource() == btnMat�riel) {
			ArrayList<Mat�riel> listeMat�riel;
			listeMat�riel = new ArrayList<Mat�riel>();
			listeMat�riel = Modele.affichageMat�riel();
			this.panelSupprimer.removeAll();
			this.panelSupprimer.add(new SupprimerMat�riel(listeMat�riel).getMonPanelSupprimerMat�riel());
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