package javadevelopment;

import java.io.File;

public class J31DeletingFile {

	public static void main(String[] args) {
		
		File file = new File("FolderToWrite/FileToWrite.txt");
		//delete() method return boolean
		if(file.delete()) {
			System.out.println("Deletion is successful");
		}else {
			System.out.println("Error in deletion");
		}

	}

}
