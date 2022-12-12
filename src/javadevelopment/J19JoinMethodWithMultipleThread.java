package javadevelopment;

public class J19JoinMethodWithMultipleThread {
	
	public int counter = 0;

	public static void main(String[] args) {
		
		J19JoinMethodWithMultipleThread obj = new J19JoinMethodWithMultipleThread();
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0; i<10000; i++) {
					obj.counter++;
				}
				
			}
			
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				//thread1 icine thread2.join() yazamayiz cunku thread2 asagida oldugu icin thread1 icinden gorunmez
				try {
					thread1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for(int i=0; i<10000; i++) {
					obj.counter++;
				}
				
			}
			
		});
		thread1.start();
		thread2.start();
		
		//Thread.sleep() kullanmazsak console'da "0" goruruz, cunku once "System.out.println(obj.counter);" calisir.
		//Thread.sleep() kullanirsak her calistirmada farkli ciktilar aliriz. Asagidaki kodu uncomment yaparak goster.
		//Thread.sleep() kullanmak yerine thread2 icindeki run() methodunun icinde loop dan once yukaridaki gibi
		//thread1.join() yazarsak thread2, thread1 bitene kadar bekler. Fakat "System.out.println(obj.counter);" dan
		//once de thread2.join() yazmaliyiz ki thread2 bitmeden "System.out.println(obj.counter);" calismasin.
		//Boylece her run ettigimizde ayni sonucu aliriz. 
//		try {
//			Thread.sleep(50);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		try {
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		System.out.println(obj.counter);

	}

}
