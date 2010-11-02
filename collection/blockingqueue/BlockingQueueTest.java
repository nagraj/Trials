package collection.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
		
		   public static void main(String args[]) {
		     BlockingQueue q = new LinkedBlockingQueue();
		     Producer p = new Producer(q);
		     Consumer c1 = new Consumer(q);
		     Consumer c2 = new Consumer(q);
		     new Thread(p).start();
		     new Thread(c1).start();
		     new Thread(c2).start();
		   }
		

}
