package javadevelopment;

public class J13Synchronization03 {
	
	/*
	 First, find the total time of execution by using "synchronized method" approach
	 then use "synchronized block" approach.
	 In the generate() method I added one more for-loop. 
	 When I use "synchronized method" approach the total time of execution is approximately 12200 millisecond
	*/

	//"synchronized method" approach
//	public static void main(String[] args) {
//		Brakets03 braket = new Brakets03();
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				long startTime = System.currentTimeMillis();
//				for(int i=1; i<=10;i++) {
//					braket.generate();
//				}
//				long endTime = System.currentTimeMillis();
//				System.out.println("Time required for thread 1: " + (endTime - startTime));
//			}
//			
//		}).start();
//		
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				long startTime = System.currentTimeMillis();
//				for(int i=1; i<=10;i++) {
//					braket.generate();
//				}
//				long endTime = System.currentTimeMillis();
//				System.out.println("Time required for thread 2: " + (endTime - startTime));
//			}
//			
//		}).start();
//	}
//
//}
//
//class Brakets03{
//	synchronized public void generate() {
//		for(int i=1; i<=10;i++) {
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				System.out.println("There is problem in sleep");
//			}
//			if(i<=5) {
//				System.out.print("[");
//			}else {
//				System.out.print("]");
//			}
//		}
//		System.out.println();
	
//	    Add one more loop
//		for(int j=0; j<=10; j++) {
//			try {
//				Thread.sleep(25);
//			} catch (InterruptedException e) {
//					System.out.println("There is problem in sleep");
//			}
//		}
//	}
//}
	
	//"synchronized block" approach
	/*
	 If I do not want to be synchronized the newly added for-loop to execute faster, I need to remove "synchronized"
	 from the method and create a "synchronized block" for the part of the method which you want to synchronize. 
	 When you do it execution time will be approximately 8300
	 */
	public static void main(String[] args) {
		Brakets03 bracket = new Brakets03();
		new Thread(new Runnable() {

			@Override
			public void run() {
				long startTime = System.currentTimeMillis();
				for(int i=1; i<=10;i++) {
					bracket.generate();
				}
				long endTime = System.currentTimeMillis();
				System.out.println("Time required for thread 1: " + (endTime - startTime));
			}
			
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				long startTime = System.currentTimeMillis();
				for(int i=1; i<=10;i++) {
					bracket.generate();
				}
				long endTime = System.currentTimeMillis();
				System.out.println("Time required for thread 2: " + (endTime - startTime));
			}
			
		}).start();
	}

}

class Brakets03{
	/*
		I removed "synchronized" from the beginning of the method and created "synchronized block"
		by typing synchronized(this){ The part which you want to synchronize }
		Note: When you use "synchronized block" approach you can create a "private" object like 
		private Object obj = "object"; to make "synchronized block" approach hidden from the other classes
		This is recommended. Make the code like 
			private Object obj = "object";
			synchronized(obj){ The part which you want to synchronize }
	*/
	 public void generate() {
	    synchronized(this) {
			for(int i=1; i<=10;i++) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					System.out.println("There is problem in sleep");
				}
				if(i<=5) {
					System.out.print("[");
				}else {
					System.out.print("]");
				}
			}
			System.out.println();
	    }
		
		//Add one more loop
		for(int j=0; j<=10; j++) {
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				System.out.println("There is problem in sleep");
			}
		}
	}
}

