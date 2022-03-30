import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestResponsable {
	/*---------------Partie Véhicule---------------*/
	@Test
	public void testSuppressionVéhicule() {
		Assert.assertTrue("Erreur au niveau de la suppression.", Modele.suppressionVéhicule("F-type"));
	}
	@Test
	public void testInsertionVéhicule() {
		Assert.assertTrue("Erreur au niveau de l'insertion.", Modele.AjouterVehicule("BG-666-AZ", "F-Type", "Jaguar", "5"));
	}
	@Test
	public void testRechercherVéhicule() {
		Assert.assertFalse("Erreur au niveau de la recherche.", Modele.rechercherVéhicule("F-type"));
	}
	@Test
	public void testTailleRéservationVéhicule() {
		Assert.assertEquals("Erreur au niveau de la taille des réservations des véhicules.", 1, Modele.affichageVéhiculeRes().size());
	}
	@Test
	public void testTailleVéhicule() {
		Assert.assertEquals("Erreur au niveau de la taille des véhicules.", 3, Modele.affichageVéhicule().size());
	}
	/*---------------Partie Matériel---------------*/
	@Test
	public void testSuppressionMatériel() {
		Assert.assertTrue("Erreur au niveau de la suppression.", Modele.suppressionMatériel("PC"));
	}
	@Test
	public void testInsertionMatériel() {
		Assert.assertTrue("Erreur au niveau de l'insertion.", Modele.AjouterMatériel("700", "500", "PC"));
	}
	@Test
	public void testRechercherMatériel() {
		Assert.assertFalse("Erreur au niveau de la recherche.", Modele.rechercherMatériel("PC"));
	}
	@Test
	public void testTailleRéservationMatériel() {
		Assert.assertEquals("Erreur au niveau de la taille de la réservation des matériels.", 1, Modele.affichageMatérielRes().size());
	}
	@Test
	public void testTailleMatériel() {
		Assert.assertEquals("Erreur au niveau de la taille des matériels.", 3, Modele.affichageMatériel().size());
	}
}