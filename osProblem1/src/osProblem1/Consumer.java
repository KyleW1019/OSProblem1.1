package osProblem1;

public class Consumer implements Runnable{
	private String[] bufferArray;
	private int arrayIndex;
	private boolean isRunning = true;
	
	public Consumer(String[] bufferArray) {
		this.bufferArray = bufferArray;
		this.arrayIndex = bufferArray.length - 1;
	}
	
	public void run() {
		while(isRunning) {
			synchronized (bufferArray){										//ensures that the threads are synchronized, will throw errors if not
				try {
					while(arrayIndex < 0) {									//checks if the buffer is empty (count = -1)
					System.out.println("Buffer is empty");
					arrayIndex = 0;											//resets the count back to 0
					bufferArray.wait();										//waits until the producer produces
					}
					bufferArray[arrayIndex] = "EMPTY";
					System.out.println("Consumed at index " + arrayIndex + " and set it to empty");
					arrayIndex = arrayIndex - 1;
					if(arrayIndex == bufferArray.length - 1) {				//notifies that the buffer is empty
					bufferArray.notify();
					}
				} catch (Exception e) {
					e.printStackTrace();
					isRunning = false;
				}
			}		
		}
	}
}
