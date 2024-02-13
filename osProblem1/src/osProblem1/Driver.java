package osProblem1;

public class Driver {
	public static void main(String[] args) {
		String[] bufferArray = new String[10];

		Producer pro = new Producer(bufferArray, 10);
		Consumer con = new Consumer(bufferArray);

		Thread producer = new Thread(pro);				//creates a thread with the producer object
		Thread consumer = new Thread(con);				//creates a thread with the consumer object

		 producer.start(); 								//runs the producer and consumer threads 
		 consumer.start();	 
	}
}