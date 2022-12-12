package javadevelopment;

public class J18JoinMethodWithSingleThread {
	
	/*
	 Asagida thread1 dan hemen sonra "System.out.println(obj.counter);" koyarsak 
	 Java once "System.out.println(obj.counter);" kodunu calistirir.
	 Bu yuzden biz counter variable'inin update edilmis degerini degil de ilk degeri olan "0" i console
	 da goruruz. Console'da artirilmis degerini gormek icin "System.out.println(obj.counter);" dan once 
	 Thread.sleep() kullanabiliriz ama sleep() in icine 2000 yazsak cok gelebilir 100 yazsak az gelebilir. 
	 Thread.sleep() yerine thread1.join() kullanmak en iyi cozumdur.
	 */
	
	public int counter = 0;

	public static void main(String[] args) {
		
		J18JoinMethodWithSingleThread obj = new J18JoinMethodWithSingleThread();
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0; i<1000; i++) {
					obj.counter++;
				}
				
			}
			
		});
		thread1.start();
		
		//Asagidaki kod console'da 1000 gormemizi saglar ama belki 2000 cok belki az. Bu iyi bir yontem degil
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		//join() methodu thread1 calismasini bitirdikten sonra "System.out.println(obj.counter);" kodunu calistirir.
		//Bu en iyi yontemdir.
		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(obj.counter);

	}

}
