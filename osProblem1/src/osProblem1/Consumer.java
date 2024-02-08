package osProblem1;

import java.util.Date;

public class Consumer implements Runnable{
	private final int[] buffer;
	private int count;
	
	public Consumer(int[] buffer) {
		this.buffer = buffer;
		this.count = buffer.length - 1;
	}
	
	public void run() {
		while(true) {
			synchronized (buffer){
				try {
					while(count == 0) {
					System.out.println("Buffer is empty");
					buffer.wait();
					}
					buffer[count--] = 0;
					System.out.println("Consumed");
					buffer.notify();
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}		
		}
	}
}
