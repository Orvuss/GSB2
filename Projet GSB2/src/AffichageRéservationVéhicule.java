import java.awt. * ;
import java.awt.event.ActionEvent;
import javax.swing. * ;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Classe AffichageR�servationV�hicule
 * @author ldatchi
 *
 */
public class AffichageR�servationV�hicule extends JPanel implements ActionListener {
	
	/**
	 * Attributs priv�s de la classe AffichageR�servationV�hicule
	 */
	//Attributs priv�s
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
    public AffichageR�servationV�hicule(ArrayList<V�hiculeRes> listeV�hiculeRes) {
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
	    this.lblMessage = new JLabel("Affichage du tableau des r�servations des v�hicules.");
	    
	    /**
	     * Mise en place de la couleur d'�criture du label "lblMessage"
	     */
	 	//Couleur de la police
	    this.lblMessage.setForeground(Color.white);
      
	    /**
	     * Cr�ation du tableau pour afficher les �l�ments dans le tableau
	     */
	    //Tableau
        Object data[][] = new Object[4][6];
        int i = 0;
        for (V�hiculeRes monV�hiculeRes: listeV�hiculeRes) {
            data[i][0] = monV�hiculeRes.getMarqueV�hicule();
            data[i][1] = monV�hiculeRes.getModeleV�hicule();
            data[i][2] = monV�hiculeRes.getDureeV�hicule();
            data[i][3] = monV�hiculeRes.getDateHeureDebutV�hicule();
            data[i][4] = monV�hiculeRes.getDateHeureFinV�hicule();
            i++;
        }
        String[] title = {
            "Marque",
            "Mod�le",
            "Dur�e",
            "Date d�but",
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
	     * Ajout des attributs � mes panels
	     */
        //Ajout des attributs aux panels
        this.panelAffichageResVeh.add(panelMessage, BorderLayout.PAGE_START);
        
        this.panelMessage.add(lblMessage);

        //Toujours � la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours � la fin de la classe
  		 */
        this.panelAffichageResVeh.add(this.scrollPane);
    }

    /**
     * Permet de retourner le panel circuit pour l'affichage
     * @return
     */
    public JPanel getMonPanelAffichageReservationV�hicule() {
    	return panelAffichageResVeh;
    }
    /**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
    public void actionPerformed(ActionEvent e) {
    	
    }
}
