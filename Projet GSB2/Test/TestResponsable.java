import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestResponsable {
	/*---------------Partie V�hicule---------------*/
	@Test
	public void testSuppressionV�hicule() {
		Assert.assertTrue("Erreur au niveau de la suppression.", Modele.suppressionV�hicule("F-type"));
	}
	@Test
	public void testInsertionV�hicule() {
		Assert.assertTrue("Erreur au niveau de l'insertion.", Modele.AjouterVehicule("BG-666-AZ", "F-Type", "Jaguar", "5"));
	}
	@Test
	public void testRechercherV�hicule() {
		Assert.assertFalse("Erreur au niveau de la recherche.", Modele.rechercherV�hicule("F-type"));
	}
	@Test
	public void testTailleR�servationV�hicule() {
		Assert.assertEquals("Erreur au niveau de la taille des r�servations des v�hicules.", 1, Modele.affichageV�hiculeRes().size());
	}
	@Test
	public void testTailleV�hicule() {
		Assert.assertEquals("Erreur au niveau de la taille des v�hicules.", 3, Modele.affichageV�hicule().size());
	}
	/*---------------Partie Mat�riel---------------*/
	@Test
	public void testSuppressionMat�riel() {
		Assert.assertTrue("Erreur au niveau de la suppression.", Modele.suppressionMat�riel("PC"));
	}
	@Test
	public void testInsertionMat�riel() {
		Assert.assertTrue("Erreur au niveau de l'insertion.", Modele.AjouterMat�riel("700", "500", "PC"));
	}
	@Test
	public void testRechercherMat�riel() {
		Assert.assertFalse("Erreur au niveau de la recherche.", Modele.rechercherMat�riel("PC"));
	}
	@Test
	public void testTailleR�servationMat�riel() {
		Assert.assertEquals("Erreur au niveau de la taille de la r�servation des mat�riels.", 1, Modele.affichageMat�rielRes().size());
	}
	@Test
	public void testTailleMat�riel() {
		Assert.assertEquals("Erreur au niveau de la taille des mat�riels.", 3, Modele.affichageMat�riel().size());
	}
}