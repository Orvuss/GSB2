public class VéhiculeRes {
	
	private String marqueVéhicule;
	private String modeleVéhicule;
	private String dureeVéhicule;
	private String dateHeureDebutVéhicule;
	private String dateHeureFinVéhicule;
	
	
	public VéhiculeRes(String uneMarqueVéhicule, String unModeleVéhicule, String uneDureeVéhicule, String uneDateHeureDebutVéhicule, String uneDateHeureFinVéhicule) {
		this.marqueVéhicule = uneMarqueVéhicule;
		this.modeleVéhicule = unModeleVéhicule;
		this.dureeVéhicule = uneDureeVéhicule;
		this.dateHeureDebutVéhicule = uneDateHeureDebutVéhicule;
		this.dateHeureFinVéhicule = uneDateHeureFinVéhicule;
	}

	public String getMarqueVéhicule() {
		return marqueVéhicule;
	}

	public void setMarqueVéhicule(String uneMarqueVéhicule) {
		this.marqueVéhicule = uneMarqueVéhicule;
	}

	public String getModeleVéhicule() {
		return modeleVéhicule;
	}

	public void setModeleVéhicule(String unModeleVéhicule) {
		this.modeleVéhicule = unModeleVéhicule;
	}

	public String getDureeVéhicule() {
		return dureeVéhicule;
	}

	public void setDureeVéhicule(String uneDureeVéhicule) {
		this.dureeVéhicule = uneDureeVéhicule;
	}

	public String getDateHeureDebutVéhicule() {
		return dateHeureDebutVéhicule;
	}

	public void setDateHeureDebutVéhicule(String uneDateHeureDebutVéhicule) {
		this.dateHeureDebutVéhicule = uneDateHeureDebutVéhicule;
	}

	public String getDateHeureFinVéhicule() {
		return dateHeureFinVéhicule;
	}

	public void setDateHeureFinVéhicule(String uneDateHeureFinVéhicule) {
		this.dateHeureFinVéhicule = uneDateHeureFinVéhicule;
	}


	
}
