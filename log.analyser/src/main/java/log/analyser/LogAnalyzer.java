package log.analyser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogAnalyzer {
	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("system.log"));
			String line;

			while ((line = reader.readLine()) != null) {
				String[] logs = line.split(",");
				String logLevel = logs[0];

				if (map.containsKey(logLevel)) {
					map.put(logLevel, map.get(logLevel) + 1);
				} else {
					map.put(logLevel, 1);
				}
				reader.close();
			}
		} catch (IOException e) {
			System.out.println("File not found");

		}

	}
}
