package javadevelopment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class J29WritingIntoFile {

	public static void main(String[] args) {
		
		File folder = new File("FolderToWrite");
		folder.mkdir();
		
		File file = new File("FolderToWrite/FileToWrite.txt");
//		try {
//			file.createNewFile();
//			System.out.println("File created");
//		} catch (IOException e) {
//			System.err.println("Error occured, while creating the file");
//		}	
		
		//When you type the code like that it overwrites, every time deletes the previous texts and type from the beginning
		//If you type the new FileWriter(file) like new FileWriter(file, true) it will append the new texts without removing the previous ones
		//But when you create the file once, comment out the file creation code otherwise it will create the file in every run 
		//and you cannot see the previous texts
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			//If you do not put bw.newLine() between every bw.write(), it puts sentences side by side without space
			bw.write("Java is easy");
			bw.newLine();
			bw.write("Study hard");
			bw.newLine();
			bw.write("Learn coding");
			bw.newLine();
			bw.write("Earn money");
			bw.newLine();
			//After finishing writing do not forget to close the bw
			bw.close();
		} catch (IOException e) {
			System.err.println("Error occured, while writing");
		}

	}

}
