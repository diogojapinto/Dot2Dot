package mieic.comp.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
package mieic.comp.parser;
public class ParsingValidationTest {

	@Test
	public void test() {
		fail("Not yet implemented");
		
		// to be modified
		File f = null;
		for (int i = 1; (f = new File("test" + i + ".dot")).exists(); i++) {
			Dot2DotParser.main(f);
		}
	}

}
