package javadevelopment;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class J23ReentrantLock {

    public static void main(String[] args) {

        Lock lock=new ReentrantLock();
        MyRunnable myRunnable=new MyRunnable(lock);

        Thread thread1 = new Thread(myRunnable,"Passenger1 Thread");
        thread1.start();

        Thread thread2 = new Thread(myRunnable,"Passenger2 Thread");
        thread2.start();
    }

}

class MyRunnable implements Runnable{

    int ticketsAvailable = 1;
    Lock lock;
    public MyRunnable(Lock lock) {
        this.lock=lock;
    }

    public void run(){

        System.out.println("Waiting to book ticket for : "+ Thread.currentThread().getName());
        lock.lock();

        if(ticketsAvailable>0){
            System.out.println("Booking ticket for : "+ Thread.currentThread().getName());

            //Let's say system takes some time in booking ticket here we have taken 1 second time
            try{
                Thread.sleep(1000);
            }catch(Exception e){}

            ticketsAvailable--;
            System.out.println("Ticket BOOKED for : "+ Thread.currentThread().getName());
            System.out.println("currently ticketsAvailable = "+ticketsAvailable);
        }else{
            System.out.println("Ticket NOT BOOKED for : "+ Thread.currentThread().getName());
        }

        lock.unlock();
    }
}

/*
    1) Waiting to book ticket for : Passenger1 Thread
       Waiting to book ticket for : Passenger2 Thread
       first Passenger1 Thread and Passenger2 Thread waited to book tickets.
    2) Booking ticket for : Passenger1 Thread
       Than, Passenger1 Thread acquired lock [by calling lock.lock() ],
       but Passenger2 Thread was not able to acquire lock and was waiting for Passenger1 Thread to release lock.
    3) Ticket BOOKED for : Passenger1 Thread
       Passenger1 Thread was successfully able to book ticket and reduce the available ticket count to 0.
       Than it released object lock  [by calling lock.unlock() ]
       currently ticketsAvailable = 0
    4) Ticket NOT BOOKED for : Passenger2 Thread
       Than, Passenger1 Thread acquired lock [by calling lock.lock() ],
       but available ticket count at that time was 0 so it was not able to book ticket.
 */
