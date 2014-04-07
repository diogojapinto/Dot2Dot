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
		fail("Not yet implemented");

		// to be modified
		File f = null;
		for (int i = 1; (f = new File("test" + i + ".dot")).exists(); i++) {
			FileReader reader = null;
			try {
				reader = new FileReader(f);
				CharBuffer buffer = CharBuffer.allocate((int) f.length());
				reader.read(buffer);
				Dot2DotParser.parse(new String[] { buffer.toString() });
			} catch (FileNotFoundException e) {
				System.err.println("Could not read from test file: test" + i
						+ ".dot");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Failure reading");
				e.printStackTrace();
			}
		}
	}

}
