package jcube;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CubeTextFile {
	private String filepath;
	Cube cube = new Cube();
	
	public CubeTextFile(String filepath) {
		this.filepath = filepath;
	}
	
	public BufferedReader bufferTextFiles() throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader(new File(this.filepath)));
		return reader;
	}

	public Cube newCube() throws IOException {
		BufferedReader reader = bufferTextFiles();
		cube.addFace(reader.readLine().substring(2));
		reader.close();
		return cube;
	}

	public Cube newCubeFaceComplete() throws IOException {
		BufferedReader reader = bufferTextFiles();
		cube.addFace(reader.readLine().substring(2));
		cube.addNomAstuce(reader.readLine().substring(3));
		cube.addDescriptionAstuce(reader.readLine().substring(4));
		reader.close();
		return cube;
	}

}
