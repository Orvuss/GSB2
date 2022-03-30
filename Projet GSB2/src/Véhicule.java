public class Véhicule {
	
	private String immatV;
	private String modeleV;
	private String marqueV;
	private String nbPlacesV;
	
	public Véhicule(String unImmatV, String unModeleV, String uneMarqueV, String unNbPlacesV) {
		this.immatV = unImmatV;
		this.modeleV = unModeleV;
		this.marqueV = uneMarqueV;
		this.nbPlacesV = unNbPlacesV;
	}

	public String getImmatV() {
		return immatV;
	}
	public void setImmatV(String unImmatV) {
		this.immatV = unImmatV;
	}

	public String getModeleV() {
		return modeleV;
	}
	public void setModeleV(String unModeleV) {
		this.modeleV = unModeleV;
	}

	public String getMarqueV() {
		return marqueV;
	}
	public void setMarqueV(String uneMarqueV) {
		this.marqueV = uneMarqueV;
	}

	public String getNbPlacesV() {
		return nbPlacesV;
	}
	public void setNbPlacesV(String unNbPlacesV) {
		this.nbPlacesV = unNbPlacesV;
	}
	
}
