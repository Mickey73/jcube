package jcube;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Cube {
	private String faceOne;

	public static Cube fromTextFile(String filepath) throws IOException {
		Cube cube = new Cube();
		return cube.loadFromFile(filepath);
	}

	protected Cube loadFromFile(String filePath) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
		this.addFace(reader.readLine().substring(2));
		reader.close();
		return this;
	}


	public Cube addFace(String string) {
		this.faceOne = string;
		return this;
	}
	
	public boolean equals(Object other) {
		Cube otherCube = (Cube)other;
		return this.faceOne.equals(otherCube.faceOne);
	}

	public String xmlFromSVGFile(String string) throws Exception, IOException, ParserConfigurationException {
		
		XMLDocument doc = (new XMLDocument()).loadXMLFile(string);
		Element blocNode = doc.getFirstNodeFromXPath("//tspan[contains(text(), \"$BLOCK1\")]");
		blocNode.setTextContent(faceOne);
						
		return doc.asXMLString();
	}

}
