package log.analyser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogAnalyzer {
	public static void main(String[] args) {
		String fileName = "system.log1";
		createFile(fileName);
		Map<String, Integer> map = readAndCountLogLevels(fileName);
		printResult(map);
	}

	public static void createFile(String fileName) {
		try {
			FileWriter writer = new FileWriter(fileName);
			writer.write("INFO: Start \nERROR: DB failed \nWARNING: Low memory \nERROR: Disk full \nINFO: Stop");
			writer.close();
		} catch (IOException ex) {
			System.out.println("Cannot create file right now");
		}
	}

	public static Map<String, Integer> readAndCountLogLevels(String fileName) {
		Map<String, Integer> map = new HashMap<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] logs = line.split(":");
				String logLevel = logs[0];
				if (map.containsKey(logLevel)) {
					map.put(logLevel, map.get(logLevel) + 1);
				} else {
					map.put(logLevel, 1);
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}
		return map;
	}

	public static void printResult(Map<String, Integer> map) {
		map.forEach((key, value) -> System.out.println(key + ": " + value));
	}
}