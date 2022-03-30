import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new NimbusLookAndFeel()); //Design des boutons
		Modele.connexion();
		ChoixConnexion monChoixConnexion = new ChoixConnexion();
		Modele.deconnexion();
	}
}