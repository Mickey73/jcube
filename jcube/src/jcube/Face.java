package jcube;

public class Face {

	private String titreFace;
	
	Astuce astuce=new Astuce();

	public String lireTitreFace() {
		return titreFace;
	}

	public void donnerTitreFace(String titreFace) {
		this.titreFace = titreFace;
	}
			
	public boolean equals(Object other) {
		Face otherFace = (Face)other;
		return this.lireTitreFace().equals(otherFace.lireTitreFace());
	}
	
	
	
	
}
