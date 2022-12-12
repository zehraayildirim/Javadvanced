package javadevelopment;

import java.io.File;
import java.io.IOException;

public class J27CreatingFile {

	public static void main(String[] args) throws IOException {
		
		//Create an object from File class, by using file name and file extension as parameter
		File file = new File("FirstFileOutOfSrc.txt");
		
		//By using "file" object use createNewFile() method then use throws IOException
		//After typing the following 2 lines of codes Java will create the file and you will see the 
		//"File created" message on the console, but to see the file on the left you need to refresh the project.
		file.createNewFile();
		System.out.println("File created");
		
		//I created the file inside project because of that Java will put the file inside the project folder.
		//documents/eclipse-workspace/javadevelopment/Firstfile.txt
		//If you want to put the file in a specific folder you need to give the path while you create "file object"
		//for example; src/FirstFile.txt creates the file under the src of "javadevelopment" project
		//Do not forget to refresh the project to see the file on the left
		
		//Windows'larda path yazarken "/" kullan bu Mac'ler icin de gecerli olur ama Mac'ler icin "\\" de kullanilir.
		
		//Task: Create a folder under documents, name it as "FilesCreatedByCode" then inside the folder create a text
		//      file name it as "MyFile1". To do that give absolute path
		//Solution: File file = new File("/Users/apple/Documents/FilesCreatedByCode/MyFile1.txt");

	}

}
