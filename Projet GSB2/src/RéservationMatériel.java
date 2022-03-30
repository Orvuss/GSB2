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
 * Classe R�servationMat�riel
 * @author ldatchi
 *
 */
public class R�servationMat�riel extends JPanel implements ActionListener{

	/**
	 * Attributs priv�s de la classe R�servationMat�riel
	 */
	//Attributs priv�s
	//Panel
	private JPanel panelReservationMat�riel;
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
    private JComboBox<String> jcbListeMat�rielType;
	
	//Bouton
	private JButton btnValider;
	
	//Constructeur
	public R�servationMat�riel(ArrayList<Mat�riel> listeMat�riel) {	
	    /**
	     * Instanciation de mes panels "panelReservationMat�riel", "panelMessage" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelReservationMat�riel = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelReservationMat�riel", "panelMessage" et "panelChamps"
	     */
	    //Background des panels
	    this.panelReservationMat�riel.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(SystemColor.activeCaption);

	    /**
	     * Mise en place des dispositions des panels "panelReservationMat�riel", "panelMessage" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelReservationMat�riel.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblType", "lblNom", "lblDuree", "lblDateHeureDebut", "lblDateHeureFin" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez remplir les champs pour r�server un mat�riel.");
	    this.lblMessage.setFont(new Font("Century Gothic", Font.BOLD, 15));
	    this.lblType = new JLabel("Type du mat�riel :");
	    this.lblNom = new JLabel("Nom du mat�riel :");
	    this.lblDuree = new JLabel("Dur�e de l'emprunt du mat�riel :");
	    this.lblDateHeureDebut = new JLabel("Heure du d�but du mat�riel :");
	    this.lblDateHeureFin = new JLabel("Heure de fin du mat�riel :");
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
	     * Instanciation des entr�es "jtfNom" et "jtfDuree"
	     */
	    //Instanciation des entr�es
	    this.jtfNom = new JTextField();
	    this.jtfNom.setPreferredSize(new Dimension(100, 30));
	    this.jtfDuree = new JTextField();
	    this.jtfDuree.setPreferredSize(new Dimension(100, 30));

	    //Instanciation et remplissage du JComboBox
	    this.jcbListeMat�rielType = new JComboBox<String>();
	    for (Mat�riel monMat�rielType: listeMat�riel) {
	    	this.jcbListeMat�rielType.addItem(monMat�rielType.getTypeM());
	    }
		this.jcbListeMat�rielType.setMaximumSize(new Dimension(100,30));
	    
	    /**
	     * Mise en place de la couleur d'�criture des label "lblMessage", "lblDuree", "lblDateHeureDebut" et "lblDateHeureFin"
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
	     * Ajout des attributs � mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelReservationMat�riel.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelReservationMat�riel.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblType);	
	    this.panelChamps.add(jcbListeMat�rielType);
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
		
	    //Toujours � la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours � la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelReservationMat�riel() {
    	return panelReservationMat�riel;
    }
	
	/**
	 * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnValider) {
            String unType = jcbListeMat�rielType.getSelectedItem().toString();
            String unNom = jtfNom.getText();
            String uneDureeRes = jtfDuree.getText();
            java.sql.Date uneDateHeureDebut = (java.sql.Date) R�servationMat�riel.this.datePicker.getModel().getValue();
            java.sql.Date uneDateHeureFin = (java.sql.Date) R�servationMat�riel.this.datePicker2.getModel().getValue();
            boolean rep = Modele.ReservationMat�riel(unType, unNom, uneDureeRes, uneDateHeureDebut, uneDateHeureFin);
            if(rep) {
            	lblInsertion.setText("Une r�servation du mat�riel � �t� ajout�e");
            }
            else {
            	lblInsertion.setText("ERREUR, la r�servation n'a pas pu se faire");
            }
        }
	}
}