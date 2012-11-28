package jcube;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CubeFromThreeLinesTextFile {
	
	private Cube actualCube;
	private Cube cubeFaceComplete;
	private String xml;
	private XMLDocument readCubeXML;

	@Before
	public void loadCubeFromOneLineCubeDoText() throws Exception {
		this.actualCube = Cube.fromTextFileThreeLines("templates/three-line-cube.txt");
		
		this.cubeFaceComplete = (new Cube());
		cubeFaceComplete.faceOne.donnerTitreFace("Comment sortir du cours plus tot");
		cubeFaceComplete.faceOne.astuce.donnerNomAstuce("C'est impossible");
		cubeFaceComplete.faceOne.astuce.donnerDescriptionAstuce("Jamais arrivé");
		
		this.xml = actualCube.xmlFromSVGFile("templates/cube.svg");						
		this.readCubeXML =(new XMLDocument()).loadXMLString(xml);
	}
	
		

	@Test
	public void laFaceContientElleUneAstuceComplete() throws Exception{
		assertEquals(cubeFaceComplete ,this.actualCube);
		
	}
	
		
	@Test
	public void leFichierSVGContientIlUnTitreDeFace() throws Exception {
		assertTrue(readCubeXML.match("//tspan[contains(text(),\"Comment sortir du cours plus tot\")]"));
	}
	
	@Test
	public void leFichierSVGContientIlUnTitreAstuce() throws Exception {
		assertTrue(readCubeXML.match("//text[contains(text(),\"C'est impossible\")]"));
	}
	
	@Test
	public void leFichierSVGContientIlUneDescriptionAstuce() throws Exception {
			assertTrue(readCubeXML.match("//text[contains(text(),\"Jamais arrivé\")]"));
	}
	

}
