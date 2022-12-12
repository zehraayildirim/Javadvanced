package javadevelopment;

public class J12Synchronization02 {

	public static void main(String[] args) {
		Brakets02 braket = new Brakets02();
		//braket.generate(); //1) If you use just this you will get one [[[[[]]]]] which is good.
		//let's use thread when you use 1 thread everything is good but for 2 threads it will be problem
		new Thread(new Runnable() { //2) braket.generate(); kapat sadece bunu calistir, problem olmayacak
                                    // cunku tek thread
			@Override
			public void run() {
				for(int i=1; i<=10;i++) {
					braket.generate();
				}
			}

		}).start();
		//But for 2 threads it will be problem. JVM will execute the generate() method simultaneously for 1st thread
		//and 2nd thread2. I mean without completing 1st thread it will start to run 2nd thread. It will cause not to
		//get same result in every run. To fix that issue we use "synchronized" keyword for the method. If you use 
		//"synchronized" keyword JVM does not let to run the method simutaneously for different threads.
		//This is called "synchronized method" approach
		//Note:"synchronized" keyword fix that issue for just one object, if you use different objects in the threads
		//     same problem will occur. I mean in every run you will get different outputs.
		
		new Thread(new Runnable() { //3) Yukaridaki thread ile bunu birlikte calistir
									//   her defasinda farkli sonuc cikacak.
									//   Bunu cozmek icin generate() methoduna
									//   synchronized koy
			@Override
			public void run() {
				for(int i=1; i<=10;i++) {
					braket.generate();
				}
			}

		}).start();
	}

}

class Brakets02{
	//synchronized koymadan calistir her defasinda farkli sonuc ciktigini goster
	//sonra da synchronized koy ve her defasinda ayni sonuc ciktigini goster.
	synchronized public void generate() {
		for(int i=1; i<=10;i++) {
			if(i<=5) {
				System.out.print("[");
			}else {
				System.out.print("]");
			}
		}
		System.out.println();
	}
}
