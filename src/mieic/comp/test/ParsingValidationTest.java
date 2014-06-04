package mieic.comp.test;

import mieic.comp.parser.Dot2DotParser;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;

public class ParsingValidationTest {

	@Test
	public void test() {

		// to be modified
		File f = null;
		for (int i = 1; (f = new File("test_files/test" + i + ".dot")).exists(); i++) {
			assertNotNull(Dot2DotParser.parse(f.getPath()));
		}
	}



}
