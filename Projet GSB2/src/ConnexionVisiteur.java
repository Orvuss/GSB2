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
 * Classe ConnexionVisiteur
 * @author ldatchi
 *
 */
public class ConnexionVisiteur extends JFrame implements ActionListener{
	
	/**
	 * Attributs privés de la classe ConnexionVisiteur
	 */
	//Attributs privés
	//Panel
	private JPanel panelConnexionVisiteur;
	private JPanel panelMessageAccueil;
	private JPanel panelChamps;
	private JPanel panelBouton;
	
	//Message
	private JLabel lblAccueil;
	private JLabel lblLogin;
	private JLabel lblMotDePasse;
	
	//Entrées de texte
	private JTextField jtfLogin;
	private JPasswordField jtfMotDePasse;
	
	//Bouton
	private JButton boutonRetour;
	private JButton boutonConnexion;
	
	//Constructeur
	public ConnexionVisiteur() {
		//Configuration fenetre
		/**
		 * Titre, localisation, taille etc.. indispensable au début de chaque page IHM
		 */
	    this.setTitle("Connexion visiteur");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(700, 500);
	    this.setResizable(false);
	    
	    /**
	     * Instanciation de mes panels "panelConnexionVisiteur", "panelMessageAccueil", "panelChamps" et "panelBouton"
	     */
	    //Instanciation des panels
	    this.panelConnexionVisiteur = new JPanel();
	    this.panelMessageAccueil = new JPanel();
	    this.panelChamps = new JPanel();
	    this.panelBouton = new JPanel();
	    
	    /**
	     * Mise en place des background des panels "panelConnexionVisiteur", "panelMessageAccueil" et "panelBouton"
	     */
	    //Disposition des panels
	    this.panelConnexionVisiteur.setLayout(new BorderLayout());
	    this.panelMessageAccueil.setLayout(new FlowLayout());
	    this.panelBouton.setLayout(new FlowLayout()); 
	    
	    /**
	     * Mise en place des dispositions des panels "panelMessageAccueil" et "panelBouton"
	     */
	    //Background des panels
	    this.panelMessageAccueil.setBackground(Color.black);
	    this.panelBouton.setBackground(Color.black);
	    this.panelChamps.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des labels "lblAccueil", "lblLogin" et "lblMotDePasse"
	     */
	    //Instanciation des labels
	    this.lblAccueil = new JLabel("Bienvenue, veuillez vous connecter");
	    this.lblAccueil.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    
	    this.lblLogin = new JLabel("Login : ");
	    this.lblLogin.setBounds(208, 10, 60, 165);
	    this.lblLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
	    
	    this.lblMotDePasse = new JLabel("Mot de passe : ");
	    this.lblMotDePasse.setBounds(155, 45, 100, 173);
	    this.lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 13));
	    
	    /**
	     * Mise en place de la couleur d'écriture du label "lblAccueil"
	     */
	    //Couleur de la police
	    this.lblAccueil.setForeground(Color.white);
	    
	    /**
	     * Instanciation des entrées "jtfLogin" et "jtfMotDePasse"
	     */
	    this.jtfLogin = new JTextField("");
	    this.jtfLogin.setBounds(265, 80, 150, 25);
	    this.jtfLogin.setPreferredSize(new Dimension(150, 25));
	    
	    this.jtfMotDePasse = new JPasswordField("");
	    this.jtfMotDePasse.setBounds(265, 120, 150, 25);
	    this.jtfMotDePasse.setPreferredSize(new Dimension(150, 25));
	    
	    /**
         * Instanciation des boutons "boutonRetour" et "boutonConnexion"
         */
	    //Instanciation des boutons
	    this.boutonRetour = new JButton("Retour");
	    this.boutonRetour.setFont(new Font("Century Gothic", Font.PLAIN, 15));
	    this.boutonRetour.addActionListener(this);
	    
	    this.boutonConnexion = new JButton("Connexion");
	    this.boutonConnexion.setFont(new Font("Century Gothic", Font.PLAIN, 15));
	    this.boutonConnexion.addActionListener(this);
	    
	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelConnexionVisiteur.add(panelMessageAccueil, BorderLayout.PAGE_START);
	    this.panelMessageAccueil.add(lblAccueil);
	    
	    this.panelConnexionVisiteur.add(panelChamps);
	    this.panelChamps.setLayout(null);
	    this.panelChamps.add(lblLogin); 
	    this.panelChamps.add(jtfLogin);
	    this.panelChamps.add(lblMotDePasse);
	    this.panelChamps.add(jtfMotDePasse);
	    
	    this.panelConnexionVisiteur.add(panelBouton, BorderLayout.SOUTH);
	    this.panelBouton.add(boutonRetour);
	    this.panelBouton.add(boutonConnexion);
	    
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
	    this.getRootPane().setDefaultButton(boutonConnexion);
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelConnexionVisiteur);
  		this.setVisible(true);
	}
	/**
	 * Action performed permettant la connexion à l'utilisateur
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boutonRetour) {
			this.dispose();
			ChoixConnexion monChoixConnexion = new ChoixConnexion();
		}
		if(e.getSource() == boutonConnexion) {
			String login = jtfLogin.getText();
			String mdp = jtfMotDePasse.getText();
			JLabel lblMessage = new JLabel("Erreur de connexion");
			lblMessage.setFont(new Font("Century Gothic", Font.BOLD, 15));
		    lblMessage.setForeground(Color.white);
			if(Modele.connexionVisiteur(login, mdp)) {
				this.panelMessageAccueil.remove(lblAccueil);
				this.dispose();
				AccueilVisiteur monAccueilVisiteur = new AccueilVisiteur();
			}
			this.panelMessageAccueil.removeAll();
			this.panelMessageAccueil.add(lblMessage);
			this.panelMessageAccueil.revalidate();
			this.panelMessageAccueil.repaint();
		}
	}
}