package jcube;


import java.io.IOException;
import org.w3c.dom.Element;


public class Cube {
	
	Face faceOne =new Face();
	Face faceTwo = new Face();
	


	public static Cube fromTextFileOneLine(String filepath) throws IOException {
		return (new CubeTextFile(filepath)).newCube();
	}
	
	public static Cube fromTextFileThreeLines(String filepath) throws IOException {
		return (new CubeTextFile(filepath)).newCubeFaceComplete();
	}
	
	public static Cube fromTextFileSixLines(String filepath) throws Exception {
		return (new CubeTextFile(filepath)).newCubeWithTwoFaces();
	}

	public Cube addFace(String string) {
		this.faceOne.donnerTitreFace(string);
		return this;
	}

	public Cube addNomAstuce (String string) {
		this.faceOne.astuce.donnerNomAstuce(string);
		return this;
		
	}
	
	public Cube addDescriptionAstuce (String string) {
		this.faceOne.astuce.donnerDescriptionAstuce(string);
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
		blocNode.setTextContent(faceOne.astuce.lireNomAstuce() + ": " + faceOne.astuce.lireDescriptionAstuce());
		return doc.asXMLString();
	}

	public Cube addFaceTwo(String string) {
		this.faceTwo.donnerTitreFace(string);
		return this;
		
	}
	

	
}
