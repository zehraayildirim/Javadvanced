package javadevelopment;
	/*
	 DeadLock durumu bir thread bir object'i kullanmak icin lock ettiginde baska bir thread de 
	 ayni object'i kullanmak isterse olusur. 
	 Asagidaki J24DeadLock class'inda herhangi bir problem olusmaz cunku; thread1 ve thread2 ikisi birden 
	 lock1 object'ini kullanmak istediklerinde synchronized block devreye girer ve thread1 bitmeden 
	 thread2 nin calismasina musaade etmez. 
	
	 */
public class J24DeadLockUnderstand {

	public static void main(String[] args) {
		
		String lock1 = "lock1";
		String lock2 = "lock2";
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized(lock1) {
					System.out.println("Inside thread1 on lock1");
					synchronized(lock2) {
						System.out.println("Inside thread1 on lock2");
						
					}
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized(lock1) {
					System.out.println("Inside thread2 on lock1");
					synchronized(lock2) {
						System.out.println("Inside thread2 on lock2");
					}
				}
			}
		});
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			System.out.println("There is problem in joins");
		}

		System.out.println("Inside main method");
	}

}

	/*
	Asagidaki J24DeadLockIssue class'inda problem olusur cunku; thread1 lock1 objectini, 
	thread2 lock2 objectini kullandigindan synchronized block devreye girmez ve thread1 ile thread2
	ayni anda calismaya baslar.thread1 lock1 objectini lock eder, thread2 da lock2 objectini lock eder. 
	Boylelikle thread1 icindeki inner synchronized(lock2), lock2 lock oldugundan calisamaz ve 
	thread2 icindeki inner synchronized(lock1), lock1 lock oldugundan calisamaz. Buna DeadLock denir.
	*/

class J24DeadLockIssue {

	public static void main(String[] args) {
		
		String lock1 = "lock1";
		String lock2 = "lock2";
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized(lock1) {
					System.out.println("Inside thread1 on lock1");
					synchronized(lock2) {
						System.out.println("Inside thread1 on lock2");
						
					}
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized(lock2) {
					System.out.println("Inside thread2 on lock2");
					synchronized(lock1) {
						System.out.println("Inside thread2 on lock1");
					}
				}
			}
		});
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			System.out.println("There is problem in joins");
		}

		System.out.println("Inside main method");
	}

}
