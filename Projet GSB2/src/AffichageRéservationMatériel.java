import java.awt. * ;
import java.awt.event.ActionEvent;
import javax.swing. * ;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Classe AffichageRéservationMatériel
 * @author ldatchi
 *
 */
public class AffichageRéservationMatériel extends JPanel implements ActionListener {
	
	/**
	 * Attributs privés de la classe AffichageRéservationMatériel
	 */
	//Attributs privés
	//Panel
    private JPanel panelAffichageResMat;
    private JPanel panelMessage;
    private JPanel panelTableau;

    //Label
  	private JLabel lblMessage;

  	//Tableau
    private JTable tableau;
    
    //Scrollbar
    private JScrollPane scrollPane;

    //Constructeur
    public AffichageRéservationMatériel(ArrayList<MatérielRes> listeMatériel) {
    	/**
	     * Instanciation de mes panels "panelAffichageResMat", "panelMessage" et "panelTableau"
	     */
    	//Instanciation des panels
    	this.panelAffichageResMat = new JPanel();
        this.panelMessage = new JPanel();
        this.panelTableau = new JPanel();

	    /**
	     * Mise en place des background des panels "panelAffichageResMat", "panelMessage" et "panelTableau"
	     */
        //Background des panels
	    this.panelAffichageResMat.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelTableau.setBackground(Color.white);
	    this.panelAffichageResMat.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelAffichageResMat", "panelMessage" et "panelTableau"
	     */
        //Disposition des panels
	    this.panelAffichageResMat.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
        this.panelTableau.setLayout(new FlowLayout());

	    /**
	     * Instanciation du label "lblMessage"
	     */
        //Instanciation des messages
	    this.lblMessage = new JLabel("Affichage du tableau des réservations des matériels.");
	    
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
        for (MatérielRes monMatériel: listeMatériel) {
            data[i][0] = monMatériel.getTypeMatériel();
            data[i][1] = monMatériel.getNomMatériel();
            data[i][2] = monMatériel.getDureeMatériel();
            data[i][3] = monMatériel.getDateHeureDebutMatériel();
            data[i][4] = monMatériel.getDateHeureFinMatériel(); 
            i++;
        }
        String[] title = {
            "Type",
            "Nom",
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
        this.panelAffichageResMat.add(panelMessage, BorderLayout.PAGE_START);

        this.panelMessage.add(lblMessage);
        
        //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
        this.panelAffichageResMat.add(this.scrollPane);
    }

    /**
     * Permet de retourner le panel circuit pour l'affichage
     * @return
     */
    public JPanel getMonPanelAffichageReservationMatériel() {
    	return panelAffichageResMat;
    }
    
    /**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
    public void actionPerformed(ActionEvent e) {

    }

	public Component getMonPanelAfficherMaterielDirecteur() {
		// TODO Auto-generated method stub
		return null;
	}
}
