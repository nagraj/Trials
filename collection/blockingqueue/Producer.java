package collection.blockingqueue;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	private final BlockingQueue queue;
	public Producer(BlockingQueue q) { queue = q; }
	public void run() {
		try {
			while(true) { queue.put(produce()); }
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public Object produce() {
		Date d = new Date();
		System.out.println("Producing"+d.toString()); return d; }

}
