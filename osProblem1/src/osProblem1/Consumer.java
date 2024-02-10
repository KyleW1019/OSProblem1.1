package osProblem1;

import java.util.Date;

public class Consumer implements Runnable{
	private final int[] buffer;
	private int count;
	
	public Consumer(int[] buffer) {
		this.buffer = buffer;
		this.count = buffer.length - 1;
//		Thread t = new Thread(this, "Consumer");
//		t.start();
	}
	
	public void run() {
		while(true) {
			synchronized (buffer){
				try {
					while(count < 0) {
					System.out.println("Buffer is empty");
					count = 0;
					buffer.wait();
					}
					buffer[count--] = 0;
					//System.out.println("THE CONSUMER COUNT IS: " + count);
					System.out.println("Consumed");
					if(count == buffer.length - 1) {
					buffer.notify();
					}
					//Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}		
		}
	}
}
