package scilib.utilities;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * A collection of tests for the Filereader.
 * @author rlee287
 *
 */
public class ReaderTest {
	private static String fileToRead = "fileToRead_42.txt";
	private static String fileNonExist = "whyDoYouThinkMyNonexistenceMatters";

	/**
	 * Set up the file to parse
	 * @throws IOException
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		try (FileOutputStream in = new FileOutputStream(fileToRead)) {
			in.write("the_answer_to\nlife_the_universe\nand_everything".getBytes());
		}
	}

	/**
	 * Remove the file to parse after testing is complete
	 * @throws IOException
	 */
	@AfterClass
	public static void tearDownAfterClass() throws IOException {
		Files.delete(Paths.get(fileToRead));
	}

	/**
	 * Test what happens if the file does not exist.
	 */
	@Test
	public void testConvertNoFile() {
		Reader reader = new Reader();
		assertNull(reader.convert(fileNonExist));
	}
	
	/**
	 * Test that files are converted properly
	 */
	@Test
	public void testConvertFile() {
		Reader reader = new Reader();
		Iterator<String> iter = reader.convert(fileToRead).iterator();
		assertEquals(iter.next(), "the_answer_to");
		assertEquals(iter.next(), "life_the_universe");
		assertEquals(iter.next(), "and_everything");
		assertFalse(iter.hasNext());
	}

	/**
	 * Test for the compress method
	 */
	@Test
	public void testCompress() {
		assertEquals("iwillignorethe23media",
				new Reader().compress("I will ignore the %23media"));
	}

}
