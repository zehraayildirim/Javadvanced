package javadevelopment;

public class J11Synchronization01 {
	
	public static int counter = 0;
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread01 = new Thread(new Runnable() {

			@Override
			public void run() {
				Counter.count();
				System.out.println("The loops in thread01 is over");
			}	
		});
		Thread thread02 = new Thread(new Runnable() {

			@Override
			public void run() {
				Counter.count();
				System.out.println("The loops in thread02 is over");
			}
		});
		//If you do not put sleep() after thread01.start(); main methods will run 
		//System.out.println(J11Synchronization01.counter); first and you will see 0 on the console. Because of that
		//we need to put sleep() after thread01.start();
		
		/*
			When you run the code multiple times you will get different results which is problem.
			Because, in main method there are 3 threads thread1, thread2, and
			System.out.println("Counter = " + J11Synchronization01.counter); and Java runs
			System.out.println("Counter = " + J11Synchronization01.counter); without completing thread1 and thread2
			and you get different results
			To stop that problem
			1)We can use Thread.sleep(500); but it is not possible to estimate the time
			2)We use synchronization. Synchronization restricts to run simultaneously the threads for specific elements.
			  The low is like Counter.count(); from thread1 --> System.out.println("The loops in thread01 is over"); -->
			                  Counter.count(); from thread2 --> System.out.println("Counter = " + J11Synchronization01.counter); -->
			                  System.out.println("The loops in thread02 is over");
		*/

		thread01.start();
		thread02.start();
		//Thread.sleep(500);
		//System.out.println("Counter = " + J11Synchronization01.counter);
	}
}

class Counter{
	//synchronized koymadan calistir her defasinda farkli sonuc ciktigini goster
	//sonra da synchronized koy ve her defasinda ayni sonuc ciktigini goster.
	synchronized public static void count() {
		for(int i=1; i<=1000; i++) {
			J11Synchronization01.counter++;
		}
		System.out.println("Counter = " + J11Synchronization01.counter);
	}
}
