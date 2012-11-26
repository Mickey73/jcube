package jcube;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.w3c.dom.Element;

public class Cube {
	private String faceOne;


	public static Cube fromTextFile(String filepath) throws IOException {
		return (new CubeTextFile(filepath)).newCube();
	}

	public Cube addFace(String string) {
		this.faceOne = string;
		return this;
	}

	public boolean equals(Object other) {
		Cube otherCube = (Cube)other;
		return this.faceOne.equals(otherCube.faceOne);
	}

	public String xmlFromSVGFile(String string) throws Exception {
		
		XMLDocument doc = (new XMLDocument()).loadXMLFile(string);
		Element blocNode = doc.getFirstNodeFromXPath("//tspan[contains(text(), \"$BLOCK1\")]");
		blocNode.setTextContent(faceOne);
						
		return doc.asXMLString();
	}

	public Cube addAstuce(String string) {
		
		return null;
	}

	public Object retourneAstuceComplete() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
