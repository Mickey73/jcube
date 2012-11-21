package jcube;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Cube {
	
	private String nomDuFichier;
	
	public void setNomDuFichier(String nomDuFichier) {
		this.nomDuFichier = nomDuFichier;
	}
		
	public static Cube fromTextFile(String string) {
		Cube cube = new Cube();
		cube.setNomDuFichier(string);
		return cube;
	}

	public Integer numberOfFace() {
		return 1;
	}

	public String titreFace(int i) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File(nomDuFichier)));
		String line = reader.readLine();
		reader.close();
		return line.substring(2);
		
		
	}

}