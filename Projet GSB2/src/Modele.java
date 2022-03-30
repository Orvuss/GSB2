import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
/**
 * Classe Modele
 * 
 */
public class Modele {
	
	/**
	 * Attributs privés static de la classe Modele
	 */
	//Déclaration des variables
	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
	private static PreparedStatement statement;
	
	//Méthode seConnecter
	/**
	 * Méthode pour se connecter à la BDD
	 */
	public static void connexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.210/gsb2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "sio", "slam");
			st = connexion.createStatement();
		} catch (ClassNotFoundException erreur) {
			//Message d'erreur
			System.out.println("Le driver n'a pas pu être chargé");
			erreur.printStackTrace();
		} catch (SQLException erreur) {
			//Message d'erreur
			System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);
			erreur.printStackTrace();
		}
	}
	
	//Méthode seDeconnecter
	/**
	 * Méthode pour se déconnecter de la BDD
	 */
	public static void deconnexion() {
		try {
			connexion.close();
		} catch(SQLException erreur) {
			//Message d'erreur
			System.out.println("La déconnexion n'a pas été effectuée.");
			erreur.printStackTrace();
		}
	}
	
	/**
	 * Méthode pour se connecter en tant que visiteur
	 * @param unLogin
	 * @param unMDP
	 * @return
	 */
	public static boolean connexionVisiteur(String unLogin, String unMDP) {
		Modele.connexion();
		boolean rep = false;
		int count = 0;
		try {
			statement = connexion.prepareStatement ("SELECT COUNT(*) AS count FROM personnel WHERE login_p = ? AND mdp_p = sha1(?) AND statut_p = ?;");
			statement.setString(1, unLogin);
			statement.setString(2, unMDP);
			statement.setString(3, "v");
			rs = statement.executeQuery();
			while(rs.next()){
				count = rs.getInt("count");
			}
			rs.close();
			if(count == 1) {
				rep = true;
			}
		} catch (SQLException erreur) {
			//Message d'erreur
			System.out.println("");
		}
		return rep;
	}
	
	/**
	 * Méthode pour se connecter en tant que responsable
	 * @param unLogin
	 * @param unMDP
	 * @return
	 */
	public static boolean connexionResponsable(String unLogin, String unMDP) {
		Modele.connexion();
		boolean rep = false;
		int count = 0;
		try {
			statement = connexion.prepareStatement ("SELECT COUNT(*) AS count FROM personnel WHERE login_p = ? AND mdp_p = sha1(?) AND statut_p = ?;");
			statement.setString(1, unLogin);
			statement.setString(2, unMDP);
			statement.setString(3, "r");
			rs = statement.executeQuery();
			while(rs.next()){
				count = rs.getInt("count");
			}
			rs.close();
			if(count == 1) {
				rep = true;
			}
		} catch (SQLException erreur) {
			//Message d'erreur
			System.out.println("");
		}
		return rep;
	}

	/**
	 * Méthode pour se connecter en tant que directeur
	 * @param unLogin
	 * @param unMDP
	 * @return
	 */
	public static boolean connexionDirecteur(String unLogin, String unMDP) {
		Modele.connexion();
		boolean rep = false;
		int count = 0;
		try {
			statement = connexion.prepareStatement ("SELECT COUNT(*) AS count FROM personnel WHERE login_p = ? AND mdp_p = sha1(?) AND statut_p = ?;");
			statement.setString(1, unLogin);
			statement.setString(2, unMDP);
			statement.setString(3, "d");
			rs = statement.executeQuery();
			while(rs.next()){
				count = rs.getInt("count");
			}
			rs.close();
			if(count == 1) {
				rep = true;
			}
		} catch (SQLException erreur) {
			//Message d'erreur
			System.out.println("");
		}
		return rep;
	}
	
	/**
	 * Méthode pour pouvoir réserver des véhicules
	 * @param uneMarque
	 * @param unModele
	 * @param uneDuree
	 * @param uneDateHeureDebut
	 * @param uneDateHeureFin
	 * @return
	 */
	public static boolean réservationVéhicule(String uneMarque, String unModele,String uneDuree, Date uneDateHeureDebut, Date uneDateHeureFin) {
        boolean rep = true;
        int count;
        try {
        	statement = connexion.prepareStatement("INSERT INTO empruntvehicule VALUES (?,?,?,?,?);");
        	statement.setString(1, uneMarque);
        	statement.setString(2, unModele);
        	statement.setString(3, uneDuree);
        	statement.setDate(4, uneDateHeureDebut);
        	statement.setDate(5, uneDateHeureFin);
            count = statement.executeUpdate();
        }
        catch (SQLException erreur) {
            rep = false;
            System.out.println("Insertion échoué");
            erreur.printStackTrace();
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir réserver des matériels
	 * @param unType
	 * @param unNom
	 * @param uneDuree
	 * @param uneDateHeureDebut
	 * @param uneDateHeureFin
	 * @return
	 */
	public static boolean ReservationMatériel(String unType, String unNom,String uneDuree, Date uneDateHeureDebut, Date uneDateHeureFin) {
        boolean rep = true;
        int count;
        try {
        	statement = connexion.prepareStatement("INSERT INTO empruntmateriel VALUES (?,?,?,?,?);");
        	statement.setString(1, unType);
        	statement.setString(2, unNom);
        	statement.setString(3, uneDuree);
        	statement.setDate(4, uneDateHeureDebut);
        	statement.setDate(5, uneDateHeureFin);
            count = statement.executeUpdate();
        }
        catch (SQLException erreur) {
            rep = false;
            System.out.println("Insertion échoué");
            erreur.printStackTrace();
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir ajouter des véhicules
	 * @param unImmat
	 * @param unModele
	 * @param uneMarque
	 * @param unNbPlaces
	 * @return
	 */
	public static boolean AjouterVehicule(String unImmat, String unModele, String uneMarque, String unNbPlaces) {
        boolean rep = true;
        int count;
        try {
        	statement = connexion.prepareStatement("INSERT INTO vehicule VALUES (?,?,?,?);");
        	statement.setString(1, unImmat);
        	statement.setString(2, unModele);
        	statement.setString(3, uneMarque);
        	statement.setString(4, unNbPlaces);
            count = statement.executeUpdate();
        }
        catch (SQLException erreur) {
            rep = false;
            System.out.println("Insertion échoué");
            erreur.printStackTrace();
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir ajouter des matériels
	 * @param uneLargeur
	 * @param uneLongueur
	 * @param unType
	 * @return
	 */
	public static boolean AjouterMatériel(String uneLargeur, String uneLongueur, String unType) {
        boolean rep = true;
        int count;
        try {
        	statement = connexion.prepareStatement("INSERT INTO materiel VALUES (?,?,?);");
        	statement.setString(1, uneLargeur);
        	statement.setString(2, uneLongueur);
        	statement.setString(3, unType);
            count = statement.executeUpdate();
        }
        catch (SQLException erreur) {
            rep = false;
            System.out.println("Insertion échoué");
            erreur.printStackTrace();
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir afficher des réservations de véhicules
	 * @return
	 */
	public static ArrayList<VéhiculeRes> affichageVéhiculeRes(){
        Modele.connexion();
        ArrayList <VéhiculeRes> listeVéhicule;
        listeVéhicule = new ArrayList<VéhiculeRes>();
        try {
            rs = st.executeQuery("SELECT * FROM empruntvehicule");
            while (rs.next()) {
                String marqueV = rs.getString(1);
                String modeleV = rs.getString(2);
                String dureeV = rs.getString(3);
                String dateHeureDebutV = rs.getString(4);
                String dateHeureFinV = rs.getString(5);
                listeVéhicule.add(new VéhiculeRes(marqueV, modeleV, dureeV, dateHeureDebutV, dateHeureFinV));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return listeVéhicule;
    }
	
	/**
	 * Méthode pour pouvoir afficher des réservations de matériels
	 * @return
	 */
	public static ArrayList<MatérielRes> affichageMatérielRes(){
        Modele.connexion();
        ArrayList <MatérielRes> listeMatériel;
        listeMatériel = new ArrayList<MatérielRes>();
        try {
            rs = st.executeQuery("SELECT * FROM empruntmateriel");
            while (rs.next()) {
                String typeM = rs.getString(1);
                String nomM = rs.getString(2);
                String dureeM = rs.getString(3);
                String dateHeureDebutM = rs.getString(4);
                String dateHeureFinM = rs.getString(5);
                listeMatériel.add(new MatérielRes(typeM, nomM, dureeM, dateHeureDebutM, dateHeureFinM));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return listeMatériel;
    }
	
	/**
	 * Méthode pour pouvoir afficher des véhicules
	 * @return
	 */
	public static ArrayList<Véhicule> affichageVéhicule(){
        Modele.connexion();
        ArrayList <Véhicule> listeVéhicule;
        listeVéhicule = new ArrayList<Véhicule>();
        try {
            rs = st.executeQuery("SELECT * FROM vehicule");
            while (rs.next()) {
                String immatV = rs.getString(1);
                String modeleV = rs.getString(2);
                String marqueV = rs.getString(3);
                String nbPlacesV = rs.getString(4);
                listeVéhicule.add(new Véhicule(immatV, modeleV, marqueV, nbPlacesV));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return listeVéhicule;
    }
	
	/**
	 * Méthode pour pouvoir afficher des matériels
	 * @return
	 */
	public static ArrayList<Matériel> affichageMatériel(){
        Modele.connexion();
        ArrayList <Matériel> listeMatériel;
        listeMatériel = new ArrayList<Matériel>();
        try {
            rs = st.executeQuery("SELECT * FROM materiel");
            while (rs.next()) {
                String largeurM = rs.getString(1);
                String longueurM = rs.getString(2);
                String typeM = rs.getString(3);
                listeMatériel.add(new Matériel(largeurM, longueurM, typeM));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return listeMatériel;
    }
	
	/**
	 * Méthode pour pouvoir supprimer des réservations de véhicules
	 * @param unModele
	 * @return
	 */
	public static boolean suppressionRéservationVéhicule(String unModele) {
        Modele.connexion();
        boolean rep; 
        int nbLogin;
        rep = false;
        nbLogin = 0;
        int count;
        try {
            statement = connexion.prepareStatement( "DELETE FROM empruntvehicule WHERE modele_ev = ?");
            statement.setString(1, unModele);
            count = statement.executeUpdate();
            if (count == 1) {
                rep = true;
            }
        } catch (SQLException erreur) {
            System.out.println("Erreur de suppression");
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir supprimer des réservations de matériels
	 * @param unNom
	 * @return
	 */
	public static boolean suppressionRéservationMatériel(String unNom) {
        Modele.connexion();
        boolean rep; 
        int nbLogin;
        rep = false;
        nbLogin = 0;
        int count;
        try {
            statement = connexion.prepareStatement( "DELETE FROM empruntmateriel WHERE nom_em = ?");
            statement.setString(1, unNom);
            count = statement.executeUpdate();
            if (count == 1) {
                rep = true;
            }
        } catch (SQLException erreur) {
            System.out.println("Erreur de suppression");
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir supprimer des véhicules
	 * @param unModele
	 * @return
	 */
	public static boolean suppressionVéhicule(String unModele) {
        Modele.connexion();
        boolean rep; 
        int nbLogin;
        rep = false;
        nbLogin = 0;
        int count;
        try {
            statement = connexion.prepareStatement( "DELETE FROM vehicule WHERE modele_v = ?");
            statement.setString(1, unModele);
            count = statement.executeUpdate();
            if (count == 1) {
                rep = true;
            }
        } catch (SQLException erreur) {
            System.out.println("Erreur de suppression");
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir supprimer des matériels
	 * @param unType
	 * @return
	 */
	public static boolean suppressionMatériel(String unType) {
        Modele.connexion();
        boolean rep; 
        int nbLogin;
        rep = false;
        nbLogin = 0;
        int count;
        try {
            statement = connexion.prepareStatement( "DELETE FROM materiel WHERE type_m = ?");
            statement.setString(1, unType);
            count = statement.executeUpdate();
            if (count == 1) {
                rep = true;
            }
        } catch (SQLException erreur) {
            System.out.println("Erreur de suppression");
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir rechercher des véhicules
	 * @param unModele
	 * @return
	 */
	public static boolean rechercherVéhicule(String unModele) {
        Modele.connexion();
        boolean rep = false;
        int count = 0;
        try {
        	statement = connexion.prepareStatement("SELECT COUNT(*) AS count FROM empruntvehicule WHERE modele_ev = ?");
        	statement.setString(1, unModele);
			rs = statement.executeQuery();
            while(rs.next()) {
                count = rs.getInt("count");
            }
            rs.close();
            if(count == 1) {
                rep = true;
            }
        } catch (SQLException erreur) {
            System.out.println("Erreur.");
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir rechercher des matériels
	 * @param unNom
	 * @return
	 */
	public static boolean rechercherMatériel(String unNom) {
        Modele.connexion();
        boolean rep = false;
        int count = 0;
        try {
        	statement = connexion.prepareStatement("SELECT COUNT(*) AS count FROM empruntmateriel WHERE nom_em = ?");
        	statement.setString(1, unNom);
			rs = statement.executeQuery();
            while(rs.next()) {
                count = rs.getInt("count");
            }
            rs.close();
            if(count == 1) {
                rep = true;
            }
        } catch (SQLException erreur) {
            System.out.println("Erreur.");
        }
        return rep;
    }
}