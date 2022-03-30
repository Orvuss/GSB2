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
 * Classe RéservationMatériel
 * @author ldatchi
 *
 */
public class RéservationMatériel extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe RéservationMatériel
	 */
	//Attributs privés
	//Panel
	private JPanel panelReservationMatériel;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
	private JLabel lblMessage;
	private JLabel lblType;
	private JLabel lblNom;
	private JLabel lblDuree;
	private JLabel lblDateHeureDebut;
	private JLabel lblDateHeureFin;
	private JLabel lblInsertion;
	
	//JTextField
	private JTextField jtfNom;
	private JTextField jtfDuree;

	//JDatePicker
	private JDatePickerImpl datePicker;
	private JDatePickerImpl datePicker2;
	
	//JComboBox
    private JComboBox<String> jcbListeMatérielType;
	
	//Bouton
	private JButton btnValider;
	
	//Constructeur
	public RéservationMatériel(ArrayList<Matériel> listeMatériel) {	
	    /**
	     * Instanciation de mes panels "panelReservationMatériel", "panelMessage" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelReservationMatériel = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelReservationMatériel", "panelMessage" et "panelChamps"
	     */
	    //Background des panels
	    this.panelReservationMatériel.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelReservationMatériel", "panelMessage" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelReservationMatériel.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblType", "lblNom", "lblDuree", "lblDateHeureDebut", "lblDateHeureFin" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez remplir les champs pour réserver un matériel.");
	    this.lblMessage.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    this.lblType = new JLabel("Type du matériel :");
	    this.lblNom = new JLabel("Nom du matériel :");
	    this.lblDuree = new JLabel("Durée de l'emprunt du matériel :");
	    this.lblDateHeureDebut = new JLabel("Heure du début du matériel :");
	    this.lblDateHeureFin = new JLabel("Heure de fin du matériel :");
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

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
	    
	    /**
	     * Instanciation des entrées "jtfNom" et "jtfDuree"
	     */
	    //Instanciation des entrées
	    this.jtfNom = new JTextField();
	    this.jtfNom.setPreferredSize(new Dimension(100, 30));
	    this.jtfDuree = new JTextField();
	    this.jtfDuree.setPreferredSize(new Dimension(100, 30));

	    //Instanciation et remplissage du JComboBox
	    this.jcbListeMatérielType = new JComboBox<String>();
	    for (Matériel monMatérielType: listeMatériel) {
	    	this.jcbListeMatérielType.addItem(monMatérielType.getTypeM());
	    }
		this.jcbListeMatérielType.setMaximumSize(new Dimension(100,30));
	    
	    /**
	     * Mise en place de la couleur d'écriture des label "lblMessage", "lblDuree", "lblDateHeureDebut" et "lblDateHeureFin"
	     */
	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);
	    this.lblDuree.setForeground(Color.black);
	    this.lblDateHeureDebut.setForeground(Color.black);
	    this.lblDateHeureFin.setForeground(Color.black);
	    
	    /**
         * Instanciation du bouton "btnValider"
         */
	    //Instanciation des boutons
	    this.btnValider = new JButton("Valider");
	    this.btnValider.addActionListener(this);
	    
	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelReservationMatériel.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelReservationMatériel.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblType);	
	    this.panelChamps.add(jcbListeMatérielType);
	    this.panelChamps.add(lblNom);
	    this.panelChamps.add(jtfNom);
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
	
	public JPanel getMonPanelReservationMatériel() {
    	return panelReservationMatériel;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnValider) {
            String unType = jcbListeMatérielType.getSelectedItem().toString();
            String unNom = jtfNom.getText();
            String uneDureeRes = jtfDuree.getText();
            java.sql.Date uneDateHeureDebut = (java.sql.Date) RéservationMatériel.this.datePicker.getModel().getValue();
            java.sql.Date uneDateHeureFin = (java.sql.Date) RéservationMatériel.this.datePicker2.getModel().getValue();
            boolean rep = Modele.ReservationMatériel(unType, unNom, uneDureeRes, uneDateHeureDebut, uneDateHeureFin);
            if(rep) {
            	lblInsertion.setText("Une réservation du matériel à été ajoutée");
            }
            else {
            	lblInsertion.setText("ERREUR, la réservation n'a pas pu se faire");
            }
        }
	}
}