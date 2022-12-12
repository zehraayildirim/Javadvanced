package javadevelopment;

import java.util.Scanner;

public class J32ResourceLeak {

	public static void main(String[] args) {
		
		/*
			 When we use Scanner class, if we do not close the scan1 object, we get yellow underline.
			 It is warning for resource leak, resource leak is not good for security and performance.

			 When objects are no longer being used by the application, but the Garbage Collector is unable
			 to remove them from working memory – because they’re still being referenced.
			 As a result, the application consumes more and more resources – which eventually leads to a fatal OutOfMemoryError.

			 Because of that we need to close the scan1 object.
			 But better practice is making Scanner object creation in "try" parenthesis.
			 Especially when we use BufferReader, we create BufferReader object in try parenthesis
		*/
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter an integer");
		int a = scan1.nextInt();
		System.out.println(a);
		scan1.close();
		
		
		//Better way...
		try(Scanner scan2 = new Scanner(System.in)){
			System.out.println("Enter an integer");
			int b = scan2.nextInt();
			System.out.println(b);
		}catch(Exception e){
			System.out.println("Exception occured");
		}
		


	}

}
