package javadevelopment;

import java.util.concurrent.ArrayBlockingQueue;

/*
Example 1:
	Real-time processing applications such as screen recorder.
	The logic behind this kind of application is there are two threads working concurrently:
	The producer thread captures screenshots constantly and puts the images into a queue;
	the consumer thread takes the images from the queue to process the video.

Example 2:
	Messages are put into a queue. When you are sending a message, you are the producer; and your friend who reads the message, is the consumer.
	Messages need to be kept in queue because of network latency.
	Imagine network connection dropped when you are trying to send a message.
	In this case, the message is still in the queue, awaiting the receiver to consume upon the connection becomes available.
 */

//Producer thread will wait when queue is full. 
//As soon as, an element is taken from queue, it adds the element to queue.

/*
 Once consumer class'i ve consumer thread'i olusturmadan producer thread'in bekleme yaptigini goster.
 Bekliyor cunku herhangi bir eleman silinirse hemen ekleme yapacak
 
 Note: sleep surelerini produce icin 1000 ve consumer icin 5000 yaparak ne oldugunu goster.
       Sonra da consumer icin 5000 ve producer icin 1000 yaparak goster.
*/

public class J22BlockingQueue {

	static int counter = 1;

	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
		Producer produce = new Producer(queue);
		Thread producerThread = new Thread(produce);
		producerThread.start();

		Consumer consume = new Consumer(queue);
		Thread consumerThread = new Thread(consume);
		consumerThread.start();
	}

}

class Producer implements Runnable{
	
	private ArrayBlockingQueue<Integer> queue;

	public Producer(ArrayBlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				queue.put(J22BlockingQueue.counter);
			    System.out.println("Value added to the queue " + J22BlockingQueue.counter);
			    J22BlockingQueue.counter++;
			} catch (InterruptedException e) {
				System.out.println("Problem in sleep");
			}
		}
		
	}
	
}
//Consumer thread will wait if queue is empty. 
//As soon as, there is a single element in queue, it take out the element.
/*
 Consumer elemanlari siler queue bos olursa eklenecek yeni elemani silmek icin bekler.
*/
class Consumer implements Runnable{
	
	private ArrayBlockingQueue<Integer> queue;

	public Consumer(ArrayBlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				queue.take();
				J22BlockingQueue.counter--;
			    System.out.println("Value removed form the queue " + J22BlockingQueue.counter);	    
			} catch (InterruptedException e) {
				System.out.println("Problem in sleep");
			}
		}
		
	}
	
}


