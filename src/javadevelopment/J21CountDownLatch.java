package javadevelopment;

import java.util.concurrent.CountDownLatch;

/*
 main method icindeki kodlarin thread'lerden sonra calismasini istiyorsak
 "latch" kullaniriz. "latch" kapi mandali(surgu) demek, kapiyi belli bir durumda tutmamiza yarar.
 Programlamada da ayni anlamda kullanilir. Thread'leri main methoddaki diger kodlardan once 
 calisir halde tutmamiza yarar. Bunun icin latch.await(); kodunu thread'lerin hemen sonrasina main method'daki 
 diger kodlarin oncesine yazariz. Ama latch.await(); kodunu yazinca surekli bekler bu beklemeyi bitirmek
 icin de run() methodunun icine latch.countDown(); kodunu yazariz.  
 */

public class J21CountDownLatch {

	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(4);
		
		TestThread thread1 = new TestThread(latch);
		TestThread thread2 = new TestThread(latch);
		TestThread thread3 = new TestThread(latch);
		TestThread thread4 = new TestThread(latch);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			System.out.println("Waiting latch interrupted");
		}
		System.out.println("I am in main thread ");
	}

}

class TestThread extends Thread{
	private CountDownLatch latch;

	public TestThread(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Thread running with thread name " + Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName() + " execution completed");
		System.out.println("*************************");
		latch.countDown();
	}
}
