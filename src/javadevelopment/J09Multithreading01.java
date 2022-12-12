package javadevelopment;

public class J09Multithreading01 {
	
	/*
	 1)Thread:Sub process in a major process ==> Major Process = [Thread1, Thread2, Thread3]
	   Spotlight => Activity Monitor => Enter => Show Processes and Threads
	 2)A Thread can be in "Runnable State" or "Running State" or "Waiting/Blocked State" 
	 3)The flow of thread is like:
	   new Thread()-->[New State] ==> start()-->[Runnable State] ==> run()-->[Running State]
	                                                                 {No worries about run(), it will be run by JVM} 
	   After [Running State] there are 2 options a)Thread is run then it is terminated
	                                             b)By using sleep(), wait(), or yield() methods it can be put in
	                                               [Waiting/Blocked State]
	 */

	public static void main(String[] args) throws InterruptedException {
		//Create multi task without extending Thread Class
		long startTime00 = System.currentTimeMillis();//To get starting time
		CounterWithoutMultiThread counter01 = new CounterWithoutMultiThread(1);
		CounterWithoutMultiThread counter02 = new CounterWithoutMultiThread(2);
		counter01.countMe();
		System.out.println("*****************");
		counter02.countMe();
		long endTime00 = System.currentTimeMillis();//To get ending time
		System.out.println("Process Time: " + (endTime00 - startTime00));//To print processing time on the console
																		//It is about 9 seconds
		
		System.out.println("=================");
		
		//Create multi task by extending to Thread Class and check what if we call run()
		CounterWithMultiThread counter03 = new CounterWithMultiThread(1);
		CounterWithMultiThread counter04 = new CounterWithMultiThread(2);
		long startTime01 = System.currentTimeMillis();//To get starting time
		counter03.countMe();
		System.out.println("*****************");
		counter04.countMe();
		long endTime01 = System.currentTimeMillis();//To get ending time
		System.out.println("Process Time: " + (endTime01 - startTime01));//To print processing time on the console
		                                                                 //It is about 9 seconds
		System.out.println("=================");
		
		//Create multi task by extending to Thread Class and check what if we call start()
		CounterWithMultiThread counter05 = new CounterWithMultiThread(1);
		CounterWithMultiThread counter06 = new CounterWithMultiThread(2);
		long startTime02 = System.currentTimeMillis();//To get starting time
		counter05.start();
		System.out.println("*****************");
		counter06.start();
		
		//Run the code without uncommenting the Thread.sleep(5000); then it will display the processing time 
		//1 milisecond, it is totally wrong. Because calculating processing time is another thread in main method
		//it runs it first and returns processing time wrongly.
		
		//Then uncomment Thread.sleep(4000); and try it with Thread.sleep(5020);
		//and Thread.sleep(4505); then compare it with the previous processing times which were 9 seconds 
		Thread.sleep(5020);
		long endTime02 = System.currentTimeMillis();//To get ending time
		System.out.println("Process Time: " + (endTime02 - startTime02));//To print processing time on the console
		                                                               //It is about 9 seconds
	}
}

class CounterWithoutMultiThread{
	private int threadNo;

	public CounterWithoutMultiThread(int threadNo) {
		this.threadNo = threadNo;
	}
	public void countMe() {
		for(int i=1; i<=9; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("i = " + i + " Thread Number = " + threadNo);
		}
	}	
}

class CounterWithMultiThread extends Thread{
	private int threadNo;

	public CounterWithMultiThread(int threadNo) {
		this.threadNo = threadNo;
	}
	public void countMe() {
		for(int i=1; i<=9; i++) {
//			try {
//				sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println("i = " + i + " Thread Number = " + threadNo);
		}
	}
	//Override the run() and change counter03.run() and counter04.run() then run the code
	//You will see the processing time will be about 9 seconds again. So we will understand no need to call run method
	//it will be called by JVM
	  @Override
	  public void run() {
		  countMe();
	  }	
}
