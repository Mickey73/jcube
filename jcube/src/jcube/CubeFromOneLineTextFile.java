package jcube;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CubeFromOneLineTextFile {
	private Cube cube;
	
	@Test
	public void cubeShouldBeOneFaceWithCommentSortirDuCoursPlusTot(){
		Cube expectedCube = (new Cube())
							.addFace("Comment sortir du cours...");
		Cube actualCube = Cube.fromTextFile("templates/One-line-cube.txt");

		assertEquals(expectedCube, actualCube);
	}

}