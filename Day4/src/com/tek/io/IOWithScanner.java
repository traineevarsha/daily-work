package com.tek.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IOWithScanner {

	public static void main(String[] args) throws IOException{
		FileWriter writer = new FileWriter("output.txt",true);
		Scanner sc = new Scanner(System.in);
		try {
		while(true) {
		System.out.println("Enter your name");
		String name = sc.nextLine();
		writer.write(name + "\n");
		writer.flush();
		System.out.println("File created");
		
	}
	}finally {
		writer.close();
		sc.close();
	}

}
}
