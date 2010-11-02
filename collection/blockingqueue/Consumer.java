package collection.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	
		   private final BlockingQueue queue;
		   public Consumer(BlockingQueue q) { queue = q; }
		   public void run() {
		     try {
		       while(true) { consume(queue.take()); }
		     } catch (InterruptedException ex) { 
		    	 System.out.println(ex.getMessage());
		     }
		   }
		   public void consume(Object x) { System.out.println("Consuming"+x.toString()); }
		
}
