import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
/**
 * Classe RéservationVéhicule
 * @author ldatchi
 *
 */
public class RéservationVéhicule extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe RéservationVéhicule
	 */
	//Attributs privés
	//Panel
	private JPanel panelReservationVéhicule;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
	private JLabel lblMessage;
	private JLabel lblMarque;
	private JLabel lblModele;
	private JLabel lblDuree;
	private JLabel lblDateHeureDebut;
	private JLabel lblDateHeureFin;
	private JLabel lblInsertion;
	
	//JTextField
	private JTextField jtfDuree;
	private JTextField jtfDateHeureDebut;
	private JTextField jtfDateHeureFin;
	
	//JDatePicker
	private JDatePickerImpl datePicker;
	private JDatePickerImpl datePicker2;

	//JComboBox
    private JComboBox<String> jcbListeVéhiculeMarque;
    private JComboBox<String> jcbListeVéhiculeModele;
	
	//Bouton
	private JButton btnValider;
	
	//Constructeur
	public RéservationVéhicule(ArrayList<Véhicule> listeVéhicule) {	
	    /**
	     * Instanciation de mes panels "panelReservationVéhicule", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelReservationVéhicule = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelReservationVéhicule", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Background des panels
	    this.panelReservationVéhicule.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelReservationVéhicule", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelReservationVéhicule.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblNomCircuit", "lblTailleCircuit", "lblPaysCircuit" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez remplir les champs pour réserver un véhicule.");
	    this.lblMessage.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    this.lblMarque = new JLabel("Marque du véhicule :");
	    this.lblModele = new JLabel("Modèle du véhicule :");
	    this.lblDuree = new JLabel("Durée de l'emprunt du véhicule :");
	    this.lblDateHeureDebut = new JLabel("Heure du début de l'emprunt :");
	    this.lblDateHeureFin = new JLabel("Heure de fin de l'emprunt :");
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    /**
	     * Instanciation des entrées "jtfDuree", "jtfDateHeureDebut" et "jtfDateHeureFin"
	     */
	    //Instanciation des entrées
	    this.jtfDuree = new JTextField();
	    this.jtfDuree.setPreferredSize(new Dimension(100, 30));
	    
	    //DatePickerDebut
        SqlDateModel model = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.day", "Day");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl panel = new JDatePanelImpl(model,p);
        this.datePicker = new JDatePickerImpl(panel, new DateLabelFormatter());
        this.datePicker.setMaximumSize(new Dimension(150,30));
	    
        //DatePickerFin
        SqlDateModel model2 = new SqlDateModel();
        Properties p2 = new Properties();
        p2.put("text.day", "Day");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl panel2 = new JDatePanelImpl(model2,p2);
        this.datePicker2 = new JDatePickerImpl(panel2, new DateLabelFormatter());
        this.datePicker2.setMaximumSize(new Dimension(150,30));        
        
	    this.jtfDateHeureDebut = new JTextField();
	    this.jtfDateHeureDebut.setPreferredSize(new Dimension(100, 30));
	    this.jtfDateHeureFin = new JTextField();
	    this.jtfDateHeureFin.setPreferredSize(new Dimension(100, 30));

	    //Instanciation et remplissage du JComboBox
	    this.jcbListeVéhiculeMarque = new JComboBox<String>();
	    for (Véhicule monVéhiculeMarque: listeVéhicule) {
	    	this.jcbListeVéhiculeMarque.addItem(monVéhiculeMarque.getMarqueV());
	    }
		this.jcbListeVéhiculeMarque.setMaximumSize(new Dimension(100,30));
	    
	    this.jcbListeVéhiculeModele = new JComboBox<String>();
	    for (Véhicule monVéhiculeModele: listeVéhicule) {
	    	this.jcbListeVéhiculeModele.addItem(monVéhiculeModele.getModeleV());
	    }
		this.jcbListeVéhiculeModele.setMaximumSize(new Dimension(100,30));
	    
	    /**
	     * Mise en place de la couleur d'écriture des label "lblMessage", "lblNomCircuit", "lblTailleCircuit" et "lblPaysCircuit"
	     */
	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);
	    this.lblDuree.setForeground(Color.black);
	    this.lblDateHeureDebut.setForeground(Color.black);
	    this.lblDateHeureFin.setForeground(Color.black);
	    
	    /**
         * Instanciation des boutons "btnValider" et "btnRetour"
         */
	    //Instanciation des boutons
	    this.btnValider = new JButton("Valider");
	    this.btnValider.addActionListener(this);
	    
	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelReservationVéhicule.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelReservationVéhicule.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblMarque);	  
	    this.panelChamps.add(jcbListeVéhiculeMarque);
	    this.panelChamps.add(lblModele);
	    this.panelChamps.add(jcbListeVéhiculeModele);
	    this.panelChamps.add(lblDuree);
	    this.panelChamps.add(jtfDuree);
	    this.panelChamps.add(lblDateHeureDebut);
	    this.panelChamps.add(datePicker);
	    this.panelChamps.add(lblDateHeureFin);
        this.panelChamps.add(datePicker2);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
		
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelReservationVéhicule() {
    	return panelReservationVéhicule;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnValider) {
            String uneMarque = jcbListeVéhiculeMarque.getSelectedItem().toString();
            String unModele = jcbListeVéhiculeModele.getSelectedItem().toString();
            String uneDuree = jtfDuree.getText();
            java.sql.Date uneDateHeureDebut = (java.sql.Date) RéservationVéhicule.this.datePicker.getModel().getValue();
            java.sql.Date uneDateHeureFin = (java.sql.Date) RéservationVéhicule.this.datePicker2.getModel().getValue();
            boolean rep = Modele.réservationVéhicule(uneMarque, unModele, uneDuree, uneDateHeureDebut, uneDateHeureFin);
            if(rep) {
            	lblInsertion.setText("Une réservation de véhicule à été ajoutée");
            }
            else {
            	lblInsertion.setText("ERREUR, la réservation n'a pas pu se faire");
            }
        }
	}
}