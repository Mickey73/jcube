package jcube;

import static org.junit.Assert.*;


import org.junit.Test;
import org.w3c.dom.Element;


public class ReplaceCubeSVGBlock1ToMesAstucesTest {

	@Test
	public void replaceNodeContentShouldBeMesAstuces() throws Exception {
		XMLDocument cubeSVG = (new XMLDocument()).loadXMLFile("templates/cube.svg");
		Element blocNode = cubeSVG.getFirstNodeFromXPath("//tspan[contains(text(), \"$BLOCK1\")]");
		blocNode.setTextContent("Mes astuces");
		
		XMLDocument  readCubeSVG = (new XMLDocument()).loadXMLString(cubeSVG.asXMLString());
		assertTrue(readCubeSVG.match("//tspan[contains(text(), \"Mes astuces\")]"));
	}
		
		
}
