package javadevelopment;

public class J15Synchronization05 {
	/*
	 Sometimes a thread can run as based on a variable. When the value of the variable change
	 the thread will stop. But sometimes the thread goes on to read the old value continuously and does not stop
	 running, it blocks our application.
	 To prevent that risk we use "volatile" keyword for the variable.
	 If you create the variable like "public static int flag = 0;" it has risk but if you put "volatile" at the beginning
	 no risk. Because of that when you use thread based on a variable put "volatile" at the beginning.
	 */

	volatile public static int flag = 0;
	
	public static void main(String[] args) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				
				while(true) {
					if(flag==0) {
						System.out.println("Thread is running");
					}else {
						break;
					}
				}
				
			}
			
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println("There is a problem in sleep");
				}
				flag=1;
				System.out.println("The flag is updated");
				
			}
			
		}).start();
		

	}

}
