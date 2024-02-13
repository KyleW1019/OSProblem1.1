package osProblem1;

public class Producer implements Runnable{					
	private String[] bufferArray;
	private int bufferSize;
	private int count;
	private boolean isRunning = true;
	public Producer(String[] bufferArray, int bufferSize) {
		this.bufferArray = bufferArray;
		this.bufferSize = bufferSize;
		this.count = 0;
	}
	public void run() {
		while(isRunning) {
			synchronized (bufferArray) {											//synchronized ensures that the threads are synchronized and avoids errors at runtime
				try {
					while(count == bufferSize) {									//check if the buffer is full
						System.out.println("BUFFER IS FULL");
						bufferArray.wait();											//waits until the buffer is empty
					}
					bufferArray[count] = "FULL";
					System.out.println("Producer produced and set index " + count + " to FULL");
					count = count + 1;
					bufferArray.notify();											//notifies the consumer thread that the producer has produced
				} catch(Exception e) {
					isRunning = false;
					e.printStackTrace();
				}
			}
		}
	}
}
