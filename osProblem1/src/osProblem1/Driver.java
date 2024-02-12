package osProblem1;

public class Driver {
	public static void main(String[] args) {
		int[] buffer = new int[5];

		Producer pro = new Producer(buffer);
		Consumer con = new Consumer(buffer);

		Thread producer = new Thread(pro);
		Thread consumer = new Thread(con);

		 producer.start(); 
		 consumer.start();	 
	}

}