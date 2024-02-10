package osProblem1;

import java.util.Date;

public class Driver {
	public static void main(String[] args) {
		int BUFFER_SIZE = 5;
		int[] buffer = new int[BUFFER_SIZE];
		int FULL = 1;
		int EMPTY = 0;

		Producer pro = new Producer(buffer);
		Consumer con = new Consumer(buffer);

		Thread producer = new Thread(pro);
		Thread consumer = new Thread(con);

		
		 producer.start(); 
		 try {
			producer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 consumer.start();
		 try {
			consumer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}

//https://www.youtube.com/watch?v=UOr9kMCCa5g