package log.analyser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogAnalyzerTest {
	String fileName = "test.log";

	@BeforeEach
	void setup() throws IOException {
		FileWriter writer = new FileWriter(fileName);
		writer.write("");
		writer.close();
	}

	void writeToFile(String fileContent) throws IOException {
		FileWriter writer = new FileWriter(fileName);
		writer.write(fileContent);
		writer.close();
	}

	@Test
	void testSuccessCase() throws IOException {
		writeToFile("INFO: Start\nERROR: Fail\nERROR: Crash\nWARNING: Low");
		Map<String, Integer> result = LogAnalyzer.readAndCountLogLevels(fileName);
		assertEquals(1, result.get("INFO"));
		assertEquals(2, result.get("ERROR"));
		assertEquals(1, result.get("WARNING"));
	}

	@Test
	void testSingleLineInFile() throws IOException {
		writeToFile("INFO: Start");
		Map<String, Integer> result = LogAnalyzer.readAndCountLogLevels(fileName);
		assertEquals(1, result.get("INFO"));
	}
}