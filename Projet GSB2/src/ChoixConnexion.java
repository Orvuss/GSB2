import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
/**
 * Classe ChoixConnexion
 * 
 *
 */
public class ChoixConnexion extends JFrame implements ActionListener{
	
	/**
	 * Attributs privés de la classe ChoixConnexion
	 */
	//Attributs privés
	//Panel
	private JPanel panelConnexion;
	private JPanel panelMessageAccueil;
	private JPanel panelChamps;
	private JPanel panelBouton;
	
	//Message
	private JLabel lblAccueil;
	
	//Bouton
	private JButton boutonVisiteur;
	private JButton boutonResponsable;
	private JButton boutonDirecteur;
	
	//Constructeur
	public ChoixConnexion() {
		//Configuration fenetre
		/**
		 * Titre, localisation, taille etc.. indispensable au début de chaque page IHM
		 */
	    this.setTitle("GSB2");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(700, 500);
	    this.setResizable(false);
	    
	    /**
	     * Instanciation de mes panels "panelConnexion", "panelMessageAccueil", "panelChamps" et "panelBouton"
	     */
	    //Instanciation des panels
	    this.panelConnexion = new JPanel();
	    this.panelMessageAccueil = new JPanel();
	    this.panelChamps = new JPanel();
	    this.panelChamps.setBackground(SystemColor.activeCaption);
	    this.panelBouton = new JPanel();
	    
	    /**
	     * Mise en place des background des panels "panelConnexion", "panelMessageAccueil" et "panelBouton"
	     */
	    //Disposition des panels
	    this.panelConnexion.setLayout(new BorderLayout());
	    this.panelMessageAccueil.setLayout(new FlowLayout());
	    this.panelBouton.setLayout(new FlowLayout()); 
	    
	    /**
	     * Mise en place des dispositions des panels "panelMessageAccueil" et "panelBouton"
	     */
	    //Background des panels
	    this.panelMessageAccueil.setBackground(Color.black);
	    this.panelBouton.setBackground(Color.black);
	    
	    /**
	     * Mise en place du label "lblAccueil"
	     */
	    //Instanciation des labels
	    this.lblAccueil = new JLabel("Bienvenue, veuillez vous connecter");
	    this.lblAccueil.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    
	    /**
	     * Mise en place de la couleur d'écriture du label "lblAccueil"
	     */
	    //Couleur de la police
	    this.lblAccueil.setForeground(Color.white);
	    
	    /**
         * Instanciation du bouton "boutonVisiteur", "boutonResponsable" et "boutonDirecteur"
         */
	    //Instanciation des boutons
	    this.boutonVisiteur = new JButton("Visiteur");
	    this.boutonVisiteur.setFont(new Font("Century Gothic", Font.PLAIN, 15));
	    this.boutonVisiteur.setBounds(265, 95, 150, 25);
	    this.boutonVisiteur.addActionListener(this); 
	    
	    this.boutonResponsable = new JButton("Responsable");
	    this.boutonResponsable.setFont(new Font("Century Gothic", Font.PLAIN, 15));
	    this.boutonResponsable.setBounds(265, 130, 150, 25);
	    this.boutonResponsable.addActionListener(this);
	    
	    this.boutonDirecteur = new JButton("Directeur");
	    this.boutonDirecteur.setFont(new Font("Century Gothic", Font.PLAIN, 15));
	    this.boutonDirecteur.setBounds(265, 165, 150, 25);
	    this.boutonDirecteur.addActionListener(this);
	    
	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelConnexion.add(panelMessageAccueil, BorderLayout.PAGE_START);
	    this.panelMessageAccueil.add(lblAccueil);
	    
	    this.panelConnexion.add(panelChamps);
	    this.panelChamps.setLayout(null);
	    this.panelChamps.add(boutonVisiteur); 
	    this.panelChamps.add(boutonResponsable);
	    this.panelChamps.add(boutonDirecteur);
	    
	    JLabel Titre = new JLabel("Connexion");
	    Titre.setForeground(new Color(25, 25, 112));
	    Titre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 38));
	    Titre.setBounds(240, -14, 250, 116);
	    panelChamps.add(Titre);
	    
	    this.panelConnexion.add(panelBouton, BorderLayout.SOUTH);
	    
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelConnexion);
  		this.setVisible(true);
	}
	/**
	 * Action performed permettant la connexion à l'utilisateur
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boutonVisiteur) {
			this.dispose();
			ConnexionVisiteur maConnexionVisiteur = new ConnexionVisiteur();
		}
		if(e.getSource() == boutonResponsable) {
			this.dispose();
			ConnexionResponsable maConnexionResponsable = new ConnexionResponsable();
		}
		if(e.getSource() == boutonDirecteur) {
			this.dispose();
			ConnexionDirecteur maConnexionDirecteur = new ConnexionDirecteur();
		}
	}
}