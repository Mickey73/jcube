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
	public void twoCubeWithTwoDifferentFaceShouldNotBeEqual() {
		Cube cubeGit = (new Cube()).addFace("Git").addFace("Hub");
		Cube cubeSVN = (new Cube()).addFace("SVN").addFace("toto");
		assertFalse(cubeGit.equals(cubeSVN));
	}
}
