import java.awt. * ;
import java.awt.event.ActionEvent;
import javax.swing. * ;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Classe AffichageMatériel
 * @author ldatchi
 *
 */
public class AffichageMatériel extends JPanel implements ActionListener {
	
	/**
	 * Attributs privés de la classe AffichageMatériel
	 */
	//Attributs privés
	//Panel
    private JPanel panelAffichageMat;
    private JPanel panelMessage;
    private JPanel panelTableau;

    //Label
  	private JLabel lblMessage;

  	//Tableau
    private JTable tableau;
    
    //Scrollbar
    private JScrollPane scrollPane;

    //Constructeur
    public AffichageMatériel(ArrayList<Matériel> listeMatériel) {
    	/**
	     * Instanciation de mes panels "panelAffichageMat", "panelMessage" et "panelTableau"
	     */
    	//Instanciation des panels
    	this.panelAffichageMat = new JPanel();
        this.panelMessage = new JPanel();
        this.panelTableau = new JPanel();

	    /**
	     * Mise en place des background des panels "panelAffichageMat", "panelMessage" et "panelTableau"
	     */
        //Background des panels
	    this.panelAffichageMat.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelTableau.setBackground(Color.white);
	    this.panelAffichageMat.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelAffichageMat", "panelMessage" et "panelTableau"
	     */
        //Disposition des panels
	    this.panelAffichageMat.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
        this.panelTableau.setLayout(new FlowLayout());

	    /**
	     * Instanciation du label "lblMessage"
	     */
        //Instanciation des messages
	    this.lblMessage = new JLabel("Affichage du tableau des matériels.");
	    
	    /**
	     * Mise en place de la couleur d'écriture du label "lblMessage"
	     */
	 	//Couleur de la police
	    this.lblMessage.setForeground(Color.white);
      
	    /**
	     * Création du tableau pour afficher les éléments dans le tableau
	     */
	    //Tableau
        Object data[][] = new Object[4][3];
        int i = 0;
        for (Matériel monMatériel: listeMatériel) {
            data[i][0] = monMatériel.getLargeurM();
            data[i][1] = monMatériel.getLongueurM();
            data[i][2] = monMatériel.getTypeM();
            i++;
        }
        String[] title = {
            "Largeur",
            "Longueur",
            "Type",
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
        this.panelAffichageMat.add(panelMessage, BorderLayout.PAGE_START);

        this.panelMessage.add(lblMessage);
        
        //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
        this.panelAffichageMat.add(this.scrollPane);
    }

    /**
     * Permet de retourner le panel circuit pour l'affichage
     * @return
     */
    public JPanel getMonPanelAffichageMatériel() {
    	return panelAffichageMat;
    }
    
    /**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
    public void actionPerformed(ActionEvent e) {

    }
}
