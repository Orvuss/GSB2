import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
/**
 * Classe Modele
 * 
 */
public class Modele {
	
	/**
	 * Attributs priv�s static de la classe Modele
	 */
	//D�claration des variables
	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
	private static PreparedStatement statement;
	
	//M�thode seConnecter
	/**
	 * M�thode pour se connecter � la BDD
	 */
	public static void connexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.210/gsb2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "sio", "slam");
			st = connexion.createStatement();
		} catch (ClassNotFoundException erreur) {
			//Message d'erreur
			System.out.println("Le driver n'a pas pu �tre charg�");
			erreur.printStackTrace();
		} catch (SQLException erreur) {
			//Message d'erreur
			System.out.println("La connexion � la base de donn�es a �chou� ou Erreur SQL�" + erreur);
			erreur.printStackTrace();
		}
	}
	
	//M�thode seDeconnecter
	/**
	 * M�thode pour se d�connecter de la BDD
	 */
	public static void deconnexion() {
		try {
			connexion.close();
		} catch(SQLException erreur) {
			//Message d'erreur
			System.out.println("La d�connexion n'a pas �t� effectu�e.");
			erreur.printStackTrace();
		}
	}
	
	/**
	 * M�thode pour se connecter en tant que visiteur
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
	 * M�thode pour se connecter en tant que responsable
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
	 * M�thode pour se connecter en tant que directeur
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
	 * M�thode pour pouvoir r�server des v�hicules
	 * @param uneMarque
	 * @param unModele
	 * @param uneDuree
	 * @param uneDateHeureDebut
	 * @param uneDateHeureFin
	 * @return
	 */
	public static boolean r�servationV�hicule(String uneMarque, String unModele,String uneDuree, Date uneDateHeureDebut, Date uneDateHeureFin) {
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
            System.out.println("Insertion �chou�");
            erreur.printStackTrace();
        }
        return rep;
    }
	
	/**
	 * M�thode pour pouvoir r�server des mat�riels
	 * @param unType
	 * @param unNom
	 * @param uneDuree
	 * @param uneDateHeureDebut
	 * @param uneDateHeureFin
	 * @return
	 */
	public static boolean ReservationMat�riel(String unType, String unNom,String uneDuree, Date uneDateHeureDebut, Date uneDateHeureFin) {
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
            System.out.println("Insertion �chou�");
            erreur.printStackTrace();
        }
        return rep;
    }
	
	/**
	 * M�thode pour pouvoir ajouter des v�hicules
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
            System.out.println("Insertion �chou�");
            erreur.printStackTrace();
        }
        return rep;
    }
	
	/**
	 * M�thode pour pouvoir ajouter des mat�riels
	 * @param uneLargeur
	 * @param uneLongueur
	 * @param unType
	 * @return
	 */
	public static boolean AjouterMat�riel(String uneLargeur, String uneLongueur, String unType) {
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
            System.out.println("Insertion �chou�");
            erreur.printStackTrace();
        }
        return rep;
    }
	
	/**
	 * M�thode pour pouvoir afficher des r�servations de v�hicules
	 * @return
	 */
	public static ArrayList<V�hiculeRes> affichageV�hiculeRes(){
        Modele.connexion();
        ArrayList <V�hiculeRes> listeV�hicule;
        listeV�hicule = new ArrayList<V�hiculeRes>();
        try {
            rs = st.executeQuery("SELECT * FROM empruntvehicule");
            while (rs.next()) {
                String marqueV = rs.getString(1);
                String modeleV = rs.getString(2);
                String dureeV = rs.getString(3);
                String dateHeureDebutV = rs.getString(4);
                String dateHeureFinV = rs.getString(5);
                listeV�hicule.add(new V�hiculeRes(marqueV, modeleV, dureeV, dateHeureDebutV, dateHeureFinV));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return listeV�hicule;
    }
	
	/**
	 * M�thode pour pouvoir afficher des r�servations de mat�riels
	 * @return
	 */
	public static ArrayList<Mat�rielRes> affichageMat�rielRes(){
        Modele.connexion();
        ArrayList <Mat�rielRes> listeMat�riel;
        listeMat�riel = new ArrayList<Mat�rielRes>();
        try {
            rs = st.executeQuery("SELECT * FROM empruntmateriel");
            while (rs.next()) {
                String typeM = rs.getString(1);
                String nomM = rs.getString(2);
                String dureeM = rs.getString(3);
                String dateHeureDebutM = rs.getString(4);
                String dateHeureFinM = rs.getString(5);
                listeMat�riel.add(new Mat�rielRes(typeM, nomM, dureeM, dateHeureDebutM, dateHeureFinM));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return listeMat�riel;
    }
	
	/**
	 * M�thode pour pouvoir afficher des v�hicules
	 * @return
	 */
	public static ArrayList<V�hicule> affichageV�hicule(){
        Modele.connexion();
        ArrayList <V�hicule> listeV�hicule;
        listeV�hicule = new ArrayList<V�hicule>();
        try {
            rs = st.executeQuery("SELECT * FROM vehicule");
            while (rs.next()) {
                String immatV = rs.getString(1);
                String modeleV = rs.getString(2);
                String marqueV = rs.getString(3);
                String nbPlacesV = rs.getString(4);
                listeV�hicule.add(new V�hicule(immatV, modeleV, marqueV, nbPlacesV));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return listeV�hicule;
    }
	
	/**
	 * M�thode pour pouvoir afficher des mat�riels
	 * @return
	 */
	public static ArrayList<Mat�riel> affichageMat�riel(){
        Modele.connexion();
        ArrayList <Mat�riel> listeMat�riel;
        listeMat�riel = new ArrayList<Mat�riel>();
        try {
            rs = st.executeQuery("SELECT * FROM materiel");
            while (rs.next()) {
                String largeurM = rs.getString(1);
                String longueurM = rs.getString(2);
                String typeM = rs.getString(3);
                listeMat�riel.add(new Mat�riel(largeurM, longueurM, typeM));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return listeMat�riel;
    }
	
	/**
	 * M�thode pour pouvoir supprimer des r�servations de v�hicules
	 * @param unModele
	 * @return
	 */
	public static boolean suppressionR�servationV�hicule(String unModele) {
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
	 * M�thode pour pouvoir supprimer des r�servations de mat�riels
	 * @param unNom
	 * @return
	 */
	public static boolean suppressionR�servationMat�riel(String unNom) {
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
	 * M�thode pour pouvoir supprimer des v�hicules
	 * @param unModele
	 * @return
	 */
	public static boolean suppressionV�hicule(String unModele) {
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
	 * M�thode pour pouvoir supprimer des mat�riels
	 * @param unType
	 * @return
	 */
	public static boolean suppressionMat�riel(String unType) {
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
	 * M�thode pour pouvoir rechercher des v�hicules
	 * @param unModele
	 * @return
	 */
	public static boolean rechercherV�hicule(String unModele) {
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
	 * M�thode pour pouvoir rechercher des mat�riels
	 * @param unNom
	 * @return
	 */
	public static boolean rechercherMat�riel(String unNom) {
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