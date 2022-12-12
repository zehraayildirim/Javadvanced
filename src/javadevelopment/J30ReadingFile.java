package javadevelopment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class J30ReadingFile {

	public static void main(String[] args) {
		File folder = new File("FolderToWrite");
		folder.mkdir();
		
		File file = new File("FolderToWrite/FileToWrite.txt");
		try {
			file.createNewFile();
			System.out.println("File created");
		} catch (IOException e) {
			System.err.println("Error occured, while creating the file");
		}	
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write("Java is easy");
			bw.newLine();
			bw.write("Study hard");
			bw.newLine();
			bw.write("Learn coding");
			bw.newLine();
			bw.write("Earn money");
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			System.err.println("Error occured, while writing");
		}
		
		//First way to read the file
		try {
			BufferedReader br = new BufferedReader(new FileReader("FolderToWrite/FileToWrite.txt"));
			String line;
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("File could not be found");
		} catch (IOException e) {
			System.err.println("Input or output exception");
		}
		
		System.out.println("=========");
		
		//Second way to read the file
		try {
			Scanner scan = new Scanner(new File("FolderToWrite/FileToWrite.txt"));
			String line;
			while(scan.hasNext()) {
				line = scan.nextLine();
				System.out.println(line);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error while reading file ");
		}
		
		System.out.println("=========");
		
		//Third way to read the file
		FileInputStream fis;
		int k;
		try {
			fis = new FileInputStream("FolderToWrite/FileToWrite.txt");
			while((k = fis.read()) != -1) {
				System.out.print((char)k);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			System.err.println("File could not be found");
		} catch (IOException e) {
			System.err.println("Input or output exception");
		}
		
		
		/*
		 BufferReader Class                    vs                    Scanner Class
		 1)Synchronized                                              Not synchronized
		 2)Can be used for multi-threads                             Cannot be used for multi-threads
		 3)Can handle larger data until 8KB							 It is for smaller data until 1KB, it is used for user entered data
		 4)Fast														 Slow
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
