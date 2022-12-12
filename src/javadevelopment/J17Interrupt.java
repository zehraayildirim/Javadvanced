package javadevelopment;

public class J17Interrupt {
	/*
	 interrupt() method can be used to stop wait() and terminate the program.
	 In the following program I created 2 threads. In the 1st thread I called the withdraw() method. 
	 withdraw() method will wait until the balance is greater than zero or greater than the amount.
	 In thread2 I called deposit() method, when the deposit() method ran the balance will be greater than zero and
	 the amount to withdraw then withdraw() method will run. But after calling deposit() method if we do not
	 use interrupt() method program will not be terminated. When we use interrupt() method catch block will run.  
	 Note: wait() method calismadigi zaman da interrupt() kullanilabilir, problem yok...  
	 */
	
	static public int balance = 0;

	public static void main(String[] args) {
		
		J17Interrupt obj = new J17Interrupt();
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				obj.withdraw(800);	
			}
			
		});
		thread1.start();
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				obj.deposit(2000);
				thread1.interrupt();
			}
			
		});
		thread2.start();
	}
	
	public void withdraw(int amount) {
		synchronized(this){
			if(balance<=0 || balance < amount) {
				try {
					System.out.println("Waiting for the balance to update");
					wait();
				} catch (InterruptedException e) {
					System.out.println("Interrupted catch block executed");
					balance = balance - amount;
					System.out.println("Withdrawal is successful.The current balance is " + balance);
				}
			}else {
				System.out.println("We are inside the else");
			}
		}
		
	}
	
	public void deposit(int amount) {
		balance = balance + amount;
		System.out.println("The amount is deposited. The current balance is " + balance);		
	}
}

/*
	 Difference between wait() + notify() and wait() + interrupt() :
	 Consider Telephone as Object , Person as Thread.
	 Suppose for instance A person is using Telephone and B person also wants to use the telephone
	 but as A person i.e (Thread 1) is busy using it unless the work is done acquires a lock on
	 telephone Object now B i.e(Thread 2) tries to use Telephone but as A has acquired lock on it
	 B it goes into wait state until lock is released.

	 If Telephone object calls wait method it will restrict current thread which want to use Telephone
	 and it will go into wait state.
	 If Telephone object calls notify it will signal the thread waiting on it to acquire lock and
	 proceed with the intended work.
	 If Person A(Thread 1) is using Telephone object and is in some task but interrupt method is called
	 then A will be signaled to stop with current task and may need to do some other task assigned.
 */

