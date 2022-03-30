import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestDirecteur {
	@Test
	public void testConnexionDirecteur() {
		Assert.assertTrue("Erreur au niveau de la connexion.", Modele.connexionDirecteur("dir", "123"));
	}
}
