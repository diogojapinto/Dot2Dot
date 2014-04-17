package mieic.comp.test;

import static org.junit.Assert.*;

import java.io.File;

import mieic.comp.parsing.Dot2DotParser;

import org.junit.Test;

public class ParsingValidationTest {

	@Test
	public void test() {

		// to be modified
		File f = null;
		for (int i = 1; (f = new File("test_files/test" + i + ".dot")).exists(); i++) {
			assertTrue(Dot2DotParser.parse(new String[] { f.getPath() }));
		}
	}
}
