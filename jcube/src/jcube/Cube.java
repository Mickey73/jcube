package jcube;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Cube {
	
	Face faceOne =new Face();


	public static Cube fromTextFile(String filepath) throws IOException {
		return (new CubeTextFile(filepath)).newCube();
	}

	public Cube addFace(String string) {
		this.faceOne.donnerTitreFace(string);
		return this;
	}

	public boolean equals(Object other) {
		Cube otherCube = (Cube)other;
		return this.faceOne.equals(otherCube.faceOne);
	}

	public String xmlFromSVGFile(String string) throws Exception {
		
		XMLDocument doc = (new XMLDocument()).loadXMLFile(string);
		Element blocNode = doc.getFirstNodeFromXPath("//tspan[contains(text(), \"$BLOCK1\")]");
		blocNode.setTextContent(faceOne.lireTitreFace());
		blocNode = doc.getFirstNodeFromXPath("//text[contains(text(), \"$text1\")]");
		blocNode.setTextContent(faceOne.astuce.lireDescriptionAstuce());
		return doc.asXMLString();
	}
	
	public Cube addNomAstuce (String string) {
		this.faceOne.astuce.donnerNomAstuce(string);
		return this;
		
	}
	
	public Cube addDescriptionAstuce (String string) {
		this.faceOne.astuce.donnerDescriptionAstuce(string);
		return this;
		
	}

//	public String xmlFromSVGFile2(String string) throws Exception {
//		XMLDocument doc = (new XMLDocument()).loadXMLFile(string);
//		Element blocNode = doc.getFirstNodeFromXPath("//text[contains(text(), \"$text1\")]");
//		blocNode.setTextContent(faceOne.astuce.lireNomAstuce());
////		blocNode.setTextContent(faceOne.astuce.lireDescriptionAstuce());
//
//		return doc.asXMLString();
//	}

}
