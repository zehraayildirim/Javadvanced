package javadevelopment;

public class J10Multithreading02 {
	/*
	 To create threads you can use both Thread Class or Runnable Interface, both have same advantages
	*/
	
	public static void main(String[] args) throws InterruptedException {
		/*
		 1.Way to create threads by using Runnable Interface
		 a)Create a class and implement Runnable Interface
		 b)Implement unimplemented run() and type some codes inside the run()
		 c)Create at least 2 objects from Thread class and use CounterMultiThread object as parameter
		 d)For every object use start() 
		 */
		 long startTime00 = System.currentTimeMillis();//To get starting time
	     Thread thread01 = new Thread(new CounterMultiThread(1));
	     Thread thread02 = new Thread(new CounterMultiThread(2));
	     thread01.start();
	     thread02.start();
	     
	     Thread.sleep(3000);
		 long endTime00 = System.currentTimeMillis();//To get ending time
		 System.out.println("Process Time: " + (endTime00 - startTime00));//To print processing time on the console

	     System.out.println("====================");
	     
	     /*
	      2.Way to create threads by using Runnable Interface
	     */
		 long startTime01 = System.currentTimeMillis();//To get starting time
	     Thread thread03 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=1; i<=9; i++) {
					System.out.println("i = " + i + "Thread Number:" + 3);
				}
			}
	     });
	     Thread thread04 = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int k=1; k<=9; k++) {
						System.out.println("k = " + k + "Thread Number:" + 4);
					}
				}
		     });
	     thread03.start();
	     thread04.start();

		Thread.sleep(3000);
		long endTime01 = System.currentTimeMillis();//To get ending time
		System.out.println("Process Time: " + (endTime01 - startTime01));//To print processing time on the console
	}
}

class CounterMultiThread implements Runnable{
	private int threadNo;
	public CounterMultiThread(int threadNo) {
		this.threadNo = threadNo;
	}
	@Override
	public void run() {
		for(int i=1; i<=9; i++) {
			System.out.println("i = " + i + " Thread Number = " + threadNo);
		}
	}
}



