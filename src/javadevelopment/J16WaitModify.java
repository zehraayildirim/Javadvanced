package javadevelopment;

public class J16WaitModify {
	/*
	 What if a thread depends on another thread?
	 In the following example; balance is 0 at the beginning but while balance is 0 we cannot withdraw
	 because of that we put wait() into the withdraw method. It will wait until the balance happens more than 0.
	 deposit() method will update the balance to 2000, when the balance is 2000 withdraw() method will release from the
	 wait() by notify() method and withdraw() will run.
	 The notify() method is used for waking up threads that are waiting for an access to this object's monitor.
	*/
	
	static public int balance = 0;

	public static void main(String[] args) {
		
		J16WaitModify obj = new J16WaitModify();
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				obj.withdraw(800);	
			}
			
		});
		thread1.setName("thread1");
		thread1.start();
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				obj.deposit(2000);
			}
			
		});
		thread1.setName("thread2");
		thread2.start();

	}
	
	public void withdraw(int amount) {
		synchronized(this){
			if(balance<=0 || balance<amount) {
				try {
					System.out.println("Waiting for the amount to update");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		balance = balance - amount;
		System.out.println("Withdrawal is successful.The current amount is " + balance);
	}
	
	public void deposit(int amount) {
		balance = balance + amount;
		System.out.println("The amount is deposited. The current amount is " + balance);
		synchronized(this){
			notify();
		}
	}
}

