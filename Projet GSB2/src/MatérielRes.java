public class MatérielRes {
	
	private String typeMatériel;
	private String nomMatériel;
	private String dureeMatériel;
	private String dateHeureDebutMatériel;
	private String dateHeureFinMatériel;
	
	public MatérielRes(String unTypeMatériel, String unNomMatériel, String uneDureeMatériel, String uneDateHeureDebutMatériel, String uneDateHeureFinMatériel) {
		this.typeMatériel = unTypeMatériel;
		this.nomMatériel = unNomMatériel;
		this.dureeMatériel = uneDureeMatériel;
		this.dateHeureDebutMatériel = uneDateHeureDebutMatériel;
		this.dateHeureFinMatériel = uneDateHeureFinMatériel;
	}
	
	public String getTypeMatériel() {
		return typeMatériel;
	}
	public void setTypeMatériel(String unTypeMatériel) {
		this.typeMatériel = unTypeMatériel;
	}
	public String getNomMatériel() {
		return nomMatériel;
	}
	public void setNomMatériel(String unNomMatériel) {
		this.nomMatériel = unNomMatériel;
	}
	public String getDureeMatériel() {
		return dureeMatériel;
	}
	public void setDureeMatériel(String uneDureeMatériel) {
		this.dureeMatériel = uneDureeMatériel;
	}
	public String getDateHeureDebutMatériel() {
		return dateHeureDebutMatériel;
	}
	public void setDateHeureDebutMatériel(String uneDateHeureDebutMatériel) {
		this.dateHeureDebutMatériel = uneDateHeureDebutMatériel;
	}
	public String getDateHeureFinMatériel() {
		return dateHeureFinMatériel;
	}
	public void setDateHeureFinMatériel(String uneDateHeureFinMatériel) {
		this.dateHeureFinMatériel = uneDateHeureFinMatériel;
	}
	
	
}
