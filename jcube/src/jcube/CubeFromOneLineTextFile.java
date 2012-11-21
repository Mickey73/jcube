package jcube;

import static org.junit.Assert.*;

import org.junit.Test;

public class CubeFromOneLineTextFile {

	@Test
	public void cubeShouldHaveOneFace() {
		Cube cube = Cube.fromTextFile ("templates/one-line-cube.txt");
		assertEquals(new Integer(1), cube.numberOfFace());
	}

}