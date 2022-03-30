import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestVisiteur {
	/*---------------Partie V�hicule---------------*/
	@Test
	public void testSuppressionR�servationV�hicule() {
		Assert.assertTrue("Erreur au niveau de la suppression.", Modele.suppressionR�servationV�hicule("F-type"));
	}
	
	@Test
	public void testTailleV�hicule() {
		Assert.assertEquals("Erreur au niveau de la taille des v�hicules.", 2, Modele.affichageV�hicule().size());
	}
	/*---------------Partie Mat�riel---------------*/
	@Test
	public void testSuppressionR�servationMat�riel() {
		Assert.assertTrue("Erreur au niveau de la suppression.", Modele.suppressionR�servationMat�riel("iPad"));
	}
	
	@Test
	public void testTailleMat�riel() {
		Assert.assertEquals("Erreur au niveau de la taille des mat�riels.", 1, Modele.affichageMat�riel().size());
	}
}
