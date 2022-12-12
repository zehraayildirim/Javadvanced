package javadevelopment;

public class J26DataStreams {
	
	/*
	 Java'da 3 tip stream vardir:
	 1)System.out: Bu output stream'dir ve data/file yazdirmaya yarar.
	               System.out is often used from console-only programs like command line tools as a way 
	               to display the result of their execution to the user.
	 2)System.in: Bu input stream'dir ve keyboard inputlarini okumaya yarar
	 3)System.err: Bu error streamdir ve data/file okurken olusan errorlari handle etmemize veya errorlari gostermeye yarar.
	               System.err works like System.out except it is normally only used to output error texts. 

	 This is where all debugging and error messages should go.
	 This is so that this sort of information can easily be separately captured from
	 the regular output of a program.
	 Web servers do this, by sending error messages to an error_log file via stderr,
	 while the normal log file would be e. g. access_log.
	 */
	
	public static void main(String[] args) {
		try {
			  System.out.println(12/0);
			  System.out.println("File opened...");//Bu console'a siyah yazdirir

			} catch (ArithmeticException e){
			  System.err.println("File opening failed:");//Bu console'a kirmizi yazdirir
			  e.printStackTrace();
			}
	}

}
