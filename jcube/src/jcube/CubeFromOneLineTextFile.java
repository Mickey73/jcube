package jcube;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class CubeFromOneLineTextFile {

	@Test
	public void cubeShouldHaveOneFace() {
		Cube cube = Cube.fromTextFile ("templates/one-line-cube.txt");
		assertEquals(new Integer(1), cube.numberOfFace());
	}

	@Test
	public void titreFaceShouldBeConmmenntSortirDuCours() throws IOException {
		Cube cube = Cube.fromTextFile ("templates/one-line-cube.txt");
		assertEquals("Comment sortir du cours...", cube.titreFace(0));
	}
}