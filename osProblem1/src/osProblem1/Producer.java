package osProblem1;

public class Producer implements Runnable{
	private int[] buffer;
	private int bufferSize = 5;
	private int count;
	public Producer(int[] buffer) {
		this.buffer = buffer;
		this.count = 0;
	}
	public void run() {
		while(true) {
			synchronized (buffer) {
				try {
					while(count == bufferSize) {
						System.out.println("BUFFER IS FULL");
						buffer.wait();
					}
					buffer[count++] = 1;
					System.out.println("Producer produced");
					buffer.notify();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
