package mieic.comp.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

import mieic.comp.parsing.Dot2DotParser;

import org.junit.Test;

public class ParsingValidationTest {

	@Test
	public void test() {

		// to be modified
		File f = null;
		for (int i = 1; (f = new File("test" + i + ".dot")).exists(); i++) {
			Dot2DotParser.parse(new String[] { f.getPath() });
		}
	}
}
