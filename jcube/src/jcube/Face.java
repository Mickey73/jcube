package jcube;

public class Face {

	private String titreFace, astuce, descirptionAstuce;

	public String lireTitreFace() {
		return titreFace;
	}

	public void donnerTitreFace(String titreFace) {
		this.titreFace = titreFace;
	}

	public String lireAstuce() {
		return astuce;
	}

	public void donnerAstuce(String astuce) {
		this.astuce = astuce;
	}

	public String lireDescirptionAstuce() {
		return descirptionAstuce;
	}

	public void donnerDescirptionAstuce(String descirptionAstuce) {
		this.descirptionAstuce = descirptionAstuce;
	}
	
	
	public boolean equals(Object other) {
		Face otherFace = (Face)other;
		return this.lireTitreFace().equals(otherFace.lireTitreFace());
	}
	
	
	
	
}
