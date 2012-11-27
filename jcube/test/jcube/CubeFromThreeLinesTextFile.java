package jcube;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class CubeFromThreeLinesTextFile {
	
	private Cube actualCube;

	@Before
	public void loadCubeFromOneLineCubeDoText() throws Exception {
		this.actualCube = Cube.fromTextFile("templates/three-line-cube.txt");
			
	}

	@Test
	public void laFaceContientElleUneAstuceComplete() throws Exception{
		Cube cubeFaceComplete = (new Cube());
		cubeFaceComplete.faceOne.donnerTitreFace("Comment sortir du cours plus tot");
		cubeFaceComplete.faceOne.astuce.donnerNomAstuce("C'est impossible");
		cubeFaceComplete.faceOne.astuce.donnerDescriptionAstuce("Jamais arrivé");
							
		assertEquals(cubeFaceComplete ,this.actualCube);
		
	}
	
	@Test
	public void leFichierSVGContientIlUnTitreDeFace() throws Exception {
		String xml = actualCube.xmlFromSVGFile("templates/cube.svg");						
		XMLDocument readCubeXML =(new XMLDocument()).loadXMLString(xml);
		assertTrue(readCubeXML.match("//tspan[contains(text(),\"Comment sortir du cours plus tot\")]"));
	}
	
	@Test
	public void leFichierSVGContientIlUnTitreAstuce() throws Exception {
		String xml = actualCube.xmlFromSVGFile("templates/cube.svg");						
		XMLDocument readCubeXML =(new XMLDocument()).loadXMLString(xml);
		assertTrue(readCubeXML.match("//text[contains(text(),\"C'est impossible\")][preceding-sibling:text/tspan[contains(text(),\"Comment sortir du cours plus tot\")]]"));
	}
	

}
