import java.awt. * ;
import java.awt.event.ActionEvent;
import javax.swing. * ;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Classe AffichageRéservationVéhicule
 * @author ldatchi
 *
 */
public class AffichageRéservationVéhicule extends JPanel implements ActionListener {
	
	/**
	 * Attributs privés de la classe AffichageRéservationVéhicule
	 */
	//Attributs privés
	//Panel
    private JPanel panelAffichageResVeh;
    private JPanel panelMessage;
    private JPanel panelTableau;
    
    //Label
  	private JLabel lblMessage;

  	//Tableau
    private JTable tableau;
    
    //Scrollbar
    private JScrollPane scrollPane;

    //Constructeur
    public AffichageRéservationVéhicule(ArrayList<VéhiculeRes> listeVéhiculeRes) {
    	/**
	     * Instanciation de mes panels "panelAffichageResVeh", "panelMessage" et "panelTableau"
	     */
    	//Instanciation des panels
    	this.panelAffichageResVeh = new JPanel();
        this.panelMessage = new JPanel();
        this.panelTableau = new JPanel();
        
	    /**
	     * Mise en place des background des panels "panelAffichageResVeh", "panelMessage" et "panelTableau"
	     */
        //Background des panels
	    this.panelAffichageResVeh.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelTableau.setBackground(Color.white);
	    this.panelAffichageResVeh.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelAffichageResVeh", "panelMessage" et "panelTableau"
	     */
        //Disposition des panels
	    this.panelAffichageResVeh.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
        this.panelTableau.setLayout(new FlowLayout());
        
	    /**
	     * Instanciation du label "lblMessage"
	     */
        //Instanciation des messages
	    this.lblMessage = new JLabel("Affichage du tableau des réservations des véhicules.");
	    
	    /**
	     * Mise en place de la couleur d'écriture du label "lblMessage"
	     */
	 	//Couleur de la police
	    this.lblMessage.setForeground(Color.white);
      
	    /**
	     * Création du tableau pour afficher les éléments dans le tableau
	     */
	    //Tableau
        Object data[][] = new Object[4][6];
        int i = 0;
        for (VéhiculeRes monVéhiculeRes: listeVéhiculeRes) {
            data[i][0] = monVéhiculeRes.getMarqueVéhicule();
            data[i][1] = monVéhiculeRes.getModeleVéhicule();
            data[i][2] = monVéhiculeRes.getDureeVéhicule();
            data[i][3] = monVéhiculeRes.getDateHeureDebutVéhicule();
            data[i][4] = monVéhiculeRes.getDateHeureFinVéhicule();
            i++;
        }
        String[] title = {
            "Marque",
            "Modèle",
            "Durée",
            "Date début",
            "Date fin",
        };
        this.tableau = new JTable(data, title);
        this.tableau.setPreferredScrollableViewportSize(new Dimension(350, 300));

        /**
         * Mise en place de la taille du tableau
         */
        //Taille
        this.tableau.setRowHeight(30);

        /**
         * Mise en place de la barre de scroll
         */
        //Barre de scroll
        this.scrollPane = new JScrollPane(this.tableau);
        this.panelTableau.add(this.scrollPane);

	    /**
	     * Ajout des attributs à mes panels
	     */
        //Ajout des attributs aux panels
        this.panelAffichageResVeh.add(panelMessage, BorderLayout.PAGE_START);
        
        this.panelMessage.add(lblMessage);

        //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
        this.panelAffichageResVeh.add(this.scrollPane);
    }

    /**
     * Permet de retourner le panel circuit pour l'affichage
     * @return
     */
    public JPanel getMonPanelAffichageReservationVéhicule() {
    	return panelAffichageResVeh;
    }
    /**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
    public void actionPerformed(ActionEvent e) {
    	
    }
}
