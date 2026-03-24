package log.analyser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogAnalyzer {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		try {
			FileWriter writer = new FileWriter("system.log1");
			writer.write("INFO: Start \nERROR: DB failed \nWARNING: Low memory \nERROR: Disk full \nINFO: Stop");
			writer.close();
		} catch (IOException ex) {
			System.out.println("Cannot create file right now");
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader("system.log1"));
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
		map.forEach((key, value) -> System.out.println(key + ": " + value));
	}
}
