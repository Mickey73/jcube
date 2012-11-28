package jcube;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CubeWithTwoFaces {

	private Cube actualCubeWithTwoFaces;

	@Before
	public void loadCubeWithTwoFaces() throws Exception{
		
		this.actualCubeWithTwoFaces = Cube.fromTextFileSixLines("templates/six-line-cube.txt");
	}
	
	@Test
	public void VerifieQueLeCubeADeuxFace() {
		Cube otherCube = new Cube();
		otherCube.addFace("Comment sortir du cours plus tot").addFaceTwo("Face 2");
		assertEquals(this.actualCubeWithTwoFaces, otherCube);		
		System.out.println(actualCubeWithTwoFaces.faceTwo.lireTitreFace());
		System.out.println(otherCube.faceTwo.lireTitreFace());
	}

}
