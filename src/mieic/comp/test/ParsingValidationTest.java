package mieic.comp.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class ParsingValidationTest {

	@Test
	public void test() {
		fail("Not yet implemented");
		
		// to be modified
		File f = null;
		for (int i = 1; (f = new File("file" + i + ".dot")).exists(); i++) {
			// test the class in parsing in here
		}
	}

}
