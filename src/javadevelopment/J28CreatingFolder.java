package javadevelopment;

import java.io.File;
import java.io.IOException;

public class J28CreatingFolder {

	public static void main(String[] args) throws IOException {
		
		//To create a folder, create a File class object. Then by using object access to the mkdir() method. 
		//mkdir() method creates a folder inside the project outside the src.
		//Do not forget to refresh the project after running the codes.
		//mkdir() does not throw Exception.
		File folder = new File("FirstFolder");
		folder.mkdir();
		System.out.println("Folder created");
		
		//To create sub-folders inside the "FirstFolder" you need to use "folder.mkdirs();" with the following path.
		//If you want, you can create grand child sub folder as well by giving the path like FirstFolder/FirstSubFolder/FirstSubSubFolder
		File folderSub = new File("FirstFolder/FirstSubFolder");
		folderSub.mkdirs();
		System.out.println("Sub-folder created");
		
		//To create a file inside the folder which we created type the following code
		File fileInFolder = new File("FirstFolder/File1.txt");
		fileInFolder.createNewFile();
		System.out.println("File1 created");
		
		//To create a file inside the sub-folder which we created type the following code
		File fileInSubFolder = new File("FirstFolder/FirstSubFolder/File2.txt");
		fileInSubFolder.createNewFile();
		System.out.println("File2 created");
		
		//Task: Create a folder under documents, name it as "MyFirstFolder"
		//      Create a sub-folder under "MyFirstFolder", name it as "MyFirstSubFolder"
		//      Create a file under "MyFirstFolder", name it as "FileOuter"
		//      Create a file under "MyFirstSubFolder", name it as "FileInner"
		
		File folderOuter = new File("/Users/apple/documents/FolderOuter");
		folderOuter.mkdirs();
		System.out.println("Outer folder created");
		
		File folderInner = new File("/Users/apple/documents/FolderOuter/FolderInner");
		folderInner.mkdirs();
		System.out.println("Inner folder created");
		
		File fileOuter = new File("/Users/apple/documents/FolderOuter/FileOuter.txt");
		fileOuter.createNewFile();
		System.out.println("Outer file created");
		
		File fileInner = new File("/Users/apple/documents/FolderOuter/FolderInner/FileInner.txt");
		fileInner.createNewFile();
		System.out.println("Inner file created");
		

	}

}
