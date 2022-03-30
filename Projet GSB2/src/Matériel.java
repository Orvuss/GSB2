public class Matériel {
	
	private String largeurM;
	private String longueurM;
	private String typeM;
	
	public Matériel(String uneLargeurM, String uneLongueurM, String unTypeM) {
		this.largeurM = uneLargeurM;
		this.longueurM = uneLongueurM;
		this.typeM = unTypeM;
	}
	
	public String getLargeurM() {
		return largeurM;
	}
	public void setLargeurM(String uneLargeurM) {
		this.largeurM = uneLargeurM;
	}
	
	public String getLongueurM() {
		return longueurM;
	}
	public void setLongueurM(String uneLongueurM) {
		this.longueurM = uneLongueurM;
	}
	
	public String getTypeM() {
		return typeM;
	}
	public void setTypeM(String unTypeM) {
		this.typeM = unTypeM;
	}
	
	
}
