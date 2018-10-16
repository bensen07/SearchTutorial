package org.benz.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableExample {

	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 100; i++) {
			int count = i;
			exe.submit(() -> {
				System.out.println("Task[" + count + "]");
				try {

					Thread.sleep(5000L);
					System.out.println("Waking Task[" + count + "]");

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}

		exe.shutdown();

		try {
			exe.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
