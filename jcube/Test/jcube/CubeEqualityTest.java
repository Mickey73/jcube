package jcube;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.w3c.dom.Element;

public class CubeEqualityTest {

	@Test
	public void twoCubeWithOneDifferentFaceShouldNotBeEqual() {
		Cube cubeGit = (new Cube()).addFace("Git");
		Cube cubeSVN = (new Cube()).addFace("SVN");
		assertFalse(cubeGit.equals(cubeSVN));
	}
	
	@Test
	public void cubeAvecTexte() throws Exception{
		Cube cubeTest = (new Cube()).addFace("Comment sortir du cours plus tot");
		
		String xml = cubeTest.xmlFromSVGFile("templates/cube.svg");
						
		XMLDocument readCubeXML =(new XMLDocument()).loadXMLString(xml);
		assertTrue(readCubeXML.match("//tspan[contains(text(),\"Comment sortir du cours plus tot\")]"));
				
	}

	@Test
	public void unCubeAvecDeuxFaces() throws Exception {
		Cube cubeDoubleFace = (new Cube()).addFace("Test1", "Test2");
		
		assertEquals(cubeDoubleFace.nombreFace(), 2);
		
	}
}
