package jcube;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CubeFromOneLineTextFile {
	private Cube cube;
	
	@Before
	public void createFromTextFile() {
		this.cube = Cube.fromTextFile ("templates/one-line-cube.txt");
	}
	
	@Test
	public void cubeShouldHaveOneFace() {
		assertEquals(new Integer(1), this.cube.numberOfFace());
	}

	@Test
	public void titreFaceShouldBeConmmenntSortirDuCours() throws IOException {
		assertEquals("Comment sortir du cours...", this.cube.titreFace(0));
	}
}