import java.awt. * ;
import java.awt.event.ActionEvent;
import javax.swing. * ;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;
/**
 * Classe AffichageR�servationV�hicule
 *
 */
public class AfficherVehiculeDirecteur extends JPanel implements ActionListener {
	
	/**
	 * Attributs priv�s de la classe AffichageR�servationV�hicule
	 */
	//Attributs priv�s
	//Panel
    private JPanel panelAffichageResVeh;
    private JPanel panelMessage;
    private JPanel panelTableau;
	private JPanel panelBouton;

    //Label
  	private JLabel lblMessage;

  	//Tableau
    private JTable tableau;
    
    //Scrollbar
    private JScrollPane scrollPane;
    
    //PDF
    private JButton btnAffiMatDir;
    private JButton btnPDF;

    //Constructeur
    public AfficherVehiculeDirecteur (ArrayList<V�hiculeRes> listeV�hiculeRes) {
    	/**
	     * Instanciation de mes panels "panelAffichageResVeh", "panelMessage" et "panelTableau"
	     */
    	//Instanciation des panels
    	this.panelAffichageResVeh = new JPanel();
        this.panelMessage = new JPanel();
        this.panelTableau = new JPanel();
	    this.panelBouton = new JPanel();

	    /**
	     * Mise en place des background des panels "panelAffichageResVeh", "panelMessage" et "panelTableau"
	     */
        //Background des panels
	    this.panelAffichageResVeh.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelTableau.setBackground(Color.white);
	    this.panelBouton.setBackground(Color.black);
	    this.panelAffichageResVeh.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelAffichageResVeh", "panelMessage" et "panelTableau"
	     */
        //Disposition des panels
	    this.panelAffichageResVeh.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
        this.panelTableau.setLayout(new FlowLayout());
	    this.panelBouton.setLayout(new FlowLayout()); 

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
	    
	    //Bouton PDF
        this.btnPDF = new JButton("G�n�rer un PDF");
        this.btnPDF.addActionListener(this);
        
        this.btnAffiMatDir = new JButton("Se rendre sur la page PDF mat�riel");
        this.btnAffiMatDir.addActionListener(this);
      
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
	    this.panelAffichageResVeh.add(panelBouton, BorderLayout.SOUTH);

        this.panelMessage.add(lblMessage);
        
        this.panelBouton.add(btnAffiMatDir);
        this.panelBouton.add(btnPDF); 

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
    public JPanel getMonPanelAfficherVehiculeDirecteur () {
    	return panelAffichageResVeh;
    }
    /**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
    public void actionPerformed(ActionEvent e) {
		MessageFormat header = new MessageFormat("R�capitulatif v�hicules r�serv�s");
    	
		try {
			this.tableau.print(JTable.PrintMode.FIT_WIDTH,header, null);
		}
		catch(java.awt.print.PrinterException a){
			System.err.format("Erreur lors de la g�n�ration du PDF", a.getMessage());
		}
		if(e.getSource() == btnAffiMatDir) {
			ArrayList<Mat�rielRes> listeMat�rielRes;
			listeMat�rielRes = new ArrayList<Mat�rielRes>();
			listeMat�rielRes = Modele.affichageMat�rielRes();
			this.panelAffichageResVeh.removeAll();
			this.panelAffichageResVeh.add(new AfficherMaterielDirecteur(listeMat�rielRes).getMonPanelAfficherMaterielDirecteur());
			this.panelAffichageResVeh.revalidate();
			this.panelAffichageResVeh.repaint();
		}
    }
}
