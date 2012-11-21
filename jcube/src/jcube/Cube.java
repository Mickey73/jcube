package jcube;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Cube {
	
	static String nomDuFichier;
		
	public static Cube fromTextFile(String string) {
		nomDuFichier = string;
		return new Cube();
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