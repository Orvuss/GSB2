import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestVisiteur {
	/*---------------Partie Véhicule---------------*/
	@Test
	public void testSuppressionRéservationVéhicule() {
		Assert.assertTrue("Erreur au niveau de la suppression.", Modele.suppressionRéservationVéhicule("F-type"));
	}
	
	@Test
	public void testTailleVéhicule() {
		Assert.assertEquals("Erreur au niveau de la taille des véhicules.", 2, Modele.affichageVéhicule().size());
	}
	/*---------------Partie Matériel---------------*/
	@Test
	public void testSuppressionRéservationMatériel() {
		Assert.assertTrue("Erreur au niveau de la suppression.", Modele.suppressionRéservationMatériel("iPad"));
	}
	
	@Test
	public void testTailleMatériel() {
		Assert.assertEquals("Erreur au niveau de la taille des matériels.", 1, Modele.affichageMatériel().size());
	}
}
